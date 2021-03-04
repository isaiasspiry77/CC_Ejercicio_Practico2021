/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controladores.RS;

import com.mycompany.Modelos.SeguimientoEvaluacionModel;
import com.mycompany.Services.SeguimientoEvaluacionServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author IsaiasSpiry7
 */
public class addEvaluaciones extends HttpServlet {
    private SeguimientoEvaluacionServiceImp eService;
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
        response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Methods", "*");
        
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
        //processRequest(request, response);
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
       response.setContentType("text/html;charset=UTF-8");
       response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Methods", "*");
       
       addEvaluacion(request,response);
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

    private boolean addEvaluacion(HttpServletRequest request, HttpServletResponse response) {
        eService = new SeguimientoEvaluacionServiceImp();
        boolean band= false;
        SeguimientoEvaluacionModel tempEvaluacion = null; 
        Enumeration<String> param = request.getParameterNames();
        String haber = param.nextElement();
        
        try{
            JSONObject array = new JSONObject(haber);
            int idEv = array.getInt("idEval");
            String observacionEv = array.getString("observEval");
            int estadoEv = array.getInt("estadoEval");
            
            tempEvaluacion = new SeguimientoEvaluacionModel(idEv,observacionEv,estadoEv);
            
            band = eService.add(tempEvaluacion);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return band;
    }

}
