<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jspf/commonHeader.jspf"%>
<%@include file="/jspf/form.css.jspf"%>
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
						<span>基本信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">用户名</td>
				<td><input type="text" name="userNameId" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填'"></td>
				<td class="label">姓名</td>
				<td><input type="text" name="userName" class="easyui-textbox"
					data-options="required:true,width:278,prompt:'必填'"></td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td><input name="sex" class="easyui-switchbutton" checked
					data-options="onText:'男',offText:'女',width:278"></td>
				<td class="label">年龄</td>
				<td><input type="text" name="age" class="easyui-textbox"
					data-options="width:278"></td>
			</tr>
			<tr>
				<td class="label">职务</td>
				<td><input type="text" name="post" data-toggle="topjui-textbox"
					data-options="width:278"></td>
				<td class="label">固定电话</td>
				<td><input type="text" name="telephone"
					data-toggle="topjui-textbox"
					data-options="required:true,validType:'telephone',width:278">
				</td>
			</tr>
			<tr>
				<td class="label">电子邮箱</td>
				<td><input type="text" name="email"
					data-toggle="topjui-textbox"
					data-options="required:true,validType:'email',prompt:'必填',width:278">
				</td>
				<td class="label">手机</td>
				<td><input type="text" name="mobile"
					data-toggle="topjui-textbox"
					data-options="required:true,validType:'cellphone',prompt:'必填',width:278">
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="divider">
						<span>其它信息</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">国家</td>
				<td><input type="text" name="country"
					data-toggle="topjui-textbox" data-options="readonly:true,width:278">
				</td>
				<td class="label">省份</td>
				<td><input type="text" name="province"
					data-toggle="topjui-textbox" data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">城市</td>
				<td><input type="text" name="city" data-toggle="topjui-textbox"
					data-options="readonly:true,width:278"></td>
				<td class="label">区县</td>
				<td><input type="text" name="district"
					data-toggle="topjui-textbox" data-options="readonly:true,width:278"></td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td><input type="text" name="nativePlace"
					data-toggle="topjui-combobox"
					data-options="url:remoteHost + '/system/codeItem/getListByCodeSetIdAndLevelId?codeSetId=AAAC&levelId=1',
                       width:278,
                       valueField:'text',
                       panelHeight:'250'">
				</td>
				<td class="label">民族</td>
				<td><input type="text" name="nation"
					data-toggle="topjui-combobox"
					data-options="url:remoteHost + '/system/codeItem/getListByCodeSetIdAndLevelId?codeSetId=AAAB&levelId=2',
                       width:278,
                       valueField:'text',
                       panelHeight:'250'"></td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td><input type="text" name="idCard"
					data-toggle="topjui-textbox" data-options="width:278"></td>
				<td class="label">毕业院校</td>
				<td><input type="text" name="school"
					data-toggle="topjui-textbox" data-options="width:278"></td>
			</tr>
			<tr>
				<td class="label">学历</td>
				<td><input type="text" id="education" name="education"
					data-toggle="topjui-combobox"
					data-options="url:remoteHost + '/system/codeItem/getListByCodeSetIdAndLevelId?codeSetId=AABA&levelId=5',
                       width:278,
                       valueField:'text',"></td>
				<td class="label">学位</td>
				<td><input type="text" id="degree" name="degree"
					data-toggle="topjui-combobox"
					data-options="url:remoteHost + '/system/codeItem/getListByCodeSetIdAndLevelId?codeSetId=AABB&levelId=5',
                       width:278,
                       valueField:'text',"></td>
			</tr>
			<tr>
				<td class="label">备注</td>
				<td colspan="3"><textarea name="remark"
						style="height: 100px; width: 500px;"></textarea></td>
			</tr>
		</table>
	</form>
    <div style="height: 34px; padding: 5px; text-align: right;">
        <a id="btn_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
        <a id="btn_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
    </div>	

	<script type="text/javascript">
	$('#ff').form('load', {
		userNameId : 'name2',
		userName : 'mymail@gmail.com'
	});	
		/* $('#ff').form({
			url : "${prePath}/students/add",
		    onSubmit: function(){
		    	alert("onSubmit");
				var isValid = $(this).form('validate');
				return isValid;
		    },    
		    success:function(data){
		    	alert(data);
		    }
		}); */ 		
		$(function(){    
		    $('#btn_submit').bind('click', function(){    
		        alert('btn_submit');
		        $("#ff").submit();
		    });    
		    $('#btn_reset').bind('click', function(){    
		        alert('btn_submit'); 
		        $("#ff").form("reset");
		    });    
		}); 
	</script>
</body>
</html>