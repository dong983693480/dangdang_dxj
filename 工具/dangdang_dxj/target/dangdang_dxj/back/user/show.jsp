<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;">
		<div align=center style="font-size:25px">用户管理</div><hr/>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
			<tr bgcolor='lightblue' align='center'>
				<td>Id</td>
				<td>昵称</td>
				<td>邮箱</td>
				<td>状态</td>
				<td>激活码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="l">
			<tr align='center'>
				<td>${l.id}</td>
				<td>${l.nick_name}</td>
				<td>${l.email}</td>
				<c:if test="${l.status==1}">
					<td>正常</td>
				</c:if>
				<c:if test="${l.status==2}">
					<td>冻结</td>
				</c:if>
				
				<td>sdihdt</td>
				<td>
					<input class="button" onclick="location.href='${path}/updateUser?id=${l.id}'" value="修改 &raquo;" />
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>  
</html>



