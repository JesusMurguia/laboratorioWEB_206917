/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
public class Control extends HttpServlet {

    /**
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     * 
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Obten de la solicitud, la tarea seleccionada del menú de canciones
        String tareaSel = request.getParameter("tarea");
        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String siguiente = null;

        // Guarda en la variable de sesion tareaSel, la tarea seleccionada
        session.setAttribute("tareaSel", tareaSel);

        // establece la pagina JSP o servlet que inicia
        // el caso de uso seleccionado
        switch (tareaSel) {
            case "agregarProducto":
                siguiente = "capturaProducto.jsp";
                break;
            case "actualizarProducto":
                siguiente = "ObtenProductos";
                break;
            case "eliminarProducto":
                siguiente = "ObtenProductos";
                break;
            case "listarProductos":
                siguiente = "ObtenProductos";
                break;
            case "consultarProductos":
                siguiente="ObtenProductos";
                break;
            case "inventariarMaterial":
                siguiente="ObtenProductos";
                break;
            case "consultarInventarioMateriales":
                siguiente="ObtenInventarioMateriales";
                break;
            case "desinventariarMaterial":
                siguiente="ObtenInventarioMateriales";
            default:
                break;
        }

        // Obten el objeto RequestDispatcher
        rd = request.getRequestDispatcher(siguiente);
        
        // Redirecciona a la página JSP siguiente
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método HTTP: POST.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
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
        return "Servlet de control";
    }// </editor-fold>
}