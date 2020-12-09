/*
 * Validaciones.java
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import objetosTransferencia.Mensaje;

/**
 * Esta clase contiene métodos que validan los diferentes campos de entrada de
 * los formularios de la aplicacion laboratorioWEB
 *
 * @author jesus
 */
public class Validaciones {

    /**
     * Este método permite validar una clave de un producto del formulario de la
     * página capturaClave.jsp. La validacion se hace en el servlet ObtenProducto
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaClaveProducto(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String clave = request.getParameter("clave");

        // Si no hay clave
        if (valida.cadenaVacia(clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave", mensaje);
        } // Si la clave no es valida
        else if (!valida.validaCadena(13,clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave2", mensaje);
        }
        return mensajes;
    }

    /**
     * Este método permite validar un producto de los formularios de las páginas
     * capturaProducto.jsp y editaProducto.jsp. Las validaciones se hacen en los
     * servlets AgregaProducto y ActualizaProducto, respectivamente.
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaProducto(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;
        String nombre = request.getParameter("nombre");

        // Si no hay nombre
        if (valida.cadenaVacia(nombre)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("nombre", mensaje);
        } // Si el nombre es muy largo
        else if (!valida.validaCadena(35, nombre)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("nombre", mensaje);
        }
        
        String unidad = request.getParameter("unidad");
        // Si no hay unidad
        if (valida.cadenaVacia(unidad)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("unidad", mensaje);
        } // Si la unidades muy largo
        else if (!valida.validaCadena(3, unidad)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("unidad", mensaje);
        }else if (!valida.validaEntero(unidad)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor entero:", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("unidad", mensaje);
        }

        return mensajes;
    }
    /**
     * Este método permite validar un material de los formularios de las páginas
     * capturaMaterialDesinventariar.jsp y capturaMaterialInventariar.jsp. Las validaciones se hacen en los
     * servlets DesinventariarMaterial y InventariaMaterial, respectivamente.
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaMaterial(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String cantidad = request.getParameter("cantidad");

        // Si no es entero
        if (!valida.validaEntero(cantidad)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor entero:", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("cantidad", mensaje);
        }
        

        return mensajes;
    }
}
