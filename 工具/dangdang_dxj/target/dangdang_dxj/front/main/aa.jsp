<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${path}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".zoom").mouseover(function(e){
					var bigImg = $("<img id='bImg' src='"+$(this).attr("src")+"'/>");
					$(bigImg).css({
						"top" : e.pageY + 5,
						"left" : e.pageX + 5,
						"position" : "absolute",
						"height" : "200px"
					})
					$("body").append(bigImg);
				}).mouseout(function(){
					$("#bImg").remove();
				}).mousemove(function(e){
					$("#bImg").css({
						"top" : e.pageY + 5,
						"left" : e.pageX + 5,
						"position" : "absolute",
						"height" : "200px"
					})
				})
			});
		</script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="/front/common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank">
				<img src="${path }/front/images/default/book_banner_081203.jpg" border="0" />
			</a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<%@ include file="category.jsp" %>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<%@ include file="recommend.jsp" %>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<%@ include file="hot.jsp" %>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<%@ include file="new.jsp" %>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->

			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<div id="NewProduct_1_o_t" onmouseover="">
							<%@ include file="hotBoard.jsp" %>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>