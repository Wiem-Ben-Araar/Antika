/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Evenement;
import Services.EvenementService;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class ModifierEventController implements Initializable {

    @FXML
    private TextField newEventNameTF;
    @FXML
    private TextField newEventPlaceTF;
    @FXML
    private TextField newEventCapacityTF;
    @FXML
    private TextArea newEventDescritionTF;
    @FXML
    private DatePicker newEventDateTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void updateEvenement(ActionEvent event) {
        
         EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
        
        evenement.setNom(newEventNameTF.getText());
        evenement.setLieu(newEventPlaceTF.getText());
        evenement.setCapacite(Integer.parseInt(newEventCapacityTF.getText()));
        evenement.setDescription(newEventDescritionTF.getText());
        evenement.setEvenement_date(Date.valueOf(newEventDateTF.getValue()));
        
        evenementInterface.updateEvenement(evenement);
    }

    @FXML
    private void getEvenementsByNom(ActionEvent event) {
        EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
       
        evenementInterface.getEvenements(evenement);
        
    }

    @FXML
    private void deleteEvenement(ActionEvent event) {
        
         EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
       
        evenementInterface.deleteEvenement(evenement,9);
        
    }
    
}
