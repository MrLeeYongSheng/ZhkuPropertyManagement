<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta charset="UTF-8">
<title>MeidaRecorder</title>
<script type="text/javascript"
	src="<c:url value='/static/js/jquery-1.11.1.min.js'/>"></script>
<head>


</head>
<body>
	<div>
      <button  id="startPreview"  onclick="startPreview()">开启摄像头</button>
      <button  id="startRecording" onclick="startRecording()">开始录制</button>
      <button  id="stopRecording" onclick="stopRecording()">停止录制</button>
	</div>

   <video height="320px" id="video"   autoplay="autoplay" muted="muted">
       	 您的浏览器不支持Video
   </video> 

</body>
<script type="text/javascript">
	var explorer =navigator.userAgent ;
	//ie 
	if (explorer.indexOf("MSIE") >= 0) {
		alert("您的浏览器不支持录像功能");
	}
	//firefox 
	else if (explorer.indexOf("Firefox")>= 0) {
		alert("即将开始录像请做好准备.....");
	}
	//Chrome
	else if(explorer.indexOf("Chrome")>= 0){
		alert("即将开始录像请做好准备.....");
	}
	//Safari
	else if(explorer.indexOf("Safari") >= 0){
		alert("您的浏览器不支持录像功能");
	} 
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


	var g_stream = null,g_recorder = null ;chunks = [];
	var video=document.getElementById('video');
	function startPreview(){
	    navigator.mediaDevices.getUserMedia({
	        audio: true, video: { width: 1280, height: 720 }
	    })
	    .then(function(stream) {       
	    		g_stream = stream;
	       		//绑定本地媒体流到video标签用于输出
	           	video.src = URL.createObjectURL(stream);
	         
	       		//向PeerConnection中加入需要发送的流
	           	video.srcObject = stream;
	           	video.onloadedmetadata = function(e) { 
	           	video.play();
	        }
	         
	     })
	     .catch(function(err) {
	     		console.log(err.name + ": " + err.message);
	     });
	 
	}
/* 	var saveFile = function(url, filename){
		var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
		save_link.href = url;
		save_link.download = filename;
		
		var event=document.createEvent('MouseEvents');
		event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
		save_link.dispatchEvent(event);
	}; */
	function startRecording(){
		g_recorder = new MediaRecorder(g_stream,{ mimeType:'video/webm' });
		g_recorder.ondataavailable = function(e) {
			chunks.push(e.data);
		}
		g_recorder.onstop = function(e) {
			//使用formdata
			var oMyForm = new FormData();
			
			var oBlob = new Blob(chunks, { 'type' : 'video/webm' });
		
			oMyForm.append("file", oBlob,new Date().getTime()+".mp4");
			 
			
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
				    alert('发送成功!!!');
				}
			}   
		    xmlhttp.open("POST", "<c:url value='/video/upload'/>",true);
		    xmlhttp.send(oMyForm);
		}
		g_recorder.start(); 
		$("#startRecording").attr("disabled","disabled");
		$("#stopRecording").removeAttr("disabled");
	}
	function stopRecording(){
		g_recorder.stop();

		$("#stopRecording").attr("disabled","disabled");
		$("#startRecording").removeAttr("disabled");
		chunks = [];
	}
</script>
</html>