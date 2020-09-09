<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${path}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path}/front/js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${path}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${path}/quanbu'>当当图书</a> &gt;&gt;
			<c:forEach var="l" items="${fenlei}">
					<c:if test="${l.id==oneid}">
					
						<a href="${path}/selectBy?oneid=${l.id}"><font style='color: #cc3300'><strong>${l.cate_name }</strong> </font>	
						</a>
					</c:if>
					<c:if test="${l.id==tid}">
						<a href="${path}/selectBy?oneid=${l.id}"><strong>${l.cate_name}</strong></a>&gt;&gt;
						<c:forEach var="ll" items="${l.d}">
							<c:if test="${ll.id==oneid}">
						<font style='color: #cc3300'><strong>${ll.cate_name}</strong> </font>
							</c:if>
						</c:forEach>
					</c:if>
				
			</c:forEach>
			
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
						
			<c:forEach var="l" items="${fenlei}">
				<c:if test="${l.id==oneid}">
							<li>
								<div>
									<div class=second_fenlei>
									
										<a href="${path}/selectBy?oneid=${l.id}">&middot;<font style='color: #cc3300'>全部</font>&nbsp;(23)</a>
									</div>
								</div>
								
							</li>
							<div class="clear"></div>
				<c:forEach var="ll" items="${l.d}">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									
									<div class=second_fenlei>
						<a href="${path}/selectBy?tid=${l.id}&oneid=${ll.id}">&nbsp;${ll.cate_name}(10)</a>
									</div>
								</div>
							</li>
							
						    <div class="clear"></div>
				    </c:forEach>
				    </c:if>
					<c:if test="${l.id==tid}">
							<li>
								<div>
									<div class=second_fenlei>
										<a href="${path}/selectBy?oneid=${l.id}">&middot;全部&nbsp;(23)</a>
									</div>
								</div>
								
							</li>
							<div class="clear"></div>
						<c:forEach var="ll" items="${l.d}">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									
						<c:if test="${ll.id!=oneid}">
								<a href="${path}/selectBy?tid=${l.id}&oneid=${ll.id}">&nbsp;${ll.cate_name}(10)</a>
						</c:if>
						<c:if test="${ll.id==oneid}">
								<a href="${path}/selectBy?tid=${l.id}&oneid=${ll.id}"><font style='color: #cc3300'>&nbsp;${ll.cate_name}(10)</font></a>
						</c:if>
						
									</div>
								</div>
							</li>
							
						    <div class="clear"></div>
					</c:forEach>
		    </c:if>
			</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
					<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
					<c:forEach items="${fenlei}" var="l">		
					<c:if test="${l.id==oneid}">
							<c:if test="${page!=1}">	
								<div class='list_r_title_text3a'>
								<a name=link_page_next href="${path}/selectBy?oneid=${l.id}&page=${page-1}">
									<img src='${path}/front/images/page_up.gif' /> 
								</a>
							</div>
							</c:if>
							<c:if test="${page==1}">	
							<div class='list_r_title_text3a'>
								<img src='${path}/front/images/page_up_gray.gif' />
							</div>
							</c:if>
					
						<div class='list_r_title_text3b'>
								第${page}页/共${xx}页
							</div>
							<c:if test="${page<xx}">
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${path}/selectBy?oneid=${l.id}&page=${page+1}">
									<img src='${path}/front/images/page_down.gif' /> 
								</a>
							</div>
							</c:if>
							<c:if test="${page>=xx}">
							<div class='list_r_title_text3a'>
								<img src='${path}/front/images/page_down_gray.gif' />
							</div>
							</c:if>
						</c:if>
						<!--  二级菜单的分页   -->
						<c:forEach items="${l.d}" var="ll">
					<c:if test="${ll.id==oneid}">
						
							
							<c:if test="${page!=1}">	
								<div class='list_r_title_text3a'>
								<a name=link_page_next href="${path}/selectBy?tid=${l.id}&oneid=${ll.id}&page=${page-1}">
									<img src='${path}/front/images/page_up.gif' /> 
								</a>
							</div>
							</c:if>
							<c:if test="${page==1}">	
							<div class='list_r_title_text3a'>
								<img src='${path}/front/images/page_up_gray.gif' />
							</div>
							</c:if>
						
							<div class='list_r_title_text3b'>
								第${page}页/共${xx}页
							</div>
								<c:if test="${page<xx}">
									<div class='list_r_title_text3a'>
										
										<a name=link_page_next href="${path}/selectBy?tid=${l.id}&oneid=${ll.id}&page=${page+1}">
											<img src='${path}/front/images/page_down.gif' /> 
										</a>
									</div>
								</c:if>
								<c:if test="${page>=xx}">
									<div class='list_r_title_text3a'>
										<img src='${path}/front/images/page_down_gray.gif' />
									</div>
								</c:if>
								</c:if>
						</c:forEach>
					
				</c:forEach>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<c:forEach items="${list1}" var="list1">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							<div class="list_r_list">
							
								<span class="list_r_list_book">
									<a name="link_prd_img" href='#'>
										<img src="${path}/back/img/${list1.src}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='#'>${list1.book_name}</a>
								</h2>
								<h3>
									顾客评分：${list1.e_recommend }
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${list1.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${list1.company }</a>
								</h4>
								<h4>
									出版时间：2009-01-01<fmt:formatDate value="${list1.publish_time }" pattern="yyy年MM月dd日" />
								</h4>
								<h5>
									${list1.book_description }
									
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">${list1.price }</span>
									<span class="red">${list1.dd_price }</span>
									节省：￥${list1.price-list1.dd_price }
								</h6>
								<span class="list_r_list_button"> 
								<a href="#"> 
									<img src='${path}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
								
							</div>
						<div class="clear"></div>
						</c:forEach>
						
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
