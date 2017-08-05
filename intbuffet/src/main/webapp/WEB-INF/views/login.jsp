<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags"%>
<%@ taglib prefix= "security" uri= "http://www.springframework.org/security/tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/cart.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />
<link href="resources/css/login.css" rel="stylesheet" />
</head>
<body>

	<!-- **********************Test**************************************** -->

	<header id="header">
		<!--header-->

<%@include file="head.jspf"%>
</header>

<c:if test="${not empty param.error}">
	<font color="red">
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</font>
</c:if>

<div class="container">
	<section id="content">
		<form method="POST"
			action="<c:url value="/login" />">
			<h1>Authentication</h1>
			<div>
				<input placeholder='login' required="" id="username" type="text"
					name="username">
			</div>
			<div>
				<!--      <input name="_spring_security_remember_me" type="checkbox" class="remember">remember me </input> -->
				<input placeholder='password' required="" id="password"
					type="password" name="password">
			</div>
			<div id="strengthValue"></div>
			<br>
			<div>
				<br>
			</div>
			<br>
			<div>
				<input type="submit" value="Login"> <a href="registration"
					id="register">Registration</a> <a href="cancel" id="cancel">Cancel</a>
					</div>
		</form>
		<!-- form -->
	</section>
	<!-- content -->
</div>
<!-- container -->

<spring:url value="/resources/js/jquery-3.2.1.js" var="mainJs1" />
<script src="${mainJs1}"></script>

<spring:url value="/resources/js/eshop.js" var="mainJs" />
<script src="${mainJs}"></script>
</body>
</html>