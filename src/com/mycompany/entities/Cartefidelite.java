/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author raoun
 */
public class Cartefidelite {
    
     private int id ;
    private String num;
    private int nbpts;
    private String periodevalidation;
    private String dateexpiration;

    
    public Cartefidelite(){}
    
    public Cartefidelite(int id, String num, int nbpts, String periodevalidation, String dateexpiration) {
        this.id = id;
        this.num = num;
        this.nbpts = nbpts;
        this.periodevalidation = periodevalidation;
        this.dateexpiration = dateexpiration;
    }

    
    public int getId() {
        return id;
    }
    
        public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public int getNbpts() {
        return nbpts;
    }

    public String getPeriodevalidation() {
        return periodevalidation;
    }

    public String getDateexpiration() {
        return dateexpiration;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setNbpts(int nbpts) {
        this.nbpts = nbpts;
    }

    public void setPeriodevalidation(String periodevalidation) {
        this.periodevalidation = periodevalidation;
    }

    public void setDateexpiration(String dateexpiration) {
        this.dateexpiration = dateexpiration;
    }
    
    

    
    
}
