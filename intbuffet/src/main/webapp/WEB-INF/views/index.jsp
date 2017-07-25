<%@include file="head.jspf"%>
<%@include file="head_search_menu.jspf"%>
<%@include file="carousel.jspf"%>

<!-- 	******************MAIN row****************** -->
<div class="row">


	<div class="container graycolor">
		<div class="row">

			<!-- 	******************MAIN row menu****************** -->
			<%@include file="left_menu_client.jspf"%>

			<!-- 	******************MAIN row products****************** -->
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<div class="row masonry" data-columns>

					<c:forEach var="product" items="${productList1}">

						<div>
							<div class="thumbnail">
								<img
									src="<%=request.getContextPath()%>/imageDisplay?id=${product.id}"
									class="img-responsive">
								<div class="caption">
									<h3>
										<a href="#">${product.name}</a>
									</h3>
									<p>Category: ${product.category.name}</p>
									<p>Beschreibung sehr gross........................</p>
									<p> Price: ${product.price}</p>
									<p> Vegetarian: ${product.vegetarian}</p>
									<p> Weight: ${product.weight}</p>
									<a target="_self" id="${product.id}"  onclick="addAjax(${product.id})">Add+${product.id}<i
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
