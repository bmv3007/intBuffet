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
<!-- <link href="resources/css/datepicker.css" rel="stylesheet" /> -->
<link href="resources/css/w2ui-1.5.rc1.css" rel="stylesheet" />
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

								<li class="active"><h2>Statistic</h2></li>

							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

	</header>
	<!--/header-->
	<div class="row">
		<div class="col-md-12">
			<div class="w2ui-field">
				<label>	Period:</label>
				<div>
					<input type="us-date1" id="from" dateAttr="from"> - <input type="us-date2" id="to" dateAttr="to">
					<a target="_self" class="btn  btn-primary" onclick="showProfit()">Profit</a>
					<div id="profit">
					<p> Profit: </p>
					</div>
				</div>
			</div>
		</div>
	</div>




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

	

	<!-- 	******************footer row****************** -->

	<%@include file="footer.jspf"%>
	<script src="resources/js/jquery-3.2.1.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/salvattore.min.js"></script>

	<script src="resources/js/eshop.js"></script>

	<script src="resources/js/w2ui-1.5.rc1.js"></script>

	<script>
		$(function() {
			var month = (new Date()).getMonth() + 1;
			var year = (new Date()).getFullYear();

			// US Format
			$('input[type=us-date]').w2field('date');
			$('input[type=us-dateA]').w2field('date', {
				format : 'm/d/yyyy',
				start : month + '/5/' + year,
				end : month + '/25/' + year
			});
			$('input[type=us-dateB]').w2field(
					'date',
					{
						format : 'm/d/yyyy',
						blocked : [ month + '/12/2014', month + '/13/2014',
								month + '/14/' + year, ]
					});
			$('input[type=us-date1]').w2field('date', {
				format : 'm/d/yyyy',
				end : $('input[type=us-date2]')
			});
			$('input[type=us-date2]').w2field('date', {
				format : 'm/d/yyyy',
				start : $('input[type=us-date1]')
			});
			$('input[type=us-time]').w2field('time', {
				format : 'h12'
			});
			$('input[type=us-timeA]').w2field('time', {
				format : 'h12',
				start : '8:00 am',
				end : '4:30 pm'
			});

			// EU Common Format
			$('input[type=eu-date]').w2field('date', {
				format : 'd.m.yyyy'
			});
			$('input[type=eu-dateA]').w2field('date', {
				format : 'd.m.yyyy',
				start : '5.' + month + '.' + year,
				end : '25.' + month + '.' + year
			});
			$('input[type=eu-dateB]').w2field(
					'date',
					{
						format : 'd.m.yyyy',
						blocked : [ '12.' + month + '.' + year,
								'13.' + month + '.' + year,
								'14.' + month + '.' + year ]
					});
			$('input[type=eu-date1]').w2field('date', {
				format : 'd.m.yyyy',
				end : $('input[type=eu-date2]')
			});
			$('input[type=eu-date2]').w2field('date', {
				format : 'd.m.yyyy',
				start : $('input[type=eu-date1]')
			});
			$('input[type=eu-time]').w2field('time', {
				format : 'h24'
			});
			$('input[type=eu-timeA]').w2field('time', {
				format : 'h24',
				start : '8:00 am',
				end : '4:30 pm'
			});
		});
	</script>

	</div>
</body>
</html>
