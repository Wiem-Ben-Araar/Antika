/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utilities.MaConnexion;

/**
 * FXML Controller class
 *
 * @author dridi
 */
public class FXMLBlogController implements Initializable {
PreparedStatement pst;
    @FXML
    private TextField tf_titre;
    @FXML
   private Label tf_artiste;
     @FXML
   private Label tn_contenu;
      @FXML
   private Label tn_etiquette;
       @FXML
    private Label  tn_date;
        @FXML
    private Label tn_image;

    /**
     * Initializes the controller class.
     * @param url 
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_envoyer(ActionEvent event) {
        
    }
    
}
