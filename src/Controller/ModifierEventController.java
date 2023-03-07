/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Models.Evenement;
import Services.EvenementService;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class ModifierEventController implements Initializable {

    private TextField newEventNameTF;
    private TextField newEventPlaceTF;
    private TextField newEventCapacityTF;
    private TextArea newEventDescritionTF;
    private DatePicker newEventDateTF;
    @FXML
    private TableView<Evenement> EventDetailsTable;
    @FXML
    private TableColumn<Evenement, String> nomTF;
    @FXML
    private TableColumn<Evenement, String> lieuTF;
    @FXML
    private TableColumn<Evenement, Integer> capTF;
    @FXML
    private TableColumn<Evenement, Date> dateTF;
    @FXML
    private TableColumn<Evenement, String> descTF;
    private TextField nameEventTF;
    @FXML
    private Button deleteEventBT;
    @FXML
    private Button updateEvent;
    @FXML
    private Button getEvent;
    @FXML
    private TextField lieu;
    @FXML
    private TextField capacite;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker date;
    @FXML
    private TextField nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
 
    //delete ne fonctionne pas !! 
    //badaltha delete by event name 
    @FXML
    private void deleteEvenement(MouseEvent event) {
         EvenementService evenementService = new EvenementService();
        Evenement evenement = new Evenement();
       String nom = evenement.getNom();
        evenementService.deleteEvenement(evenement);
        
    }

    //update ne fonctionne pas aussi
    @FXML
    private void updateEvenement(MouseEvent event) {
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
    private void getEvenementsByNom(MouseEvent event) {
         EvenementService evenementService = new EvenementService();  
        List <Evenement> eventList;
        eventList = evenementService.getEvenementsByNom(nameEventTF.getText());
        ObservableList<Evenement> evenements = FXCollections.observableList(eventList);
        
        nomTF.setCellValueFactory(new PropertyValueFactory<>("nom"));
        lieuTF.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        descTF.setCellValueFactory(new PropertyValueFactory<>("description"));
        capTF.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        dateTF.setCellValueFactory(new PropertyValueFactory<>("evenement_date"));
        
        EventDetailsTable.setItems(evenements);
    }
    
}
