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
public class modificarParejas extends HttpServlet {

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
        
        };

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
            ArrayList<Parejas> lista = new ArrayList<Parejas>();
            Conexiones conexiones = new Conexiones();
            lista = conexiones.parejasListasByM(ida);
            request.setAttribute("lista", lista);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/modificarPareja.jsp");
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
            String nom1 = request.getParameter("nom1");
            String ape1 = request.getParameter("ape1");
            String nom2 = request.getParameter("nom2");
            String ape2 = request.getParameter("ape2");

            Parejas parejas = new Parejas(nom1, ape1, nom2,ape2);

            parejas.setId(ida);

            conexiones.ModPar(parejas);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/indexLogin");
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
