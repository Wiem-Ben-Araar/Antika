/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Produit;
import Utilities.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shily
 */
public class ProduitService {
     Connection cnx=MyConnection.getInstance().getConnection();
    PreparedStatement ste ;
    public Produit getProduit(int id) {
       Produit produit =new Produit();
        try {
            Statement st=cnx.createStatement();
            String req="SELECT * FROM `produit` where id_produit ="+id;
            ResultSet resultat=st.executeQuery(req);
          while(resultat.next()){
                produit = new Produit(resultat.getInt(1),resultat.getDouble(2),resultat.getString(3));
          }
          
       }  
        catch(SQLException ex ){
 System.out.println("non");       }
        return produit;
    }
    public List<Produit> getAllProduit() {
       Produit produit =new Produit();
       List<Produit> produits = new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String req="SELECT * FROM `produit` ";
            ResultSet resultat=st.executeQuery(req);
          while(resultat.next()){
                produit = new Produit(resultat.getInt(1),resultat.getDouble(2),resultat.getString(3));
                produits.add(produit);
          }
          
       }  
        catch(SQLException ex ){
 System.out.println("non");       }
        return produits;
    }
}
