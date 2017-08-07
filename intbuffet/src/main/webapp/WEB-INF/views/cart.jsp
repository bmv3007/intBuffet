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

								<li class="active"><h2>Shopping Cart</h2></li>

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
							<td class="quantity"></td>
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
										<a class="btn cart_quantity_up" articul="${item.id}"
											onclick="addAjax(${item.id},${item.price},${item.quantity})">
											+ </a> <input class="cart_quantity_input" type="text"
											name="quantity" value=${item.quantity } autocomplete="off"
											size="2" disabled cartAttr="${item.id}"> <a
											class="btn cart_quantity_down" articul="${item.id}"
											onclick="deleteAjax(${item.id},${item.price},${item.quantity})">
											- </a>
									</div> <a href="delete_item/${item.id}" type="button" class="close"
									aria-label="Close"><span aria-hidden="true">&times;</span></a>

								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3" style="text-align: right" class="cart_total"><p
									class="cart_total_price">Total:</p></td>
							<td class="cart_price">
								<p id="total_price">&#8364; ${cart.total}</p>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<a href="<c:url value='/order' />" class="btn  btn-primary btn-lg"
					role="button">order</a><br>
			</div>
		</div>
	</section>
	<!--/#cart_items-->

	<!-- 	******************END MAIN row products****************** -->

	<!-- 	******************footer row****************** -->

		<%@include file="footer.jspf"%>

	<script src="resources/js/jquery-3.2.1.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/salvattore.min.js"></script>

	<script src="resources/js/eshop.js"></script>
	</div>
</body>
</html>
