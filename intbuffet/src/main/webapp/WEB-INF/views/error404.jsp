<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.js.intbuffetproject.dao.impl.ProductDAOImpl"%>
<%@page import="com.js.intbuffetproject.model.Product"%>
<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/cart.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />
</head>
<body>

	<!-- **********************Test**************************************** -->

	<header id="header">

		<%@include file="head.jspf"%>
		
	</header>

<c:if test="${not empty param.error}">
	<font color="red"> 
 Error: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>

	<%@include file="footer.jspf"%>