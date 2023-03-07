package Controller;

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
                      Parent  UserPage =FXMLLoader.load(getClass().getResource("../GUI/profile.fxml"));  
       Scene UserPageScene =new Scene(UserPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(UserPageScene);
    appStage.show();
                  
                }
            }
         }
     }catch (SQLException e){
         
     }   
    }

  

    @FXML
    private void btn_créeruncompte(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLCreate.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void motdepasseoublié(ActionEvent event) throws IOException {
      Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLCodeMDP.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();   
    }
    @FXML
    private void WelcomePage(ActionEvent event) throws IOException {
            Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLWelcome.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }
    
}
