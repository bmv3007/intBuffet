<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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


<div class="container">
	<section id="content">
		<form:form method="POST" commandName="user"  action="signup">
			<h1>Registration</h1>
			<fieldset>
			<div>
				<form:input placeholder='login' required="" path="username" id="username" type="text"
					name="username"/>
			</div>
						
			<div>
				<!--      <input name="_spring_security_remember_me" type="checkbox" class="remember">remember me </input> -->
				<form:input placeholder='password' required="" path="password"  id="password"
					type="password" name="password" />
			</div>
			<div id="strengthValue">  </div>
			<br>
			
			<div>
				<form:input placeholder='e-mail' required="" path="email"  id="email" type="text"
					name="email"/>
			</div>
			</fieldset>
			<br>
			<div>
				<input type="submit"  value="Sign up"/> <a href="cancel"
					id="cancel">Cancel</a>
			</div>
			<div>
			<c:if test="${not empty errormassage}">
	<font color="red"> ${errormassage}</font>
</c:if>
<div>
		</form:form>
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