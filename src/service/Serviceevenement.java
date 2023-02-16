/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import java.sql.Date;

import tools.Connexion;
import entities.evenement;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sarra
 */
public class Serviceevenement {

    Connection cnx;
  
 

    public Serviceevenement() {
        Connexion instance = Connexion.getInstance();

    }

    public void CreateEvent( evenement e) {
        try {
            String req = "INSERT INTO evenement(nom,lieu,date,capacite,description) VALUES "
                    + "('" + e.getNom() + "'" + ",'" + e.getLieu() + "','" + e.getDate() + "'" + ",'" + e.getCapacite() + "','" + e.getDescription() + "')";
            Statement st = DataSource.getInstance().getCnx().createStatement();
            st.executeUpdate(req);
            System.out.println("evenement ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void Ajoutevenement(evenement e) {
        try {
            String req = "INSERT INTO evenement(identifiant,nom,lieu,date,capacite,description) VALUES "
                    + "('" + e.getIdentifiant() + "','" + e.getNom() + "','" + e.getLieu() + "','" + e.getDate() + "','" + e.getCapacite() + "','" + e.getDescription() + "')";
            Statement st = DataSource.getInstance().getCnx().createStatement();
            st.executeUpdate(req);
            System.out.println("evenement ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<evenement> Readevenement() {
        List<evenement> plist = new ArrayList<>();
        try {
            String req = "select * from evenement";
            Statement st = DataSource.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                evenement e = new evenement();
                e.setIdentifiant(rs.getInt("identifiant"));
                e.setNom(rs.getString(2));
                e.setLieu(rs.getString(3));
                e.setDate(rs.getString(4));
                e.setCapacite(rs.getInt(5));
                e.setDescription(rs.getString(6));

                plist.add(e);
            }
        } catch (Exception e) {
        }
        return plist;
    }


    
  /* public void Addproduct(produit p) throws SQLException  {
  try {
        String req ="INSERT INTO produit (nom,photo,description,disponibilte,prix) values (?,?,?,?,?)";
        
        
            
            PreparedStatement stm = cnx.prepareStatement(req);
             stm.setString(1, p.getNom());
             stm.setString(2, p.getPhoto());
             stm.setString(3,p.getDescription());
             stm.setString(4,p.getDisponibilte());
             stm.setDouble(5, p.getPrix());
             
             stm.executeUpdate();
             System.out.println("Produit ajouté");
                     
        } catch (SQLException ex) {
            System.out.println("probleme");
            System.out.println(ex.getMessage());
        }       
    } */
   
  
   public void addevent(evenement e) {
         try {
            String requete= "insert into evenement (nom,lieu,date,capacite,description)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = DataSource.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getLieu());
            pst.setString(3, e.getDate());
            pst.setInt(4, e.getCapacite());
            pst.setString(5, e.getDescription());



            pst.executeUpdate();
            System.out.println("Evenement inserée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
   
   
   
   
   
   
     
    public List<evenement> afficherevenement() throws SQLException {
        List<evenement> resulta = new ArrayList<>();

        Statement stm = cnx.createStatement();
        String query = "select * from produit ";

        ResultSet resultat = stm.executeQuery(query);
        evenement e = new evenement();
        while (resultat.next()) {
            e.setIdentifiant(resultat.getInt("identifiant"));
            e.setNom(resultat.getString("nom"));
            e.setLieu(resultat.getString("lieu"));
            e.setDate(resultat.getString("date"));
            e.setCapacite(resultat.getInt("capacite"));
            e.setDescription(resultat.getString("description"));

            resulta.add(e);
        }

        return resulta;
    }

    public void supprimerevenement(evenement e) {
        String req = "delete from evenement where identifiant=?";

        try {
            PreparedStatement stm = DataSource.getInstance().getCnx().prepareStatement(req);
            stm.setInt(1, e.getIdentifiant());
            int i = stm.executeUpdate();
            System.out.println(i + " evenement supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(int identifiant, evenement e) {
        String updateStatement = "UPDATE evenement SET nom= ? ,lieu=?, date=?, capacite=?, description=? WHERE identifiant= ? ";

        try {
            PreparedStatement pre = DataSource.getInstance().getCnx().prepareStatement(updateStatement);
            pre.setString(1, e.getNom());
            pre.setString(2, e.getLieu());
            pre.setString(3, e.getDate());
            pre.setInt(4, e.getCapacite());
            pre.setString(5, e.getDescription());
            pre.setInt(6, identifiant);
            pre.executeUpdate();
            System.out.println("Record Update successfully from database.:!!: ");
        } catch (SQLException m) {
            System.out.println(m.getMessage());
        }

    }

    /*
      public int Modifierevent(int id,evenement e, PreparedStatement pre) throws SQLException {
        if(chercher(id)){
        
        pre=cnx.prepareStatement("UPDATE event SET nom = ? , photo = ? , description = ? , lieu = ? , prix = ? WHERE id = "+id+"");
    try{     
             pre.setString(1, e.getNom());
             pre.setString(2, e.getPhoto());
             pre.setString(3,e.getDescription());
             pre.setString(4,e.getLieu());
             pre.setDouble(5, e.getPrix());
    
    
    pre.executeUpdate();
    }
    catch (SQLException m){
      System.out.println(m.getMessage());  
    }
    return 1;}
        return 0;
    } 
      /*
      public boolean chercher(int id) throws SQLException {
        String req="select * from event";
        List<Integer> list = new ArrayList<>();
        
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(evenementservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.forEach(System.out::println);
        return list.contains(id);
    }
      
       /*
      public ObservableList<evenement> FindEvent() {
        ObservableList<evenement> list = FXCollections.observableArrayList();
        try {
            String requete4 = "SELECT * FROM event";
            Statement st5 = Connexion.getInstance().getConnection.createStatement();
            ResultSet rs = st5.executeQuery(requete4);
            while (rs.next()) {
                evenement e = new evenement();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setLieu(rs.getString("lieu"));
                e.setDescription(rs.getString("description"));
          
              
                list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return list;
    }*/

    public List<evenement> getAll() {
        ObservableList<evenement> myList = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                evenement e = new evenement();
                e.setIdentifiant(rs.getInt(1));
                e.setNom(rs.getString("nom"));
                e.setLieu(rs.getString("lieu"));
                e.setDate(rs.getString("date"));
                e.setCapacite(rs.getInt("capacite"));
                e.setDescription(rs.getString("description"));

                myList.add(e);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public ObservableList<evenement> read() throws SQLException {
        ObservableList<evenement> L = FXCollections.observableArrayList();

        Statement st = cnx.createStatement();
        String req = "select * from evenement";
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            int identifiant = rs.getInt(1);
            String nom = rs.getString("nom");
            String lieu = rs.getString("lieu");
            String date = rs.getString("date");
            int capacite = rs.getInt("capacite");
            String description = rs.getString("description");

            evenement e = new evenement(identifiant, nom, lieu, date, capacite, description);

            L.add(e);
        }

        return L;

    }

    public evenement searchByReference(int identifiant) throws SQLException {
        
          //To change body of generated methods, choose Tools | Templates.
        Statement stm = cnx.createStatement();
        evenement E =new evenement();
        String query = "SELECT * FROM evenement WHERE `identifiant`='"+identifiant+"'";
         
        ResultSet rs= stm.executeQuery(query);
          
        while (rs.next()){
            
            E.setIdentifiant(rs.getInt("identifiant"));
            E.setNom(rs.getString("nom"));
            E.setLieu(rs.getString("lieu"));
            E.setDate(rs.getString("date"));
            E.setCapacite(rs.getInt("capacite"));
            
            E.setDescription(rs.getString("description"));
            
            
        }
        return E;
    }
    
    public evenement SearchById(int identifiant) throws SQLException{
        Statement stm = cnx.createStatement();
        evenement E =new evenement();
        String query = "SELECT * FROM evenement WHERE identifiant = "+identifiant;
        ResultSet rs= stm.executeQuery(query);
          
        while (rs.next()){
            
            E.setIdentifiant(rs.getInt("identifiant"));
            E.setNom(rs.getString("nom"));
            E.setLieu(rs.getString("lieu"));
            E.setDate(rs.getString("date"));
            E.setCapacite(rs.getInt("capacite"));
            
            E.setDescription(rs.getString("description"));
            
            
        }
        return E;
    }
      

}