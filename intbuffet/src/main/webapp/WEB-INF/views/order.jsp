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
<title>Order</title>
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
						
					</div>
					<div class="col-sm-8">
						<div class="breadcrumbs">
							<ol class="breadcrumb">
								<li class="active"><h2>Order</h2></li>
								
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
			<form:form action="makeOrder" modelAttribute="order"
				class="navbar-form navbar-center">
				<label for="order">Order</label>
				<table>

					<tr>
						<td><form:label path="date"> Date: <fmt:formatDate
									type="date" value="${order.date}" />
							</form:label></td>
					</tr>

					<tr>
						<td><form:label path="paymentmethod">Method of payment: </form:label></td>
						<td><form:select path="paymentmethod">
								<form:options items="${paymentmethod1}" itemValue="name"
									itemLabel="name" />
							</form:select></td>
					</tr>
					<tr>
						<td><form:label path="deliverymethod">Method of delivery: </form:label></td>
						<td><form:select path="deliverymethod">
								<form:options items="${deliverymethod}" itemValue="name"
									itemLabel="name" />
							</form:select></td>
					</tr>
					<tr>
						<td><form:label path="paid">The payment is made: 
                    		<c:choose>
									<c:when test="${order.paid}">
        						    Yes
       						 		</c:when>
									<c:otherwise>
									No
									</c:otherwise>
								</c:choose>
							</form:label></td>
					</tr>

					<tr>
						<td><form:label path="orderstatus">	Order status: ${order.orderstatus}
						</form:label></td>
					</tr>

				</table>

				<label for="address">Address</label> 
				<table>


					<tr>
						<td><form:label path="address.country">Country: </form:label></td>
						<td><form:select path="address.country">
								<form:options items="${countries}" />
							</form:select></td>
					</tr>

					<tr>
						<td><form:label path="address.city">City: </form:label></td>
						<td><form:select path="address.city">
								<form:options items="${cities}" />
							</form:select></td>
					</tr>

					<tr>
						<td><form:label path="address.postcode">Postcode: </form:label></td>
						<td><form:input path="address.postcode"></form:input></td>
					</tr>

					<tr>
						<td><form:label path="address.street">Street: </form:label></td>
						<td><form:select path="address.street">
								<form:options items="${streets}" />
							</form:select></td>
					</tr>

					<tr>
						<td><form:label path="address.housenumber">Housenumber: </form:label></td>
						<td><form:input path="address.housenumber"></form:input></td>
					</tr>

					<tr>
						<td><form:label path="address.apartment">Apartment: </form:label></td>
						<td><form:input path="address.apartment" value=''></form:input></td>
					</tr>

				</table>



				<div class="table-responsive cart_info">
					<table class="table table-condensed">

						<thead>
							<tr class="cart_menu">
								<td class="description">Item</td>
								<td class="price">Price</td>
								<td class="quantity">Quantity</td>
							</tr>
						</thead>
						<tbody>
						<c:if test="${not empty productLisInCart}">
							<c:forEach var="item" items="${productLisInCart}">

								<tr>
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
										<p>${item.quantity}</p>
									</td>

								</tr>

							</c:forEach>
							<tr>
								<td colspan="3" style="text-align: right" class="cart_total">
									<p class="cart_total_price" id="totalItem">Total price:
										${cart.total} &#8364;</p>
								</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty productLisInOrder}">
							<c:forEach var="item" items="${productLisInOrder}">

								<tr>
									<td class="cart_description">
										<h4>
											<a href="">${item.product.name} </a>
										</h4>
										<p>${item.product.description}</p>
									</td>
									<td class="cart_price">
										<p>&#8364; ${item.product.price}</p>
									</td>
									<td class="cart_quantity">
										<p>${item.quantity}</p>
									</td>

								</tr>

							</c:forEach>
							<tr>
								<td colspan="3" style="text-align: right" class="cart_total">
									<p class="cart_total_price" id="totalItem">Total price:
										${order.ordertotal} &#8364;</p>
								</td>
							</tr>
							</c:if>
						</tbody>
					</table>
				</div>


				<input type="submit" value="Send" />

			</form:form>

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
