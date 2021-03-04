/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Cosultas;

import com.mycompany.Modelos.ProspectoModel;
import com.mycompany.basedatos.Conexionbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IsaiasSpiry7
 */
public class ProspectoConsult {
    
    private Conexionbd conn;
            
    public ProspectoConsult() {
        this.conn = new Conexionbd();
    }

    public List<ProspectoModel> getlist() {
        List<ProspectoModel> listProspectos = new ArrayList<>();
        ProspectoModel tempProspecto = null;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = conn.obtener();
            st = con.createStatement();
            String sql = "SELECT *FROM vw_getListProspectos";
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                int idPros = rs.getInt("idProspecto");
                String namePros = rs.getString("NombreProspecto");
                String lastnamePP = rs.getString("ApellidoPProspecto");
                String lastnameMP = rs.getString("ApellidoMProspecto");
                String streetP = rs.getString("CalleDomProspecto");
                int streetNumberP = rs.getInt("NumeroDomProspecto");
                String suburbP = rs.getString("ColoniaDomProspecto");
                String CPP = rs.getString("CPDomProspecto");
                String phoneP = rs.getString("TelefonoProspecto");
                String RFCP = rs.getString("RFCProspecto");
                String estado = rs.getString("DescEstado");
                
                if(lastnameMP == null){
                    tempProspecto = new ProspectoModel(idPros,namePros,lastnamePP,"null", streetP,streetNumberP,suburbP, CPP, phoneP, RFCP, estado);
                }else{
                    tempProspecto = new ProspectoModel(idPros,namePros,lastnamePP,lastnameMP, streetP,streetNumberP,suburbP, CPP, phoneP, RFCP, estado);
                }
                
                listProspectos.add(tempProspecto);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (conn.obtener() != null) {
                    conn.obtener().close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return listProspectos;
    }

    public ProspectoModel getProspecto(int id) {
        ProspectoModel tempProspecto = null;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            con = conn.obtener();
            String sql = "CALL getInfoProspecto(?)";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            
            while(rs.next()){
                int idPros = rs.getInt("idProspecto");
                String namePros = rs.getString("NombreProspecto");
                String lastnamePP = rs.getString("ApellidoPProspecto");
                String lastnameMP = rs.getString("ApellidoMProspecto");
                String streetP = rs.getString("CalleDomProspecto");
                int streetNumberP = rs.getInt("NumeroDomProspecto");
                String suburbP = rs.getString("ColoniaDomProspecto");
                String CPP = rs.getString("CPDomProspecto");
                String phoneP = rs.getString("TelefonoProspecto");
                String RFCP = rs.getString("RFCProspecto");
                String estado = rs.getString("DescEstado");
                
                if(lastnameMP == null){
                    tempProspecto = new ProspectoModel(idPros,namePros,lastnamePP,"null", streetP,streetNumberP,suburbP, CPP, phoneP, RFCP, estado);
                }else{
                    tempProspecto = new ProspectoModel(idPros,namePros,lastnamePP,lastnameMP, streetP,streetNumberP,suburbP, CPP, phoneP, RFCP, estado);
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn.obtener() != null) {
                    conn.obtener().close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return tempProspecto;
    }

    public boolean addProspecto(ProspectoModel p) {
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = conn.obtener();
            String sql = "CALL addInfoProspecto(?,?,?,?,?,?,?,?,?)";
            st = con.prepareStatement(sql);
            
            st.setString(1, p.getNombreP());
            st.setString(2, p.getApellidoPP());
            st.setString(3, p.getApellidoMP());
            st.setString(4, p.getCalleP());
            st.setInt(5, p.getNumeroCP());
            st.setString(6, p.getColoniaP());
            st.setString(7, p.getCPP());
            st.setString(8, p.getTelefonoP());
            st.setString(9,p.getRFCP());
            
            st.execute();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn.obtener() != null) {
                    conn.obtener().close();
                }
                if (st != null) {
                    st.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return true;
    }
}
