/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.User;
import Services.UserService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLProfilController implements Initializable {

    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label typeLabel;
 

    
       private UserService userService = new UserService();

    private User user;

    public void initData(User user) {
        this.user = user;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          nomLabel.setText(user.getNom());
        prenomLabel.setText(user.getPrenom());
        adresseLabel.setText(user.getAdresse());
        emailLabel.setText(user.getEmail());
        telephoneLabel.setText(user.getTelephone());
        typeLabel.setText(user.getType().toString());
        
    }
}
