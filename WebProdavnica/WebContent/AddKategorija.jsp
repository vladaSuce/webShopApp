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
<script src="<c:url value="js/dodatnaUsluga.js" />"></script>
<script src="<c:url value="js/kategorija.js" />"></script>
<script src="lib/js/jquery-2.1.4.js"></script>
<script src="lib/js/jquery.tmpl.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="lib/css/bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<%@ include file="header.tag"%>
	<c:if test="${ tempKategorija!=null}">
	<form role="form"
		onsubmit="kategorija.fillDataEdit('#nazivKategorije', '#opisKategorije','#nadKategorija'); return false;">
		
		<div id="namestaj-items-root" class="well">
			<hr>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Naziv Nove kategorije:</span>
				</div>
				<div class="col-md-2">
					<input type="text" value="${tempKategorija.naziv }" name="nazivKategorije"
						id="nazivKategorije" class="pull-right" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Opis:</span>
				</div>
				<div class="col-md-2">
					<input type="text" name="opisKategorije" id="opisKategorije"
						value="${tempKategorija.opis }" class="pull-right" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Cena:</span>
				</div>
				<div class="col-md-2">
					<input type="text" value="${tempKategorija.cena }" name="nadKategorija"
						id="nadKategorija" class="pull-right" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<button class="pull-left" type="submit" name="submit">Sacuvaj
						kategoriju</button>
				</div>
			</div>
		</div>
	</form>
	</c:if>
	<c:if test="${ tempKategorija==null}">
	<form role="form"
		onsubmit="kategorija.fillDataInsert('#nazivKategorije', '#opisKategorije','#nadKategorija',AddKategorijaServlet); return false;">
		
		<div id="namestaj-items-root" class="well">
			<hr>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Naziv Kategorije:</span>
				</div>
				<div class="col-md-2">
					<input type="text" name="nazivKategorije"
						id="nazivKategorije" class="pull-right" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Opis:</span>
				</div>
				<div class="col-md-2">
					<input type="text" name="opsiKategorije" id="opsiKategorije"
						class="pull-right" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<span class="pull-left">Nadkategorija:</span>
				</div>
				<div class="col-md-2">
				<input type="text" name="nadKategorija" id="nadKategorija"
						class="pull-right" />
						
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<button class="pull-right" type="submit" name="submit">Dodaj
						kategoriju</button>
				</div>
			</div>
		</div>
	</form>
	</c:if>
</body>
</html>