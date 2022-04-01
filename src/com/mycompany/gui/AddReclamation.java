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
import com.mycompany.entities.Reclamation;
import com.mycompany.entities.TypeReclamation;
import com.mycompany.services.ReclamationService;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lenovo
 */
public class AddReclamation extends BaseForm {
    
    Form current;
    public AddReclamation(Resources res ,TypeReclamation p) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
//        super.addSideMenu(res);
        
        TextField sujet = new TextField("", " Votre Reclamation" , 60 , TextField.ANY);
       TextField niveau = new TextField("", " Niveau" , 60 , TextField.ANY);
             //  TextField dateexpiration =new TextField(String.valueOf(r.getDateexpiration()), "Date expiration " , 20 , TextField.ANY);
 
        
        
        
        
        sujet.setUIID("NewsTopLine");
        
        
        sujet.setSingleLineTextArea(true);  niveau.setUIID("NewsTopLine");
        
        
        niveau.setSingleLineTextArea(true);
       
       
        // dateexpiration.setSingleLineTextArea(true);
        
        Button btnAjouter = new Button("Ajouter");
       btnAjouter.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnAjouter.addPointerPressedListener(l ->   { 
           Reclamation r = new Reclamation();
           r.setSujetReclamation(sujet.getText());
           r.setType(p);
           r.setNiveau(niveau.getText());
           sendMail(res,p);
          
     //  r.setDateexpiration(r.getDateexpiration());
      
       
       //appel fonction modfier reclamation men service
       
       if(ReclamationService.getInstance().addReclamation(p.getId(), r)) { // if true
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
                new FloatingHint(sujet),
                createLineSeparator(),
                 new FloatingHint(niveau),
                createLineSeparator(),
               
                
                btnAjouter,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
    
    
    
        
  public void sendMail(Resources res,TypeReclamation p) {
        try {
            
            Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication
             
            Session session = Session.getInstance(props,null); // aleh 9rahach 5ater mazlna masabinach javax.mail .jar
            
            
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress("Une Reclamation a été ajouté <monEmail@domaine.com>"));
            msg.setRecipients(Message.RecipientType.TO, "racha.aoun@hotmail.com");
            msg.setSubject("Reclamation ajouté ");
            msg.setSentDate(new Date(System.currentTimeMillis()));
            
           //String mp = ServiceUtilisateur.getInstance().getPasswordByEmail(email.getText().toString(), res);//mp taw narj3lo
           String txt = "Une nouvelle reclamation a été ajouté ";
           
           
           msg.setText(txt);
           
          SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;
            
          st.connect("smtp.gmail.com",465,"racha.aoun@esprit.tn","14355402");
           
          st.sendMessage(msg, msg.getAllRecipients());
            
          System.out.println("server response : "+st.getLastServerResponse());
          
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
}