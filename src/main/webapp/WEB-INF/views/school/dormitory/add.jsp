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
						<span>宿舍添加</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">宿舍号</td>
				<td>
					<input id="name" name="name" class="easyui-textbox"
					data-options="required:true,prompt:'必填',width:278">
				</td>
			</tr>
			<tr>
				<td class="label">校区</td>
				<td><input id="campus" name="campus" class="easyui-combobox"
					data-options="required:true,prompt:'必选',width:278"></td>
			</tr>
			<tr>
				<td class="label">宿舍最大人数</td>
				<td>
					<input id="maxNumber" name="maxNumber" class="easyui-textbox"
					data-options="required:true,prompt:'必填',width:278,validType: 'num'">
				</td>
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; margin-right:210; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>		
	<script type="text/javascript">
		$(function(){
			$('#campus').combobox({
				valueField:'value',
				textField:'value',
				limitToList: true,
				url:'${prePath }/system/datadict/getDatadictListByDatadict',
				queryParams:{"key":"campus"},
				onLoadSuccess : function() {
					var selected = $(this).combobox("getData")[0].value;
					$(this).combobox("select",selected);
				}
			});
			
			$('#ff').form({
				url : "${prePath}/school/dormitory/add",
			    onSubmit: function(){
					var isValid = $(this).form('validate');
					return isValid;
			    },
			    success:function(data){
			    	parent.$("#dg").datagrid("reload");
			    	parent.$("#win").dialog("close");
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