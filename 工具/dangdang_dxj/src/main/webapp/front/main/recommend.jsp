<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<h2>编辑推荐</h2>
<c:forEach var="l" items="${list1}">
<div class=second_c_02_b1>
	
		<div class=second_c_02_b1_1>
			<a href='${path}/selectBookId1?id=${l.id}' target='_blank'><img class="zoom" src="${path}/back/img/${l.src}"
				width=70 border=0 /> </a>
		</div>
		<div class=second_c_02_b1_2>
			<h3>
				<a href='${path}/selectBookId1?id=${l.id}' target='_blank'>${l.book_name}</a>
			</h3>
			<h4>
				作者：${l.author } 著 <br /> 出版社：${l.company }&nbsp;&nbsp;&nbsp;&nbsp;
				出版时间：
				<f:formatDate value="${l.publish_time }" pattern="yyyy年MM月dd日" />
			</h4>
			<h5>
				介绍 <span class=pot>${l.book_description }</span>
			</h5>
			<h6>
				定价：￥${l.price }&nbsp;&nbsp; 当当价：￥${l.dd_price } 销量：<font color="red">${l.sale_count}</font>
			</h6>
		</div>

</div>
	</c:forEach>

