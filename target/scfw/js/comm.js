/**
 * 公用js
 */
var root = "/ebs/";
var ssInfo = "保存成功！";
var dsInfo = "删除成功！";
var osInfo = "操作成功！";
var erInfo = "出错啦！";
var delConfirmInfo = "是否确认删除？";

function deleteRowTR(element){
	//var h1 = $(element).parent().parent().html();
	/*alert(h1);*/
	$(element).parent().parent().remove();
}