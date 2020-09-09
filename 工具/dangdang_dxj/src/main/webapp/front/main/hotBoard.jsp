<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<c:forEach var="l" items="${list4}">
		<li>&nbsp;&nbsp;&nbsp;
		
		<a  target='_blank' href="${path}/selectBookId1?id=${l.id}">
				${l.book_name}
			</a>
		</li>
		</c:forEach>
	</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>