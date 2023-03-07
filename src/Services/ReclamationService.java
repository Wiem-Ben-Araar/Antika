/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.ReclamationInterface;
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
import Models.Reclamation;
import Utilities.MaConnexion;

/**
 *
 * @author admin
 */
public class ReclamationService implements ReclamationInterface{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
       public void addReclamation(Reclamation r) {
           Reclamation p = new Reclamation();
String req;
     req = "INSERT INTO `reclamations`(`description`, `email`, `date`,`Id`,`note`) VALUES (?,?,?,?,?)";
     try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, r.getDescription());
            ps.setString(2, r.getEmail());
            ps.setDate(3, r.getDate());
            ps.setInt(4, r.getId());
            ps.setInt(5, r.getNote());

       // if (!rs.next()) {
            // Si le résultat est vide, le produit n'existe pas, afficher une erreur
         //   System.err.println("Le produit correspondant à Id n'existe pas.");
           // return;
       // }

            ps.executeUpdate();
            System.out.println("Reclamation ajouté avec success !");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }      }
       
  
    
    @Override
     public void modifierReclamation(Reclamation l, int x) {
try {
            String req ; 
            req = "UPDATE `reclamations` SET `description`=?,`email`=?,`date`=?,`Id`=?, `note`=? WHERE id_reclamation='"+x+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
           // ps.setInt(1, l.getId_Reclamation());
            ps.setString(1, l.getDescription());
            ps.setString(2, l.getEmail());
            ps.setDate(3, l.getDate());
            ps.setInt(4, l.getId());
            ps.setInt(5, l.getNote());

         
            ps.executeUpdate();
            System.out.println("Reclamation est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
            }

    @Override
               public List<Reclamation> recherche(String desc) {
 List<Reclamation> Reclamations = new ArrayList<>();
        String request;
       request = "SELECT * FROM reclamations WHERE description='"+desc+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Reclamation l = new Reclamation();
                l.setId_Reclamation(rs.getInt(1));
                l.setDescription(rs.getString("description"));
                l.setEmail(rs.getString("email"));
                l.setDate(rs.getDate("date"));
                l.setNote(rs.getInt("note"));
                //
                Reclamations.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reclamations;
        }
               
               
    @Override
    public List<Reclamation> fetchReclamation() {
        List<Reclamation> Reclamation = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM reclamations";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reclamation r = new Reclamation();
              Produit p = new Produit();

                r.setId_Reclamation(rs.getInt(1));
                r.setDescription(rs.getString("description"));
                r.setEmail(rs.getString("email"));
                r.setDate(rs.getDate("date"));
                r.setId(rs.getInt("Id"));
                r.setNote(rs.getInt("note"));

                 
              // r.setProduit(p);
                
                Reclamation.add(r);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Reclamation;
    }

    public void supprimerReclamation(int id_Reclamation) {
         Reclamation p = new Reclamation();
        String request = "DELETE FROM reclamations WHERE Id = '"+id_Reclamation+"'";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("deleted");

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    
    
    public List<Reclamation> afficherReclamation() {
        List<Reclamation> Reclamations = new ArrayList<>();
        String request = "SELECT * FROM reclamations";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                
                Reclamation p = new Reclamation();
                p.setId_Reclamation(rs.getInt(1));
                p.setDescription(rs.getString("Description"));
                p.setEmail(rs.getString("Email"));
                p.setDate(rs.getDate("Date"));
                
                //
                Reclamations.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reclamations;
    }

    /**
     *
     * @param Id
     * @return
     */
    @Override
    public List<Reclamation> afficherReclamationbyId(int Id) {
                List<Reclamation> Reclamation = new ArrayList<>();
        String req = "SELECT * FROM reclamations WHERE `Id` ="+Id+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reclamation r = new Reclamation();
                r.setId_Reclamation(rs.getInt(1));
                r.setDescription(rs.getString("description"));
                r.setEmail(rs.getString("email"));
                r.setDate(rs.getDate("date"));
                r.setNote(rs.getInt("note"));
                Reclamation.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reclamation;
    }

}