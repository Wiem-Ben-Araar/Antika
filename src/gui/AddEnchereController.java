/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Enchere;
import Models.Produit;
import Models.User;
import Services.EnchereService;
import Services.UserService;
import Utilities.MaConnexion;
import Utilities.Type;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class AddEnchereController implements Initializable {

    @FXML
    private TextField prixInitialeTF;
    @FXML
    private Button createEnchereButton;
    private TableColumn<Enchere, Integer> prixInitTF;
    private TableColumn<Enchere, Integer> prixFinalTF;
    private TableColumn<Enchere, Timestamp> CreationTF;
    private TableColumn<Enchere, Timestamp> FermetureTF;
    private TableColumn<Enchere, Integer> winnerTF;
    private TableColumn<Enchere, Integer> creatorTF;
    private TableColumn<Enchere, Integer> productTF;
    private TableView<Enchere> display;
    @FXML
    private TextField productID;

    /**
     * Initializes the controller class.
     */
    
   /* Enchere enchere = new Enchere();
    List<Enchere> encheres = new ArrayList<>();
    EnchereService enchereService = new EnchereService();
    ObservableList<Enchere> data = FXCollections.observableArrayList(enchereService.getEncheres());
     /**
     * Initializes the controller class.
     */
   // ObservableList<Enchere> eventList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createEnchere(ActionEvent event) {
        
        Produit produit = new Produit();
        produit.setId(Integer.parseInt(productID.getText()));
        Enchere enchere = new Enchere();
        EnchereService enchereService = new EnchereService();
       
        
        enchere.setPrix_initale(Integer.parseInt(prixInitialeTF.getText()));
        enchere.setProduit(produit);
        enchere.setDate_fermeture(Timestamp.valueOf(LocalDateTime.now()));
        
        enchereService.createEnchere(enchere);
        
    }

   

    private void displayEnchere(MouseEvent event) {
        
        EnchereService enchereService = new EnchereService();
        List <Enchere> enchereList;
        enchereList = enchereService.getEncheres();
        ObservableList<Enchere> encheres = FXCollections.observableList(enchereList);
        
        prixInitTF.setCellValueFactory(new PropertyValueFactory<>("prix_initiale"));
        prixFinalTF.setCellValueFactory(new PropertyValueFactory<>("prix_finale"));
        CreationTF.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        FermetureTF.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
        winnerTF.setCellValueFactory(new PropertyValueFactory<>("gagnant"));
        creatorTF.setCellValueFactory(new PropertyValueFactory<>("createur"));
        productTF.setCellValueFactory(new PropertyValueFactory<>("produit"));

        display.setItems(encheres);

    }

    private void deleteEnchere(MouseEvent event) {
        
       
        EnchereService enchereService = new EnchereService();
        Enchere enchere = new Enchere();
        enchereService.deleteEnchere(enchere);
        
        
    }

    @FXML
    private void createEnchere(MouseEvent event) {
    }

}
    
    
