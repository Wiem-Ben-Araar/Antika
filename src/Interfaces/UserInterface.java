/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Models.User;

import java.util.List;

/**
 *
 * @author wiemb
 */
    public interface UserInterface {
    public User afficherUserbyEmail(String email);
            
    public void ajouterUser(User p);
    
    public void ajouterUser2(User p);
    
    public void modifierUser(int id, User p);
    
    public void supprimerUser(int id);
   
    public List<User> RechercherUser(String nom);
    
    public List<User> afficherUser();
    
    public User afficherUserbyID(int id_user);
    
    public List<User> FiltrerParNom(String nom); 
    public boolean userExiste(String email);
}
