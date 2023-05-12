/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.AvisInterface;
import Models.Avis;
import Models.User;
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

/**
 *
 * @author wiemb
 */
public class AvisService implements AvisInterface{
Connection cnx = MaConnexion.getInstance().getCnx();
    @Override
    public void ajouterAvis(Avis avis) {
        String req = "INSERT INTO `avis`(`commentaire`,`note`) VALUES ('"+avis.getCommentaire()+"','"+avis.getNote()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Avis ajouté avec success!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      @Override
    public void modifierAvis(int id_avis,Avis avis) {
           try{
             String req ="UPDATE `avis` SET `commentaire`=?,`note`=? WHERE id_avis='"+id_avis+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, avis.getCommentaire());
            ps.setInt(2, avis.getNote());



            ps.executeUpdate();
            System.out.println("Avis est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

    };

    @Override
    public void supprimerAvis(int id) {
       Avis avis = new Avis();
        String request = "DELETE FROM `avis` WHERE `id` ="+id+";";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
             System.out.println("Avis est supprimé");

        } catch (SQLException ex) {
              Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<Avis> afficherAvis() {
        List<Avis> aviss = new ArrayList<>();
        String request = "SELECT * FROM avis";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Avis avis = new Avis();
             avis.setId_avis(rs.getInt(1));
                avis.setCommentaire(rs.getString("Commentaire"));
                avis.setNote(rs.getInt("Note"));



                aviss.add(avis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aviss;
    }

    @Override
    public Avis afficherAvisbyID(int id_avis) {
         Avis avis = new Avis();
        String request = "SELECT * FROM avis WHERE `id_avis` ="+id_avis+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                avis.setId_avis(rs.getInt(1));
                avis.setCommentaire(rs.getString("Commentaire"));
                avis.setNote(rs.getInt("Note"));


            }
        } catch (SQLException ex) {
          Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avis;
    }

    @Override
    public List<Avis> FiltrerParId_avis(int id_avis) {
         List<Avis> avis = new ArrayList<>();
        String request = "SELECT * FROM Avis WHERE id_avis = '"+id_avis+"';";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Avis a1 = new Avis();
                a1.setId_avis(rs.getInt(1));
                a1.setCommentaire(rs.getString("commentaire"));
                a1.setNote(rs.getInt("note"));



                //
                avis.add(a1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avis;

    }

    @Override
    public List<Avis> RechercherAvis(int id) {
        
    List<Avis> aviss = new ArrayList<>();
        String request = "SELECT * FROM avis WHERE id_avis='"+id+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                Avis a = new Avis();
                a.setId_avis(rs.getInt(1));
                a.setCommentaire(rs.getString("Commentaire"));
                a.setNote(rs.getInt("Note"));
                
              
                //
                aviss.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aviss;
    }


}
   
    

