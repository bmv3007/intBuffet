<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link href="resources/css/datepicker.css" rel="stylesheet" />
</head>
<body>

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

								<li class="active">Statistic</li>

							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

	</header>
	<!--/header-->



	<!--  <div class="row">
    <div class="col-md-12">
        <div class="alert alert-danger" id="alert">
            <strong>Something went wrong!</strong>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-3 text-center">
        <strong>Start date</strong> <a href="#" class="btn btn-info btn-sm" id="dp4" data-date-format="dd-mm-yyyy" data-date="20-01-2015">Change</a>
    </div>
    <div class="col-md-3 text-center">
        <strong>End date</strong> <a href="#" class="btn btn-info btn-sm" id="dp5" data-date-format="dd-mm-yyyy" data-date="25-01-2015">Change</a>
    </div>
</div>
<div class="row">
    <div class="col-md-3">
        <div class="date-bg bg-success" id="startDate">20-01-2015</div>
    </div>
    <div class="col-md-3">
        <div class="date-bg bg-success" id="endDate">25-01-2015</div>
    </div>
</div> -->



	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">

			<div class="table-responsive cart_info">

				<table class="table table-striped  table-hover table-condensed">
					<div class="caption">
						<h3>Top 10 clients</h3>
					</div>
					<thead>
						<tr class="cart_menu">
							<td class="description">Client</td>

							<td class="total">Total (&#8364;)</td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${topClients}">

							<tr>
								
								<security:authorize
									access="hasRole('ROLE_ADMIN') and fullyAuthenticated">

									<td class="total">${item.user}</td>
									
								</security:authorize>
								
								<td class="total">${item.sum}</td>
								


							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>


		</div>
	</nav>


<nav class="navbar navbar-default navbar-static-top">
		<div class="container">

			<div class="table-responsive cart_info">

				<table class="table table-striped  table-hover table-condensed">
					<div class="caption">
						<h3>Top products</h3>
					</div>
					<thead>
						<tr class="cart_menu">
							<td class="description">Product</td>

							<td class="total">Total quantity</td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${topProducts}">

							<tr>
							
								<td class="total">${item.name}</td>
									
								<td class="total">${item.sell_quantity}</td>
					
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>


		</div>
	</nav>

	<%-- <section id="cart_items">
		<div class="container">

			<div class="table-responsive cart_info">
				<table class="table table-condensed table-striped">
					<thead>
						<tr class="cart_menu">
							<td class="description">N</td>
							<td class="date">Date</td>
							<td class="description">Client</td>
							<td class="description">Order status</td>
							<td class="description">Method of payment</td>
							<td class="description">Method of delivery</td>
							<td class="description">Paid</td>
							<td class="total">Total (&#8364;)</td>
							<td></td>
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
								<security:authorize
									access="hasRole('ROLE_ADMIN') and fullyAuthenticated">

									<td class="cart_description">${item.user.surname}
										${item.user.firstname}</td>

									<td class="cart_price">
										<section>
											<select items="${orderstatus}" itemValue="name"
												itemLabel="name" value="${item.orderstatus}" />
										</section>

									</td>
								</security:authorize>
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
									<td class="cart_description">${item.ordertotal} </td>
								<td><a href="updateCategory/${category.id}/${newName}"><img
										class="img-rounded" src="resources/images/save.png"></a></td>
								

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!--/#cart_items-->
 --%>
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

	<script src="bootstrap-datepicker.js"></script>

	<script src="resources/js/statistic.js"></script>
	</div>
</body>
</html>
