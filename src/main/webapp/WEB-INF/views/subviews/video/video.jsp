<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf" %>
<%@include file="/jspf/customerHeader.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频监控</title>
</head>
	<body>
		<security:authentication property="principal.username" var="username"/>
		<form id="ff" method="post">
			<table class="editTable">
				<tr>
					<td>
						<div class="divider">
							<span>视频监控</span>
						</div>
					</td>
				</tr>
				<tr>
					<td>
					   <video height="320px" id="video"   autoplay="autoplay" muted="muted">
					       	 您的浏览器不支持Video
					   </video> 					
					</td>
				</tr>			
				<tr>
					<td>
						<a  id="startPreview" onclick="startPreview()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">开启摄像头</a>
						<a  id="autoRecording" onclick="autoRecording()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">自动录制</a>
						<a  id="noautoRecording" onclick="noautoRecording()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">关闭自动录制</a>
						<a  id="startRecording" onclick="startRecording()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">开始录制</a>
						<a  id="stopRecording" onclick="stopRecording()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">停止录制</a>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">		
			$(function(){
				$("#startPreview").linkbutton('enable');
				$("#autoRecording").linkbutton('disable');
				$("#noautoRecording").linkbutton('disable');
				$("#startRecording").linkbutton('disable');
				$("#stopRecording").linkbutton('disable');					
				var explorer =navigator.userAgent ;
				//ie 
				if (explorer.indexOf("MSIE") >= 0) {
				}
				//firefox 
				else if (explorer.indexOf("Firefox")>= 0) {
				}
				//Chrome
				else if(explorer.indexOf("Chrome")>= 0){
				}
				//Safari
				else if(explorer.indexOf("Safari") >= 0){
					$.messager.alert('操作提示','你的浏览器不支持录像功能，请换一个浏览器再试！','info');
					$("#startPreview").linkbutton('disable');
					$("#startRecording").linkbutton('disable');
					$("#stopRecording").linkbutton('disable');	
				} 
			});
			//Netscape
			navigator.getUserMedia = navigator.getUserMedia ||
		                      		 navigator.webkitGetUserMedia ||
		                      		 navigator.mozGetUserMedia;
			navigator.mediaDevices.enumerateDevices()
				.then(
					function (data) {
						console.log(data);
					 // body...
					},
					function (error) {
						alert("获取失败" + error);
						console.log(error);
					}
				);
	
			var g_stream = null,g_recorder = null;
			var chunks = [];
			var video=document.getElementById('video');
			function startPreview(){
			    navigator.mediaDevices.getUserMedia({
			        audio: true, video: { width: 1280, height: 720 }
			    })
			    .then(function(stream) {       
		    		g_stream = stream;
		       		//绑定本地媒体流到video标签用于输出
		           	//video.src = URL.createObjectURL(stream);
		         
		       		//向PeerConnection中加入需要发送的流
		           	video.srcObject = stream;
		           	video.onloadedmetadata = function(e) { 
		           		video.play();
			        }
		           	
					g_recorder = new MediaRecorder(g_stream,{ mimeType:'video/webm' });
					g_recorder.ondataavailable = function(e) {
						chunks.push(e.data);
					}
					g_recorder.onstop = function(e) {
						//使用formdata
						var oMyForm = new FormData();
						
						var oBlob = new Blob(chunks, { 'type' : 'video/webm' });
					
						oMyForm.append("file", oBlob,new Date().getTime()+".mp4");
						oMyForm.append("username","${username}");//用户账户	 
						
						if (window.XMLHttpRequest)
						{
						    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
						   xmlhttp=new XMLHttpRequest();
						}
						else
						{
						    // IE6, IE5 浏览器执行代码
						    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
						}
						xmlhttp.onreadystatechange=function(){
							if (xmlhttp.readyState==4 && xmlhttp.status==200)
							{
								chunks = [];
								$.messager.alert('操作提示',JSON.parse(xmlhttp.responseText).msg,'info');
							}
						}   
					    xmlhttp.open("POST", "<c:url value='/video/upload'/>",true);
					    xmlhttp.send(oMyForm);		
					}	
					//自动上传
					loop();
			     })
			     .catch(function(err) {
			     		console.log(err.name + ": " + err.message);
			     });
				$("#startPreview").linkbutton('disable');
				$("#autoRecording").linkbutton('disable');
				$("#noautoRecording").linkbutton('enable');
				$("#startRecording").linkbutton('disable');
				$("#stopRecording").linkbutton('disable');	
			}
		/* 	var saveFile = function(url, filename){
				var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
				save_link.href = url;
				save_link.download = filename;
				
				var event=document.createEvent('MouseEvents');
				event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
				save_link.dispatchEvent(event);
			}; */

			var to1,to2;
			function loop() {
				if(g_recorder.state=="inactive") {//inactive,paused
					g_recorder.start();//在停止时，开始录制
				}
				//在录制时，停止并上传
				to1 = setTimeout("if(g_recorder.state=='recording'){g_recorder.stop();}",10000);
				to2 = setTimeout("loop();",10000);
			}
			function autoRecording(){
				if(g_recorder.state=="recording") {//inactive,paused
					g_recorder.stop();//停止录制并上传
				}
				loop();//自动录制
				$("#startPreview").linkbutton('disable');
				$("#autoRecording").linkbutton('disable');
				$("#noautoRecording").linkbutton('enable');
				$("#startRecording").linkbutton('disable');
				$("#stopRecording").linkbutton('disable');	
			}
			function noautoRecording(){
				clearTimeout(to1);//停止自动录制
				clearTimeout(to2);//停止自动上传
				if(g_recorder.state=="recording") {//inactive,paused
					g_recorder.stop();//停止录制并上传
				}
				$("#startPreview").linkbutton('disable');
				$("#autoRecording").linkbutton('enable');
				$("#noautoRecording").linkbutton('disable');
				$("#startRecording").linkbutton('enable');
				$("#stopRecording").linkbutton('disable');					
			}
			function startRecording(){
				if(g_recorder.state=="inactive") {//inactive,paused
					g_recorder.start();//在停止时，开始录制
				}
				$("#startPreview").linkbutton('disable');
				$("#autoRecording").linkbutton('disable');
				$("#noautoRecording").linkbutton('disable');
				$("#startRecording").linkbutton('disable');
				$("#stopRecording").linkbutton('enable');
			}
			function stopRecording(){
				if(g_recorder.state=="recording") {//inactive,paused
					g_recorder.stop();//在录制时，停止录制并上传
				}
				$("#startPreview").linkbutton('disable');
				$("#autoRecording").linkbutton('enable');
				$("#noautoRecording").linkbutton('disable');
				$("#startRecording").linkbutton('enable');
				$("#stopRecording").linkbutton('disable');
			}
		</script>
	</body>
</html>