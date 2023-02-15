/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.ReclamationInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Reclamation;
import util.MyConnection;

/**
 *
 * @author admin
 */
public class ReclamationService implements ReclamationInterface{
    //var
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
       public void addReclamation(Reclamation p) {
String req;
     req = "INSERT INTO `reclamations`(`description`, `email`, `date`) VALUES (?,?,?)";
     try {
            PreparedStatement ps = cnx.prepareStatement(req);
           ps.setString(1, p.getDescription());
            ps.setString(2, p.getEmail());
            ps.setDate(3, p.getDate());
        

            ps.executeUpdate();
            System.out.println("Reclamation ajouté avec success !");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }      }


    @Override
    public List<Reclamation> fetchReclamation() {
        List<Reclamation> Reclamation = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM reclamations";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reclamation r = new Reclamation();
                r.setId_Reclamation(rs.getInt(1));
                r.setDescription(rs.getString("Description"));
                r.setEmail(rs.getString("Email"));
                r.setDate(rs.getDate("Date"));
                
                Reclamation.add(r);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Reclamation;
    }

    public void supprimerReclamation(int Id_Reclamation) {
         Reclamation p = new Reclamation();
        String request = "DELETE FROM reclamations WHERE id_reclamation = '"+Id_Reclamation+"'";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);

        } catch (SQLException ex) {
            Logger.getLogger(afficherReclamationbyId.class.getName()).log(Level.SEVERE, null, ex);
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
     * @param Id_Description
     * @return
     */
    @Override
    public Reclamation afficherReclamationbyId(int Id_Description) {
        Reclamation p = new Reclamation();
        String request = "SELECT * FROM reclamations WHERE `id_reclamation` ="+Id_Description+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId_Reclamation(rs.getInt(1));
                p.setDescription(rs.getString("Description"));
                p.setEmail(rs.getString("Email"));
                p.setDate(rs.getDate("date"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(afficherReclamationbyId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}