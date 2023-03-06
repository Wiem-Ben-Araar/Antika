/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Reclamation;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Dali
 */
public class AfficheReclamationController implements Initializable {

    @FXML
    private ListView<Reclamation> lview;
    public static int b ;
   // private Text info;

 ReclamationService ps = new ReclamationService();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Associer la liste observable au ListView
        List<Reclamation> a = new ArrayList();
        a = ps.afficherReclamationbyId(MarketController.a);
        lview.getItems().addAll(a);
        lview.setCellFactory(lv -> new ListCell<Reclamation>() {
    
            @Override
            public void updateItem(Reclamation avis, boolean empty) {
        super.updateItem(avis, empty) ;
        setText(empty ? null : "Commentaire : " +avis.getDescription()+" **Email : "+avis.getEmail()+" **Date : "+avis.getDate()+" **Note : " +avis.getNote());
    
    }
    });  
    }


    @FXML
    private void supprimerreclamation(MouseEvent event) {
        
         if(lview.getSelectionModel().getSelectedItem()!=null){
            Reclamation avis = lview.getSelectionModel().getSelectedItem();
            ps.supprimerReclamation(avis.getId_Reclamation());
           // info.setText("Reclamation supprimée");
             lview.getItems().clear();
             System.out.println("supp");
        lview.getItems().addAll(ps.afficherReclamationbyId(MarketController.a));
        lview.setCellFactory(lv -> new ListCell<Reclamation>() {
            
   
    @Override
    public void updateItem(Reclamation avis, boolean empty) {
        super.updateItem(avis, empty) ;
        setText(empty ? null : avis.getDescription()+"    "+avis.getEmail()+"  "+avis.getDate()+"  " +avis.getNote());
    
    }
});
        }else{
           // info.setText("Il faut choisir une Reclamation");
        }
    }

    @FXML
    private void modifierreclamation(MouseEvent event) {
            try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierReclamation.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void chercherreclamation(MouseEvent event) {
    }


    
}
