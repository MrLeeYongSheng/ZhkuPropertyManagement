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
					<input id="authority" name="authority" class="easyui-textbox"
					data-options="required:true,prompt:'必选',width:278"></td>
			</tr>
			<tr>
				<td class="label">有效性</td>
				<td><input id="enable" name="enable" class="easyui-switchbutton"
					data-options="onText:'有效',offText:'无效',width:278,checked:true" value="true">
					<input id="disable" name="enable" type="hidden" disabled="true" value="false"/></td>			
			</tr>
			<tr>
				<td class="label">备注</td>
				<td><textarea id="remark" name="remark" class="easyui-validatebox"
						style="height: 100; width: 300;"
						data-options="validType:'length[0,100]'"></textarea></td>
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; margin-right:210; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>		
	<script type="text/javascript">
	
		$(function(){
			
			//从父页面获取数据,并填充到表单
			var row = parent.$("#dg").datagrid("getSelected");
			$("#ff").form("load",row);
			
			//表单定义
			$('#ff').form({
				url : "${prePath}/system/rolesAuthorities/auths/update",
			    onSubmit: function(){
					var isValid = $(this).form('validate');
					return isValid;
			    },    
			    success:function(data){
			    	parent.$("#dg").datagrid("reload");
			    	parent.$("#tg").treegrid("reload");
			    	parent.$("#win").dialog("close");
			    }
			});	
			$("#enable").switchbutton({
				onChange : function(checked){
					if(checked) {
						$("#disable").attr("disabled", true);
					} else {
						$("#disable").attr("disabled", false);
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