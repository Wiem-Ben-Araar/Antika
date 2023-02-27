/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Enchere;
import Services.EnchereService;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class DisplayEncheresController implements Initializable {

    @FXML
    private TableView<Enchere> EnchereDetailsTable;
    @FXML
    private TableColumn<Enchere, Integer> prixInitialeTF;
    @FXML
    private TableColumn<Enchere, Integer> prixFinaleTF;
    @FXML
    private TableColumn<Enchere, Timestamp> creationDateTF;
    @FXML
    private TableColumn<Enchere, Timestamp> dateFermetureTF;
    @FXML
    private TableColumn<Enchere, Integer> gagnantTF;
    @FXML
    private TableColumn<Enchere, Integer> createurTF;
    @FXML
    private TableColumn<Enchere, Integer> produitTF;
    @FXML
    private Button miser;

    /**
     * Initializes the controller class.
     */
    
     List <Enchere> enchereList;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EnchereService enchereService = new EnchereService();
        enchereList = enchereService.getEncheres();
        ObservableList<Enchere> encheres = FXCollections.observableList(enchereList);
        
        prixInitialeTF.setCellValueFactory(new PropertyValueFactory<>("prix_initiale"));
        prixFinaleTF.setCellValueFactory(new PropertyValueFactory<>("prix_finale"));
        creationDateTF.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        dateFermetureTF.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
        gagnantTF.setCellValueFactory(new PropertyValueFactory<>("gagnant"));
        createurTF.setCellValueFactory(new PropertyValueFactory<>("createur"));
        produitTF.setCellValueFactory(new PropertyValueFactory<>("produit"));
        
        EnchereDetailsTable.setItems(encheres);
    }    

    @FXML
    private void selectedEnchere(MouseEvent event) {
    }

    @FXML
    private void placerMise(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mise.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show(); 
    }
    
}
