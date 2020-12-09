/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import objetosNegocio.Producto;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;

/**
 *
 * @author jesus
 */
public class obtenProductoEditar extends HttpServlet {
    
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
        RequestDispatcher rd;

        // Obten la clave, unidad y nombre de el Producto enviada por la página seleccionaProductoActualizar.jsp
        // o por la página seleccionaProductoEditar.jsp
        String clave = request.getParameter("clave");
        String unidad = request.getParameter("unidad");
        String nombre = request.getParameter("nombre");

        if (clave == null) {
            Map<String, Mensaje> mensajes = new HashMap<>();
            Mensaje mensaje;

            // crea mensaje de error
            mensaje = new Mensaje("Error!: No se selecciono un Producto para editar", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("Producto", mensaje);
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es seleccionaProductoActualizar.jsp
            rd = request.getRequestDispatcher("seleccionaProductoActualizar.jsp");
        } else {
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Busca el producto en el catalogo de productos
            Producto producto = new Producto();
            producto.setUnidad(unidad);
            producto.setClave(clave);
            producto.setNombre(nombre);
            producto=fachada.obten(producto);
            // Crea la variable de solicitud Producto, con el Producto existente
            request.setAttribute("producto", producto);

            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher("editaProducto.jsp");
        }
        // Redirecciona a la página JSP o servlet siguiente
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
            return "Servlet que obtiene productoa  editar";
    }// </editor-fold>

}
