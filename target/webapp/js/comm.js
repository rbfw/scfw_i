/**
 * 公用js
 */
var root = "/ebs/";
var ssInfo = "保存成功！";
var dsInfo = "删除成功！";
var osInfo = "操作成功！";
var erInfo = "出错啦！";
var delConfirmInfo = "是否确认删除？";

$(function(){
	
	$(".top_menu").fadeIn(1000);
	//判断用户是否登录
	var userId = $("#userId").val();
	var isLoginPage = $("#isLoginPage").val();
	if('yes'!=isLoginPage){
		if(''==userId || null == userId){location.href=root+"userController/login.html";}
	}
	//退出系统
	$(".exitLogin").bind('click',function(){
		var Rand = Math.random();
		$.ajax({
			url: root+"userController/loginOut.html?"+Rand,
			success: function(){
				location.href=root+"userController/login.html";				
			}
		});
	});
	
	//判断浏览器版本，版本过低则不允许房屋
	if (!$.support.leadingWhitespace) {
		alert('亲，您的浏览器版本过低，建议您去下载较新版本的浏览器喔！');
		location.href="http://www.firefox.com.cn/";
	}
	//首页
	$(".index").bind("click",function(){
		location.href=root+"foodController/queryFoods.html";
	});
	//查看今天已点菜
	$(".todayOrderItems").bind("click",function(){
		location.href=root+"foodController/todayOrderItems.html";
	});
	
	$(".alertClose").bind('click',function(){
		$(".disableDiv").hide();
	});
	$(".yesBtn").bind('click',function(){
		$(".disableDiv").hide();
		fn(true);
	});
	$(".noBtn").bind('click',function(){
		$(".disableDiv").hide();
		fn(false);
	});
	
});

function altT(title,content){
	$(".disableDiv .alert .alert_t .alertTitle").html(title);
	$(".disableDiv .alert .alert_c").html(content);
	$(".disableDiv .alert .alert_b .noBtn").hide();
	$(".disableDiv").show();
}
function alt(content){
	$(".disableDiv .alert .alert_t .alertTitle").html('温馨提示');
	$(".disableDiv .alert .alert_c").html(content);
	$(".disableDiv .alert .alert_b .noBtn").hide();
	$(".disableDiv").show();
}
var fn = null;
function cfm(content,f){
	fn = f;
	$(".disableDiv .alert .alert_t .alertTitle").html('温馨提示');
	$(".disableDiv .alert .alert_c").html(content);
	$(".disableDiv .alert .alert_b .noBtn").show();
	$(".disableDiv").show();
}

function cfmT(title,content){
	$(".disableDiv .alert .alert_t .alertTitle").html(title);
	$(".disableDiv .alert .alert_c").html(content);
	$(".disableDiv .alert .alert_b .noBtn").show();
	$(".disableDiv").show();
}

function deleteRowTR(element){
	//var h1 = $(element).parent().parent().html();
	/*alert(h1);*/
	$(element).parent().parent().remove();
}