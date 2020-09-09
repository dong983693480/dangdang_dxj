<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <title>order</title>
	<link rel="stylesheet" href="${path}/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
  </head>
  <body style="background-color: #f0f9fd;text-align: center">
  <div align=center style="font-size:25px">订单详细信息</div><hr/>
  	 <table bordercolor='#898E90' align='center' border='3px' cellpadding='5px' cellspacing="0px">
  	 	<c:forEach items="${allorder}" var="a">
  	 		<c:if test="${a.id==id}">
  	 			<tr bgcolor="lightblue" align="center"> 
             <td>订单号：${a.order_number }</td>
             <td colspan="2">订单金额：¥：${a.total_price}</td>
             <td colspan="2">订单状态：未支付</td>
          </tr>
  	 		</c:if>
  	 	</c:forEach>
          
          <c:forEach items="${allorder1}" var="b">
			<tr align='center'> 
				 <td>${b.book_name }</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src="${path}/back/img/${b.src}"></td>
				 <td style="width: 180px;">单价：¥${b.price }</td>
				 <td style="width: 200px;">当当价：¥${b.dd_price }</td>
				 <td style="width: 100px;">${b.count }本</td>
			</tr>
			</c:forEach>
          
     </table> 
	<input class="button btn-p" value="返回上级" onclick="history.go(-1);" style="margin-top: 10px"/>
  </body>
</html>
