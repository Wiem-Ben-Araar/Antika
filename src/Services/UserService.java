/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.UserInterface;
import Models.User;
import Models.Avis;
import Utilities.MaConnexion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    AvisService ps=new AvisService();
    public static User currentUser;

   
@Override
    public void ajouterUser(User p) {
       String req = "INSERT INTO `user`(`nom`, `prenom`, `email` ,`telephone`,`adresse`,`roles`,`password`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getEmail()+"','"+p.getTelephone()+"','"+p.getAdresse()+"','"+p.getType()+"','"+p.getMot_de_passe()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User ajouté avec success!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String hashPassword(String password) {
    String generatedPassword = null;

    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    return generatedPassword;
}

@Override
public void ajouterUser2(User p) {

    String req = "INSERT INTO `user`(`email`, `roles`, `password` ,`is_verified`,`nom`,`prenom`,`telephone`,`adresse`) VALUES ( ?, ?, ?, ?, ?, ?, ?,?)";
    try (PreparedStatement ps = cnx.prepareStatement(req)) {
        ps.setString(1, p.getEmail());
        ps.setString(2, p.getType());
        ps.setString(3, p.getMot_de_passe());
        ps.setInt(4, 0);
        ps.setString(5, p.getNom());
        ps.setString(6, p.getPrenom());
        ps.setString(7, p.getTelephone());
        ps.setString(8, p.getAdresse());
        ps.executeUpdate();
        System.out.println("User ajouté avec succès!!");
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void modifierUser(int id, User p) {
       try{
             String req ="UPDATE `user` SET `nom`=?,`prenom`=?,`email`=?,`telephone`=?,`adresse`=?,`roles`=?,`password`=? WHERE id="+id;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelephone());
            ps.setString(5, p.getAdresse());
            ps.setString(6, p.getType().toString());
            ps.setString(7, p.getMot_de_passe());
            System.out.println(ps.toString());
            ps.executeUpdate();
            System.out.println("Utlisateur est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

    };

    @Override
    public void supprimerUser(int id) {
         User p = new User();
        String request = "DELETE FROM `user` WHERE `ID` ="+id+";";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("User est supprimé");

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
                 System.out.println(rs.getString("roles"));
                 p.setType(rs.getString("roles"));
                 p.setMot_de_passe(rs.getString("password"));
                
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }


    @Override
    public User afficherUserbyID(int id_user) {
        User p = new User();
        String request = "SELECT * FROM user WHERE `id` ="+id_user+";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                p.setAdresse(rs.getString("adresse"));
                p.setType(rs.getString("roles"));
                p.setMot_de_passe(rs.getString("password"));
                
            }
        } catch (SQLException ex) {
          Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public User afficherUserbyEmail(String email) {
        User p = new User();
        String request = "SELECT * FROM user WHERE email = '"+email+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                p.setAdresse(rs.getString("adresse"));
                p.setType(rs.getString("roles"));
                p.setMot_de_passe(rs.getString("password"));
                
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
                p.setType(rs.getString("Roles"));
                p.setMot_de_passe(rs.getString("Password"));
                
              
                
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }

    @Override
    public List<User> RechercherUser(String nom) {
        List<User> personnes = new ArrayList<>();
        String request = "SELECT * FROM user WHERE nom='"+nom+"'";
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
                p.setType(rs.getString("Roles"));
                p.setMot_de_passe(rs.getString("Password"));             
              
                
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }

 @Override
    public boolean userExiste(String email) {
        boolean exists = false;
        String request = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement ps = cnx.prepareStatement(request)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }

}

