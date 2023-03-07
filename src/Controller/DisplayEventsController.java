/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Models.Enchere;
import Models.Evenement;
import Models.User;
import Services.EvenementService;
import Services.UserService;
import Utilities.Type;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class DisplayEventsController implements Initializable {

    @FXML
    private Button addEventBT;
    @FXML
    private Button updateEventBT;
    @FXML
    private Button deleteEventBT;
    @FXML
    private TextField nom_txt;
    @FXML
    private TextField lieu_txt;
    @FXML
    private TextField cap_txt;
    @FXML
    private TextField desc_txt;
    @FXML
    private TextField date_txt;
    
    private Evenement selectedEvent;
    private EvenementService evenementService;

    /**
     * Initializes the controller class.
     */
    List <Evenement> eventList;
        int index = -1 ;
    @FXML
    private ListView<Evenement> eventListView;
   
        
    @Override
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
                nom_txt.setText(newValue.getNom());
                lieu_txt.setText(newValue.getLieu());
                cap_txt.setText(String.valueOf(newValue.getCapacite()));
                desc_txt.setText(newValue.getDescription());
                date_txt.setText(newValue.getEvenement_date().toString());

                selectedEvent = newValue;
            });
    }
   

  
    @FXML
    private void addEvent(MouseEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/EvenementFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        
    }

    @FXML
    private void updateEvent(MouseEvent event) throws IOException, SQLException {
        if(selectedEvent != null) {
            try {
                int newCapacite = Integer.parseInt(cap_txt.getText());
                Date newDate = Date.valueOf(date_txt.getText());
                selectedEvent.setNom(nom_txt.getText());
                selectedEvent.setLieu(lieu_txt.getText());
                selectedEvent.setCapacite(newCapacite);
                selectedEvent.setEvenement_date(newDate);
                evenementService.updateEvenement(selectedEvent);
                JOptionPane.showMessageDialog(null, "updated");
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Veuillez saisir une capacité valide.");
            } catch(IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Veuillez saisir une date valide.");
            }
             
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez selectionnez un evenement pour le modifier.");
        }
            
    }

    @FXML
    private void deleteEvent(MouseEvent event) {
        if(selectedEvent != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting " + selectedEvent.getNom());
            alert.setContentText("Etes vous sur que vous voulez supprimer " + selectedEvent.getNom() +" ?");
            ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("Non", ButtonBar.ButtonData.NO);
            ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    evenementService.deleteEvenement(selectedEvent);
                } else if (type == noButton) {} else {}
            });
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez selectionnez un evenement pour le supprimer.");
        }
    }

    private void selectEvent(MouseEvent event) {
        
       
        
    }
    
}
