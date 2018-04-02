<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
    .editTable .label {
        min-width: 80px;
        width: 80px;
    }
</style>
<security:authentication property="principal" var="principal"/>
<table class="editTable">
    <tr>
        <td class="label">用户名</td>
        <td><input type="text" id="userNameId" name="username" value="${principal.username }"></td>
    </tr>
    <tr>
        <td class="label">姓名</td>
        <td><input type="text" id="userName" name="nickname" value="${principal.nickname }"></td>
    </tr>
    <tr>
        <td class="label">新密码</td>
        <td><input type="text" id="password" name="password">
        </td>
    </tr>
    <tr>
        <td class="label">重复新密码</td>
        <td><input type="text" id="password2" name="password2"></td>
    </tr>
</table>

<script type="text/javascript">
    $(function () {
        $('#userNameId').iTextbox({
            width: 200,
            readonly: true
        });
        $('#userName').iTextbox({
            width: 200,
            readonly: true
        });
        $('#password').iPasswordbox({
            width: 200,
            required: true,
            validType: 'minLength[5]'
        });
        $('#password2').iPasswordbox({
            width: 200,
            required: true,
            validType: "equals['#password']"
        });
    });
</script>
</body>
</html>