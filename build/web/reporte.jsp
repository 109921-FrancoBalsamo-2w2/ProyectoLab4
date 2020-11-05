<%-- 
    Document   : reporte
    Created on : 05-nov-2020, 10:31:55
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte 1</title>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/modal.css">
        <link rel="stylesheet" type="text/css" href="css/tablas.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
    </head>
    <body>
        <div class="topnav">
            <a href="indexLogin"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <a href="totalFacturado"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 2</a>
            <a href="ServletReporteUno"><i class="fas fa-book" style="padding-right: 10px;"></i>Reporte 3</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
        <center>
            <img src="imagenes/repor1.png" alt="Reporte"/>
        </center>
        <center>
            <table id="customers" style="width: 20%; margin-top: 15px;">
                <tr>
                    <th style="text-align: center;">Pareja</th>
                    <th style="text-align: center;">Cantidad</th>
                    <th style="text-align: center;">Monto</th>
                </tr>
                <c:forEach items="${lista}" var="R">
                    <tr>
                        <td style="text-align: center;">${R.nombreCompleto1} - ${R.nombreCompleto2}</td>
                        <td style="text-align: center;">${R.cantidad}</td>
                        <td style="text-align: center;">${R.monto}</td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
