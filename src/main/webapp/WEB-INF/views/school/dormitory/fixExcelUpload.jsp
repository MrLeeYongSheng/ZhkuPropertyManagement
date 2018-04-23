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
	<security:authentication property="principal.username" var="username"/>
	<form id="ff" method="post" enctype="multipart/form-data">
		<input name="username" type="hidden" value="${username }">
		<table class="editTable">
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>文件信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">文件</td>
				<td><input id="fb" name="file" class="easyui-filebox"
					data-options="required:true,width:278,prompt:'必选'"></td>
			</tr>
			
		</table>
	</form>
    <div style="height: 34px; padding: 5px; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>	

	<script type="text/javascript">
		$('#ff').form({
			url : "${prePath}/school/dormitory/uploadFixExcel",
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				return isValid;
		    },    
		    success:function(data){
		    	var jsonData = $.parseJSON(data)
				if(jsonData.code==1) {
					parent.$("#win").dialog("close");
					//parent.$("#dg").datagrid("reload");
				} else{
					alert(jsonData.msg);
				} 
		    }
		});	

		$('#fb').filebox({    
		    buttonText: '选择文件', 
		    buttonAlign: 'left',
		    multiple: 'false',
		    accept: 'application/vnd.ms-excel'
		})

		$(function(){
			
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