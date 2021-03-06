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
				<td><input name="usersUsername" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填',validType:'num'"></td>
				<td class="label">姓名</td>
				<td><input name="name" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填'"></td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td><input id="gender" name="gender" class="easyui-switchbutton"
					data-options="onText:'男',offText:'女',width:278,checked:true" value="男">
					<input id="gender_women" name="gender" type="hidden" disabled="true" value="女"/></td>
				<td class="label">校区</td>
				<td><input id="campus" name="campus" class="easyui-combobox"
					data-options="required:true,prompt:'必选',width:278"></td>
			</tr>
			<tr>
				<td class="label">学院</td>
				<td><input id="department" name="department" class="easyui-combobox"
					data-options="prompt:'请先选择校区',width:278"></td>
				<td class="label">专业</td>
				<td><input id="major" name="major" class="easyui-combobox"
					data-options="prompt:'请先选择学院',width:278"></td>
			</tr>
			<tr>
				<td class="label">年级</td>
				<td><input name="grade" class="easyui-textbox"
					data-options="width:278,prompt:'请输入数字',validType:'num'"></td>
				<td class="label">班级</td>
				<td><input name="classnum" class="easyui-textbox"
					data-options="width:278,prompt:'请输入数字',validType:'num'"></td>
			</tr>
			<tr>
				<td class="label">宿舍</td>
				<td><input name="dormitory" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填'"></td>		
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
					data-options="required:true,width:278,prompt:'必填'"></td>
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
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>	

	<script type="text/javascript">
		$('#ff').form({
			url : "${prePath}/students/add",
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				return isValid;
		    },    
		    success:function(data){
		    	var jsonData = $.parseJSON(data)
				if(jsonData.code==1) {
					parent.$("#win").dialog("close");
					parent.$("#dg").datagrid("reload");
				} else{
					alert(jsonData.msg);
				} 
		    }
		});	
		$(function(){
			$('#campus').combobox({
				valueField:'value',
				textField:'value',
				limitToList: true,
				url:'${prePath }/students/getDatadictListByDatadict',
				queryParams:{"key":"campus"},
				onLoadSuccess : function() {
					var selected = $(this).combobox("getData")[0].value;
					$(this).combobox("select",selected);
				},
				onSelect : function(record){
					$('#department').combobox("clear");
					$('#major').combobox("clear");
					var queryParams = {parentid : record.id, key : 'department'};
					$('#department').combobox("options").queryParams = queryParams;
					$('#department').combobox("reload");
				}
			});
			$('#department').combobox({
				valueField:'value',
				textField:'value',
				limitToList: true,
				url:'${prePath }/students/getDatadictListByDatadict',
				onSelect : function(record){
					$('#major').combobox("clear");
					var queryParams = {parentid : record.id, key : 'major'};
					$('#major').combobox("options").queryParams = queryParams;
					$('#major').combobox("reload");
				}
			});
			$('#major').combobox({
				valueField:'value',
				textField:'value',
				limitToList: true,
				queryParams: {key:""},
				url:'${prePath }/students/getDatadictListByDatadict'
			});
			
			$("#gender").switchbutton({
				onChange : function(checked){
					if(!checked) {
						$("#gender_women").attr("disabled", false);
					} else {
						$("#gender_women").attr("disabled", true);
					}
				}
			});
			
		    $('#btn_submit').bind('click', function(){    
		        $("#ff").submit();
		    });    
		    $('#btn_reset').bind('click', function(){    
		        $("#ff").form("reset");
		    });
		}); 
	</script>
</body>
</html>