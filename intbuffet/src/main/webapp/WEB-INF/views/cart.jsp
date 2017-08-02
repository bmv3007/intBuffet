<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

	<!-- **********************Test**************************************** -->

	<header id="header">
		<!--header-->
		<%@include file="head.jspf"%>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-8">
						<div class="breadcrumbs">
							<ol class="breadcrumb">

								<li class="active">Shopping Cart</li>

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
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${productLisInCart}">

							<tr>
								<td class="cart_product"><a href=""><img
										src="<%=request.getContextPath()%>/getImage?id=${item.id}"
										class="img-responsive"></a></td>
								<td class="cart_description">
									<h4>
										<a href="">${item.name} </a>
									</h4>
									<p>${item.description}</p>
								</td>
								<td class="cart_price">
									<p>&#8364; ${item.price}</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" id=${item.id
											}
											onclick="addAjax(${item.id},${item.price},${item.quantity})"> + </a>
										<input class="cart_quantity_input" type="text" name="quantity"
											value=${item.quantity } autocomplete="off" size="2"
											id="quantity"> <a class="cart_quantity_down"
											id=${item.id }
											onclick="deleteAjax()"> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price" id="totalItem"+"${item.id}"></p>
								</td>
								<!-- <td class="cart_delete"><a class="cart_quantity_delete"
									href=""><i class="fa fa-times"></i></a></td>  -->
							</tr>
						</c:forEach>
						<tr>
							<td colspan="4" style="text-align: right" class="cart_total"><p
									class="cart_total_price">Total:</p></td>
							<td class="cart_price">
								<p id="total_price">&#8364; 1168,80</p>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<a href="<c:url value='/order' />" class="btn  btn-primary btn-lg"
					role="button">order</a>
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
