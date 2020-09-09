<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<c:forEach var="x" items="${fenlei}">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${path}/selectBy?oneid=${x.id}&page=1'>${x.cate_name }</a>]
				</h3>
				<ul class="ul_left_list">
						<c:forEach var="xx" items="${x.d}">
							<li>
							<a href='${path}/selectBy?tid=${x.id}&oneid=${xx.id}'>${xx.cate_name}</a>
						</li>
						</c:forEach>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
			
		

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
