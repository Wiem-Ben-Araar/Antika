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
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author wiemb
 */
public class Antika {
 public static void main(String[] args) {
      
     
        UserService ps = new UserService();
        AvisService a = new AvisService();
     
         Avis as1 = new Avis("Bonne_idée",30);
         Avis as5 = new Avis("Bonne_idée",50);
      
         Avis as2 = new Avis("Bravo",20);
         as1.setId_avis(19);
         as2.setId_avis(20);
    // a.ajouterAvis(as2);
    // a.ajouterAvis(as1);
        User p1 = new User("dali", "Belhaj", "dali@esprit.tn", "56789457","Manzah",Type.CLIENT,"dali",as1);  
        User p2 = new User("Wided", "Ben Araar", "wiem.benaraar@esprit.tn", "90180310","La Sokra",Type.ADMINISTRATEUR,"doudouu",as2);
       

    ps.ajouterUser(p1); 
     ps.ajouterUser(p2); 
    // ps.modifierUser(28,p2);
    // ps.FiltrerParNom("wided").forEach(System.out::println);
    // ps.supprimerUser(10);
     // ps.afficherUser().forEach(System.out::println); 
     //System.out.println(ps.afficherUserbyID(1));
     //ps.afficherUserbyID(1); 
     // ps.RechercherUser("dali").forEach(System.out::println); 
     
     
     //a.supprimerAvis(17);
       
     //a.modifierAvis(16, as1); 
         
    // a.afficherAvis().forEach(System.out::println); 
       
   //  a.FiltrerParId_avis(16).forEach(System.out::println); 
     
   // a.RechercherAvis(16).forEach(System.out::println); 
       
   //System.out.println(a.afficherAvisbyID(2));
   // a.afficherAvisbyID(2);
       
    
      
 
      
    }
}
 
 
 


