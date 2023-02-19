/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilities.MaConnexion;
import java.io.IOException;
import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLController implements Initializable {
    PreparedStatement pst;
    ResultSet rs;
    

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_motdepasse;
   
    @FXML
    private TextField tf_prenom;

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_connexion(ActionEvent event) throws IOException {
     try{
         if (tf_nom.getText().isEmpty()|| tf_motdepasse.getText().isEmpty()|| tf_prenom.getText().isEmpty() ){
             
     System.out.println("Champs invalide!");
            }
         else
         {
             
         MaConnexion cnx=new MaConnexion();
        pst=cnx.cnx.prepareStatement("select * from user where nom=? and prenom=? and mot_de_passe=?");
        pst.setString(1,tf_nom.getText());
        pst.setString(2,tf_prenom.getText());
        pst.setString(3,tf_motdepasse.getText());
        rs=pst.executeQuery();
            if(!rs.isBeforeFirst()){
            System.out.println("Compte invalide!");
            tf_nom.setText("");
            tf_prenom.setText("");
            tf_motdepasse.setText("");
            }
            else
            {
                while(rs.next()){
                      Parent  AvisPage =FXMLLoader.load(getClass().getResource("FXMLAvis.fxml"));  //thezek l avis
       Scene AvisPageScene =new Scene(AvisPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(AvisPageScene);
    appStage.show();
                  
                }
            }
         }
     }catch (SQLException e){
         
     }   
    }

  
    @FXML
    private void link_motdepasseoublié(ActionEvent event) {
    }

    @FXML
    private void btn_créeruncompte(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("FXMLCREATE.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }
    
}
