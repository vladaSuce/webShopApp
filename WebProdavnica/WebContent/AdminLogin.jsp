<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- CSS -->
	<link rel="stylesheet" href="lib/css/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="style/app-style.css">

	<script src="<c:url value="lib/js/jquery-2.1.4.js" />"></script>
	<script src="<c:url value="lib/css/bootstrap/js/bootstrap.js" />"></script>
	<script src="<c:url value="js/korisnik.js" />"></script>

	<title>Logovanje menadzera(admina)</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="text-center">
			<span class="btn app-btn-login pull-right"><a class="app-no-link" href="./LoginForm.jsp">Logovanje prodavaca i kupaca</a></span>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3 login-form-box">
			<form role="form" onsubmit="korisnik.loginAdminKorisnika('#usernameLogin', '#passwordLogin'); return false;">
				<div class="form-group text-center">
					<h2>Admin detalji</h2>
				</div>
				<div class="form-group">
					<label class="standard-text" for="usernameLogin">Korisnicko ime:</label>
					<input type="text" name="username" placeholder="Korisnicko ime..." id="usernameLogin" class="form-control form-username">
				</div>
				<div class="form-group">
					<label class="standard-text" for="passwordLogin">Sifra:</label>
					<input type="password" name="password" placeholder="Sifra..." id="passwordLogin" class="form-control form-password">
				</div>
				<div class="form-group text-center">
					<button type="submit" name="submit" class="btn">Login</button>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>

