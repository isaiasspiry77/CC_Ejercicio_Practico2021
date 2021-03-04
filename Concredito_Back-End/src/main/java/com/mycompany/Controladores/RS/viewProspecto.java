/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controladores.RS;

import com.mycompany.Modelos.ProspectoModel;
import com.mycompany.Services.ProspectoServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author IsaiasSpiry7
 */
public class viewProspecto extends HttpServlet {
    private ProspectoServiceImp pService;
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
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        
        String instruccion = request.getParameter("q");
        
        switch(instruccion){
            case "moreInfo":
               try {
                    getProspecto(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(viewProspecto.class.getName()).log(Level.SEVERE, null, ex);
                } 
            break;
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
        //processRequest(request, response);
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

    private void getProspecto(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("idPro");
        int idP = Integer.parseInt(id);
        pService = new ProspectoServiceImp();
        ProspectoModel prospecto = pService.listarId(idP);
        
        //JSONArray prospectoJson = new JSONArray(prospecto);
        JSONObject pro = new JSONObject(prospecto);
        out.print(pro);
    }

}
