<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="<c:url value="/lib/js/jquery-2.1.4.js" />"></script>
	<script src="<c:url value="/lib/css/bootstrap/js/bootstrap.js" />"></script>
	<script src="<c:url value="/js/script.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<center>
		<h2>Signup Details</h2>
		<form onsubmit="korisnik.loginAdminKorisnika('#usernameLogin', '#passwordLogin'); return false;">
			<br />Username:<input type="text" id="usernameLogin" name="username"> 
			<br />Password:<input type="password" id="passwordLogin" name="password"> 
			<br /><input type="submit" name="submit" value="Submit"> 
			<br/> <a href="./LoginForm.jsp">Logovanje prodavaca i kupaca</a>
		</form>
	</center>
</body>
</html>

