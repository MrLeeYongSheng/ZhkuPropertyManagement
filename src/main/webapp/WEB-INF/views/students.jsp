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
			url : '${prePath}/student_data.json',
			//行宽填充窗体
			fitColumns : true,
			idField : "usersUsername", //指明哪一个字段是标识字段
			pagination : true,//在DataGrid控件底部显示分页工具栏
			rownumbers : true,//显示一个行号列
			pageSize : 1,//初始化页面大小
			pageList : [ 1, 3, 5, 10, 20 ],//初始化页面大小选择列表
			//菜单栏
			toolbar : [ {
				iconCls : 'icon-add',
				text : '增加',
				handler : function() {
					alert('增加按钮');
					$('#win').dialog({
						title : '添加学生页面',
						width : 900,
						height : 500,
						cache : false,
						modal : true,//将窗体显示为模式化窗口
						content:"<iframe src='${prePath}/students/student_add2' frameborder='0' width='100%' height='100%'></iframe>",//所要加载的内容
						buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								// submit the form
								var win = $("iframe").get(0).contentWindow;//获取本窗体的iframe模块的窗体对象
								win.$("#ff").submit();
							}
						},{
							text:'清空',
							iconCls:'icon-reload',
							handler:function(){
								var win = $("iframe").get(0).contentWindow;//获取本窗体的iframe模块的窗体对象
								win.$("#ff").form("clear");
							}
						},{
							text:'关闭',
							iconCls:'icon-cancel',
							handler:function(){
								$("#win").dialog("close");
							}
						}]
						
					});
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '修改',
				handler : function() {
					alert('修改按钮')
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
					alert('删除按钮')

				}
			}, '-', {
				iconCls : 'icon-help',
				text : '帮助',
				handler : function() {
					alert('帮助按钮');
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
		$('#dg').datagrid('load',{});
	</script>
</body>
</html>