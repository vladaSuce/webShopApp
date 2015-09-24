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
	<br />
	<br />
	<br />
	<br />
	<br />
	<center>
		<h2>
			<c:out value="${ user.getKorisnickoIme() }"/>
		</h2>
		<br /> 
		<c:out value="${ salon.naziv }"/>
		<br /> <br />
		<br />
		<br />
		<br />
		<br /> <a href="./LoginUserServlet">Logout</a>
	</center>
</body>
</html>

