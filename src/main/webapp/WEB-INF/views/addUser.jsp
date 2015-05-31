<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<title>添加用户信息</title>
<link href="${basePath}/css/base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${basePath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/js/comm.js"></script>
<script type="text/javascript" charset="utf-8" >
	$(document).ready(function(){
		$(".backBtn").bind("click",function(){
			window.location.href=root+"userController/queryUsers.do";
		});
		
		$(".submitBtn").bind("click", function() {
			var userPwd = $("#userPwd").val();
			if('' == userPwd){$("#userPwd").val('1234');}
			$("#srModel").ajaxSubmit({
				dataType : 'json',
				success : function(data) {
					alert(data.msgInfo);
					if (data.isSuccess = 1) {
						//console.info(data);
						$("#id").val(data.model.id);
						//window.location.href=root+"userController/"+data.model.id+"/editUser.do";
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="module_title" >添加用户信息</div>
	<form:form action="submitUser.do"  method="post" commandName="srModel" >
	<form:hidden path="id" />
	<table class="mytb" width="60%" >
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tbody>
		<tr>
			<td class="lable">用户名<span class="sign">*</span></td>
			<td>
				<form:input path="userName" class="ipt request" />
				<span class="sign"></span>
			</td>
		</tr>
		<tr>
			<td class="lable">昵称</td>
			<td><form:input path="nickName" class="ipt" /> </td>
		</tr>
		<tr>
			<td class="lable">密码<span class="sign">*</span></td>
			<td><form:password path="userPwd" class="ipt" /> <span class="sign">默认1234</span></td>
		</tr>
		<tr>
			<td class="lable">性别<span class="sign">*</span></td>
			<td>
				<form:radiobutton path="sex" value="1" class="" />男
				<form:radiobutton path="sex" value="0" class="" />女
			</td>
		</tr>
		<tr>
			<td class="lable">角色<span class="sign">*</span></td>
			<td>
				<form:checkboxes path="roles" items="${srModel.roleList }" delimiter="&nbsp;&nbsp;" class="" />
			</td>
		</tr>
		<tr>
			<td class="lable">最喜爱的运动球类</td>
			<td>
				<form:radiobuttons path="favoriteBall" items="${srModel.svss }" itemLabel="valCn" itemValue="val" delimiter="&nbsp;" class="" />
				<br/>
				<%-- <form:radiobuttons path="favoriteBall" items="${srModel.ballMap }" delimiter="&nbsp;" class="" /> --%>
			</td>
		</tr>
		<tr>
			<td class="lable">工作所在地</td>
			<td>
				<form:select path="workarea" items="${srModel.areaList }" class="" />
			</td>
		</tr>
		<tr>
			<td class="lable">可用余额</td>
			<td><form:input path="myBanlance" class="ipt_50" />&nbsp;元</td>
		</tr>
		<tr>
			<td class="lable">错误信息</td>
			<td colspan="4" align="center">
				<form:errors path="*"/>
			</td>
		</tr>
		<tr>
			<td colspan="5" align="center">
			<input type="button" class="submitBtn" value="保存" />
			<input type="button" class="backBtn" value="返回" />
			</td>
		</tr>
		</tbody>
	</table>
	</form:form>
</body>
</html>
