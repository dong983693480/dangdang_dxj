<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${path}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function changeCount(id){
				var count = $("#"+id).val();
				var validate = /^[1-9]\d*$/;
				if(validate.test(count)){
					location.href="/dangdang_dxj/updateCount?id="+id+"&count="+count;
					
				}else{
					alert("请输入正确的格式");
				}
			}
		</script>
		
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${path}/front/images/pic_myshopping.gif" />
		</div>
		
			<c:if test="${cart==null}">
				<div id="div_no_choice">
				<div class="choice_title"></div>
				<div class="no_select">
				您还没有挑选商品[<a href='${path }/quanbu'> 继续挑选商品&gt;&gt;</a>]
			</div>
			</div>
			</c:if>
			<c:if test="${cart.zongddjia==0}">
				<div id="div_no_choice">
				<div class="choice_title"></div>
				<div class="no_select">
				您还没有挑选商品[<a href='${path }/quanbu'> 继续挑选商品&gt;&gt;</a>]
			</div>
			</div>
			</c:if>
		<c:if test="${cart!=null}">	
			<c:if test="${cart.zongddjia!=0}">
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
					<!-- 购物列表开始 -->
						
						<c:forEach items="${cart.map}" var="t">
						
					
						<tr class='td_no_bord'>
						
						<td style='display: none'>
							<%-- ${t.count} --%>
						</td>
						<td class="buy_td_6">
							<span class="objhide">
								<img src="" /> 
							</span>
						</td>
						<td>
							<a href="">${t.value.book_name }</a>
						</td>
						<td class="buy_td_5">
							<span class="c_gray">￥${t.value.price }</span>
						</td>
						<td class="buy_td_4">
							&nbsp;&nbsp;
							<span>￥${t.value.dd_price }</span>
						</td>
						<td class="buy_td_1">
							&nbsp;&nbsp;${t.value.count }
						</td>

						<td >
							<input  id="${t.key}" class="del_num" type="number" size="3" name="count" maxlength="4"  />
							<a href="#" onclick="changeCount('${t.key}')">变更</a>
						</td>
						<td>
							<a href="${path}/deleteCart?id=${t.key}">删除</a>
						</td>
					</tr>
					</c:forEach>
					
				</table>

				<div class="choice_balance">
					<div class="select_merch">
						<a href='${path }/quanbu'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${cart.zongjia-cart.zongddjia}</span> </span>
							<span style="font-size: 14px">|</span>
							
							<span class="c_red_b"> ￥<span id='total_account'>${cart.zongddjia}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${path}/front/order/order_info.jsp' > 
								<img src="${path}/front/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		</c:if>
		<!--页尾开始 -->
		<div style="position:absolute;bottom: 10px;width:100%;">
			<%@include file="../common/foot.jsp"%>
		</div>
		<!--页尾结束 -->
	</body>
</html>



