<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Vladimir Sucevic">



<!-- Bootstrap Core CSS -->
<link href="lib/css/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-item.css" rel="stylesheet">
<link rel="stylesheet" href="style/app-style.css">

<script src="<c:url value="js/helper.js" />"></script>
<script src="<c:url value="js/namestaj.js" />"></script>
<script src="<c:url value="js/kategorija.js" />"></script>
<script src="lib/js/jquery-2.1.4.js"></script>
<script src="lib/js/jquery.tmpl.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="lib/css/bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<%@ include file="header.tag"%>
	<c:forEach var="usluga" items="${dodatneUsluge}">
		<div id="namestaj-items-root" class="well">
			<hr>
			<div class="row">
				<div class="col-md-12">
					<span class="pull-right">${usluga.cena}</span>
					<c:if test="${user.uloga=='kupac'}">
						<div class="col-md-12">
							<button class="pull-right">Dodaj Uslugu na racun</button>
						</div>
					</c:if>

					<c:if test="${user.uloga=='prodavac'}">
						<div class="col-md-12">
							<button class="pull-right">Edituj dodatnu uslugu</button>
							<button class="pull-right">Obrisi dodatnu uslugu</button>
						</div>
					</c:if>
					<a href="javascript:;"
						onclick="namestaj.prikaziPodatkeZaKomadNamestaja(\'${naziv}\')">${usluga.naziv}</a>

				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>