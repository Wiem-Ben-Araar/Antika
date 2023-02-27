/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.PanierInterface;
import Models.Panier;
import Models.Produit;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;
import Utilities.MyConnection;

/**
 *
 * @author shily
 */
public class PanierService implements PanierInterface {
     Connection mc=MyConnection.getInstance().getConnection();
     UserService us= new UserService();
    PreparedStatement ste ;
    ProduitService produitService = new ProduitService();
        UserService userService= new UserService();
    // Produit produit = new Produit(1,15,"produit1");
   //  Produit produit2 = new Produit(2,20,"produit2");
@Override
    public void ajouter(Panier p) {
    String sql ="insert into panier (id_user,id_produit ,quantite ,total) values(?,?,?,?)" ;
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(1, p.getUser().getId_user());
            ste.setInt(2, p.getProduit().getId_produit());
            ste.setInt(3, p.getQuantite());
            ste.setDouble(4, p.getProduit().getPrix()*p.getQuantite());
            ste.executeUpdate();
            System.out.println("Panier ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
    @Override
    public List<Panier> afficher() {
        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st=mc.createStatement();
            String req="SELECT * FROM `panier`";
            ResultSet resultat=st.executeQuery(req);
          while(resultat.next()){
              Panier resultc = new Panier(resultat.getInt(1),resultat.getInt(2),resultat.getDouble(3),us.getUser(resultat.getInt("id_user")),produitService.getProduit(resultat.getInt("id_produit")));
              pers.add(resultc);
              
          }
          
       }  
        catch(SQLException ex ){
 System.out.println("non");       }
        return pers;
    }
public List<Panier> getPanier(int id_user) {
    List<Panier> pers=new ArrayList<Panier>();
         try {
             Statement st=mc.createStatement();
             String req="SELECT * FROM `panier` where id_user ="+ id_user;
             ResultSet resultat=st.executeQuery(req);
             while(resultat.next()){
                 Panier resultc = new Panier(resultat.getInt(1),resultat.getInt(2),resultat.getDouble(3),us.getUser(resultat.getInt("id_user")),produitService.getProduit(resultat.getInt("id_produit")));
                 pers.add(resultc);
                 
                 
             }        } catch (SQLException ex) {
             Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
         }

return pers;
}
public Panier getPanierUserProduit(int id_user,int id_produit) {
    Panier panier=new Panier();
         try {
             Statement st=mc.createStatement();
             String req="SELECT * FROM `panier` where id_user ="+ id_user+" AND id_produit ="+id_produit;
             ResultSet resultat=st.executeQuery(req);
             while(resultat.next()){
                  panier = new Panier(resultat.getInt(1),resultat.getInt(2),resultat.getDouble(3),us.getUser(resultat.getInt("id_user")),produitService.getProduit(resultat.getInt("id_produit")));
                 
                 
             }        } catch (SQLException ex) {
             Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
         }

return panier;
}
    @Override
    public void supprimerP(int id_panier) {
         try {
             String deleteReq= "DELETE FROM panier WHERE id_panier=" +id_panier ;
             PreparedStatement deletePs=mc.prepareStatement(deleteReq);
             deletePs.executeUpdate();
             System.out.println("Product removes from the cart!");
         } catch (SQLException ex) {
             Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    @Override
    public void decrementQuantite(Panier panier)
    {
        try{
           
            
                int quantite=panier.getQuantite();
                if(quantite>1){
                    String updateReq="UPDATE panier SET quantite= "+ (quantite-1) +", total= "+((quantite-1)*panier.getProduit().getPrix()) +" WHERE id_panier=" +panier.getId_panier() ;
                    PreparedStatement UpdatePs=mc.prepareStatement(updateReq);
                    UpdatePs.executeUpdate();
                    System.out.println("Product Quantite decremented in the cart");
                } else{
                    
                    System.out.println("Product quantite 1");
                }
           
            
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    
    
}
    @Override
public void incrementQuantite(Panier panier)
   {
      try{
                int quantite=panier.getQuantite();
                if(quantite>0){
                    String updateReq="UPDATE panier SET quantite= "+ (quantite+1) +", total= "+((quantite+1)*panier.getProduit().getPrix()) +" WHERE id_panier = " +panier.getId_panier() ;
                    PreparedStatement UpdatePs=mc.prepareStatement(updateReq);
                    UpdatePs.executeUpdate();
                    System.out.println("Product Quantite incremented in the cart"); 
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   } 

    

    @Override
    public List<Panier> chercher(String nomp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}