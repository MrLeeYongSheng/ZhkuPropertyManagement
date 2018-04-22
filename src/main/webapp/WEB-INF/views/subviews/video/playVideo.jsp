<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf" %>
<%@include file="/jspf/customerHeader.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放</title>
</head>
	<body>
		<video id="video" height="100%" width="100%" autoplay="autoplay" controls="controls" muted="muted">
			您的浏览器不支持视频播放，请更换浏览器再试！
		</video>
		<script type="text/javascript">
			$(function(){
				var row = parent.$("#dg").datagrid("getSelected");
				var video = $("#video");
				video.attr('src',"<c:url value='/video/download?id='/>"+row.id)
			});
		</script>
	</body>
</html>