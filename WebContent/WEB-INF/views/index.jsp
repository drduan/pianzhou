<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% System.out.println("index session:"+session.getId()); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"
	type="text/css" />
</head>
<body>
	<!-- 引入头页面 -->
	<div class="main">
		<div class="reg_login">
		<form method="post" action="${pageContext.request.contextPath}/user/login">
			<div class="logForm">
				登录邮箱：<br /> <input type="text" name="userName" id="userName" /><br /> 登录密码<br /> <input
					type="password" name="userPass" id="userPass" /><br /> <input type="checkbox" />自动登陆<br />
				<input type="submit"  value=" 登录  " class="sub" onclick="login()"/> 
				<a href="#">注册</a>
			</div>
			</form>
			
	<!-- 引入尾页面 -->
	
</body>
</html>