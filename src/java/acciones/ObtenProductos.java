/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Producto;
import objetosTransferencia.Lista;
import persistencia.PersistenciaBD;

/**
 * Este servlet obtiene de la tabla Productos de la base de datos laboratorio, la
 * lista de los Productos.
 * 
 * @author jesus
 */
public class ObtenProductos extends HttpServlet {

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
        String siguiente = null;

        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();

        // Obten la tarea seleccionada del atributo tareaSel de la variable session
        String tareaSel = (String) session.getAttribute("tareaSel");

        // Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene la lista de canciones del catalogo de Productos
        ArrayList<Producto> lista = fachada.consultarProductos();

        // En este bean de tipo Lista, se almacena la lista de
        // Productos leídos de la tabla materiales de la base de datos laboratorio
        Lista listaProductos = new Lista("Lista de todos los productos", lista);

        // Se requiere guardar en ambito de sesión por que se va a ocupar
        // en la solicitud de correccion de falla de validacion del lado
        // del servidor
        session.setAttribute("listaProductos", listaProductos);

        switch (tareaSel) {
            case "actualizarProducto":
                siguiente = "seleccionaProductoActualizar.jsp";
                break;
            case "eliminarProducto":
                siguiente = "seleccionaProductosEliminar.jsp";
                break;
            case "listarProductos":
                siguiente = "despliegaProductos.jsp";
                break;
            case "inventariarMaterial":
                siguiente= "capturaMaterialInventariar.jsp";
                break;
            case "desinventariarMaterial":
                siguiente= "capturaMaterialDesinventariar.jsp";
                break;
        }

        // Establece la página JSP o servlet siguiente
        rd = request.getRequestDispatcher(siguiente);
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
        return "Servlet que obtiene la lista de productos del catalogo de productos";
    }// </editor-fold>
}
