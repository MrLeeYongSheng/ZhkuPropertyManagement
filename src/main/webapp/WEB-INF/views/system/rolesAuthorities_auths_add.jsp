<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf"%>
<%@include file="/jspf/customerHeader.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form id="ff" method="post">
		<table class="editTable">
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>权限添加</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">名称</td>
				<td>
					<input id="id" name="id" type="hidden">
					<input id="authority" name="authority" class="easyui-combobox"
					data-options="required:true,prompt:'必选',width:278"></td>
			</tr>
			<tr>
				<td class="label">备注</td>
				<td><textarea id="remark" name="remark" class="easyui-validatebox"
						style="height: 100; width: 300;"
						data-options="validType:'length[0,100]', readonly:true"></textarea></td>
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; margin-right:210; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>		
	<script type="text/javascript">

		$(function(){
			$('#authority').combobox({
				valueField:'authority',
				textField:'authority',
				url:'${prePath}/system/rolesAuthorities/auths/getAuthsList',
				onLoadSuccess : function() {
					var selected = $(this).combobox("getData")[0];
					$(this).combobox("select",selected.authority);
					$("#ff").form("load", selected);
				},
				onSelect : function(record){
					$("#id").val(record.id);
					$("#remark").val(record.remark);
				}
			});	
			
			$('#ff').form({
				url : "${prePath}/system/rolesAuthorities/auths/addToRole",
			    onSubmit: function(){
					var isValid = $(this).form('validate');
					return isValid;
			    },    
			    success:function(data){
			    	parent.$("#tg").treegrid("reload");
			    	parent.$("#win").dialog("close");
			    }
			});				
		    $('#btn_submit').bind('click', function(){    
		        $("#ff").form("submit",{
		        	queryParams: {
						"roleId" : parent.$("#tg").treegrid('getSelected').id,
						"authId" : $("#id").val()		        		
		        	}
		        });
		    });    
		    $('#btn_reset').bind('click', function(){    
		        $("#ff").form("reset");
		    });
		});
	</script>
</body>

</html>