/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Articulos;
import Clases.tipoArticulosClase;
import ConexionSQL.Conexiones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francobalsamo
 */
public class ServletModificarArticulos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        String id = request.getQueryString();
        String idA = id;
        
        if(id.contains("id=")){
            id = id.replaceAll("id=", "").trim();
            int ida = Integer.parseInt(id);
            Conexiones conexiones = new Conexiones();
            
            ArrayList<Articulos> lista = conexiones.articulosListasByM(ida);
            request.setAttribute("lista", lista);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/modificarArticulo.jsp");
            requestDispatcher.forward(request, response);
        }
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
        String id = request.getQueryString();
        String idA = id;
        
        Conexiones conexiones = new Conexiones();
        
        if(id.contains("id=")){
            id = id.replaceAll("id=", "").trim();
            int ida = Integer.parseInt(id);
            String cod = request.getParameter("cod");
            String den = request.getParameter("den");
            String preun = request.getParameter("preun");
            double preuni = Double.parseDouble(preun);

            Articulos articulos = new Articulos(cod, den, preuni);

            articulos.setIdA(ida);

            conexiones.ModAr(articulos);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/articulos");
            requestDispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
