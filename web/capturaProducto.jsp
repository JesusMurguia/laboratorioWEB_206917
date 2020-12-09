<%--
    capturaProducto.jsp
    
    Esta página JSP permite capturar los datos de un producto. Forma parte de 
    la aplicación laboratorio web.
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>Capturar producto</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu productos --%>
        <%@include file="jspf/menuProductos.jspf"%>

        <main>
            
            <div class="form animated flipInX">
  <h1>Captura Producto</h1>
  <form action="AgregaProducto" method="post" name="capturaProducto">
    <div class="fila">
                        <div class="celda derecha">
                            <label for="claveId" >Clave</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="claveId" name="clave"
                                   value="${param.clave}" size="13" placeholder="Clave" />
                        </div>
                        <div id="msjTitulo" class=" celda ${mensajes.clave.claseMensaje}">
                            ${mensajes.clave.mensaje}
                        </div>
                        
                        <div id="msjTitulo" class=" celda ${mensajes.clave2.claseMensaje}">
                            ${mensajes.clave2.mensaje}
                        </div>
                        <div class="celda">&nbsp;</div>
                    </div>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="nombreId" >Nombre *</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="nombreId" name="nombre" 
                                   value="${param.nombre}" size="35" maxlength="35" required
                                   placeholder="Nombre de producto" />
                        </div>
                        
                    </div>
                        <div class="fila">
                        <div class="celda derecha">
                            <label for="unidadId" >Unidad</label>
                        </div>
                        <div class="celda">
                            <input type="number" id="unidadId" name="unidad"
                                   value="${param.unidad}" size="3" maxlength="3" placeholder="Unidad"/>
                        </div>
                        
                        <div class="celda">&nbsp;</div>
                        <div id="msjTitulo" class=" celda ${mensajes.unidad.claseMensaje}">
                            ${mensajes.unidad.mensaje}
                        </div>
                    </div>
<button>Enviar</button>
</form>
</div>
        </main>
    </body>
</html>
