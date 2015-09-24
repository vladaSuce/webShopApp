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
	<script src="<c:url value="js/script.js" />"></script>

<title>Logovanje korisnika</title>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="text-center">
                <h1>Login Page</h1>
                <h2>Signup Details</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3 login-form-box">
                <form role="form" onsubmit="korisnik.loginKorisnika('#usernameLogin', '#passwordLogin'); return false;">
                    <div class="form-group">
                        <label class="standard-text" for="usernameLogin">Username:</label>
                        <input type="text" name="username" placeholder="Username..." id="usernameLogin" class="form-control form-username">
                    </div>
                    <div class="form-group">
                        <label class="standard-text" for="passwordLogin">Password:</label>
                        <input type="password" name="password" placeholder="Password..." id="passwordLogin" class="form-control form-password">
                    </div>
                    <button type="submit" name="submit" class="btn">Sign in!</button>
                </form>
            </div>
        </div>
    </div>


	<%--<h1>Login Page</h1>
	<center>
		<h2>Signup Details</h2>
		<form onsubmit="korisnik.loginKorisnika('#usernameLogin', '#passwordLogin'); return false;">
			<br />Username:<input type="text" id="usernameLogin" name="username"> 
			<br />Password:<input type="password" id="passwordLogin" name="password"> 
			<br /><input type="submit" name="submit" value="Submit"> 
			<br/> <a href="./AdminLogin.jsp">Logovanje menadzera(admina)</a>
		</form>
	</center>--%>


</body>
</html>

