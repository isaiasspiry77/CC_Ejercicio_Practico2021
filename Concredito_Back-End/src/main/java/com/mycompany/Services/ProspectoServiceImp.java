/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.mycompany.Cosultas.ProspectoConsult;
import com.mycompany.Modelos.ProspectoModel;
import java.util.List;

/**
 *
 * @author IsaiasSpiry7
 */
public class ProspectoServiceImp implements ProspectoService{
    
    private ProspectoConsult consultas;
    
    public ProspectoServiceImp(){
       
    }
    
    @Override
    public List<ProspectoModel> listar() {
        List<ProspectoModel> prospectos = null;
        
        try{
            consultas = new ProspectoConsult();
            prospectos = consultas.getlist();
        }catch(Exception e){
            e.printStackTrace();
        }
        return prospectos;
    }

    @Override
    public ProspectoModel listarId(int id) {
        ProspectoModel prospecto = null;
        try{
            consultas = new ProspectoConsult();
            prospecto = consultas.getProspecto(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return prospecto;
    }

    @Override
    public boolean add(ProspectoModel p) {
        boolean band = false;
        try{
            consultas = new ProspectoConsult();
            band = consultas.addProspecto(p);
        }catch(Exception e){
            e.printStackTrace();
        }
        return band;
    }

    @Override
    public ProspectoModel edit(ProspectoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProspectoModel delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
