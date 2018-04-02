<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf"%>
<%@include file="/jspf/customerHeader.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<security:authentication property="principal" var="principal"/>
	<form id="ff_static" method="post">
		<table class="editTable">
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>基本信息</span>
					</div>
				</td>
			</tr>
		<security:authorize access="hasAuthority(T(com.lys.zhku.utils.Authorities).admin.auth)">
			<tr>
				<td class="label">账号</td>
				<td><input id="username" name="username" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
				<td class="label">姓名</td>
				<td><input id="nickname" name="nickname" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
			</tr>
			<script type="text/javascript">
				var row = {username : '${principal.username}',
						   nickname : '${principal.nickname}'};
				var usersUsername = row.username;
			</script>
		</security:authorize>
		<security:authorize access="not hasAuthority(T(com.lys.zhku.utils.Authorities).admin.auth)">
			<tr>
				<td class="label">学号</td>
				<td><input id="usersUsername" name="usersUsername" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
				<td class="label">姓名</td>
				<td><input name="name" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td><input id="gender" name="gender" class="easyui-textbox"
					data-options="width:278,readonly:true">
				<td class="label">校区</td>
				<td><input id="campus" name="campus" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
			</tr>
			<tr>
				<td class="label">学院</td>
				<td><input id="department" name="department" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
				<td class="label">专业</td>
				<td><input id="major" name="major" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
			</tr>
			<tr>
				<td class="label">年级</td>
				<td><input name="grade" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
				<td class="label">班级</td>
				<td><input name="classnum" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>
			</tr>
			<tr>
				<td class="label">宿舍</td>
				<td><input name="dormitory" class="easyui-textbox"
					data-options="width:278,readonly:true"></td>		
			</tr>
			<script type="text/javascript">
				var row = $.ajax({
					  data: {usersUsername : '${principal.username}'},
					  url: "${prePath}/students/getByUsersUsername",
					  async: false
					 }).responseJSON;
				var usersUsername = row.usersUsername;
			</script>			
		</security:authorize>
		</table>
	</form>
	<form id="ff" method="post">
		<table class="editTable">
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>其它信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td>
					<input id="usersUsername" name="usersUsername" type="hidden">
					<input id="idcard" name="idcard" class="easyui-textbox"
					data-options="width:278,readonly:true">
				</td>
				</td>
				<td class="label">手机号码</td>
				<td><input name="phonenum" class="easyui-textbox"
					data-options="width:278,validType:'num'"></td>
				</td>
			</tr>
			<tr>
				<td class="label">短号</td>
				<td><input name="shortnum" class="easyui-textbox"
					data-options="width:278,validType:'num'"></td>
				<td class="label">邮件</td>
				<td><input name="email" class="easyui-textbox"
					data-options="width:278,validType:'email'"></td>
			</tr>
			<tr>
				<td class="label">QQ</td>
				<td><input name="qq" class="easyui-textbox"
					data-options="width:278"></td>
				<td class="label">紧急联系电话</td>
				<td><input name="urgentnum" class="easyui-textbox"
					data-options="width:278,validType:'num'"></td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td><input name="birthplace" class="easyui-textbox"
					data-options="width:278,prompt:'省-市'"></td>
				<td class="label">详细地址</td>
				<td><input name="address" class="easyui-textbox"
					data-options="width:278"></td>
			</tr>
			<tr>
				<td class="label">政治面貌</td>
				<td><input name="political" class="easyui-textbox"
					data-options="width:278"></td>
				<td class="label">民族</td>
				<td><input name="nation" class="easyui-textbox"
					data-options="width:278"></td>
			</tr>
			<tr>
				<td class="label">备注</td>
				<td colspan="3"><textarea name="remark" class="easyui-validatebox"
						style="height: 100px; width: 500px;"
						data-options="validType:'length[0,150]'"></textarea></td>
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>	
	<script type="text/javascript">
		$('#ff').form({
			url : "${prePath}/userdetails/edit",
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				return isValid;
		    },    
		    success:function(data){
		    	var jsonData = $.parseJSON(data)
				if(jsonData.code==1) {
					parent.$("#win").dialog("close");
				}
				$.messager.alert('操作结果',jsonData.msg,'info');
		    }
		});	
		$(function(){
			//row 在上面security标签中定义
			$("#ff_static").form("load",row);
			//加载"其他信息",userdetils表的信息
			var getJson;
			$.getJSON("${prePath}/userdetails/getUserdetailsByUsersUsername",
				{usersUsername:usersUsername},//在上面已定义
				function(json){
					getJson = json;
					$("#ff").form("load",json);
			});

			$('#btn_submit').bind('click', function(){    
		        $("#ff").submit();
		    });
		    $('#btn_reset').bind('click', function(){    
		        $("#ff").form("reset");
		        $("#idcard").textbox("setValue",getJson.idcard);
		    });
		}); 
	</script>
</body>
</html>