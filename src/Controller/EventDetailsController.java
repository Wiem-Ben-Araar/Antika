/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Models.Evenement;
import Models.User;
import Services.EvenementService;
import Services.ReservationService;
import Services.UserService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    private UserService userService = new UserService();
    User user = userService.afficherUserbyID(1);


    /**
     * Initializes the controller class.
     */
    @Override
    //nheb hasb l evenement selectionn√© ytalaali les details mteeha lkol
    //button reserver yhezna lel payement
    public void initialize(URL url, ResourceBundle rb) {
        evenementService = new EvenementService();
        
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
        String reservationStatus = reservationService.createReservation(selectedEvent, user);
        if(reservationStatus.equals("Votre reservation est ajout√© avec succ√©s")) {
            JOptionPane.showMessageDialog(null, "Merci pour particip√© dans " + selectedEvent.getNom() + ", une invitation par email a √©t√© envoy√© √† " + user.getEmail() + ".");
        } else if(reservationStatus.equals("complet")) {
            JOptionPane.showMessageDialog(null, "d√©sol√© complet !");  
        } else if(reservationStatus.equals("evenement passe")) {
            JOptionPane.showMessageDialog(null, "evenement passe !");  
        } else if(reservationStatus.equals("deja participe")) {
            JOptionPane.showMessageDialog(null, "vous avez deja reserv√© une place pour cette evenement !");  
        }
    }
    
}
