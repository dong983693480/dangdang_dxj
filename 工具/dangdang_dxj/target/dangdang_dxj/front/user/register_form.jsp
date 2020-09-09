<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${path}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			/* function changeCount(txtEmail){
				
				alert(txtEmail);
				var count = $("#"+txtEmail).val();
				alert(count);
				var validate = /^[1-9]\d*$/;
				if(validate.test(count)){
					 location.href="/dangdang_dxj/updateCount?email="+count;
					alert(txtEmail);
					
				}else{
					alert("请输入正确的格式");
				}
			}; */
			function changeImage(){
				$("#imgVcode").prop("src","${path}/yzm?time="+new Date().getTime())
			}
			$(function () {
				$("#txtEmail").blur(function(){
					var reg=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
					var email = $(this).val();
					setTimeout(function(){
						$("#emailMsg").html("<img src='${path}/front/images/window_loading.gif'/>");
					}, 100)
					if(reg.test(email)){
						setTimeout(function(){
							$("#emailMsg").html("<img src='${path}/front/images/right.gif'/>");
						}, 1500)
					}else{
						setTimeout(function(){
							$("#emailMsg").html("<img src='${path}/front/images/wrong.gif'/>");
						}, 1500)
					}
				})

				$("#txtRepeatPass").blur(function(){
					var pass1 = $("#txtPassword").val();
					var pass2 = $(this).val();
					if(pass1 == pass2){
						$("#passMsg").html("");
					}else{
						$("#passMsg").html("<font style='color : red'>两次密码不一致</font>");
					}
				})
			})
		
			
		</script>
		
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${path}/adduser" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${zc1}
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email"  type="text" id="txtEmail" onblur="changeCount(txtEmail)" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<span id="emailMsg"><img src="${ path }/front/images/wrong.gif"></span>
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nick_name"  type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${path}/yzm" />
							<input name="yzm" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="javascript:changeImage()" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

