/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.mycompany.Modelos.SeguimientoEvaluacionModel;

/**
 *
 * @author IsaiasSpiry7
 */
public interface SeguimientoEvaluacionService {
    SeguimientoEvaluacionModel listarid(int id);
    boolean add(SeguimientoEvaluacionModel e);
}
