/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.PanierInterface;
import Models.Panier;
import Utilities.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;


/**
 *
 * @author shily
 */
public class PanierService implements PanierInterface{
    Connection cnx =MaConnexion.getInstance().getCnx();

    @Override
    public void AjouterPanier(Panier p) {
        String req;
        req = "INSERT INTO panier (`total`, statut,`date_creation`,`code_promo`) VALUES (?,?,?,?)";
        try {
           PreparedStatement ps= cnx.prepareStatement(req);
            ps.setFloat(1, p.getTotal());
            ps.setString(2,  p.getStatut());
            ps.setDate(3, p.getDate_creation());
            ps.setInt(4, p.getCode_promo());
            ps.executeUpdate();
            System.out.println("panier ajouté avec success via prepared Statement!!!");
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public void SupprimerPanier(Panier p) {
        String req;
        req="DELETE FROM panier WHERE id_panier=1";
        try {
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.executeUpdate(req);
            System.out.println("panier supprimé avec succes via prepared Statement!!!!");
        }
        catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE,null,ex);
    }
    }

   
    

    @Override
    public List<Panier> AfficherPanier() {
              List<Panier> paniers = new ArrayList<>();
        String request = "SELECT * FROM panier";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Panier p = new Panier();
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_creation(rs.getDate("date_creation"));
                p.setCode_promo(rs.getInt("code_promo"));
                
           
                
                //
                paniers.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paniers;

    }

   

  
    @Override
    public void ModifierPanier(Panier p, int x) {
        try {
            String req ; 
         req = "UPDATE panier SET `id_panier`=?,`total`=?,`statut`=?,`date_creation`=?,`code_promo`=? WHERE id_panier='"+x+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getId_panier());
            ps.setFloat(2, p.getTotal());
            ps.setString(3, p.getStatut());
            ps.setDate(4, (Date) p.getDate_creation());
            ps.setInt(5, p.getCode_promo());
           
        
         
            ps.executeUpdate();
            System.out.println("panier est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
    }

    @Override
    public List<Panier> RechercherPanier(int id_panier) {
        List<Panier> paniers = new ArrayList<>();
        String request;
       request = "SELECT * FROM panier WHERE id_panier='"+id_panier+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Panier p = new Panier();
                p.setId_panier(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_creation (rs.getDate("date_creation"));
                p.setCode_promo(rs.getInt("code_promo"));
                
               
                
                //
                paniers.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paniers;
    }

    @Override
    public Panier getPanierById(int id_panier) {
        String request;
        Panier p = new Panier();
       request = "SELECT * FROM panier WHERE id_panier='"+id_panier+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                
                p.setId_panier(rs.getInt(1));
                p.setTotal(rs.getInt("total"));
                 p.setStatut(rs.getString("statut"));
                p.setDate_creation(rs.getDate("date"));
                p.setCode_promo(rs.getInt("code_promo"));
           
                
                
                //
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Panier> TriePanier() {
        List<Panier> paniers = new ArrayList<>();
        String request;
       request = "SELECT * FROM panier ORDER BY id_panier DESC";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Panier p = new Panier();
                p.setId_panier(rs.getInt(1));
                p.setTotal(rs.getInt("name"));
                 p.setStatut(rs.getString("name"));
                p.setDate_creation(rs.getDate("date"));
                p.setCode_promo(rs.getInt("code_promo"));
               
             
                
                //
                paniers.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paniers;
    }
    
    

   
    
    
    
    
}