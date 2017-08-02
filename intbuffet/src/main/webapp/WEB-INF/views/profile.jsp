<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
			<form:form method="POST" action="saveProfile" modelAttribute="user">
				<h1>Profile</h1>
				<fieldset>
					<div>
						<form:input placeholder='username' required="" path="username"
							value="${username}" />
					</div>
					<div>
						<form:input placeholder='firstname' required="" path="firstname"
							value="${firstname}" />
					</div>
					<div>
						<form:input placeholder='surname' required="" path="surname"
							id="surname" type="text" name="surname" />
					</div>

					<div>
						<form:input placeholder='password' required="" path="password"
							id="password" type="password" name="password" />
					</div>




					<div>
						<form:input placeholder='e-mail' required="" path="email"
							id="email" type="text" name="email" />
					</div>
				</fieldset>
				<fieldset>
					<h1>Address</h1>
					<div>
						<form:select path="address.country" name="Country" type="text">
							<form:options items="${countries}" />
						</form:select>
					</div>
					<div>
						<form:select path="address.city" name="City" type="text" >
							<form:options items="${cities}" value="${address.city}"/>
						</form:select>
					</div>

					<div>
						<form:input placeholder='Postcode' path="address.postcode"
							name="Postcode"></form:input>
					</div>
					<div>
						<form:select path="address.street" name="Street" type="text">
							<form:options items="${streets}" />
						</form:select>
					</div>
					<div>
						<form:input placeholder='House number' path="address.housenumber"
							name="Housenumber" type="text"></form:input>
					</div>
					<div>
						<form:input placeholder='Apartment' path="address.apartment"
							name="Apartment" type="text"></form:input>
					</div>
				</fieldset>
				<br>
				<div>
					<input type="submit" value="Save" /> <a href="cancel" id="cancel">Cancel</a>
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