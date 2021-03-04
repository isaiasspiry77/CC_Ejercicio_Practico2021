/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Cosultas;

import com.mycompany.Modelos.SeguimientoEvaluacionModel;
import com.mycompany.basedatos.Conexionbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author IsaiasSpiry7
 */
public class SeguimientoEvaluacionConsult {

    private Conexionbd conn;

    public SeguimientoEvaluacionConsult() {
        this.conn = new Conexionbd();
    }

    public SeguimientoEvaluacionModel getConsulta(int id) {
        SeguimientoEvaluacionModel tempEvaluacion = null;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = conn.obtener();
            String sql = "CALL getInfoEvaluacion(?)";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int idEval = rs.getInt("idSeguimiento");
                String observEval = rs.getString("Observaciones");
                int idPros = rs.getInt("R_Prospecto");
                String descEstado = rs.getString("DescEstado");

                if (observEval == null) {
                    tempEvaluacion = new SeguimientoEvaluacionModel(idEval, "null", idPros, descEstado);
                } else {
                    tempEvaluacion = new SeguimientoEvaluacionModel(idEval, observEval, idPros, descEstado);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn.obtener() != null) {
                    conn.obtener().close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tempEvaluacion;
    }

    public boolean addEvalacion(SeguimientoEvaluacionModel ev) {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = conn.obtener();
            String sql = "CALL addObsvEvaluacionP(?,?,?)";
            st = con.prepareStatement(sql);
            
            st.setInt(1, ev.getIdEvaluacion());
            st.setString(2, ev.getObservaciones());
            st.setInt(3, ev.getR_Estado());
            
            st.execute();
            
        } catch (Exception e) {

        } finally {
            try {
                if (conn.obtener() != null) {
                    conn.obtener().close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
