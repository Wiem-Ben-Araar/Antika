/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.User;
import Utilities.Type;
import java.util.List;

/**
 *
 * @author wiemb
 */
    public interface UserInterface {
    //CRUD
    //1:Create
    public void ajouterUser(User p);
    
//1.1:Create methode2
    public void ajouterUser2(User p);
    //2: Read
    public void modifierUser(int id, User p);
    //3:Update
    public void supprimerUser(int id);
    //4:Delete
    public List<User> afficherUser();
    public User afficherUserbyID(int id);
    
    public List<User> FiltrerParNom(String nom); 
}
