/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Livraison;
import java.util.List;

/**
 *
 * @author shily
 */
public interface LivraisonInterface {
    public void AjouterLivraison (Livraison p);
    
    public void ModifierLivraison(Livraison p,int x);
    
    public void SupprimerLivraison(Livraison p );
    
    public List<Livraison> GetLivraison(int id_user);
    
    public List<Livraison> RechercherLivraison(String adresse);
    
    public List<Livraison> AfficherLivraison();
    
    public Livraison getLivraisonById(int id_Livraison);
}
