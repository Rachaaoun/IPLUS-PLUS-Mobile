/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.restaurant.utils;

import com.codename1.io.Preferences;

/**
 *
 * @author raoun
 */
public class SessionManager {
    
      public static Preferences pref ;
      
        private static int id ; 
    private static String email; 
    private static String nom;
    private static String prenom;
    private static String adresse;
    private static String passowrd ;
    private static String cin;
    private static String photo;
    
    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id",id);
    }
    public static void setId(int id) {
        pref.set("id",id);
    }
    
    public static String getNom() {
        return pref.get("nom",nom);
    }
    public static void setNom(String nom) {
        pref.set("nom",nom);
    }
    
    public static String getPrenom() {
        return pref.get("prenom",prenom);
    }
    public static void setPrenom(String prenom) {
        pref.set("prenom",prenom);
    }
    
    public static String getAdresse() {
        return pref.get("adresse",adresse);
    }
    public static void setAdresse(String adresse) {
        pref.set("adresse",adresse);
    }
    
      public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }

     public static String getPassoword() {
        return pref.get("passowrd",passowrd);
    }

    public static void setPassoword(String passowrd) {
         pref.set("passowrd",passowrd);
    }
     public static String getCin() {
        return pref.get("cin",cin);
    }

    public static void setCin(String cin) {
         pref.set("cin",cin);
    }
    
    public static String getPhoto() {
        return pref.get("photo",photo);
    }

    public static void setPhoto(String photo) {
         pref.set("photo",photo);
    }
}
