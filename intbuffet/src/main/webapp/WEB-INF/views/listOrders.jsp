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
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="resources/images/logo1.jpg"
								alt="" /></a>
						</div>

					</div>
					<div class="col-sm-8">
						<div class="breadcrumbs">
							<ol class="breadcrumb">
								<li><a href="<c:url value='/index' />">Home</a></li>
								<li class="active">Shopping Cart</li>
								<li><a href="<c:url value='/order' />">Order</a></li>
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
						<c:forEach var="item" items="${UsersOrders}" >
                          
							<tr>
								 <td class="cart_product">	<a href="">${item.id}</a></td>  
								<td class="cart_description">
									
									 <p>${item.date}</p>  
								</td>
								<td class="cart_price">
 									<p>${item.orderstatus}</p>
								</td>
								 <td class="cart_price">
 									<p>${item.paymentmethod}</p>
								</td>
								<td class="cart_price">
 									<p>${item.deliverymethod}</p>
								</td>
								<td class="cart_price">
 									<p>${item.paid}</p>
								</td>
								<td class="cart_total">
									<p class="cart_total_price" id="totalItem"+"${item.id}"></p>
								</td>
								<!-- <td class="cart_delete"><a class="cart_quantity_delete"
									href=""><i class="fa fa-times"></i></a></td>  -->
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