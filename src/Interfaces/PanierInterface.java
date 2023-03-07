/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Panier;
import java.util.List;

/**
 *
 * @author shily
 */
public interface PanierInterface {
    public void ajouter(Panier p);
    public void supprimerP(int id_client);
    public List<Panier> afficher();
    public List<Panier> getPanier(int id_client);
    public List<Panier> chercher(String nomp);
    public void decrementQuantite(Panier panier);
    public void incrementQuantite(Panier panier);
        
}
