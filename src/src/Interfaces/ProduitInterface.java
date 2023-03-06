/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import Models.Produit;
import java.util.List;

/**
 *
 * @author Dali
 */
public interface ProduitInterface {
    
    //add
    public void addProduit(Produit p); 
    public Produit afficherProduitbyId(int id);
    //list : select
    public List<Produit> fetchProduit();
    
}