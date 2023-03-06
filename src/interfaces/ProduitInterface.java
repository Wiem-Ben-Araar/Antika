/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Produit;
import java.util.List;

/**
 *
 * @author Dali
 */
public interface ProduitInterface {
    
    //add
    public void addProduit(Produit p); 
    public Produit afficherProduitbyId(int id);
    public void modifierProduit(Produit p , int x);
    public List<Produit> fetchProduit();
    public void supprimerProduit(int x);
    
}