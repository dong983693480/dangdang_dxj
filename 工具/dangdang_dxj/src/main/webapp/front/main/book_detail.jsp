<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="../css/book_detail.css"/>
		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
		
			
		
			<h1>
				丛书名：${dd.book_name}
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${path}/back/img/${dd.src}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${dd.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${dd.company }</td>
			</tr>
			<tr>
				<td>出版时间：${dd.publish_time } </td>
				<td>字数：${dd.wordCount }</td>
			</tr>
			<tr>
				<td>版次：${dd.edition }</td>
				<td>页数：${dd.pagination }</td>
			</tr>
			<tr>
				<td>印刷时间：${dd.print_time }</td>
				<td>开本：${dd.sizes }</td>
			</tr>
			<tr>
				<td>印次：${dd.print_count }</td>
				<td>纸张：${dd.paper }</td>
			</tr>
			<tr>
				<td>ISBN：${dd.isbn }</td>
				<td>包装：${dd.pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${dd.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${dd.dd_price }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${dd.price-dd.dd_price }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${path}/addCart?id=${dd.id}">
						<img src='${path}/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;${dd.e_recommend }</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;${dd.book_description }</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>&nbsp;&nbsp;${dd.aboutTheAuthor }</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>&nbsp;&nbsp;${dd.baseDirectory }</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>&nbsp;&nbsp;${dd.pressReview }</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
