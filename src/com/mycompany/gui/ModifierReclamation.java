/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Cartefidelite;
import com.mycompany.entities.Reclamation;
import com.mycompany.entities.User;
import com.mycompany.services.ReclamationService;

/**
 *
 * @author Lenovo
 */
public class ModifierReclamation extends BaseForm {
    
    Form current;
    public ModifierReclamation(Resources res , Reclamation r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("edit ");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField sujet = new TextField(r.getSujetReclamation(), "Sujet" , 20 , TextField.ANY);
        TextField niveau = new TextField(String.valueOf(r.getNiveau()), "Niveau" , 20 , TextField.NUMERIC);
            
             //  TextField dateexpiration =new TextField(String.valueOf(r.getDateexpiration()), "Date expiration " , 20 , TextField.ANY);
 
        
        
        
        
        sujet.setUIID("NewsTopLine");
        niveau.setUIID("NewsTopLine");
        //dateexpiration.setUIID("NewsTopLine");
        
        sujet.setSingleLineTextArea(true);
        niveau.setSingleLineTextArea(true);
        // dateexpiration.setSingleLineTextArea(true);
        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           r.setSujetReclamation(sujet.getText());
           r.setNiveau(niveau.getText());
     //  r.setDateexpiration(r.getDateexpiration());
      
       
       //appel fonction modfier reclamation men service
       
       if(ReclamationService.getInstance().modifierReclamation(r)) { // if true
           new ListReclamation(res,r.getType()).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListReclamation(res,r.getType()).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
         Button lactiver = new Button("Activer");
        
                lactiver.requestFocus();
        lactiver.addActionListener(e ->{
            //CarteService.getInstance().activate(r);
            
        } );
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(sujet),
                createLineSeparator(),
                new FloatingHint(niveau),
                createLineSeparator(),
               
                
                createLineSeparator(),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}