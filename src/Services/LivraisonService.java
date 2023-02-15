/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.LivraisonInterface;
import Models.Livraison;
import Models.Panier;
import Utilities.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shily
 */
public class LivraisonService implements LivraisonInterface{
 Connection cnx =MaConnexion.getInstance().getCnx();
 PanierService ps= new PanierService();
    @Override
    public void AjouterLivraison(Livraison p) {
    String req;
        req = "INSERT INTO livraison (`panier`, `adresse`, `statut`, `date_livraison`, `total`) VALUES (?,?,?,?,?)";
        try {
           PreparedStatement ps= cnx.prepareStatement(req);
           ps.setInt(1, p.getPanier().getId_panier());
            ps.setString(2,  p.getAdresse());
            ps.setString(3,  p.getStatut());
            ps.setDate(4, p.getDate_livraison());
            ps.setFloat(5, p.getTotal());
            ps.executeUpdate();
            System.out.println("livraison ajouté avec success via prepared Statement!!!");
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModifierLivraison(Livraison p, int x) {
     try {
            String req ; 
         req = "UPDATE livraison SET adresse = ?, statut = ?, date_livraison =?, total =? , panier= ? WHERE id_livraison ='"+x+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,  p.getAdresse());
            ps.setString(2,  p.getStatut());
            ps.setDate(3, p.getDate_livraison());
            ps.setFloat(4, p.getTotal());
            ps.setInt(5, p.getPanier().getId_panier());
           
        
         
            ps.executeUpdate();
            System.out.println("livraison est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
    }

    @Override
    public void SupprimerLivraison(Livraison p) {
   String req;
        req="DELETE FROM livraison WHERE id_livraiosn="+p.getId_livraison();
        try {
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.executeUpdate(req);
            System.out.println("livraison supprimé avec succes via prepared Statement!!!!");
        }
        catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE,null,ex);
    }
    }

    @Override
    public List<Livraison> RechercherLivraison(int id_Livraison) {
     List<Livraison> livraisons = new ArrayList<>();
        String request;
       request = "SELECT * FROM livraison WHERE id_panier='"+id_Livraison+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Livraison p = new Livraison();
                p.setId_livraison(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_livraison(rs.getDate("date_livraison"));
                p.setAdresse(rs.getString("adresse"));
                p.setPanier(ps.getPanierById(rs.getInt("panier")));
               
                
                //
                livraisons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livraisons;
    }

    @Override
    public List<Livraison> AfficherLivraison() {
    List<Livraison> livraisons = new ArrayList<>();
        String request;
       request = "SELECT * FROM livraison";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Livraison p = new Livraison();
                p.setId_livraison(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_livraison(rs.getDate("date_livraison"));
                p.setAdresse(rs.getString("adresse"));
                 p.setPanier(ps.getPanierById(rs.getInt("panier")));
                //
                livraisons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livraisons;}

    @Override
    public Livraison getLivraisonById(int id_Livraison) {
     String request;
        Livraison p = new Livraison();
       request = "SELECT * FROM livraison WHERE id_livraison='"+id_Livraison+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                
                p.setId_livraison(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_livraison(rs.getDate("date"));
                 p.setAdresse(rs.getString("adresse"));
                 p.setPanier(ps.getPanierById(rs.getInt("panier")));
                
                
                //
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Livraison> TrieLivraison() {
    List<Livraison> livraisons = new ArrayList<>();
        String request;
       request = "SELECT * FROM livraison ORDER BY id_livraison DESC";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Livraison p = new Livraison();
                p.setId_livraison(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_livraison(rs.getDate("date_livraison"));
                p.setAdresse(rs.getString("adresse"));
                 p.setPanier(ps.getPanierById(rs.getInt("panier")));
                //
                livraisons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livraisons;
    }
    
}
