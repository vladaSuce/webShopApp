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

    <script src="<c:url value="js/helper.js" />"></script>
    <script src="<c:url value="js/namestaj.js" />"></script>

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
    			
                    <a href="javascript:;" onclick="namestaj.getNamestajZaKategoriju('${kategorija.naziv}')" class="list-group-item active">${kategorija.naziv}</a>
                    
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

    <!-- jQuery -->
    <script src="lib/js/jquery-2.1.4.js"></script>
    <script src="lib/js/jquery.tmpl.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="lib/css/bootstrap/js/bootstrap.js"></script>

</body>

</html>
