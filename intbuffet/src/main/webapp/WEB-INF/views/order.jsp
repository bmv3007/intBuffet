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
						<div class="logo pull-left">
							<a href="index.html"><img src="resources/images/logo1.jpg"
								alt="" /></a>
						</div>

					</div>
					<div class="col-sm-8">
						<div class="breadcrumbs">
							<ol class="breadcrumb">
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
									<c:when test="${order.paid==true}">
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
				<%-- </form:form>
	<!--       ******************************************************          -->			
				
				<form:form action="makeOrder" modelAttribute="address"
				class="form-inline">
				<label for="address">Address</label> --%>
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

									<!-- <td class="cart_delete"><a class="cart_quantity_delete"
									href=""><i class="fa fa-times"></i></a></td>  -->
								</tr>

							</c:forEach>
							<tr>
								<td colspan="3" style="text-align: right" class="cart_total">
									<p class="cart_total_price" id="totalItem">Total price: ${cart.total} &#8364;</p>
								</td>
							</tr>
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
