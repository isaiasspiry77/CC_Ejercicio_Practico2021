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
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author IsaiasSpiry7
 */
public class addProspectos extends HttpServlet {
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
            throws ServletException, IOException, JSONException {
        /*response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        
        PrintWriter out = response.getWriter();

        /*JSONObject algo = new JSONObject(request.getParameter("prospecto"));*/
        /*System.out.println(request.getParameter("name"));
        out.print(request.getParameter("name"));*/

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
     * @return 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
       //response.setContentType("application/json");
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Methods", "*");
       addProspecto(request, response);
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

    private boolean addProspecto(HttpServletRequest request, HttpServletResponse response) {
       pService = new ProspectoServiceImp();
       boolean band= false;
       ProspectoModel tempProspecto = null;
       Enumeration<String> param = request.getParameterNames();
       String haber = param.nextElement();
        try {
            JSONObject array = new JSONObject(haber);
            String nombreP = array.getString("name");
            String apellidoP = array.getString("last_nameP");
            String apellidoMP = array.getString("last_nameM");
            String calleP = array.getString("street");
            int numeroSP = array.getInt("numberS");
            String coloniaP = array.getString("suburb");
            String CPP = array.getString("cp");
            String telP = array.getString("phone");
            String RFCP = array.getString("rfc");
            
            tempProspecto = new ProspectoModel(nombreP,apellidoP,apellidoMP,calleP,numeroSP,coloniaP,CPP,telP,RFCP);
            
            band = pService.add(tempProspecto);
            
        } catch (JSONException ex) {
            Logger.getLogger(addProspectos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return band;
    }

}
