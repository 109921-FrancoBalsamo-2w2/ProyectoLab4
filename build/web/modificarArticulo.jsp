<%-- 
    Document   : modificarArticulo
    Created on : 04-nov-2020, 20:32:29
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Artítulo</title>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/modal.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
    </head>
    <body>        
        <div class="topnav">
            <a href="indexLogin"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <a href="articulos"><i class="fas fa-book" style="padding-right: 10px;"></i>Artículos</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
        <center>
            <img src="imagenes/modart.png"><br>
            <label id="valorUrl" name="valorUrl" hidden>${param.id}</label>
            <c:forEach items="${lista}" var="A">
            <div class="container">
                    <label for="cod"><b>Código:</b></label>
                    <form method="POST" action="ServletModificarArticulos?id=${param.id}">
                        <input type="text" id="cod" value="${A.codigo}" placeholder="Ingrese código..." name="cod" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                        <label for="den"><b>Descripción:</b></label>
                        <input type="text" id="den" value="${A.denominacion}" placeholder="Ingrese descripción..." name="den" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                        <label for="preun"><b>Precio Unitario:</b></label>
                        <input type="text" id="preun" value="${A.precioUnitario}" placeholder="Ingrese precio unitario..." name="preun" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                        <div class="row">
                            <div class="input-field col s4 offset-s4">
                                <select name="cboTipoArticulo" id="cboTipoArticulo">
                                    <option value="${A.idta}" disabled selected>${A.tiar}</option>
                                </select>

                            </div>
                        </div>
                        <button type="submit" style="width:30%;" class="parejasLista">Guardar</button>
                    </form>
                </div>
            </c:forEach>
        </center>
    </body>
</html>
