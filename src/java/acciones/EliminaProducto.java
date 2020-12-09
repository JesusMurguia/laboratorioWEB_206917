/*
 * EliminaProducto.java
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Producto;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;

/**
 * Este servlet elimina una o varios productos de la tabla productos de la base
 * de datos laboratorio. El servlet obtiene del objeto request la lista de las
 * productos a eliminar
 *
 * @author jesus
 */
public class EliminaProducto extends HttpServlet {

    /**
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;

        // Obten la lista de claves de las productos a eliminar
        String claves[] = (String[]) request.getParameterValues("claves");

        if (claves == null) {
            Map<String, Mensaje> mensajes = new HashMap<>();
            Mensaje mensaje;

            // crea mensaje de error
            mensaje = new Mensaje("Error!: No se seleccionaron productos para eliminar", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("productos", mensaje);
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es seleccionaProductosEliminar.jsp
            rd = request.getRequestDispatcher("seleccionaProductosEliminar.jsp");
        } else {
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            for(String clave: claves) {
                // Elimina la canción del catálogo
                fachada.eliminar(new Producto(clave));
            }
            
            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSel, la tarea arealizar
            session.setAttribute("tareaSel", "listarProductos");

            rd = request.getRequestDispatcher("ObtenProductos");
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Maneja el método HTTP: GET.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método HTTP: POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Regresa una descripcion breve del servlet.
     *
     * @return Descripcion breve del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet que elimina productos del catalogo de productos";
    }
}
