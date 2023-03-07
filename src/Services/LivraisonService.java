/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.LivraisonInterface;
import Models.Livraison;
import Models.Panier;
import Models.User;
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
public class LivraisonService implements LivraisonInterface {
    PreparedStatement ste ;
      UserService us= new UserService();
     User user = us.afficherUserbyID(1);
    Connection cnx=MaConnexion.getInstance().getCnx();
    PanierService panierService=new PanierService();
    @Override
    public void AjouterLivraison (Livraison p){
        double total =0;
        String req="INSERT INTO livraison (id_user,adresse,statut,date_livraison,total) VALUES (?,?,?,?,?)";
        try{
            
            List<Panier> paniers = panierService.getPanier(user.getId_user());
            if(paniers.size()>=1){
                 PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1, user.getId_user());
        ps.setString(2, p.getAdresse());
        ps.setString(3,p.getStatut());
        ps.setDate(4, p.getDate_livraison());
        for(Panier panier :paniers){
            
                total = panier.getTotal()+total;
                panierService.supprimerP(panier.getId_panier());
                
            }
        if(CountLivraison(user.getId_user())>9){
          total=(total*80)/100;
          
      }
        ps.setDouble(5,total);
        ps.executeUpdate();
        System.out.println("Livraison ajoutée avec succes ! ");
            }
            else{
                System.out.println("Panier vide");
            }
       
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    @Override
    public void ModifierLivraison(Livraison p,int x){
        
    try{
        String req;
                req="UPDATE livraison SET adresse =? , statut=?, date_livraison=?,total= ?, id_user=? WHERE id_livraison ='"+x+"'";
                PreparedStatement ps=cnx.prepareStatement(req);
                ps.setString(1,p.getAdresse());
                ps.setString(2,p.getStatut());
                ps.setDate(3,p.getDate_livraison());
                ps.setFloat(4,p.getTotal());
                ps.setInt(5,user.getId_user());
                ps.executeUpdate();
                System.out.println("la livraison est modifier!");
    }catch(SQLException ex)
    { System.out.println(ex.getMessage());
    }
    }
    @Override
    public void SupprimerLivraison(Livraison p){
        String req;
        req="DELETE FORM livraison WHERE id_livraison= "+ p.getId_livraison();
        
        try{
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.executeUpdate(req);
            System.out.println("Livraison supprimé avec succes");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            
            
        }
    }
        @Override
        public List<Livraison> RechercherLivraison(String adresse){
            List<Livraison> livraisons=new ArrayList<Livraison>();
            String request;
            request="SELECT * FROM livraison WHERE adresse= '"+ adresse+"'";
            
            try{
                Statement st=cnx.createStatement();
                ResultSet rs =st.executeQuery(request);
            while(rs.next()){
                Livraison l =new Livraison();
            l.setId_livraison(rs.getInt(1));
            l.setTotal(rs.getInt("total"));
            l.setStatut(rs.getString("statut"));
            l.setDate_livraison(rs.getDate("Date"));
            l.setAdresse(rs.getString("adresse"));
            l.setUser(us.afficherUserbyID(rs.getInt("id_user")));
            livraisons.add(l);
            }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                
            }return livraisons;
        }
         @Override
    public List<Livraison> AfficherLivraison(){
        List<Livraison> livraisons=new ArrayList<Livraison>();
        String req;
        req="SELECT * FROM livraison";
        try {
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
          while(rs.next()){
                Livraison l =new Livraison();
            l.setId_livraison(rs.getInt(1));
            l.setTotal(rs.getInt("total"));
            l.setStatut(rs.getString("statut"));
            l.setDate_livraison(rs.getDate("date_livraison"));
            l.setAdresse(rs.getString("adresse"));
            l.setUser(us.afficherUserbyID(rs.getInt("id_user")));
            livraisons.add(l);
            }
            }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    }
            return livraisons;
        
        }
    @Override
    public List<Livraison> GetLivraison(int id_user){
        List<Livraison> livraisons=new ArrayList<Livraison>();
        String req;
        req="SELECT * FROM livraison where id_user = "+id_user;
        try {
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
          while(rs.next()){
                Livraison l =new Livraison();
            l.setId_livraison(rs.getInt(1));
            l.setTotal(rs.getInt("total"));
            l.setStatut(rs.getString("statut"));
            l.setDate_livraison(rs.getDate("date_livraison"));
            l.setAdresse(rs.getString("adresse"));
            l.setUser(us.afficherUserbyID(rs.getInt("id_user")));
            livraisons.add(l);
            }
            }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    }
            return livraisons;
        
        }
    @Override
    public int CountLivraison(int id_user){
        int nbre=0;
        List<Livraison> livraisons=new ArrayList<Livraison>();
        String req;
        req="SELECT * FROM livraison where id_user = "+id_user;
        try {
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
          while(rs.next()){
                Livraison l =new Livraison();
            l.setId_livraison(rs.getInt(1));
            l.setTotal(rs.getInt("total"));
            l.setStatut(rs.getString("statut"));
            if(rs.getString("statut").equals("Livrée")){
                nbre++;
            }
            l.setDate_livraison(rs.getDate("date_livraison"));
            l.setAdresse(rs.getString("adresse"));
            l.setUser(us.afficherUserbyID(rs.getInt("id_user")));
            livraisons.add(l);
            }
            }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    }
            return nbre;
        
        }
    
    @Override
public Livraison getLivraisonById(int id_Livraison){
    String request;
     Livraison l =new Livraison();
    request="SELECT FROM livraison WHERE id_livraison='"+ id_Livraison+"'";
    try{
        Statement st=cnx.createStatement();
        ResultSet rs=st.executeQuery(request);
        while(rs.next()){
               
            l.setId_livraison(rs.getInt(1));
            l.setTotal(rs.getInt("total"));
            l.setStatut(rs.getString("statut"));
            l.setDate_livraison(rs.getDate("date_livraison"));
            l.setAdresse(rs.getString("adresse"));
            l.setUser(us.afficherUserbyID(rs.getInt("id_user")));
            
            }
    } catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return l;
    
}






}

    
    
    
    
    
    
    
    
    
    
    

