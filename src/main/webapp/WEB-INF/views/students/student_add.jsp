<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="ff" method="post" enctype="application/x-www-form-urlencoded">
	<table>
		<tr>
			<td>
		        <label for="usersUsername">学号:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="usersUsername" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="campus">校区:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="campus" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="department">学院:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="department" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="major">专业:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="major" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="grade">年级:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="grade" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="classnum">班级:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="classnum" data-options="required:true"/>   
			</td>
		</tr>
		<tr>
			<td>
		        <label for="dormitory">宿舍:</label>   
			</td>
			<td>
		        <input class="easyui-validatebox" type="text" name="dormitory" data-options="required:true"/>   
			</td>
		</tr>
	</table>  
</form>

<script type="text/javascript">
	$('#ff').form({
		url : "${prePath}/students/add",
	    onSubmit: function(){
	    	alert("onSubmit");
			var isValid = $(this).form('validate');
			return isValid;
	    },    
	    success:function(data){
	    	alert(data);
	    }
	});    

</script>


</body>
</html>