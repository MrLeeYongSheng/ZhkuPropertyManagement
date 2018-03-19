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
						<span>修改文件信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">目录</td>
				<td><input id="parentDir" name="parentDir" class="easyui-textbox"
					data-options="required:true,prompt:'必选',width:278">
					<input name="id" type="hidden">	
					<input name="size" type="hidden">	
					<input name="time" type="hidden">	
				</td>
			</tr>
			<tr>
				<td class="label">文件名</td>
				<td><input name="name" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填'"></td>
			</tr>
			<tr>
				<td class="label">有效</td>
				<td>
					<input id="enable" name="enable" class="easyui-switchbutton"
					data-options="onText:'有效',offText:'无效',width:278,checked:false" value="true">
					<input id="disable" name="enable" type="hidden" value="false">
				</td>	
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>	

	<script type="text/javascript">
		$('#ff').form({
			url : "${prePath}/files/edit",
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				return isValid;
		    },    
		    success:function(data){
		    	var jsonData = $.parseJSON(data)
				if(jsonData.code==1) {
					parent.$("#win").dialog("close");
					parent.$("#dg").datagrid("reload");
					parent.$('#dg').datagrid('clearSelections'); //把CheckBox历史选项清空
				} else{
					$.messager.alert('操作结果',jsonData.msg,'info');
				} 
		    }
		});	
		
		
		$(function(){

			changeSwitchButton($("#enable"),$("#disable"));
			
			var row = parent.$("#dg").datagrid("getSelected");
			$("#ff").form("load",row); //应该放在combobox等会自动加载的组件下面,否则其其自动加载的内容会覆盖

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