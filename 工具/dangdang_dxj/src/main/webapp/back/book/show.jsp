<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="${path}/back/css/btn.css" />
    <meta charset="utf-8">
    
	<style type="text/css">
		table {
			border-right: 1px solid black;
			border-bottom: 1px solid black;
		}
		
		table td {
			padding: 10px;
			text-align:center;
			border-left: 1px solid black;
			border-top: 1px solid black;
		}
</style>
  </head>
  
  <body style="background-color: #f0f9fd;">
  	
  	<div align=center style="font-size:25px">图书管理</div><hr/>  	
  	<div style="margin: 0 auto;text-align:center;">
  		<form action="${path}/mhselect" method="post">
  			<input onclick="location.href='${path}/selectej'" class="button btn-p" value="添加图书&raquo;" />&emsp;&emsp;
		  	<select name="xx" class="el-select__inner inner2">
		  		<option value="book_name">书名</option>
		  		<option value="author">作者</option>
		  		<option value="company">出版社</option>
		  	</select>
		  	<input class="el-input__inner" type="text" placeholder="请输入查询条件" name="name"/>
		  	<input class="el-search-content" type="submit" value="搜索"/>
	  	</form>
  	</div>
  	<div style="margin-top:20px">
  	<table bordercolor='#898E90' align='center' border='3px' cellpadding='5px' cellspacing="0px" >
  		<tr bgcolor='lightblue' align='center'>
			<td style="width: 100px">名称</td>
			<td>作者</td>
			<td>定价</td>
			<td>当当价</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>封面图</td>
			<td>销量</td>
			<td>库存</td>
			<td>操作</td>
  		</tr>
  		
  		<c:forEach var="b" items="${book}">
  			<tr align='center'>
			<td>${b.book_name}</td>
			<td>${b.author}</td>
			<td>${b.price}</td>
			<td>${b.dd_price}</td>
			<td>${b.company}</td>
			<td><f:formatDate value="${b.publish_time }" pattern="yyyy年MM月dd日"/></td>	
			<td>
				<img width="32px" height="20px" src="${path}/back/img/${b.src}" >
			</td>
			<td>${b.sale_count}</td>
			<td>${b.public_count}</td>
			<td>
				<input  class="button"  onclick="location.href='${path}/selectBookId?id=${b.id}'" value="修改 " />
				<input class="button-del" onclick="location.href='${path}/deleteBook?id=${b.id}'" value="删除 " />
			</td>
		</tr>
  		</c:forEach>
  		<c:forEach var="b" items="${list}">
  			<tr align='center'>
			<td>${b.book_name}</td>
			<td>${b.author}</td>
			<td>${b.price}</td>
			<td>${b.dd_price}</td>
			<td>${b.company}</td>
			<td>${b.publish_time }</td>	
			<td>
				<img width="32px" height="20px" src="${path}/back/img/${b.src}" >
			</td>
			<td>${b.sale_count}</td>
			<td>${b.public_count}</td>
			<td>
				<input  class="button"  onclick="location.href='${path}/selectBookId?id=${b.id}'" value="修改 " />
				<input class="button-del" onclick="location.href='${path}/deleteBook?id=${b.id}'" value="删除 " />
			</td>
		</tr>
  		</c:forEach>
  		
  	</table>
  	</div><br>
  </body>
</html>
