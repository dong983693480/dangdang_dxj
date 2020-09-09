<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html >
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${path}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<%-- <jsp:include page="${path}/front/common/head1.jsp" /> --%>
		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">
			<%-- <jsp:include page="${path}/front/common/introduce.jsp" />	 --%>
			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>
						<form method="post" action="${path}/userlogin" id="ctl00">
							<ul>
								<li><font color="red">${xx}</font></li>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="email" id="txtEmail" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword" class="textbox" />
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter" value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${path}/front/user/register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

