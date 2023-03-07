/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.ProduitInterface;
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
import Utilities.MaConnexion;

/**
 *
 * @author admin
 */
public class ProduitService implements ProduitInterface{
    //var
    private Statement ste;
    Connection cnx = MaConnexion.getInstance().getCnx();
    public static Produit currentProduit;
    @Override
      public void addProduit(Produit p) {
String req;
     req = "INSERT INTO `produits`(`nom`, `genre`, `prix`, `img`) VALUES (?,?,?,?)";
     try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getGenre());
            ps.setFloat(3, p.getPrix());
            ps.setBytes(4, p.getImg());
            ps.executeUpdate();
            System.out.println("Produit ajouté avec success !");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }

      
    
    @Override
    public List<Produit> fetchProduit() {
        List<Produit> produits = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produit p = new Produit();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("nom"));
                p.setGenre(rs.getString("genre"));
                p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getBytes("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;
    }
    
    

    @Override
      public void modifierProduit(Produit l, int x) {
try {
            String req ; 
            req = "UPDATE `produits` SET  `nom`=?,`genre`=?,`prix`=?, `img`=? WHERE Id='"+x+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
           // ps.setInt(1, l.getId());
            ps.setString(1, l.getNom());
            ps.setString(2, l.getGenre());
            ps.setFloat(3, l.getPrix());
            ps.setBytes(4, l.getImg());
            

            ps.executeUpdate();
            System.out.println("Produit est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
}

      
          public List<Produit> recherche(String nom) {
 List<Produit> produits = new ArrayList<>();
        String request;
       request = "SELECT * FROM produits WHERE nom='"+nom+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Produit l = new Produit();
                l.setId(rs.getInt(1));
                l.setNom(rs.getString("nom"));
                l.setGenre(rs.getString("genre"));
                l.setPrix(rs.getFloat("prix"));
                l.setImg(rs.getBytes("img"));
                //
                produits.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
        }
          
          

    @Override
    public void supprimerProduit(int x) {
      String req = "DELETE FROM `produits` WHERE Id='"+x+"'";
         try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("produit est supprimee");
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
    }
    
    
    
    public List<Produit> afficherProduit() {
        List<Produit> Produit = new ArrayList<>();
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
                Produit.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Produit;
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
                p.setNom(rs.getString("nom"));
                p.setGenre(rs.getString("genre"));
                p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getBytes("img"));
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public int nmbrProduitPanier(int x) {
        int nbr=0;
        List<Produit> produits = new ArrayList<>();
        try {
            
            String req = "SELECT p.quantite FROM `produits` pr INNER JOIN `panier` p ON pr.Id=p.id_produit WHERE pr.Id="+x;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                nbr=nbr+rs.getInt("quantite");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nbr;
    }
    
}
