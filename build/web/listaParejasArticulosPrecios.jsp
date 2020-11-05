<%-- 
    Document   : listaParejasArticulosPrecios
    Created on : 28-oct-2020, 10:24:49
    Author     : francobalsamo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/tablas.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Lista Parejas</title>
    </head>
    <body>
        
            
        <div class="topnav" style="height:53px;">
            <a href="index.html"><i class="fas fa-home" style="font-size:17; padding-right: 10px;"></i>Inicio</a>
        </div>
        <br>
        <br>
        <br>
        <label id="valorUrl" name="valorUrl" hidden>${param.id}</label>
        
        <center>
            <table id="customers">
                <tr>
                    <th>Pareja</th>
                    <th>Artículos</th>
                    <th>Precios</th>
                </tr>
                <c:forEach items="${lista}" var="A">
                    <tr>
                        <td>${A.p1} - ${A.p2}</td>
                        <td>${A.denominacion}</td>
                        <td>$ ${A.precioUnitario}</td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
