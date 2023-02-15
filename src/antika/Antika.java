/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antika;

import Interfaces.UserInterface;
import Models.Avis;
import Models.User;
import Services.AvisService;
import Services.UserService;
import Utilities.Type;
import java.sql.Date;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author wiemb
 */
public class Antika {
 public static void main(String[] args) {
      
     /*
        UserService ps = new UserService();
        User p = new User("Wiem2", "Ben Araar", "wiem.benaraar@esprit.tn", "90180310","La Sokra",Type.ADMINISTRATEUR);
        User p1 = new User("Wided", "Ben Araar", "wiem.benaraar@esprit.tn", "90180310","La Sokra",Type.ADMINISTRATEUR);
       
       ps.ajouterUser(p1);
        ps.supprimerUser(6);
       
   ps.modifierUser(5,p);
 ps.afficherUser().forEach(System.out::println);
  System.out.println("::::::::::");
                ps.FiltrerParNom("wiem2").forEach(System.out::println);
                
          System.out.println("::::::::::");       
            // ps.afficherUserbyID(3).forEach(System.out::println);
            System.out.println("::::::::::Avis::::::::::::::");   
            */
            
          AvisService a = new AvisService();
      Avis as = new Avis("magnifique",5);
      
      //  
        Avis as2=new Avis("bonne",4);
      //  a.ajouterAvis(as2);
       // a.supprimerAvis(2);
       
       //  a.modifierAvis(3, as2);
         
       //a.afficherAvis().forEach(System.out::println);
       
       UserService ps = new UserService();
         a.FiltrerParId_avis(5).forEach(System.out::println);
         ps.FiltrerParNom("wiem2").forEach(System.out::println);
      
    }
}
 
 
 


