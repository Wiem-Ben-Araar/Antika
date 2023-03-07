/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;
import Models.Enchere;
import Models.Evenement;
import Models.Mise;
import Models.Produit;
import Models.User;
import Services.EnchereService;
import Services.EvenementService;
import Services.UserService;
import Utilities.Type;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import Services.ProduitService;

public class DisplayEncheresController implements Initializable {

    @FXML
    private ListView<Enchere> EnchereDetailsList;

    @FXML
    private Button miser;  

    private Enchere selectedEnchere;
    private EnchereService enchereService;
    private List <Enchere> enchereList;
    private ProduitService produitService;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       enchereService = new EnchereService();
        enchereList = enchereService.getEncheres();

        for(Enchere enchere: enchereList) {
            EnchereDetailsList.getItems().add(enchere);
        }

        EnchereDetailsList
            .getSelectionModel()
            .selectedItemProperty()
            .addListener((ObservableValue<? extends Enchere> observable, Enchere oldValue, Enchere newValue) -> {
                selectedEnchere = newValue;
            });
    }
    
@FXML
    private void selectedEnchere(MouseEvent event) throws IOException {     
    
}
        
    

    
           // DisplayEncheresController
    @FXML
    private void placerMise(MouseEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("mise.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // passer l'enchere à l'écran suivante
        stage.setUserData(selectedEnchere);

        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();*/
       
         Parent root = FXMLLoader.load (getClass().getResource("../GUI/mise.fxml"));
       // Parent root = loader.load();
       Scene scene = new Scene(root);
        Stage stage = new Stage();
        //MiseController controller = FXMLLoader.load().getController();
        
        stage.setUserData(selectedEnchere);
        stage.setScene(scene);
        stage.show();
    }

    private void sendData(ActionEvent event) throws IOException {
     
    }
    
}

