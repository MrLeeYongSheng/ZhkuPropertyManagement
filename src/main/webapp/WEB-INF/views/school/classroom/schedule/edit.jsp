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
						<span>教室修改</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">日期</td>
				<td><input id="id" name="id" type="hidden"> <input
					id="classroomId" name="classroomId" type="hidden"> <input
					id="dd" name="date" type="text"></td>
			</tr>

			<tr>
				<td class="label">有效性</td>
				<td>
					<input id="enable" name="enable" class="easyui-switchbutton" 
						data-options="onText:'有效',offText:'无效',width:278,checked:false" value="true"> 
					<input id="disable" name="enable" type="hidden" value="false" />
				</td>
			</tr>

			<tr>
				<td class="label">第1节</td>
				<td><input id="c1" name="c1" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c1_f" name="c1" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第2节</td>
				<td><input id="c2" name="c2" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c2_f" name="c2" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第3节</td>
				<td><input id="c3" name="c3" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c3_f" name="c3" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第4节</td>
				<td><input id="c4" name="c4" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c4_f" name="c4" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第5节</td>
				<td><input id="c5" name="c5" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c5_f" name="c5" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第6节</td>
				<td><input id="c6" name="c6" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c6_f" name="c6" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第7节</td>
				<td><input id="c7" name="c7" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c7_f" name="c7" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第8节</td>
				<td><input id="c8" name="c8" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c8_f" name="c8" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第9节</td>
				<td><input id="c9" name="c9" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c9_f" name="c9" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第10节</td>
				<td><input id="c10" name="c10" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c10_f" name="c10" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第11节</td>
				<td><input id="c11" name="c11" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c11_f" name="c11" type="hidden"
					value="false" /></td>
			</tr>
			<tr>
				<td class="label">第12节</td>
				<td><input id="c12" name="c12" class="easyui-switchbutton"
					data-options="onText:'占用',offText:'空闲',width:278,checked:false"
					value="true"> <input id="c12_f" name="c12" type="hidden"
					value="false" /></td>
			</tr>
		</table>
	</form>
	<div
		style="height: 34px; padding: 5px; margin-right: 210; text-align: right;">
		<a id="btn_submit" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-ok'">提交</a> <a id="btn_reset" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
	</div>
	<script type="text/javascript">
		$(function() {

			//日期
			$('#dd').datebox({
				width : 278,
				required : true
			});

			$('#ff').form({
				url : "${prePath}/school/classroom/schedule/edit",
				onSubmit : function() {
					var isValid = $(this).form('validate');
					return isValid;
				},
				success : function(data) {
					var jsonData = $.parseJSON(data)
					if (jsonData.code == 1) {
						parent.$("#win").dialog("close");
						parent.$("#dg").datagrid("reload");
						parent.$('#dg').datagrid('clearSelections'); //把CheckBox历史选项清空
					} else {
						$.messager.alert('操作结果', jsonData.msg, 'info');
					}
				}
			});

			changeSwitchButton($("#enable"), $("#disable"));
			for (i = 1; i < 13; i++) {
				changeSwitchButton($("#c" + i), $("#c" + i + "_f"));
			}

			//从父页面获取数据,并填充到表单
			var row = parent.$("#dg").datagrid("getSelected");
			$("#ff").form("load", row);

			$('#btn_submit').bind('click', function() {
				$("#ff").submit();
			});
			$('#btn_reset').bind('click', function() {
				$("#ff").form("reset");
			});
		});
	</script>
</body>

</html>