/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author raoun
 */
public class TypeReclamation {
    
       private int id ;
    private String niveau;

    public TypeReclamation() {
    }

    public TypeReclamation(String niveau) {
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    
    
}
