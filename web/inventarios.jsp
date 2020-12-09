<%-- 
    productos.jsp

    Esta página JSP es la página con el menú inventarios de la aplicación Web
    laboratorioWEB 
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Inventarios</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu inventario --%>
        <%@include file="jspf/menuInventarios.jspf"%>
    
        <main>
        </main>
    </body>
</html>
