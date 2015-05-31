/**
 * 菜单操作
 */
$(function(){
	
	$(".foodList").slideDown(1000);
	//点你
	$(".DNBtn").bind("click",function(){
		var r = confirm("确认后就不能修改咯？");
		if(r){
			var fid = $(this).attr("fid");
			$("input[name='foodIds'][value='"+fid+"']").attr("checked", true);
			$("#foodForms").ajaxSubmit({
				dataType : 'json',
				success : function(data) {
					if (data.isSuccess == 1) {
						alert('恭喜您，点餐成功！');
						deleteRowTR(this);
						//window.location.href=root+"foodController/queryFoods.html";
					}else{
						alert(data.msgInfo);
					}
				}
			});
		}
	});
	//提交菜单
	$(".submitBtn").bind("click",function(){
		var foodIds = $("input[name='foodIds']:checked");
		if(foodIds.length>0){
			var r = confirm("确认后就不能修改咯？");
			if(r){
				$("#foodForms").ajaxSubmit({
					dataType : 'json',
					success : function(data) {
						if (data.isSuccess == 1) {
							alert('恭喜您，点餐成功！');
							window.location.href=root+"foodController/queryFoods.html";
						}else{
							alert(data.msgInfo);
						}
					}
				});
			}
		}else{
			alert("请先选择您需要点的菜喔！");
		}
		
	});
	//刷新页面
	$(".flushBtn").bind("click",function(){
		location.reload();
	});
	//弹出
	$(".alertBtn").bind("click",function(){
		altT('警告','您的余额已经不足10元，请及时充值！');
		//alt("确认后将不可修改，是否继续？");
	});
	//弹出
	$(".confirmBtn").bind("click",function(){
		//altT('警告','您的余额已经不足10元，请及时充值！');
		cfm("确认后将不可修改，是否继续？",function(r){
			if(r){
				
			}
		});
	});
	
});