<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<body>
	<security:authorize
		access="hasRole('ROLE_ADMIN') and fullyAuthenticated">
		<c:set var="admin">true</c:set>
	</security:authorize>
	<security:authorize
		access="hasRole('ROLE_USER') and fullyAuthenticated">
		<c:set var="user">true</c:set>
	</security:authorize>

	<!-- **********************Test**************************************** -->

	<header id="header">
		<!--header-->
		<%@include file="head.jspf"%>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left"></div>

					</div>
					<div class="col-sm-8">
						<div class="breadcrumbs">
							<ol class="breadcrumb">

								<li class="active">Orders report</li>

							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

	</header>
	<!--/header-->


	<!-- 	******************MAIN row products****************** -->




	<section id="cart_items">
		<div class="container">

			<div class="table-responsive cart_info">

				<table class="table table-condensed table-striped">
					<thead>
						<tr class="cart_menu">
							<td class="description">N</td>
							<td class="date">Date</td>
							<c:if test="${admin eq 'true'}">
								<td class="description">Client</td>
							</c:if>
							<td class="description">Order status</td>
							<td class="description">Method of payment</td>
							<td class="description">Method of delivery</td>
							<td class="description">Paid</td>
							<td class="total">Total (&#8364;)</td>
							<td></td>
							<c:if test="${user eq 'true'}">
									<td></td>
								</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${UsersOrders}">

							<tr>
								<td class="cart_description"><a href="">${item.id}</a></td>

								<td class="cart_description">
									<p>
										<fmt:formatDate type="date" value="${item.date}" />
									</p>
								</td>


								<c:if test="${admin eq 'true'}">
									<td class="cart_description">${item.user.surname}
										${item.user.firstname}</td>
								</c:if>
								<td class="cart_price" ><select
									name="titles" size="1" optionAttr="${item.id}"
									 ${admin eq 'true' ? 'anabled' : 'disabled'}>
										<c:forEach items="${orderstatus}" var="status">
											<option value="${status.name}"
												${status.name eq item.orderstatus ? 'selected' : ''}>${status.name}</option>

										</c:forEach>
								</select></td>



								<td class="cart_price">
									<p>${item.paymentmethod}</p>
								</td>
								<td class="cart_price">
									<p>${item.deliverymethod}</p>
								</td>
								<td class="cart_price"><c:choose>
										<c:when test="${item.paid==true}">
											<p>Yes</p>
										</c:when>
										<c:otherwise>
											<p>No</p>
										</c:otherwise>
									</c:choose></td>
								<td class="cart_description">${item.ordertotal}</td>
								<c:if test="${admin eq 'true'}">
									<td><a a href="#" onclick="changeHrefOrder('${item.id}')"
										refattr="${item.id}"><img class="img-rounded"
											src="resources/images/save.png"></a></td>
								</c:if>
								
								<c:if test="${user eq 'true'}">
									<td><a a href="#" onclick="repeatOrder('${item.id}')"
										refattr="${item.id}"><img class="img-rounded"
											src="resources/images/repeat.jpg"></a></td>
								</c:if>

							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>

		</div>
	</section>
	<!--/#cart_items-->

	<!-- 	******************END MAIN row products****************** -->

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
