/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.UserInterface;
import Models.User;
import Utilities.MaConnexion;
import Utilities.Type;
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
public class UserService implements UserInterface {
    Connection cnx = MaConnexion.getInstance().getCnx();

    public static User currentUser;

    public void login(User user) {
        currentUser = user;

    }
    
    @Override
    public void ajouterUser(User p) {
       String req = "INSERT INTO `user`(`nom`, `prenom`, `email` ,`telephone`,`adresse`,`type`, `mot_de_passe`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getEmail()+"','"+p.getTelephone()+"','"+p.getAdresse()+"','"+p.getType()+"','"+p.getMot_de_passe()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User ajouté avec success!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterUser2(User p) {
      String req = "INSERT INTO `user`(`nom`, `prenom`, `email` ,`telephone`,`adresse`,`type`,`mot_de_passe`) VALUES (?,?,?,?,?,?,?,?)";
      
    try {
            PreparedStatement ps = cnx.prepareStatement(req);
   //ps.setInt(1, p.getID_User(1));
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelephone());
            ps.setString(5, p.getAdresse());
            ps.setString(6, p.getType().toString());
            ps.setString(7, p.getMot_de_passe());
            
            ps.executeUpdate();
            System.out.println("Personne ajouté avec success via prepared Statement!!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifierUser(int id, User p) {
       try{
             String req ="UPDATE `user` SET `nom`=?,`prenom`=?,`email`=?,`telephone`=?,`adresse`=?,`type`=?,`mot_de_passe`=? WHERE id_user='"+id+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelephone());
            ps.setString(5, p.getAdresse());
            ps.setString(6, p.getType().toString());
            ps.setString(7, p.getMot_de_passe());
         
            ps.executeUpdate();
            System.out.println("Utlisateur est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

    };

    @Override
    public void supprimerUser(int id) {
         User p = new User();
        String request = "DELETE FROM `user` WHERE `ID_User` ="+id+";";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);

        } catch (SQLException ex) {
              Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    @Override
    public List<User> afficherUser() {
        List<User> personnes = new ArrayList<>();
        String request = "SELECT * FROM user";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                User p = new User();
             p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
      
                p.setEmail(rs.getString("Email"));
                
                
                p.setTelephone(rs.getString("Telephone"));
                 p.setAdresse(rs.getString("Adresse"));
                 p.setType(Type.valueOf(rs.getString("Type")));
                 p.setMot_de_passe(rs.getString("Mot_de_passe"));
                
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }


    @Override
    public User afficherUserbyID(int id) {
        User p = new User();
        String request = "SELECT * FROM user WHERE `ID_User` ="+id+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
                p.setEmail(rs.getString("Email"));
                p.setTelephone(rs.getString("Telephone"));
                p.setAdresse(rs.getString("Adresse"));
                p.setType(Type.valueOf(rs.getString("Type")));
                p.setMot_de_passe(rs.getString("Mot_de_passe"));
                
            }
        } catch (SQLException ex) {
          Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<User> FiltrerParNom(String nom) {
        List<User> personnes = new ArrayList<>();
        String request = "SELECT * FROM user WHERE nom = '"+nom+"';";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                User p = new User();
                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
                p.setEmail(rs.getString("Email"));
                p.setTelephone(rs.getString("Telephone"));
                p.setAdresse(rs.getString("Adresse"));
                p.setType(Type.valueOf(rs.getString("Type")));
                p.setMot_de_passe(rs.getString("Mot de passe"));
              
                //
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }



}

