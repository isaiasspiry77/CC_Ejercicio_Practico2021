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
public class ProspectoModel {
    private int idP;
    private String nombreP;
    private String apellidoPP;
    private String apellidoMP;
    private String calleP;
    private int numeroCP;
    private String coloniaP;
    private String CPP;
    private String telefonoP;
    private String RFCP;
    private int r_Estado;
    private String descEstado;

    public ProspectoModel(int idP, String nombreP, String apellidoPP, String apellidoMP, String calleP, int numeroCP, String coloniaP, String CPP, String telefonoP, String RFCP, String descEstado) {
        this.idP = idP;
        this.nombreP = nombreP;
        this.apellidoPP = apellidoPP;
        this.apellidoMP = apellidoMP;
        this.calleP = calleP;
        this.numeroCP = numeroCP;
        this.coloniaP = coloniaP;
        this.CPP = CPP;
        this.telefonoP = telefonoP;
        this.RFCP = RFCP;
        this.descEstado = descEstado;
    }

    public ProspectoModel(String nombreP, String apellidoPP, String apellidoMP, String calleP, int numeroCP, String coloniaP, String CPP, String telefonoP, String RFCP) {
        this.nombreP = nombreP;
        this.apellidoPP = apellidoPP;
        this.apellidoMP = apellidoMP;
        this.calleP = calleP;
        this.numeroCP = numeroCP;
        this.coloniaP = coloniaP;
        this.CPP = CPP;
        this.telefonoP = telefonoP;
        this.RFCP = RFCP;
    }
    
    
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoPP() {
        return apellidoPP;
    }

    public void setApellidoPP(String apellidoPP) {
        this.apellidoPP = apellidoPP;
    }

    public String getApellidoMP() {
        return apellidoMP;
    }

    public void setApellidoMP(String apellidoMP) {
        this.apellidoMP = apellidoMP;
    }

    public String getCalleP() {
        return calleP;
    }

    public void setCalleP(String calleP) {
        this.calleP = calleP;
    }

    public int getNumeroCP() {
        return numeroCP;
    }

    public void setNumeroCP(int numeroCP) {
        this.numeroCP = numeroCP;
    }

    public String getColoniaP() {
        return coloniaP;
    }

    public void setColoniaP(String coloniaP) {
        this.coloniaP = coloniaP;
    }

    public String getCPP() {
        return CPP;
    }

    public void setCPP(String CPP) {
        this.CPP = CPP;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getRFCP() {
        return RFCP;
    }

    public void setRFCP(String RFCP) {
        this.RFCP = RFCP;
    }

    public int getR_Estado() {
        return r_Estado;
    }

    public void setR_Estado(int r_Estado) {
        this.r_Estado = r_Estado;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
    
    
}
