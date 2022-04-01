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
public class User {
    private int id ;
    private String nom;
    private String prenom;
    private String password;
    private String cin;
    private String photo;
    private String email;
    private boolean isverified=true;
    
     public User() {
    }

    public User(String nom, String prenom, String password, String email, String cin,String photo ) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.cin = cin;
        this.photo = photo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
     public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
     public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
     public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean getIsverified() {
        return this.isverified;
    }

    public void setIsVerfied(boolean verified) {
        this.isverified = verified;
    }
    
    
    
    
}
