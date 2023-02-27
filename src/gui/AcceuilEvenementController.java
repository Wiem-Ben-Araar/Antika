/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Enchere;
import Services.EnchereService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class AcceuilEvenementController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button addEventButton;
    @FXML
    private Button updateEvent;
    @FXML
    private Button enchereButton;
    @FXML
    private Button displayEventButton;

    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonAddEvenement(MouseEvent event) throws IOException {
        
          try {
            Parent root = FXMLLoader.load(getClass().getResource("evenementFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void buttonUpdateEvent(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ModifierEvent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
    }

    @FXML
    private void goToEnchere(MouseEvent event) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("enchereAcceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
    }

    @FXML
    private void displayEvents(MouseEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DisplayEvents.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
       } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}