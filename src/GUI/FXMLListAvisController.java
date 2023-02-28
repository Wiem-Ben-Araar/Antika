/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Avis;
import Models.User;
import Services.AvisService;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemb
 */

public class FXMLListAvisController implements Initializable {
@FXML
    private ListView<Avis> lview;
private AvisService avisService = new AvisService();
    @FXML
    private Text info;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Associer la liste observable au ListView
        List<Avis> a = new ArrayList();
        a = avisService.afficherAvis();
        lview.getItems().addAll(a);
        lview.setCellFactory(lv -> new ListCell<Avis>() {
    @Override
    public void updateItem(Avis avis, boolean empty) {
        super.updateItem(avis, empty) ;
        setText(empty ? null : avis.getCommentaire()+"    "+avis.getNote());
    
    }
});
    } 

    @FXML
    private void btn_supprimer(MouseEvent event) {
         if(lview.getSelectionModel().getSelectedItem()!=null){
            Avis avis = lview.getSelectionModel().getSelectedItem();
            avisService.supprimerAvis(avis.getId_avis());
            info.setText("Avis supprimé");
             lview.getItems().clear();
        lview.getItems().addAll(avisService.afficherAvis());
        lview.setCellFactory(lv -> new ListCell<Avis>() {
            
    public void updateItem(Avis avis, boolean empty) {
        super.updateItem(avis, empty) ;
        setText(empty ? null : avis.getCommentaire()+"    "+avis.getNote());
    
    }
});
        }else{
            info.setText("Il faut choisir un utilisateur");
        }
    }

  

    @FXML
    private void btn_ajouter(MouseEvent event) throws IOException {
         Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLAvis.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
    } 

