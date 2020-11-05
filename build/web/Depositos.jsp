<%-- 
    Document   : Depositos
    Created on : 05-nov-2020, 9:45:22
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Depósitos</title>
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
            <form method="POST" action="ServletDepositos">
                <div class="container">
                    <img src="imagenes/depo.png"><br>
                    <label for="datos"><b>Datos:</b></label>
                    <input type="text" id="datos" placeholder="Ingrese datos..." name="datos" style="width:20%;" maxlength="50" required/> <br>
                    <label for="monto" ><b>Monto:</b></label>
                    <input type="text" id="monto" placeholder="Ingrese monto..." name="monto" style="width:20%;" onkeypress="return soloNumeros(event)" required/> <br>
                    <label for="cboParejas"><b>Pareja:</b></label>
                    <div class="row">
                        <div class="input-field col s4 offset-s4">
                            <select name="cboParejas" id="cboParejas">
                                <option value="" disabled selected>Seleccione</option>
                                <c:forEach items="${lista}" var="P">
                                    <option value=${P.id}>${P.nombreCompleto1} - ${P.nombreCompleto2}</option>
                                </c:forEach>               
                            </select>
                        </div>
                    </div>
                    <button type="submit" style="width:30%;" class="parejasLista">Guardar</button>
                </div>
            </form>
        </center>
    </body>
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
</html>
