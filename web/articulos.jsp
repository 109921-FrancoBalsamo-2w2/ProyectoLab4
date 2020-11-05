<%-- 
    Document   : altaArticulos
    Created on : 04-nov-2020, 11:27:32
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Artículos</title>
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
            <a href="indexLogin"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <a href="ServletReporte"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 1</a>
            <a href="totalFacturado"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 2</a>
            <a href="ServletReporteUno"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 3</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
    <center><img class="img" src="imagenes/00.png"/></center>
    <center><p>Bienvenida/a, por favor presione el botón para la acción que desea llevar a cabo.</p></center>
    <center>
        <form action="ServletAltaArticulo">
            <button class="parejasLista" style="width: 150px">Agregar</button> <br>
        </form>
    </center>
        <center>
            <div class="container">
                 <c:forEach items="${lista}" var="A">
                    <div class="card">
                        <img src="imagenes/articulos.png" alt="Articulos" class="card__image">
                        <p class="card__name" style="margin-top: 15px;">${A.codigo} - ${A.denominacion}</p>
                         <ul class="social-icons">
                            <li><a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                        </ul>
                        <form>
                            <a class="a draw-border" href="ServletModificarArticulos?id=${A.idA}">Modificar</a>
                        </form>
                        <br><br>
                        <form>
                            <a class="a draw-border" href="ServletEliminarArticulo?id=${A.idA}">Eliminar</a>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </center>
    </body>
</html>
