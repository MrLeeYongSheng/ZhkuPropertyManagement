<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf"%>
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
			url : '${prePath}/students/getStudentsPage',
			queryParams : {enable:true},//加载有效的账号信息
			cache : false,//取消datagrid缓存
			//行宽填充窗体
			fitColumns : true,
			striped : true,//显示斑马效果
			idField : "usersUsername", //指明哪一个字段是标识字段
			pagination : true,//在DataGrid控件底部显示分页工具栏
			rownumbers : true,//显示一个行号列
			pageSize : 2,//初始化页面大小
			pageList : [2, 5, 10, 15],//初始化页面大小选择列表
			onDblClickRow : function(index,row){//双击一行查看详细信息
				$("#dg").datagrid("clearSelections");
				$("#dg").datagrid("selectRow",index);
				$('#win').dialog({
					title : '查看学生页面',
					width : 900,
					height : 500,
					cache : false,
					modal : true,//将窗体显示为模式化窗口
					content:"<iframe src='${prePath}/students/student_detail' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
				});
			},
			//菜单栏
			toolbar : [ {
				iconCls : 'icon-add',
				text : '增加',
				handler : function() {
					$('#win').dialog({
						title : '添加学生页面',
						width : 900,
						height : 500,
						cache : false,
						modal : true,//将窗体显示为模式化窗口
						content:"<iframe src='${prePath}/students/student_add' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
					});
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
					$('#win').dialog({
						title : '修改学生页面',
						width : 900,
						height : 500,
						cache : false,
						modal : true,//将窗体显示为模式化窗口
						content:"<iframe src='${prePath}/students/student_edit' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
					});
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
							pks.push(row.usersUsername);
						});
						$.ajax({
							type : "POST",//请求方式
							dataType : 'json',
							url : "${prePath}/students/delete",//请求目的URL
							traditional : true,//用传统的方式来序列化数据,去除参数名的[]
							data : {//请求数据
								usersUsernames : pks
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
				text : '<input name="name" class="easyui-textbox" data-options="">',
			} , '-', {
				iconCls : 'icon-search',
				text : '查询',
				handler : function() {
					alert('查询按钮');//TODO: 查询
				}
			} ],
			//列    
			columns : [ [ {
				field : 'select',
				checkbox: true,
				width : 100
			}, {
				field : 'usersUsername',
				title : '学号',
				width : 100
			}, {
				field : 'name',
				title : '姓名',
				width : 100
			}, {
				field : 'gender',
				title : '性别',
				width : 100
			}, {
				field : 'campus',
				title : '校区',
				width : 100
			}, {
				field : 'department',
				title : '学院',
				width : 100
			}, {
				field : 'major',
				title : '专业',
				width : 100
			}, {
				field : 'grade',
				title : '年级',
				width : 100
			}, {
				field : 'classnum',
				title : '班级',
				width : 100
			}, {
				field : 'dormitory',
				title : '宿舍',
				width : 100
			} ] ]
		});
	</script>
</body>
</html>