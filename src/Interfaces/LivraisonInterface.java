/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Livraison;
import java.util.List;

/**
 *
 * @author shily
 */
public interface LivraisonInterface {
     public void AjouterLivraison(Livraison p);

    public void ModifierLivraison(Livraison p,int x);

    public void SupprimerLivraison(Livraison p);

    public List<Livraison> RechercherLivraison(int id_Livraison);

    public List<Livraison> AfficherLivraison();

    public Livraison getLivraisonById(int id_Livraison);

    public List<Livraison>  TrieLivraison();
}
