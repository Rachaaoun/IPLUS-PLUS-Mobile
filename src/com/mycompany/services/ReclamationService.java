/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.esprit.restaurant.utils.SessionManager;
import com.mycompany.entities.Cartefidelite;
import com.mycompany.entities.Reclamation;
import com.mycompany.entities.TypeReclamation;
import com.mycompany.entities.User;
import com.mycompany.gui.ProfileForm;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author raoun
 */
public class ReclamationService {
        
    public ArrayList<Reclamation> reclamations;
    public static ReclamationService instance = null;
    private ConnectionRequest req;
     Resources res;
     
      public static boolean resultOk = true;
     
    public static ReclamationService getInstance() {
        if (instance == null) {
            instance = new ReclamationService();
        }
        return instance;

    }

    public ReclamationService() {
        req = new ConnectionRequest();
    }
    
        public ArrayList<Reclamation> parseTasks(String jsonText){
        try {
            reclamations=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
     
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return reclamations;
    }
    
    
    public ArrayList<Reclamation> getAll(){
        String url = Statics.BASE_URL+"/reclamation/reclamation/list";
       
        
       ArrayList<Reclamation> result = new ArrayList<>();
        
        
        req.setUrl(url);
        req.setPost(false);
        
        
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {

                    Map<String, Object> mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapReclamations.get("reclamation");
                   System.out.println("lissst"+mapReclamations);
                    for(Map<String, Object> obj : listOfMaps) {
                        Reclamation re = new Reclamation();

                        String sujet = obj.get("sujetRec").toString();
                        //String niveau =obj.get("niveau").toString();
                            
                             // float nbpts = Float.parseFloat(obj.get("nbpts").toString());
                              float id = Float.parseFloat(obj.get("id").toString());
                     re.setId((int)id);
                     re.setSujetReclamation(sujet);
                    // re.setNiveau(niveau);
                   
                    
                     result.add(re);
                System.out.println("data "+obj.get("sujet").toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
             }

        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        
        return result;
    }
    
   public boolean deleteReclamation(int id ) {
        String url = Statics.BASE_URL +"/reclamation/reclamation/delete?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
   
    public boolean modifierReclamation(Reclamation r) {
        String url = Statics.BASE_URL +"/reclamation/modifier/reclamation/"+r.getId()+"?sujet="+r.getSujetReclamation()+"&niveau="+r.getNiveau();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    
     
        public void activate(Cartefidelite c){
        
           String url = Statics.BASE_URL +"/cartefidelite/activate/carte?id="+c.getId();
        
        req.setUrl(url);
        
         req.addResponseListener( (e) -> {
                  JSONParser j = new JSONParser(); 
                String json= new String (req.getResponseData()); 
                         if (new String(req.getResponseData()).equals(new String('"'+"false"+'"')) )   {
                             System.out.println("Carte ne peut pas etre  activé");
                             Dialog.show("Period of activation is not terminated", "Date expiration encore valable", null);
                             
                             }
                      
                      else 
                             
                         {
                              System.out.println("Carte activé");
                             Dialog.show("periode renouvellé", "Date expiration a été renouvellé par +3ans", null);
                     
                     }
                 });
         
   
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
        
          public boolean addReclamation(int u,Reclamation c)  {
        String url = Statics.BASE_URL + "/reclamation/AddReclamation/json?idType=" + u+ "&sujet=" + c.getSujetReclamation()+"&niveau="+c.getNiveau() ;
         
      req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
   
    }
    
}
