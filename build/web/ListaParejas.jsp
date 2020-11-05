<%-- 
    Document   : ListaParejas
    Created on : 26-oct-2020, 20:36:19
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/cardlist.css">
        <title>Lista Parejas</title>
        
    </head>
    <body>
        <div class="topnav">
            <a href="index.html"><i class="fa fa-home" style="padding-right: 10px;"></i>Inicio</a>
        </div>
        <br>
        <br>
        <br>
        <center>
            <div class="container">
                 <c:forEach items="${lista}" var="P">
                    <div class="card">
                        <img src="imagenes/panditas.jpg" alt="Parejas" class="card__image">
                        <p class="card__name" style="margin-top: 15px;">${P.nombreCompleto1} - ${P.nombreCompleto2}</p>
                         <ul class="social-icons">
                            <li><a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                        </ul>
                        <form method="POST" action="listaArticulosPreciosParejas?id=${P.id}" style="float: right;">
                            <button class="btn draw-border">Lista regalos</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </center>
    </body>
</html>
