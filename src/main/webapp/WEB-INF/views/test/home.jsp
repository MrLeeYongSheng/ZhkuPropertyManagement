<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@include file="/jspf/commonHeader.jspf" %>
<html>
<head>
<script type="text/javascript"
	src="${prePath }/static/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${prePath }/static/plugins/jquery/jquery.cookie.js"></script>

<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<script type="text/javascript">

	</script>
</body>
</html>
