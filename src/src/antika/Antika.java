/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antika;

import Models.*;
import Services.EnchereService;
import Services.EvenementService;
import Services.UserService;
import Utilities.Type;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author wiemb
 */
public class Antika {
    public static void main(String[] args) {
        
        //add event
          Evenement event = new Evenement();
      EvenementService serviceEvenement = new EvenementService();
      event.setNom("Liber-toi");
      event.setLieu("club G");
      event.setEvenement_date(java.sql.Date.valueOf(LocalDate.now()));
      event.setCapacite(500);
      event.setDescription("By Libertad");
      
      //serviceEvenement.createEvenement(event);
      //serviceEvenement.deleteEvenement(event,7);
        //serviceEvenement.getEvenements(event);
        
        //serviceEvenement.updateEvenement(event);
        //add user
        User user = new User();
        UserService userService = new UserService();
        user.setNom("nada");
        user.setPrenom("bkh");
        user.setEmail("nada@gmail.com");
        user.setMot_de_passe("12345678");
        user.setType(Type.ARTISTE);
        //userService.ajouterUser(user);
        
       
        
        
        Produit produit = new Produit();
        
        Enchere enchere = new Enchere();
        EnchereService enchereService = new EnchereService();
        enchere.setPrix_initale(3000);
        enchere.setDate_fermeture(Timestamp.valueOf(LocalDateTime.now()));
        enchere.setCreateur(user);
        enchere.setProduit(produit);
            
        //enchereService.createEnchere(enchere);
        
       
      
    }
}
 
 
 


