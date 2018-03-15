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
	<form id="ff" method="post">
		<table class="editTable">
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>基本信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">学号</td>
				<td><input id="usersUsername" name="usersUsername" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">姓名</td>
				<td><input name="name" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td><input id="gender" name="gender" class="easyui-textbox"
					data-options="readonly:true,width:278">
				<td class="label">校区</td>
				<td><input id="campus" name="campus" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">学院</td>
				<td><input id="department" name="department" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">专业</td>
				<td><input id="major" name="major" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">年级</td>
				<td><input name="grade" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">班级</td>
				<td><input name="classnum" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">宿舍</td>
				<td><input name="dormitory" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>		
			</tr>
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>其它信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td><input name="idcard" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				</td>
				<td class="label">手机号码</td>
				<td><input name="phonenum" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				</td>
			</tr>
			<tr>
				<td class="label">短号</td>
				<td><input name="shortnum" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">邮件</td>
				<td><input name="email" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">QQ</td>
				<td><input name="qq" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">紧急联系电话</td>
				<td><input name="urgentnum" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td><input name="birthplace" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">详细地址</td>
				<td><input name="address" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">政治面貌</td>
				<td><input name="political" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">民族</td>
				<td><input name="nation" class="easyui-textbox"
					data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">备注</td>
				<td colspan="3"><textarea name="remark" class="easyui-validatebox"
						style="height: 100px; width: 500px;"
						data-options="readonly:true"></textarea></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		$(function(){			
			var row = parent.$("#dg").datagrid("getSelected");
			$("#ff").form("load",row); //应该放在combobox等会自动加载的组件下面,否则其其自动加载的内容会覆盖
			
			//加载"其他信息",userdetils表的信息
			$.getJSON("${prePath}/userdetails/getUserdetailsByUsersUsername",
				{usersUsername:row.usersUsername},
				function(json){
					$("#ff").form("load",json);
			});
		}); 
	</script>
</body>
</html>