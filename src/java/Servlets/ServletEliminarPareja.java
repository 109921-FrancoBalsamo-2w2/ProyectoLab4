/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Parejas;
import ConexionSQL.Conexiones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francobalsamo
 */
public class ServletEliminarPareja extends HttpServlet {

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
        
        Conexiones conexiones = new Conexiones();
        
        String id = request.getQueryString();
        String idA = id;
        
        if(id.contains("id=")){
            id = id.replaceAll("id=", "").trim();
            int ida = Integer.parseInt(id);
            int borrar = 1;

            Parejas parejas = new Parejas(ida);

            parejas.setIdBorrado(borrar);
            parejas.setId(ida);

            conexiones.EliPar(parejas);
            
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/indexLogin");
            requestDispatcher.forward(request, response);
        }
        
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
//        Conexiones conexiones = new Conexiones();
//        
//        String id = request.getQueryString();
//        String idA = id;
//        
//        if(id.contains("id=")){
//            id = id.replaceAll("id=", "").trim();
//            int ida = Integer.parseInt(id);
//            int borrar = 1;
//
//            Parejas parejas = new Parejas(ida);
//
//            parejas.setIdBorrado(borrar);
//            parejas.setId(ida);
//
//            conexiones.EliPar(parejas);
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/indexLogin");
//            requestDispatcher.forward(request, response);
//        }
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
