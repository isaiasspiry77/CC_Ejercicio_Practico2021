/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Modelos;

/**
 *
 * @author IsaiasSpiry7
 */
public class SeguimientoEvaluacionModel {
    private int idEvaluacion;
    private String Observaciones;
    private int R_Prospecto;
    private int R_Estado;
    private String Desc_Estado;

    public SeguimientoEvaluacionModel(int idEvaluacion, String Observaciones, int R_Prospecto, String Desc_Estado) {
        this.idEvaluacion = idEvaluacion;
        this.Observaciones = Observaciones;
        this.R_Prospecto = R_Prospecto;
        this.Desc_Estado = Desc_Estado;
    }

    public SeguimientoEvaluacionModel(int idEvaluacion, String Observaciones, int R_Estado) {
        this.idEvaluacion = idEvaluacion;
        this.Observaciones = Observaciones;
        this.R_Estado = R_Estado;
    }
    
    
    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getR_Prospecto() {
        return R_Prospecto;
    }

    public void setR_Prospecto(int R_Prospecto) {
        this.R_Prospecto = R_Prospecto;
    }

    public int getR_Estado() {
        return R_Estado;
    }

    public void setR_Estado(int R_Estado) {
        this.R_Estado = R_Estado;
    }

    public String getDesc_Estado() {
        return Desc_Estado;
    }

    public void setDesc_Estado(String Desc_Estado) {
        this.Desc_Estado = Desc_Estado;
    }
    
    
}
