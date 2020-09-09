<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${path}/updatebook" method="post" enctype="multipart/form-data">
			<table>
			<td><input type="hidden" name="dd.id" class="el-input__inner" value="${y.id}"></td>
				<tr>
					
					<td>名称：</td>
					<td><input type="text" name="dd.book_name" class="el-input__inner" value="${y.book_name }"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="dd.pagination" class="el-input__inner" value="${y.pagination }" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
					
					<%-- <c:if test="${y.cate_id==e.id}"> --%>
						<select name="dd.cate_id" class="el-select__inner inner2">
							<c:forEach var="e" items="${selectej}">
							<c:if test="${y.cate_id==e.id}">
								<option value="${e.id}">${e.cate_name}</option>
							</c:if>
							<c:if test="${e.id!=y.cate_id}">
							<option value="${e.id}">${e.cate_name}</option>
							</c:if>
							</c:forEach>
						</select>
					<%--  --%>
						
					</td>
					<td>字数：</td>
					<td><input type="number" name="dd.wordCount" class="el-input__inner" value="${y.wordCount }" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="text" name="dd.price" class="el-input__inner" value="${y.price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${path}/back/img/${y.src}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="upload" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type="text" name="dd.dd_price" class="el-input__inner" value="${y.dd_price }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="dd.public_count" class="el-input__inner" value="${y.public_count }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="dd.author" class="el-input__inner" value="${y.author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="dd.e_recommend">${y.e_recommend }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="dd.company" class="el-input__inner" value="${y.company }"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="dd.publish_time" class="el-input__inner" value="<f:formatDate value="${y.publish_time }" pattern="yyyy-MM-dd"/>"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="dd.book_description" >${y.book_description }</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="dd.edition" class="el-input__inner" value="${y.edition }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="dd.print_time" class="el-input__inner" value="<f:formatDate value="${y.print_time }" pattern="yyyy-MM-dd"/>"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="dd.aboutTheAuthor">${y.aboutTheAuthor }</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="dd.print_count" class="el-input__inner" value="${y.print_count }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="dd.isbn" class="el-input__inner" value="${y.isbn }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="dd.baseDirectory" >${y.baseDirectory }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="dd.sizes" class="el-input__inner" value="${y.sizes }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="dd.paper" class="el-input__inner" value="${y.paper }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="dd.pressReview">${y.pressReview }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="dd.pack" class="el-input__inner" value="${y.pack }"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

