<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Titulo del documento</title>
        <meta charset="utf-8" />
        <!--<link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="css/mensajes.css">-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/signin.css"/>
    
    </head>

    <body>



        <c:import url="/WEB-INF/vista/pantallas/${param.c}" />

    </body>
</html>
