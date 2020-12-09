<%--
    editaProducto.jsp
    
    Esta página JSP permite capturar los datos de un producto. Forma parte de 
    la aplicación laboratorioWeb.
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>Actualiza Producto</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu productos --%>
        <%@include file="jspf/menuProductos.jspf"%>

        <main>
            <h1>Actualiza Producto</h1>
            <div class="form animated flipInX">
            <%-- Formulario para capturar los atributos de un producto.
                 Los datos se envían al servlet agregaProducto para
                 guardarlos en la BD --%>
            <form action="ActualizarProducto" method="post" name="capturaCancion" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet agregaProducto. --%>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="claveId" >Clave</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="claveId" name="clave"
                                   value="${producto.clave}" size="13" readonly />
                        </div>
                        <div class="celda">&nbsp;</div>
                    </div>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="nombreId" >Nombre *</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="nombreId" name="nombre" 
                                   value="${producto.nombre}" size="35" maxlength="35" required
                                   placeholder="Nombre de producto" />
                        </div>
                        
                    </div>
                        <div class="fila">
                        <div class="celda derecha">
                            <label for="unidadId" >Unidad</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="unidadId" name="unidad"
                                   value="${producto.unidad}" size="3" maxlength="3" />
                        </div>
                        <div class="celda">&nbsp;</div>
                        <div id="msjTitulo" class=" celda ${mensajes.unidad.claseMensaje}">
                            ${mensajes.unidad.mensaje}
                        </div>
                    </div>
                <br />
                <button>Enviar</button>
            </form>
                 </div>
                
                       
        </main>
    </body>
</html>
