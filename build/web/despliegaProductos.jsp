<%--
    despliegaProductos.jsp
    
    Esta página JSP despliega una tabla con la lista de productos del catálogo 
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
        <title>Despliega productos</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu productos --%>
        <%@include file="jspf/menuProductos.jspf"%>

        <main>
            <h1>Desplegar productos</h1>
        <div class="content">
            <%-- Despliega los datos de todas los productos. Los datos
     se encuentran en el bean listaproductos guardados en
     el objeto session por el servlet obtenproductos
            --%>
            
            <table id="data-table">
                <thead>
                    <tr>
                        <%-- Títulos de las columnas --%>
                        <th>Clave</th>
                        <th>Nombre</th>
                        <th>Unidad</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaProductos.lista}" var="p">
                        <tr>
                            <td>${p.clave}</td>
                            <td>${p.nombre}</td>
                            <td>${p.unidad}</td>
                        </tr>
                    </c:forEach></td>
                    </tr>
</tbody>
  </table>
</div></main>
                    </body>
                    </html>
