/**
 * 自定义函数库
 */
function showDialog(id,path,title) {
	$('#'+id).dialog({
		title : title,
		width : 900,
		height : 500,
		cache : false,
		modal : true,//将窗体显示为模式化窗口
		content:"<iframe src='"+path+"' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
	});				
}

function showDialogWithAll(id,path,title,height,width,cache,model,closable,draggable,resizable) {
	$('#'+id).dialog({
		title : title,
		width : width,
		height : height,
		cache : cache,
		modal : model,//将窗体显示为模式化窗口
		closable : closable,
		draggable : draggable,
		resizable : resizable,
		content:"<iframe src='"+path+"' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
	});				
}

function showDialogByEleObj(obj,path,title) {
	obj.dialog({
		title : title,
		width : 900,
		height : 500,
		cache : false,
		modal : true,//将窗体显示为模式化窗口
		content:"<iframe src='"+path+"' frameborder='0' width='100%' height='100%'></iframe>"//所要加载的内容
	});				
}

/**
 * 改变SwitchButton的值
 * @param obj 标签对象,按钮对象
 * @param disObj 隐藏的提交对象
 * @returns
 */
function changeSwitchButton(obj,disObj) {
	obj.switchbutton({
		onChange : function(checked) {
			if (checked) {
				disObj.attr("disabled", true);
			} else {
				disObj.attr("disabled", false);
			}
		}
	});			
}