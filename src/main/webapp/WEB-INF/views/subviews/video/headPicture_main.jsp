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
	<table id="dg"></table>
	<div id="win"/>
	<security:authentication property="principal.username" var="username"/>
	<script type="text/javascript">
		$('#dg').datagrid({
			//数据源
			url : '${prePath}/personalFiles/getPage',
			queryParams : {usersUsername:'${username}'},//加载有效的账号信息
			cache : false,//取消datagrid缓存
			//行宽填充窗体
			fitColumns : true,
			striped : true,//显示斑马效果
			idField : "id", //指明哪一个字段是标识字段
			pagination : true,//在DataGrid控件底部显示分页工具栏
			rownumbers : true,//显示一个行号列
			pageSize : 5,//初始化页面大小
			pageList : [5, 10, 20, 30],//初始化页面大小选择列表
			//菜单栏
			toolbar : [ {
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
					var selections = $("#dg").datagrid("getSelections");
					if(selections.length==0 ){
						$.messager.alert('操作提示','至少选择一行！','info');
						return ;
					}
					$.messager.confirm('操作提示', '这是一个不可逆的操作,您确定要删除这些数据吗？', function(r){
						if (!r){
							$("#dg").datagrid("clearSelections");
						    return ;
						}
						var pks = new Array();
						$.each(selections,function(rowNum,row){
							pks.push(row.id);
						});
						$.ajax({
							type : "POST",//请求方式
							dataType : 'json',
							url : "${prePath}/personalFiles/delete",//请求目的URL
							traditional : true,//用传统的方式来序列化数据,去除参数名的[]
							data : {//请求数据
								ids : pks
							},
							success : function(msg) {//数据返回时所执行的函数
								$('#dg').datagrid('clearSelections'); //把CheckBox历史选项清空
								$('#dg').datagrid('reload');//从新加载reload
							},
							error : function(XMLHttpRequest, textStatus, errorThrown) {
								// 通常 textStatus 和 errorThrown 之中
								// 只有一个会包含信息
								alert("服务器发生未知错误textStatus:" + textStatus + " textStatus:"
										+ textStatus);
							}
						});						
					});
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '下载',
				handler : function() {
					var selections = $("#dg").datagrid("getSelections");
					if(selections.length !=1 ){
						$.messager.alert('操作提示','必须且只能选择一行！','info');
						return ;
					}
					var row = selections[0];
					//下载
					//定义一个form表单
					var form=$("<form>");
					form.attr("style","display:none");  
					form.attr("target","");  
					form.attr("method","post");  
					form.attr("action","${prePath}/personalFiles/download");
					//end form
					//定义input标签
					var input=$("<input>");  
					input.attr("type","hidden");  
					input.attr("name","id");  
					input.attr("value",row.id);  
					//end input
					form.append(input); //将input标签放到form中 
					$("#win").append(form);//将表单放置在web中  
					form.submit();//表单提交 	
				}
			} ],
			//列    
			columns : [ [ {
				field : 'select',
				checkbox: true,
				width : 100
			}, {
				field : 'parentDir',
				title : '目录',
				width : 100
			}, {
				field : 'name',
				title : '文件名',
				width : 100
			}, {
				field : 'size',
				title : '文件大小',
				width : 100
			}, {
				field : 'time',
				title : '时间',
				width : 100
			}, {
				field : 'enable',
				title : '有效',
				width : 100
			} ] ]
		});
	</script>
</body>
</html>