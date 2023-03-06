/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.ProduitInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Produit;
import Models.User;
import Utilities.MaConnexion;

/**
 *
 * @author admin
 */
public class ProduitService implements ProduitInterface{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    public static Produit currentProduit;

    @Override
      public void addProduit(Produit p) {
String req;
     req = "INSERT INTO `produits`(`nom`, `genre`, `prix`) VALUES (?,?,?)";
     try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getGenre());
            ps.setFloat(3, p.getPrix());
        

            ps.executeUpdate();
            System.out.println("Produit ajouté avec success !");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }      }

    
    @Override
    public List<Produit> fetchProduit() {
        List<Produit> produit = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setGenre(rs.getString("genre"));
                p.setPrix(rs.getFloat("prix"));
               
                
                produit.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return produit;
    }

    public void modifierProduit(int id, String nom) {
       try{
             String req ="UPDATE `Produits` SET `Nom`= ? WHERE Id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, nom);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }

    };

    public void supprimerProduit(int id) {
         Produit p = new Produit();
        String request = "DELETE FROM `produits` WHERE `Id` ="+id+";";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);

        } catch (SQLException ex) {
            Logger.getLogger(afficherProduitbyId.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    public List<Produit> afficherProduit() {
        List<Produit> Produits = new ArrayList<>();
        String request = "SELECT * FROM produits";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Produit p = new Produit();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("Nom"));
      
                p.setGenre(rs.getString("Genre"));
                p.setPrix(rs.getFloat(1));
                
                //
                Produits.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Produits;
    }


    @Override
    public Produit afficherProduitbyId(int Id) {
        Produit p = new Produit();
        String request = "SELECT * FROM produits WHERE `Id` ="+Id+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("Nom"));
                p.setGenre(rs.getString("Genre"));
                p.setPrix(rs.getFloat("real"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(afficherProduitbyId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
