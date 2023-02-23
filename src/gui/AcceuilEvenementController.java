/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
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
    private VBox addEventButton;

    
    private void switchToAddScene(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EvenementFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonAddEvenement(MouseEvent event) throws IOException {
        
         Stage stage;
        Parent root;

        stage = (Stage) addEventButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/gui/evenementFXML.fxml"));

    }

    
}
