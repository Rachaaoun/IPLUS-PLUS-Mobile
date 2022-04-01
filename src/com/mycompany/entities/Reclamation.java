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
public class Reclamation {
    private int id ;
    private String sujetReclamation;
    private String niveau;
    private int userId;
    private TypeReclamation type;

    public Reclamation(String sujetReclamation, String niveau, int userId, TypeReclamation type) {
        this.sujetReclamation = sujetReclamation;
        this.niveau = niveau;
        this.userId = userId;
        this.type = type;
    }

    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public String getSujetReclamation() {
        return sujetReclamation;
    }

    public String getNiveau() {
        return niveau;
    }

    public int getUserId() {
        return userId;
    }

    public TypeReclamation getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSujetReclamation(String sujetReclamation) {
        this.sujetReclamation = sujetReclamation;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setType(TypeReclamation type) {
        this.type = type;
    }
    
    
    
    
    
    
}
