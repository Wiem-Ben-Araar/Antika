/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Avis;

import java.util.List;

/**
 *
 * @author wiemb
 */
public interface AvisInterface {
     
  //CRUD
    //1:Create
    public void ajouterAvis(Avis avis);
    

    //2: Read
    public void modifierAvis(int id_avis,Avis avis);
    //3:Update
    public void supprimerAvis(int id_avis);
    //4:Delete
    public List<Avis> afficherAvis();
    public Avis afficherAvisbyID(int id_avis);
    
    public List<Avis> FiltrerParId_avis(int id_avis); 
  
}
