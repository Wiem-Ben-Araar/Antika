/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Evenement;
import Models.User;
import Services.EvenementService;
import Services.UserService;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

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

    private User currentUser;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUser = UserService.currentUser;
    }    

    @FXML
    private void createEvenement(ActionEvent event) {
        try {
            EvenementService evenementService = new EvenementService();
            Evenement evenement = new Evenement();
            int newCapacite = Integer.parseInt(eventCapaciteLabel.getText());
            Date newDate = Date.valueOf(eventDateLabel.getValue());
            evenement.setNom(eventNomLabel.getText());
            evenement.setLieu(eventLieuLabel.getText());
            evenement.setCapacite(newCapacite);
            evenement.setDescription(eventDescLabel.getText());
            evenement.setEvenement_date(newDate);
            evenement.setCreateur(currentUser);
            evenementService.createEvenement(evenement);
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir une capacité valide.");
        } catch(IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir une date valide.");
        }
        JOptionPane.showMessageDialog(null, "L'evenement a été ajouté avec succés.");
    }
    
}
