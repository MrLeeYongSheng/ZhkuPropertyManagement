<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf" %>
<%@include file="/jspf/customerHeader.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<security:authentication property="principal.username" var="username"/>
		<form id="ff" method="post">
			<table class="editTable">
				<tr>
					<td>
						<div class="divider">
							<span><input type="button" title="开启摄像头" value="开启摄像头" onclick="new VideoCanvas().getMedia('video');" /></span>
						</div>
					</td>
				</tr>
				<tr>
					<td><video id='video' height="240px" width="320px" autoplay="autoplay"></video></td>
				</tr>
				<tr><td><a onclick="new VideoCanvas().getPhoto('canvas1',120);" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">拍照</a></td></tr>
				<tr>
					<td>
						<div class="divider">
							<span>图片预览</span>
						</div>
					</td>
				</tr>
				<tr>
					<td><canvas id="canvas1" height="120px" width="160px"></canvas></td>
				</tr>
				<tr>
					<td>
						<a onclick="new VideoCanvas().upload('http://localhost:8080/zhku/personalFiles/uploadHeadPicture');" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">上传</a>
						<a onclick="new VideoCanvas().download();" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">下载</a>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
	
			function VideoCanvas() {
				this.getMedia = function (id) {
					VideoCanvas.prototype.video = document.getElementById(id);
					navigator.getUserMedia = navigator.getUserMedia || navigator.mozGetUserMedia;
					if(navigator.getUserMedia) {
						navigator.getUserMedia({
							'video': true,
							'audio': false
						}, function(stream) { //success是获取成功的回调函数
							VideoCanvas.prototype.video.srcObject = stream;
						}, function(e) { //error是获取失败的回调函数
							alert('Error！' + e);
						});   
					} else {
						alert('Native device media streaming (getUserMedia) not supported in this browser.');
					}
				}
				//拍照
				this.getPhoto = function (orginId,height) {
					VideoCanvas.prototype.canvas = document.getElementById(orginId);
					var context = VideoCanvas.prototype.canvas.getContext('2d');				
					var radio = this.video.width/this.video.height;
					context.drawImage(VideoCanvas.prototype.video, 0, 0, radio*height, height); //将video对象内指定的区域捕捉绘制到画布上指定的区域，实现拍照。
				}
				
				this.download = function(){
					var canvas = VideoCanvas.prototype.canvas;
					var alink = document.createElement('a');
					alink.download=new Date().getTime()+'.png';
					alink.href=canvas.toDataURL();
					alink.click();
				}
				
				this.upload = function(url) {
					var formData = new FormData();
					formData.append("username","${username}");
					VideoCanvas.prototype.canvas.toBlob(function(blobData) {//该回调函数是异步的
						formData.append('file',blobData,new Date().getTime()+'.png');
						var xhr;
						if(window.XMLHttpRequest) {
							xhr = new XMLHttpRequest();
						} else if(window.ActiveXObject) {
							xhr = new ActiveXObject("Microsoft.XMLHTTP");
						}
						xhr.onreadystatechange = function(e) {
							if(xhr.readyState==4) {
								$.messager.alert('操作提示',JSON.parse(xhr.responseText).msg,'info');
							}
						}
						xhr.open('post',url,true);
						xhr.send(formData);
					});
				}
			}
		</script>
	</body>
</html>