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
  
    public void ajouterAvis(Avis avis);
    
    public void modifierAvis(int id_avis,Avis avis);
  
    public void supprimerAvis(int id);
   
    public List<Avis> afficherAvis();
    
    public List<Avis> RechercherAvis(int id);
    
    public Avis afficherAvisbyID(int id_avis);
    
    public List<Avis> FiltrerParId_avis(int id_avis); 
  
}
