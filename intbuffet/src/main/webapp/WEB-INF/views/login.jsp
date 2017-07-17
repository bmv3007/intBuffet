<%@include file="head.jspf"%>

<%-- <%

if(request.getParameter("username")!=null && !request.getParameter("username").trim().isEmpty()) {
   session.setAttribute("username", request.getParameter("username"));
} 

%> --%>

<!-- 	******************HEAD seach****************** -->
		<div class="row">
			<div class="seach">
				
				<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
					
				</div>
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
    

<c:if test="${not empty param.error}">
	<font color="red"> <spring:message code="label.loginerror" />
	: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>

<div class="container">
 <section id="content">
  <form method="POST" action="<c:url value="/j_spring_security_check" />">
   <h1>Anmeldung</h1>
    <div>
     <input placeholder='login' required="" id="username" type="text" name="j_username" >
    </div>
    <div>
<!--      <input name="_spring_security_remember_me" type="checkbox" class="remember">remember me </input> -->
     <input placeholder='password'  required="" id="password" type="password" name="j_password" onkeyup="doAjax()">
     </div>
     <div id="strengthValue">
      </div>
      <br>
      <div>
      <br>
      </div>
      <br>
    <div>
      <input type="submit" value="Login">
      <a href="register" id="register">Register</a>
      <a href="cancel" id="cancel">Cancel</a>
    </div>
   </form><!-- form -->
 </section><!-- content -->
</div><!-- container -->

 <spring:url value="/resources/js/jquery-3.2.1.js" var="mainJs1" />
	<script src="${mainJs1}"></script>
	
	<spring:url value="/resources/js/eshop.js" var="mainJs" />
	<script src="${mainJs}"></script>
</body>
</html>