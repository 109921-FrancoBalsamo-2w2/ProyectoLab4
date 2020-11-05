<%-- 
    Document   : altaParejas
    Created on : 28-oct-2020, 13:20:01
    Author     : francobalsamo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Pareja</title>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/modal.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
    </head>
    <body>
        <div class="topnav">
            <a href="indexLogin"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
        <center>
            <form method="POST" action="altaPareja">
                <div class="container">
                    <img src="imagenes/insertPareja.png"><br>

                    <label for="nom1"><b>Nombre 1:</b></label>
                    <input type="text" id="nom1" placeholder="Ingrese nombre..." name="nom1" style="width:20%;" maxlength="50" required> <br>

                    <label for="ape1"><b>Apellido 1:</b></label>
                    <input type="text" id="ape1" placeholder="Ingrese apellido..." name="ape1" style="width:20%;" maxlength="50" required/> <br>

                    <label for="nom2"><b>Nombre 2:</b></label>
                    <input type="text" id="nom2" placeholder="Ingrese nombre..." name="nom2" style="width:20%;" maxlength="50" required/> <br>

                    <label for="ape2"><b>Apellido 2:</b></label>
                    <input type="text" id="ape2" placeholder="Ingrese apellido..." name="ape2" style="width:20%;" maxlength="50" required/> <br>

                    <button type="submit" style="width:30%;" class="parejasLista">Guardar</button>
                </div>
            </form>
        </center>
    </body>
</html>
