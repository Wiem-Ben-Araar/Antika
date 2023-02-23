/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Interfaces.EvenementInterface;
import Models.Evenement;
import Services.EvenementService;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class EvenementFXMLController implements Initializable {

    @FXML
    private TextField eventNomLabel;
    @FXML
    private TextField eventLieuLabel;
    @FXML
    private TextField eventCapaciteLabel;
    @FXML
    private TextField eventDescLabel;
    @FXML
    private DatePicker eventDateLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void createEvenement(ActionEvent event) {
        
        EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
        
        evenement.setNom(eventNomLabel.getText());
        evenement.setLieu(eventLieuLabel.getText());
        evenement.setCapacite(Integer.parseInt(eventCapaciteLabel.getText()));
        evenement.setDescription(eventDescLabel.getText());
        evenement.setEvenement_date(Date.valueOf(eventDateLabel.getValue()));
        
        evenementInterface.createEvenement(evenement);
        
    }

   /* @FXML
    private void deleteEvenement(ActionEvent event) {
        EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
        evenementInterface.deleteEvenement(evenement,7);
    }

    @FXML
    private void updateEvenement(ActionEvent event) {
        
        EvenementService evenementInterface = new EvenementService();
        Evenement evenement = new Evenement();
        evenementInterface.updateEvenement(evenement);
    }*/

    
}
