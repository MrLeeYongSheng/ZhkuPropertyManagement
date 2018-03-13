<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf" %>
<%@include file="/jspf/customerHeader.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<table id="dg"></table>
		<div id="win"/>	
		<script type="text/javascript">
		$('#dg').datagrid({
			//数据源
			url : '${prePath}/system/datadict/getPage',
			cache : false,//取消datagrid缓存
			//行宽填充窗体
			fitColumns : true,
			striped : true,//显示斑马效果
			idField : "id", //指明哪一个字段是标识字段
			pagination : true,//分页工具栏
			pageSize : 5,//初始化页面大小
			pageList : [5,10,15,20,30],//初始化页面大小选择列表
			rownumbers : true,//显示一个行号列
			//菜单栏
			toolbar : [ {
				iconCls : 'icon-add',
				text : '增加',
				handler : function() {
					showDialog("win","${prePath}/system/datadict/add"); 
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '修改',
				handler : function() {
					var selections = $("#dg").datagrid("getSelections");
					if(selections.length !=1 ){
						$.messager.alert('操作提示','必须且只能选择一行！','info');
						return ;
					}
					showDialog("win","${prePath}/system/datadict/edit"); 
				}
			}, '-', {
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
							url : "${prePath}/system/datadict/delete",//请求目的URL
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
			} ],
			//列    
			columns : [ [ {
				field : 'select',
				checkbox: true,
				width : 100
			}, {
				field : 'id',
				title : 'id',
				width : 100
			}, {
				field : 'key',
				title : '键',
				width : 100
			}, {
				field : 'value',
				title : '值',
				width : 100
			}, {
				field : 'enable',
				title : '有效',
				width : 100
			}, {
				field : 'parentid',
				title : '父级id',
				width : 100
			} ] ]
		});		
		</script>
	</body>

</html>