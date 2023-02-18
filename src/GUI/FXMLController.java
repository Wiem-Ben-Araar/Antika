/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
    private void btn_connexion(ActionEvent event) {
    }

    @FXML
    private void btn_créermoncompte(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("FXMLCREATE.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    
    }
    @FXML
    private void link_motdepasseoublié(ActionEvent event) {
    }
    
}
