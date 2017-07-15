<%@page import="java.util.ArrayList"%>
<%@page import="com.js.intbuffetproject.dao.impl.ProductDAOImpl"%>
<%@page import="com.js.intbuffetproject.model.Product"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />

</head>
<body>

	<div class="container">
		<!-- 	******************HEAD logo****************** -->
		<div class="row graycolor">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">


				<div align="center">
					<img src="resources/images/logo1.jpg" align="left" />

				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<div align="center">
					<img src="resources/images/logo1.jpg" align="right" />
				</div>
			</div>
		</div>

		<!-- 	******************HEAD seach****************** -->
		<div class="row">
			<div class="seach">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">

					<a class="bot3" onclick="">Seach </a>
				</div>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<form class="form-search" method="get" action="/search"
						target="_blank">
						<input type="text" name="q" placeholder="suchen" value="" />
					</form>
				</div>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 top-menu">


					<ul>
						<li><a href="#">About us</a></li>
						<li><a href="#">Buffets</a></li>
						<li><a href="goin" id="goin">goin</a></li>
						<li><a href="#"><img src="resources/images/basket5.jpg"></a></li>
						
						<!-- <li><a href="?lang=ge"><img src="resources/images/du.jpg"></a></li>
						<li><a href="?lang=ru"><img src="resources/images/ru.jpg"></a></li> -->

					</ul>

				</div>
			</div>

		</div>


		<!-- *****************************carousel************************************ -->


		<div class="container">
			<div class="row graycolor">
				<div id="carousel" class="carousel slide graycolor">
					<!--  Ð¸Ð½Ð´Ð¸ÐºÐ°ÑÐ¾ÑÑ ÑÐ»Ð°Ð¹Ð´Ð¾Ð² -->
					<ol class="carousel-indicators graycolor">

						<li class="active" data-target="#carousel" data-slide="0"></li>
						<li data-target="#carousel" data-slide="1"></li>
						<li data-target="#carousel" data-slide="2"></li>
						<li data-target="#carousel" data-slide="3"></li>
						<li data-target="#carousel" data-slide="4"></li>

					</ol>

					<!--  ÑÐ»Ð°Ð¹Ð´Ñ -->
					<div class="carousel-inner">
						<div class="item active">
							<p class="fig">
								<img src="resources/images/1.jpg">
							</p>
						</div>
						<div class="item">
							<p class="fig">
								<img src="resources/images/2.jpg">
							</p>
						</div>
						<div class="item">
							<p class="fig">
								<img src="resources/images/3.jpg">
							</p>
						</div>
						<div class="item">
							<p class="fig">
								<img src="resources/images/4.jpg">
							</p>
						</div>
						<div class="item">
							<p class="fig">
								<img src="resources/images/5.jpg">
							</p>
						</div>
					</div>

					<!--  cÑÑÐµÐ»ÐºÐ¸ Ð¿ÐµÑÐµÐºÐ»ÑÑÐµÐ½Ð¸Ñ ÑÐ»Ð°Ð¹Ð´Ð¾Ð² -->
					<a href="#carousel" class="left carousel-control" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a> <a href="#carousel" class="right carousel-control"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>


		<!-- 	******************MAIN row****************** -->
		<div class="row">


			<div class="container graycolor">
				<div class="row">

					<!-- 	******************MAIN row menu****************** -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
						MENU ryrtyryrtykfsf sdf sdf s df sdf s df sdf s fs df s fs df sf s
						df s dfsdf sd fs df sdf sd f sdf s fs df sdf <a class="bot3"
							onclick="newMyWindow()">Order </a>

					</div>

					<!-- 	******************MAIN row products****************** -->
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<div class="row masonry" data-columns>


							<jsp:useBean id="productList"
								class="com.js.intbuffetproject.dao.impl.ProductDAOImpl" scope="page"></jsp:useBean>


							<%
								ArrayList<Product> list = productList.listProduct();
								session.setAttribute("currentProductList", list);
								for(Product product : list) {
							%> 
							<div>
								<div class="thumbnail">
									 <img
										src="<%=request.getContextPath()%>/Controller2?im_id=<%=list.indexOf(product)%>"
										class="img-responsive"> 
									<div class="caption">
										<h3>
											<a href="#">${product.name}</a>
										</h3>
										<p>Beschreibung sehr gross........................</p>
										<a href="#">Kaufen <i
											class="glyphicon glyphicon-shopping-cart"></i></a>
									</div>
								</div>
							</div>
							
							<%} %>
							
							
					</div>

					</div>


				</div>

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

	</div>
	<script src="resources/js/jquery-3.2.1.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/salvattore.min.js"></script>
</body>
</body>
</html>
