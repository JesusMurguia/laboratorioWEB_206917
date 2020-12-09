<%--
    capturaMaterialDesinventariar.jsp
    
    Esta página JSP permite capturar los datos de un material. Forma parte de 
    la aplicación laboratorioWeb .
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>Capturar Material Desinventariar</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu inventarios --%>
        <%@include file="jspf/menuInventarios.jspf"%>

        <main>
            <h1>Desinventariar Material</h1>

            <%-- Formulario para capturar los atributos de un material.
                 Los datos se envían al servlet InventariaMaterial para
                 guardarlos en la BD --%>
            <form action="DesinventariaMaterial" method="post" name="capturaMaterial" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet DesinventariaMaterial. --%>
                <div class="tabla">
                        <div class="fila">
                        <div class="celda derecha">
                            Producto *
                        </div>
                        <div class="celda">
                            <select onFocus="" name="cveProducto" required>
                                <%-- La lista de materiales de productos se encuentran
                                     en el bean listaMateriales almacenado en el
                                     objeto session por el servlet ObtenInventarioMateriales. --%>
                                <c:forEach items="${listaMateriales.lista}" 
                                           var="producto" >
                                    <c:choose>
                                        <c:when test="${param.clave == producto.clave}" >
                                            <option selected value="${producto.clave}" >${producto.clave}</option>
                                        </c:when>
                                        <c:when test="${param.clave != producto.clave}" >
                                            <option value="${producto.clave}" >${producto.nombre}</option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        
                    </div>
                        <div class="fila">
                        <div class="celda derecha">
                            <label for="cantidadId" >Cantidad</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="cantidadId" name="cantidad"
                                   value="${param.cantidad}"  required/>
                        </div>
                        <div class="celda">&nbsp;</div>
                        <div id="msjProducto" class="celda ${mensajes.cantidad.claseMensaje}">
                            ${mensajes.cantidad.mensaje}
                        </div>
                    </div>
                </div>
                <br />
<div class="form animated flipInX">
                             <button>Enviar</button>
 </div>
            </form>
        </main>
                        
    </body>
</html>
