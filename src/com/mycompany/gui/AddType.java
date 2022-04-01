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
import com.mycompany.entities.TypeReclamation;
import com.mycompany.services.TypeReclamationService;

/**
 *
 * @author Lenovo
 */
public class AddType extends BaseForm {
    
    Form current;
    public AddType(Resources res ) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout ");
        getContentPane().setScrollVisible(false);
        
        
//        super.addSideMenu(res);
        
        TextField niveau = new TextField("", "type : " , 20 , TextField.ANY);
        
        
        
        
        
        niveau.setUIID("NewsTopLine");
        
        //dateexpiration.setUIID("NewsTopLine");
        
        niveau.setSingleLineTextArea(true);
        
        // dateexpiration.setSingleLineTextArea(true);
        
        Button btnAjouter = new Button("Ajouter");
       btnAjouter.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnAjouter.addPointerPressedListener(l ->   { 
           TypeReclamation r = new TypeReclamation();
           r.setNiveau(niveau.getText());
     //  r.setDateexpiration(r.getDateexpiration());
      
       
       //appel fonction modfier reclamation men service
       
       if(TypeReclamationService.getInstance().addType(r)) { // if true
           new ListType(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListType(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
       
      
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(niveau),
                createLineSeparator(),
                
                createLineSeparator(),//ligne de séparation
                
                btnAjouter,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}