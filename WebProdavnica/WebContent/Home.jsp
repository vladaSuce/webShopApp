<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Vladimir Sucevic">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="lib/css/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-item.css" rel="stylesheet">
    <link rel="stylesheet" href="style/app-style.css">

    <script src="<c:url value="js/helper.js" />"></script>
    <script src="<c:url value="js/namestaj.js" />"></script>
    <script src="<c:url value="js/kategorija.js" />"></script>

</head>

<body>

  <%@ include file="header.tag" %>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                <c:forEach var="kategorija" items="${kategorije}">
                    <div class="app-menu-item">
                        <a href="javascript:;" onclick="namestaj.getNamestajZaKategoriju('${kategorija.naziv}')" class="active">${kategorija.naziv}</a>
                        <c:if test="${not empty kategorija.podKategorije}">
                            <span onclick="kategorija.otvoriZatvoriSubmenu('#app-podKategorije-lista')" class="app-arrow pull-right caret"></span>
                        </c:if>
                        <div id="app-podKategorije-lista" class="list-group" style="display: none;">
                        <c:forEach var="podKategorijaNaziv" items="${kategorija.podKategorije}">
                            <div class="app-menu-item app-gray-color">
                                <a href="javascript:;" onclick="namestaj.getNamestajZaKategoriju('${podKategorijaNaziv}')" class="active">${podKategorijaNaziv}</a>
                            </div>
                        </c:forEach>
                        </div>
                    </div>
				</c:forEach>
                </div>
            </div>

            <div class="col-md-9">

                <div id="detail-placeholder" class="thumbnail">
                    <%-- Placeholder za detalje namestaja renderovane preko jQuery-ja --%>
                </div>

                <div id="namestaj-items-root" class="well">
                    <%-- Placeholder za namestaj renderovan preko jQuery-ja --%>
                </div>
                <c:if test="${user.uloga=='prodavac'}">
                <div class="pull-right">
                    <button type="button" class="btn">Dodaj namestaj</button>
                </div>
                </c:if>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Vladimir Sucevic e13133</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

<input id="ulogaKorisnika" type="hidden" value="${user.uloga}"/>

    <!-- jQuery -->
    <script src="lib/js/jquery-2.1.4.js"></script>
    <script src="lib/js/jquery.tmpl.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="lib/css/bootstrap/js/bootstrap.js"></script>
    <script src="<c:url value="js/korisnik.js" />"></script>

</body>

</html>
