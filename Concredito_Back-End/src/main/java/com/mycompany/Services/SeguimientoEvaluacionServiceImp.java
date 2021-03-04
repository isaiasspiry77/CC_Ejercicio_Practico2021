/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.mycompany.Cosultas.SeguimientoEvaluacionConsult;
import com.mycompany.Modelos.SeguimientoEvaluacionModel;

/**
 *
 * @author IsaiasSpiry7
 */
public class SeguimientoEvaluacionServiceImp implements SeguimientoEvaluacionService{
    SeguimientoEvaluacionConsult consultas;

    public SeguimientoEvaluacionServiceImp() {
    }
    
    @Override
    public SeguimientoEvaluacionModel listarid(int id) {
        SeguimientoEvaluacionModel tempEvaluacion = null;
        
        try{
            consultas = new SeguimientoEvaluacionConsult();
            tempEvaluacion = consultas.getConsulta(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return tempEvaluacion;
    }

    @Override
    public boolean add(SeguimientoEvaluacionModel ev) {
        boolean band= false;
        try{
            consultas = new SeguimientoEvaluacionConsult();
            band = consultas.addEvalacion(ev);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return band;
    }
    
}
