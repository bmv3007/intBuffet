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
<title>Product</title>
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

	</header>
	<!--/header-->


	<!-- 	******************MAIN row products****************** -->

	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 top-material"></div>

			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 top-material">

				<h2>New product</h2>



				<form:form action="newProduct" modelAttribute="product"	class="form-group"  enctype="multipart/form-data">

					<table>

						<tr>

							<td><form:label path="name">Name: </form:label></td>
							<td><form:input path="name" class="form-control"></form:input></td>
						</tr>

						<tr>
							<td><form:label path="category">Category: </form:label></td>
							<td><form:select path="category" class="form-control">
									<form:options items="${categories}" itemValue="id"
										itemLabel="name" />
								</form:select></td>
						</tr>
						<tr>
							<td><form:label path="description">Description: </form:label></td>
							<td><form:textarea path="description" class="form-control"></form:textarea></td>
						</tr>
						<tr>
							<td><form:label path="price">Price: </form:label></td>
							<td><form:input type="number" step="0.1" path="price"
									class="form-control"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="vegetarian">Vegetarian: </form:label></td>
							<td><form:checkbox path="vegetarian" class="custom-checkbox"></form:checkbox></td>
						</tr>
						<tr>
							<td><form:label path="weight">Weight: </form:label></td>
							<td><form:input type="number" step="1" path="weight"
									class="form-control"></form:input></td>
						</tr>
						
						<%-- <tr>
							<td><form:label path="image">Image: </form:label></td>
							<td><a a href="#" onclick="upload()" refattr="ahref"><img class="img-rounded"
											src="resources/images/download.jpg"></a></td><td><form:input type="file"  path="image" name="file"></form:input>
							<br></td>
						</tr> --%>
						<tr>
						<td><form:label path="image">Image: </form:label></td>
				
				<td><form:input type="file"  path="image" name="file" id="file"></form:input><td>
					
						</tr>
					</table>


					<input type="submit" value="Save" class="btn btn-primary" />

				</form:form>
				<form:form action="uploadFile" id="file" method="post" enctype="multipart/form-data" modelAttribute="fileHolder"	class="form-group" >
				<form:label path="file">Image: </form:label>
				
				<form:input type="file"  path="file" name="file"></form:input>
					<br>	
					<input type="submit" value="Upload" class="btn btn-primary" />	
				 <a a href="#" type="submit"  refattr="ahref"  onclick="uploadFile()" ><img class="img-rounded"
											src="resources/images/download.jpg"></a> 
		
	</form:form>

			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 top-material"></div>
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

	<script src="resources/js/jquery-3.2.1.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/salvattore.min.js"></script>

	<script src="resources/js/eshop.js"></script>
	</div>
</body>
</html>
