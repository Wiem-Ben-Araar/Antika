/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.User;
import Services.UserService;
import Utilities.Type;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class EnchereAcceuilController implements Initializable {

    @FXML
    private Button enchereButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button displayEventButton;
    @FXML
    private Button displayEnchereDetails;
    private UserService userService = new UserService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        User currentUser = UserService.currentUser;
        if (currentUser.getType()==Type.CLIENT){
            enchereButton.setVisible(false);
            EventButton.setVisible(false);
        }
        
    }    

    @FXML
    private void displayEncheres(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateEnchere.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
    }

    @FXML
    private void displayEvenements(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("displayEvents.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();        
    }

    @FXML
    private void displayEvents(MouseEvent event) throws IOException {
        
          Parent root = FXMLLoader.load(getClass().getResource("EventDetails.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();        
            
    }

    @FXML
    private void displayEnchereDetails(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("displayEncheres.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show(); 
    }
    
}
