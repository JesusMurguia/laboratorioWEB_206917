/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
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
import utils.Validaciones;

/**
 * Este servlet actualiza un producto a la tabla productos de la base de datos
 * laboratorio. El servlet obtiene del objeto request los atributos de los productos. 
 * El servlet verifica que los atributos de producto sean válidas.
 * 
 * @author jesus
 */
public class ActualizarProducto extends HttpServlet {

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
        Validaciones validaciones = new Validaciones();

        // valida los datos del producto
        Map<String, Mensaje> mensajes = validaciones.validaProducto(request);
        
        // Si la validación falla
        if (!mensajes.isEmpty()) {
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece la siguiente pagina
            rd = request.getRequestDispatcher("editaProducto.jsp");
            
        } else {
            // En este bean de tipo producto, se almacenan los atributos de un
            //  producto enviada por la página capturaProducto.jsp.
            Producto p = new Producto();

            // Obtiene de la solicitud los datos de un producto y los guarda al bean producto
            p.setClave(request.getParameter("clave"));
            p.setNombre(request.getParameter("nombre"));
            p.setUnidad(request.getParameter("unidad"));
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();
                    
            fachada.actualizar(p);
            

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSel, la tarea arealizar
            session.setAttribute("tareaSel", "listarProductos");

            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher("ObtenProductos");
        }
        // Redirecciona a la página JSP o servlet siguiente
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
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Regresa una descripcion breve del servlet.
     * 
     * @return Descripcion breve del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet que actualiza un producto al catalogo de productos";
    }// </editor-fold>
    }
