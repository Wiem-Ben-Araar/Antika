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
    private TextField tf_motdepasse;
   
  
    @FXML
    private TextField tf_email;

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_connexion(ActionEvent event) throws IOException {
     try{
         if (tf_email.getText().isEmpty()|| tf_motdepasse.getText().isEmpty() ){
             
     System.out.println("Champs invalide!");
            }
         else
         {
             
         MaConnexion cnx=new MaConnexion();
        pst=cnx.cnx.prepareStatement("select * from user where email=? and mot_de_passe=?");
        pst.setString(1,tf_email.getText());
       
        pst.setString(2,tf_motdepasse.getText());
        rs=pst.executeQuery();
            if(!rs.isBeforeFirst()){
            System.out.println("Compte invalide!");
            tf_email.setText("");
            
            tf_motdepasse.setText("");
            }
            else
            {
                while(rs.next()){
                      Parent  AvisPage =FXMLLoader.load(getClass().getResource("FXMLAvis.fxml"));  
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
    private void btn_créeruncompte(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("FXMLCreate.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void motdepasseoublié(ActionEvent event) throws IOException {
      Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("FXMLCodeMDP.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();   
    }
    
}
