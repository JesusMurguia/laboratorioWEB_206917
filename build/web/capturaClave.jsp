<%-- 
    capturaClave.jsp

    Esta página JSP permite capturar la clave de un producto a agregar
    al catálogo de productos. Forma parte de la aplicación Web 
    laboratorioWeb
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <title>Captura Clave</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu productos --%>
        <%@include file="jspf/menuProductos.jspf"%>

        <main>
            <h1>Capturar clave</h1>
            <%-- Formulario para capturar la clave de un producto.
                 La clave se envía al servlet ObtenProductos para
                 obtener el producto de la BD --%>
            <form action="ObtenProducto" method="post" name="capturaClave" >
                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet ObtenProducto. --%>
                <div class="tabla">
                    <div class="fila">
                        <div class="celda"><label for="claveId" >Clave *</label></div>
                        <div class="celda">
                            <input type="text" id="claveId" name="clave" 
                                   value="${param.clave}" size="13" pattern="^[0-9]{13}$" 
                                   title="13 digitos"
                                   placeholder="1234567890123" required />
                        </div>
                        <div id="msjClave" class="celda ${mensajes.clave.claseMensaje}">
                            ${mensajes.clave.mensaje}
                        </div>
                    </div>
                </div>
                <br />
                <div class="tabla" >
                    <div class="fila">
                        <%-- Boton enviar --%>
                        <div class="celda">
                            <input type="submit" name="boton" value="Continuar" />
                        </div>
                        <%-- Botón limpiar --%>
                        <div class="celda">
                            <input type="reset" value="Limpiar" />
                        </div>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
