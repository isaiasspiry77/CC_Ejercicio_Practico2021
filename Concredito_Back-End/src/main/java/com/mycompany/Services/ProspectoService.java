/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.mycompany.Modelos.ProspectoModel;
import java.util.List;

/**
 *
 * @author IsaiasSpiry7
 */
public interface ProspectoService {
    List<ProspectoModel>listar();
    ProspectoModel listarId(int id);
    boolean add(ProspectoModel p);
    ProspectoModel edit(ProspectoModel p);
    ProspectoModel delete(int id);
}
