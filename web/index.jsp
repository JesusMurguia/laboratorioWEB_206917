<%-- 
    index.jsp

    Esta página JSP es la página inicial de la aplicación LaboratorioWeb
    Despliega el menú de opciones.
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>LaboratorioWEB</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu principal --%>
        <%@include file="jspf/menuPpal.jspf"%>
        
        <main>
            <p id="info">Presiona el botón para saber más información sobre esta pagina.</p>
 
        <button type="button" onclick="loadDoc()">Información</button>
        <script>
        function loadDoc() {
          var xhttp = new XMLHttpRequest();
          xhttp.open("GET", "ajaxContent/info.txt", false);
          xhttp.send();
          document.getElementById("info").innerHTML = xhttp.responseText;
        }
        </script>
        </main>
    </body>
</html>
