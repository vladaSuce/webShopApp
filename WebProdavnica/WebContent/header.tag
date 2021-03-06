
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">${user.korisnickoIme }</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="./Home.jsp">Namestaj</a></li>
				<li><a href="./DodatneUsluge.jsp">Dodatne usluge</a></li>
				<c:if test="${ user.uloga =='kupac'}">
					<li><a href="#">Kupovina</a></li>
				</c:if>
				<c:if test="${ user.uloga !='kupac'}">
				<li><a href="#">Akcijska prodaja</a></li>
				</c:if>
				<c:if test="${ user.uloga =='menadzer'}">
				<li><a href="#">Izvestaji</a></li>
				</c:if>
				<li><a href="#">Racuni</a></li>
				<li><a href="#">Pretraga</a></li>
				<li><a href="./LogoutServlet">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>