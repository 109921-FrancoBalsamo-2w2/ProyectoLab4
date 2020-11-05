<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Modificar Pareja</title>
        <link rel="stylesheet" type="text/css" href="css/modal.css">
        <link rel="stylesheet" type="text/css" href="css/botones.css">
        <link rel="stylesheet" type="text/css" href="css/topnav.css">
    <body>
        <div class="topnav">
            <a href="indexLogin"><i class="fas fa-home" style="padding-right: 10px;"></i>Inicio</a>
            <button onclick="logoutBut()">Cerrar sesión</button>
        </div>
        <center>
            <label id="valorUrl" name="valorUrl" hidden>${param.id}</label>
                <c:forEach items="${lista}" var="P">
                            <div class="container">
                                    <img src="imagenes/modi.png"><br>
                                    <form method="POST" action="modificarParejas?id=${param.id}">
                                        <label for="nom1"><b>Nombre 1:</b></label>
                                        <input type="text" id="nom1" value="${P.nombreUno}" name="nom1" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                                        <label for="ape1"><b>Apellido 1:</b></label>
                                        <input type="text" id="ape1" value="${P.apellidoUno}" name="ape1" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                                        <label for="nom2"><b>Nombre 2:</b></label>
                                        <input type="text" id="nom2" value="${P.nombreDos}" name="nom2" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                                        <label for="ape2"><b>Apellido 2:</b></label>
                                        <input type="text" id="ape2" value="${P.apellidoDos}" name="ape2" style="width:20%;" onkeypress="return soloLetras(event)"/> <br>

                                    
                                        <button type="submit" style="width:30%;" class="parejasLista">Guardar</button>
                                    </form> 
                                </div>
                    </c:forEach>
            </div>
        </center>
        <center>   
        </center>    
    </body>
</html>