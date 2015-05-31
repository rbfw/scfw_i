<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<title>查询用户列表</title>
<link href="${basePath}/css/base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${basePath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${basePath}/js/comm.js"></script>
<script type="text/javascript" charset="utf-8" >
	$(document).ready(function(){
		//添加
		$(".addBtn").bind("click",function(){
			window.location.href=root+"userController/addUser.do";
		});
		//编辑
		$(".editBtn").bind("click",function(){
			var uid = $(this).attr('uid');
			window.location.href=root+"userController/"+uid+"/editUser.do";
		});
		//查看
		$(".viewBtn").bind("click",function(){
			var uid = $(this).attr('uid');
			window.open(root+"userController/"+uid+"/showUser.do");
		});
		//删除
		$(".deleteBtn").bind("click",function(){
			if(confirm(delConfirmInfo)){
				var uid = $(this).attr('uid');
				var thisEle = this;
				$.ajax({
					type:'post',
					url:uid+'/deleteUser.do',
					data:{},
					success:function(data){
						alert(dsInfo);
						deleteRowTR(thisEle);
					},error:function(e){
						alert(eInfo);
					}
				});
			}
		});
		//刷新
		$(".flushBtn").bind("click",function(){
			window.location.reload(true);
		});
		
	});
</script>
</head>
<body>
	<div class="module_title" >用户信息</div>
	<table class="mytb" width="60%" >
		<thead>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>昵称</th>
				<th>余额</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${users }" varStatus="s">
		<tr>
		<td class="tct"><c:out value="${s.count }"></c:out></td>
		<td><c:out value="${user.userName }"></c:out></td>
		<td><c:out value="${user.nickName }"></c:out></td>
		<td><fmt:formatNumber type="currency" value="${user.myBanlance }"></fmt:formatNumber> </td>
		<td><fmt:formatDate value="${user.createDate }" pattern="yyyy年MM月dd日 HH:mm:ss"  /></td>
		<td class="tct">
			<!-- <input type="button" value="修改" /> -->
			<a href="###" uid="${user.id }" class="editBtn">修改</a>
			<a href="###" uid="${user.id }" class="deleteBtn">删除</a>
			<a href="###" uid="${user.id }" class="viewBtn">查看</a>
			<!-- <input type="button" value="删除" /> -->
		</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
			<input type="button" class="addBtn" value="添加" />
			<input type="button" class="flushBtn" value="刷新" />
			</td>
		</tr>
		</tbody>
	</table>
	
</body>
</html>
