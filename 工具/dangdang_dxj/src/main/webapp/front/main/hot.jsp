<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>

<div class="book_c_04">
		<c:forEach var="l" items="${list3}">
		<!--热销图书A开始-->
	<div class="second_d_wai">
		
		<div class="img">
			<a href="${path}/selectBookId1?id=${l.id}" target='_blank'>
				<img class="zoom" src="${path}/back/img/${l.src}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${path}/selectBookId1?id=${l.id}" target="_blank">${l.book_name}</a><a href="${path}/selectBookId1?id=${l.id}" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${l.price}
		</div>
		<div class="price">
			当当价：￥${l.dd_price}
		</div>
		<div class="price">
			销量：<font color="red">${l.sale_count}</font>
		</div>
		
	</div>
	</c:forEach>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	
	

</div>

<div class="clear"></div>