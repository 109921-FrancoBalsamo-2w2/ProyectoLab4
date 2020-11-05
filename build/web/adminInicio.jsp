<%-- 
    Document   : adminInicio
    Created on : 28-oct-2020, 13:02:05
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/cardlist.css">
        <script type="text/javascript" src="js/logout.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <div class="topnav">
            <a href="#"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <a href="ServletReporte"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 1</a>
            <a href="totalFacturado"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 2</a>
            <a href="ServletReporteUno"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 3</a>
            <a href="articulos"><i class="fas fa-laptop" style="padding-right: 10px;"></i>Artículos</a>
            <a href="ServletDepositos"><i class="fas fa-money" style="padding-right: 10px;"></i>Depósitos</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
    <center><img class="img" src="imagenes/00.png"/></center>
    <center><p>Bienvenida/a, por favor presione el botón para la acción que desea llevar a cabo.</p></center>
    <center>
        <form method="POST" action="altaParejas.jsp">
            <button class="parejasLista" style="width: 150px">Agregar</button> <br>
        </form>
    </center>
        <center>
            <div class="container">
                 <c:forEach items="${lista}" var="P">
                    <div class="card">
                        <img src="imagenes/panditas.jpg" alt="Parejas" class="card__image">
                        <p class="card__name" style="margin-top: 15px;">${P.nombreCompleto1} - ${P.nombreCompleto2}</p>
                         <ul class="social-icons">
                            <li><a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                        </ul><br>
                        <form>
                            <a class="a draw-border" href="modificarParejas?id=${P.id}">Modificar</a>
                        </form>
                        <br><br>
                        <form>
                            <a class="a draw-border" href="ServletEliminarPareja?id=${P.id}">Eliminar</a>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </center>
    </body>
</html>
