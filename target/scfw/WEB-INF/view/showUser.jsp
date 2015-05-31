<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>查看用戶信息</title>
	<link href="${basePath}/css/base.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="module_title">用户详细信息</div>
【${su.userName }】
【${su.nickName }】
【${su.myBanlance }】
【${su.power }】
【<fmt:formatDate value="${su.createDate }" pattern="yyyy年MM月dd日 HH:mm:ss"  />】
【${su.sex }】
【${su.favoriteBall }】
【${su.workarea }】
<div class="module_title"></div>
<input type="button" value="关闭" onclick="window.close()" />
</body>
</html>
