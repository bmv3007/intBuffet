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
	
	<%@include file="carousel.jspf"%>

	<!-- 	******************MAIN row****************** -->
	<div class="row">


		<div class="container graycolor">
			<div class="row">

				<!-- 	******************MAIN row menu****************** -->
				<%@include file="left_menu_client.jspf"%>

				<!-- 	******************MAIN row products****************** -->
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
					<div class="row masonry" id="goods" data-columns>

						<c:forEach var="product" items="${productList1}">

							<div>
								<div class="thumbnail">
									<img
										src="<%=request.getContextPath()%>/getImage?id=${product.id}"
										class="img-responsive">

									<div class="caption">
										<h3>
											<a href="#">${product.name}</a>
										</h3>
										<p>Category: ${product.category.name}</p>
										<p>${product.description}</p>
										<p>Price: ${product.price}</p>
										<p>
											Vegetarian:
											<c:choose>
												<c:when test="${product.vegetarian}">
											Yes
										</c:when>
												<c:otherwise>
											 No
										</c:otherwise>
											</c:choose>


										</p>
										<p>Weight: ${product.weight}</p>
										<a target="_self" id="${product.id}" class="btn btn-danger"
											onclick="addAjax(${product.id})"><i
											class="glyphicon glyphicon-shopping-cart"></i></a>
									</div>

								</div>
							</div>

						</c:forEach>

					</div>

				</div>
				<!-- 	******************END MAIN row products****************** -->

			</div>

		</div>

	</div>


	<%@include file="footer.jspf"%>