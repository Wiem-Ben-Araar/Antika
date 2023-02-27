/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande;

import Models.User;
import Models.Panier;
import Models.Livraison;
import Models.Produit;
import Services.LivraisonService;
import Services.PanierService;
import Services.ProduitService;
import Services.UserService;
import Utilities.MyConnection;
import java.sql.Date;
import java.sql.SQLException;



/**
 *
 * @author shily
 */
public class Commande {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        PanierService panierService = new PanierService();
        ProduitService produitService = new ProduitService();
        UserService userService= new UserService();
        LivraisonService livraisonService = new LivraisonService();
        
        User user = userService.getUser(1);
        Produit produit = produitService.getProduit(1);
        
        Panier panier = new Panier(5, user, produit);
        panierService.ajouter(panier);
        //Panier panier1 = panierService.getPanierUserProduit(1, 1);
        //panierService.incrementQuantite(panier1);
        System.out.println(panierService.afficher());
        //panierService.supprimerP(17);
        //Date date = new Date(11,11,11);
       // Livraison livraison = new Livraison("mourouj", "en cours", user, date);
        // livraisonService.AjouterLivraison(livraison);
        
        //livraison.setAdresse("esprit");
        //livraison.setId_livraison(9);
        //livraisonService.ModifierLivraison(livraison, livraison.getId_livraison());
        
       // System.out.println(livraisonService.AfficherLivraison());
    }
    
}
