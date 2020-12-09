<%--
    despliegaInventarioMateriales.jsp
    
    Esta página JSP despliega una tabla con la lista de materiales del catálogo 
    de productos. Forma parte de la aplicación Web laboratorioweb.
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ page import="objetosNegocio.*" %>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Despliega materiales</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu inventario --%>
        <%@include file="jspf/menuInventarios.jspf"%>

        <main>
             <h1>Desplegar Inventario</h1>
            <div class="content">
            <%-- Despliega los datos de todas los materiales. Los datos
                 se encuentran en el bean listaMateriales guardados en
                 el objeto session por el servlet obtenInventarioMateriales
            --%>
            <table id="data-table">
                <thead>
                    <tr>
                    <%-- Títulos de las columnas --%>
                    <th>Clave</th>
                    <th>Nombre</th>
                    <th>Unidad</th>
                    <th>Cantidad</th>
             </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaMateriales.lista}" var="m">
                    <tr>
                      <td>${m.clave}</td>
                      <td>${m.nombre}</td>
                      <td>${m.unidad}</td>
                      <td>${m.cantidad}</td>
                  </tr>
                </c:forEach>
            </tr>
</tbody>
  </table>
                    </div></main>
        </main>
    </body>
</html>
