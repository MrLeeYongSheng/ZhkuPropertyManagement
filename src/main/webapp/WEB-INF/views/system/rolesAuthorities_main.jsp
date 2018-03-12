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
		<table id="tg"></table>
		<table id="dg"></table>
		<div id="mm1" class="easyui-menu"   style="width:120px;">
			<div data-options="iconCls:'icon-add'">添加角色</div>
		</div>		
		<div id="mm2" class="easyui-menu" style="width:120px;">
			<div data-options="iconCls:'icon-remove'">删除角色</div>
			<div data-options="iconCls:'icon-edit'">修改角色</div>
			<div data-options="iconCls:'icon-add'">添加权限</div>
		</div>		
		<div id="mm3" class="easyui-menu" style="width:120px;">
			<div data-options="iconCls:'icon-remove'">删除权限</div>
		</div>	
		<div id="win"/>	
		<script type="text/javascript">
		
		//treegrid
		
			$('#tg').treegrid({
				url: '${prePath}/system/rolesAuthorities/getRolesAuthoritiesAll',
				fitColumns: true,
				idField: 'id',
				treeField: 'authority',
				loadFilter : function(data){
					var newArray = []
					$.each(data, function(i,obj) {
						$.each(obj.authorities, function(i, auth) {
							auth.id = obj.id + "-" + auth.id;
						});
						var newObj = {
							id : obj.id,
							authority : obj.role,
							enable : obj.enable,
							remark : obj.remark,
							children : obj.authorities
						};
						newArray.push(newObj);
					});
					var root = {
							id : 'root',
							authority : '角色',
							enable : false,
							remark : '',
							children : newArray
						};
					return [root];
				},
				onContextMenu : function(e, row){
					$('#mm1').menu({    
					    onClick:function(item){
							showDialog("win","${prePath}/system/rolesAuthorities/roles_add");
					    }    
					}); 
					$('#mm2').menu({    
					    onClick:function(item){
							if(item.text=='删除角色') {
								$.post("${prePath}/system/rolesAuthorities/roles/delete", { id: row.id },
								   	function(data){
										$("#tg").treegrid('reload');
								  }, "json");					    		
							} else if(item.text=='修改角色') {
								showDialog("win","${prePath}/system/rolesAuthorities/roles_edit");
							} else if(item.text=='添加权限') {
								showDialog("win","${prePath}/system/rolesAuthorities/auths_add");
							} else{
								alert('菜单名不符');
							}
					    }    
					}); 
					$('#mm3').menu({    
					    onClick:function(item){
				    		var id = row.id.split('-')[1];
							$.post("${prePath}/system/rolesAuthorities/auths/deleteToRole", 
								{ 
									'roleId': row._parentId,
									'authId': id
								},
							   	function(data){
									$("#tg").treegrid('reload');
							  }, "json");					    		
					    }    
					}); 
 					if (row && row.id=='root'){
						e.preventDefault();
						$(this).treegrid('select', row.id);
						$('#mm1').menu('show',{
							left: e.pageX,
							top: e.pageY
						});
						$("#mm1").menu('onClick');
					} else if(row && row._parentId=='root') {
						e.preventDefault();
						$(this).treegrid('select', row.id);
						$("#mm2").menu('show',{
							left: e.pageX,
							top: e.pageY
						});
					} else if(row) {
						e.preventDefault();
						$(this).treegrid('select', row.id);
						$("#mm3").menu('show',{
							left: e.pageX,
							top: e.pageY
						});
					}	 			
				},
				columns: [
					[{
							title: '角色-权限',
							field: 'authority',
							width: 120
						},
						{
							field: 'remark',
							title: '备注',
							width: 120
						}
					]
				]
			});
		
		
		//datagrid
		
		$('#dg').datagrid({
			//数据源
			url : '${prePath}/system/rolesAuthorities/auths/getAuthsListAll',
			cache : false,//取消datagrid缓存
			//行宽填充窗体
			fitColumns : true,
			striped : true,//显示斑马效果
			idField : "id", //指明哪一个字段是标识字段
			rownumbers : true,//显示一个行号列
			//菜单栏
			toolbar : [ {
				iconCls : 'icon-add',
				text : '增加',
				handler : function() {
					showDialog("win","${prePath}/system/rolesAuthorities/auths_insert"); 
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
					showDialog("win","${prePath}/system/rolesAuthorities/auths_update"); 
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
							url : "${prePath}/system/rolesAuthorities/auths/delete",//请求目的URL
							traditional : true,//用传统的方式来序列化数据,去除参数名的[]
							data : {//请求数据
								ids : pks
							},
							success : function(msg) {//数据返回时所执行的函数
								$('#dg').datagrid('clearSelections'); //把CheckBox历史选项清空
								$('#dg').datagrid('reload');//从新加载reload
								$("#tg").treegrid('reload');
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
				field : 'authority',
				title : '权限',
				width : 100
			}, {
				field : 'remark',
				title : '备注',
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