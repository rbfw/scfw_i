/**
 * 菜单操作
 */
$(function(){
	var isLogin = $("#isLogin").val();
	//alert(isLogin);
	if('yes'==isLogin){
		location.href=root+"foodController/queryFoods.html";
	}
	$(".loginDiv").show();
	$(".loginDiv").animate({marginTop:'250px'},200,function(){
		$(".loginDiv").animate({marginTop:'200px'},100);
	});
	
	
	$("input[name='userName'],input[name='userPwd']").bind('keypress',function(event){
        if(event.keyCode == "13"){
           $(".loginBtn").trigger('click');
        }
    });
	
	$(".loginBtn").bind("click",function(){
		var flag = loginValide();
		if(flag=="false"){return;}
		$("#userLogin").ajaxSubmit({
			dataType : 'json',
			success : function(data) {
				if (data.isSuccess == 1) {
					window.location.href=root+"foodController/queryFoods.html";
				}else{
					alert(data.msgInfo);
				}
			}
		});
	});
	//登录验证
	function loginValide(){
		var uname = $.trim($("input[name='userName']").val());
		var upwd = $.trim($("input[name='userPwd']").val());
		if(uname==''){
			alert('请输入用户名！');
			return "false";
		}else if(upwd==''){
			alert('请输入密码！');
			return "false";
		}else{
			return "true";
		}
	}
});