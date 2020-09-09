<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%><html>
	<head>
		<link rel="stylesheet" href="../css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/cx'">添加二级类别&raquo;</div>
		</div>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach var="cc" items="${all}">
			<tr>
				<td>${cc.id}</td>
				<td>${cc.cate_name}</td>
				<td></td>
				<td>${cc.levels}</td>
				<c:if test="${cc.d.size()==0}">
				<td><a href="${pageContext.request.contextPath}/delete1?id=${cc.id}">删除</a></td>
				</c:if>
			</tr>
			<c:forEach var="x" items="${cc.d}">
			<tr>
				<td>${x.id}</td>
				<td>${x.cate_name}</td>
				<td>${cc.cate_name}</td>
				<td>${x.levels}</td>
				<td><a href="${pageContext.request.contextPath}/delete1?id=${x.id}">删除</a></td>
			</tr>
			</c:forEach>
			</c:forEach>
			
		</table><br/>
		
	</body>  
</html>



