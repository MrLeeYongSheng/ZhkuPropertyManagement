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