<%@page import="com.js.intbuffetproject.util.Util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Categories</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/cart.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />
</head>
<body>

	<!-- **********************Test**************************************** -->

	<header id="header">
		<!--header-->
		<%@include file="head.jspf"%>
		<!--/header_top-->

	</header>
	<!--/header-->

	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 top-material"></div>

			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 top-material">

				<h2>New category</h2>

				<form:form method="post" action="newcategory" class="form-group"
					commandName="newcategory" modelAttribute="category">

					<table>
						<tr>
							<td><form:label path="name">
									Name:
								</form:label></td>
							<td><form:input path="name" class="form-control" ></form:input></td>

						</tr>

						<tr>
							<td><input type="submit" value="Save" class="btn btn-primary"/></td>
						</tr>
					</table>
				</form:form>


				<c:if test="${!empty categories}">
					<form class="form-group">
					<table class="data">
						<tr>
							<th><h3><span >Categories:</span></h3></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
						<c:forEach items="${categories}" var="category">
							<tr>
								<td> <input path="${category.name}" class="form-control" value="${category.name}"></input></td>
								<td><a href="updateCategory/${category.id}/${newName}"><img class="img-rounded" src="resources/images/save.png"></a></td>
								<td><a href="deleteCategory/${category.id}"><img class="img-rounded" src="resources/images/delete.png"></a></td>
							</tr>
						</c:forEach>
					</table>
					</form>
				</c:if>

			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 top-material"></div>
		</div>
	</div>
	<!-- 	******************footer row****************** -->

	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
				<address>
					<strong>Twitter, Inc.</strong><br> 1355 Market Street, Suite
					900</br> <br>San Francisco, CA 94103</br> <abbr title="Phone">P:</abbr>
					(123) 456-7890
				</address>

				<address>
					<strong>Full Name</strong><br> <a href="mailto:#">first.last@example.com</a>
					</br>
				</address>

			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
		</div>
	</div>

	<script src="resources/js/jquery-3.2.1.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/salvattore.min.js"></script>

	<script src="resources/js/eshop.js"></script>
	</div>
</body>
</html>
