<%@include file="head.jspf"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%

if(request.getParameter("username")!=null && !request.getParameter("username").trim().isEmpty()) {
   session.setAttribute("username", request.getParameter("username"));
} 

%> --%>

<!-- 	******************HEAD seach****************** -->
<div class="row">
	<div class="seach">

		<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7"></div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 top-menu">


			<ul>
				<li><a href="#">About us</a></li>
				<li><a href="#">Buffets</a></li>
				<li><a href="#"><img src="resources/images/basket5.jpg"></a></li>

				<!-- <li><a href="?lang=ge"><img src="resources/images/du.jpg"></a></li>
						<li><a href="?lang=ru"><img src="resources/images/ru.jpg"></a></li> -->

			</ul>

		</div>
	</div>

</div>



<div class="container">
	<section id="content">
		<form:form method="POST" commandName="user"  action="signup">
			<h1>Registration</h1>
			<fieldset>
			<div>
				<form:input placeholder='login' required="" path="username" id="username" type="text"
					name="username"/>
			</div>
			<div>
				<form:input placeholder='firstname' required="" path="firstname" id="firstname"
					type="text" name="firstname"/>
			</div>
			<div>
				<form:input placeholder='surname' required="" path="surname" id="surname" type="text"
					name="surname"/>
			</div>
			<div>
				<form:input placeholder='e-mail' required="" path="email"  id="email" type="text"
					name="email"/>
			</div>
			<div>
				<!--      <input name="_spring_security_remember_me" type="checkbox" class="remember">remember me </input> -->
				<form:input placeholder='password' required="" path="password"  id="password"
					type="password" name="password" />
			</div>
			<div id="strengthValue"></div>
			<br>
			<div>
				<form:input placeholder='birthday' required="" path="birthday"  id="birthday" type="date"
					name="date"/>
			</div>
			</fieldset>
			<div>
				<br>
			</div>
			<br>
			<div>
				<input type="submit"  value="Sign up"/> <a href="cancel"
					id="cancel">Cancel</a>
			</div>
			<div>
			<c:if test="${not empty errormassage}">
	<font color="red"> ${errormassage}</font>
</c:if>
<div>
		</form:form>
		<!-- form -->
	</section>
	<!-- content -->
</div>
<!-- container -->

<spring:url value="/resources/js/jquery-3.2.1.js" var="mainJs1" />
<script src="${mainJs1}"></script>

<spring:url value="/resources/js/eshop.js" var="mainJs" />
<script src="${mainJs}"></script>
</body>
</html>