package gui;

import Models.Enchere;
import Services.EnchereService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UpdateEnchereController implements Initializable {

    @FXML
    private TableView<Enchere> EnchereDetailsTable;
    @FXML
    private Button deleteEnchereBT;
    @FXML
    private TextField newPrixInitialTF;
    @FXML
    private Button updateEnchereBT;
    @FXML
    private Button addenchereBT;
    @FXML
    private TableColumn<Enchere, Integer> prixTF;
    @FXML
    private TableColumn<Enchere, Date> dateTF;
    @FXML
    private TableColumn<Enchere, Integer> produitTF;
    @FXML
    private TextField dateFermetureTF;
    @FXML
    private TextField newProduitTF;
    

     List <Enchere> enchereList;
     int index = -1;
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EnchereService enchereService = new EnchereService();
        enchereList = enchereService.getEncheres();
        ObservableList<Enchere> encheres = FXCollections.observableList(enchereList);
        
        prixTF.setCellValueFactory(new PropertyValueFactory<>("prix_initiale"));
        dateTF.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
        produitTF.setCellValueFactory(new PropertyValueFactory<>("produit"));
        
        EnchereDetailsTable.setItems(encheres);

    }  
    
    @FXML
    void deleteEnchere(MouseEvent event) {

    }

    @FXML
    void updateEnchere(MouseEvent event) {

         
            
    }

    @FXML
    private void selectedEnchere(MouseEvent event) {
        
       index = EnchereDetailsTable.getSelectionModel().getSelectedIndex();
         
        if(index<= -1){
            return;
        }
        newPrixInitialTF.setText(prixTF.getCellData(index).toString());
        dateFermetureTF.setText(dateTF.getCellData(index).toString());
        newProduitTF.setText(produitTF.getCellData(index).toString());
    }

    @FXML
    private void addEnchere(MouseEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("AddEnchere.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();        
    }

}

