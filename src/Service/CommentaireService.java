/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interfaces.CommentaireInterface;
import Models.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Blog;
import utilities.MaConnexion;

/**
 *
 * @author dridi
 */
public class CommentaireService implements CommentaireInterface{
     Connection  conn = MaConnexion.getInstance().getCnx();
     BlogService bs = new BlogService();
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Object java;
/*
      @Override
    public void AjouterCommentaire(Commentaire object) {
 try {
            String req = "INSERT INTO `commentaire`(`contenu`) VALUES ('" + object.getContenu() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Commenatire Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     }

    @Override
    public void ModifierCommentaire(Commentaire object) {
       try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(BlogService.class.getName()).log(Level.SEVERE, null, ex);
    }
        } 

    @Override
    public void SupprimerCommentaire(Commentaire object) {
         try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        } 

    @Override
    public List<Commentaire> RechercherCommentaire(String object) {
       List<Commentaire> list = new ArrayList<>();
        String req = " SELECT * FROM blog WHERE (titre LIKE '%" + object + "%' OR artiste LIKE '%" + object + "%'OR date_publication LIKE '%" + object + "%'OR contenu LIKE '%" + object + "%'OR image LIKE '%" + object + "%'";
        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Commentaire(rs.getInt("id_blog"), rs.getString("titre"), rs.getString("artiste"), rs.getDate("date_publication"), rs.getString("contenu"),rs.getString("etiquette"), rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    }

    @Override
    public List<Commentaire> AfficherCommentaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commentaire getCommentaireId(int object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> TrieCommentaire(String object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/


    @Override
    public void AjouterCommentaire(Commentaire object) {

         try {
             String req = "INSERT INTO `commentaire`(`contenu`) VALUES ('" + object.getContenu() + "')";
             ste = conn.createStatement();
             ste.executeUpdate(req);
             System.out.println("Commenatire Added successfully!");
         } catch (SQLException ex) {
             Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    @Override
    public void ModifierCommentaire(Commentaire cmnt, int id) {
         String req = "UPDATE commentaire SET contenu ='" + cmnt.getContenu() + "' WHERE id_commentaire = '" + id+ "'";    
    
      try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("modification avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(BlogService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
    public void SupprimerCommentaire(Commentaire object) {}
     public void SupprimerCommentaire1(int i){
        String req = "DELETE FROM commentaire WHERE id_commentaire='" + i+ "'";
         try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("supprission avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<Commentaire> RechercherCommentaire(String object) {
     List<Commentaire> list = new ArrayList<>();
        String req = " SELECT * FROM commentaire WHERE (contenue LIKE '%" + object + "%'";
        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenue"),bs.getBlogById(rs.getInt("blog"))));
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    }

    @Override
    public List<Commentaire> AfficherCommentaire() {
      
    List<Commentaire> list = new ArrayList<>();
        String req = " SELECT * FROM commentaire";
        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
         list.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),bs.getBlogById(rs.getInt("blog"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(list);
        return list; 
    }

    @Override
    public Commentaire getCommentaireId(int object) {
         Commentaire c = new Commentaire();
        String req = "select * from commentaire WHERE id_commentaire='" + object + "'";  
     try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            rs.next();
            c = new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),bs.getBlogById(rs.getInt("blog")));
        } catch (SQLException ex) {
            Logger.getLogger(BlogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public List<Commentaire> TrieCommentaire(String object) {
       List<Commentaire> list = new ArrayList<>();
        String req;
        switch (object) {
            case "contenu":
                req = " SELECT * FROM blog  OrderBy contenu";
                break;
            
            default:
                req = " SELECT * FROM blog  OrderBy id_blog";

        }

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),bs.getBlogById(rs.getInt("blog"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //get commentaire par blog

    public void AfficherCommentaire(Commentaire c1) {
        List<Commentaire> list = new ArrayList<>();
        String req = " SELECT * FROM commentaire";
        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
         list.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),bs.getBlogById(rs.getInt("blog"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(list);
         //To change body of generated methods, choose Tools | Templates.
    }
}
