<%-- 
    Document   : altaArticulo
    Created on : 04-nov-2020, 11:48:43
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Artículo</title>
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
            <form method="POST" action="ServletAltaArticulo">
                <div class="container">
                    <img src="imagenes/inserar.png"><br>

                    <label for="cod"><b>Código:</b></label>
                    <input type="text" id="cod" placeholder="Ingrese código..." name="cod" style="width:20%;" maxlength="10" required/> <br>

                    <label for="den"><b>Descripción:</b></label>
                    <input type="text" id="den" placeholder="Ingrese descripción..." name="den" style="width:20%;" maxlength="100" required/> <br>

                    <label for="preun"><b>Precio Unitario:</b></label>
                    <input type="text" id="preun" placeholder="Ingrese precio unitario..." name="preun" style="width:20%;" onkeypress="return soloNumeros(event)" required/> <br>
                   
                    <div class="row">
                        <div class="input-field col s4 offset-s4">
                            <select name="cboTipoArticulo" id="cboTipoArticulo" required>
                                <option value="" disabled selected>Seleccione</option>
                                <c:forEach items="${lista}" var="TA">
                                    <option value=${TA.id}>${TA.tipo}</option>
                                </c:forEach>               
                            </select>

                        </div>
                    </div>
                    <button type="submit" style="width:30%;" class="parejasLista">Guardar</button>
                </div>
            </form>
        </center>
    <script>
        function soloNumeros(e) {
            tecla = (document.all) ? e.keyCode : e.which;

            //Tecla de retroceso para borrar
            if (tecla == 8 || tecla == 13) {
                return true;
            }

            // Patrón de entrada, en este caso solo acepta numeros y letras
            patron = /[0-9]/;
            tecla_final = String.fromCharCode(tecla);
            return patron.test(tecla_final);
        }   
    </script>
    </body>
</html>
