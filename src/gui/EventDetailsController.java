/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Evenement;
import Models.User;
import Services.EvenementService;
import Services.ReservationService;
import Services.UserService;
import static Services.UserService.currentUser;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class EventDetailsController implements Initializable {
    @FXML
    private Button reserver;
    @FXML
    private ListView<Evenement> eventListView;

    private Evenement selectedEvent;
    private EvenementService evenementService;
    private List <Evenement> eventList;
    private User currentUser;


    /**
     * Initializes the controller class.
     */
    @Override
    //nheb hasb l evenement selectionné ytalaali les details mteeha lkol
    //button reserver yhezna lel payement
    public void initialize(URL url, ResourceBundle rb) {
        evenementService = new EvenementService();
        currentUser = UserService.currentUser;
        eventList = evenementService.getEvenements();

        for(Evenement event: eventList) {
            eventListView.getItems().add(event);
        }

        eventListView
            .getSelectionModel()
            .selectedItemProperty()
            .addListener((ObservableValue<? extends Evenement> observable, Evenement oldValue, Evenement newValue) -> {
                selectedEvent = newValue;
            });
    }    

    @FXML
    private void reserverEvenement(MouseEvent event) {
        ReservationService reservationService = new ReservationService();
        String reservationStatus = reservationService.createReservation(selectedEvent, currentUser);
        if(reservationStatus.equals("Votre reservation est ajouté avec succés")) {
            JOptionPane.showMessageDialog(null, "Merci pour participé dans " + selectedEvent.getNom() + ", une invitation par email a été envoyé à " + currentUser.getEmail() + ".");
        } else if(reservationStatus.equals("complet")) {
            JOptionPane.showMessageDialog(null, "désolé complet !");  
        } else if(reservationStatus.equals("evenement passe")) {
            JOptionPane.showMessageDialog(null, "evenement passe !");  
        } else if(reservationStatus.equals("deja participe")) {
            JOptionPane.showMessageDialog(null, "vous avez deja reservé une place pour cette evenement !");  
        }
    }
    
}
