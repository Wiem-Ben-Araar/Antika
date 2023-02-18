/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLCreateController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_telephone;
    @FXML
    private TextField tf_adresse;
    @FXML
    private TextField tf_type;
    @FXML
    private TextField tf_motedepasse;
    @FXML
    private TextField tf_confirmermotdepasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    
}
