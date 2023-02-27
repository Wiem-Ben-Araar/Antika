/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Livraison;
import Services.LivraisonService;
import Models.Panier;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author shily
 */
public class AffichageLivraisonController implements Initializable {

    @FXML
    private ListView<Livraison> listview;
    
    @FXML
    private Text error;
    
    
    LivraisonService livraisonService= new LivraisonService();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         listview.getItems().addAll(livraisonService.GetLivraison(1));
listview.setCellFactory(lv -> new ListCell<Livraison>() {
    @Override
    public void updateItem(Livraison livraison, boolean empty) {
        super.updateItem(livraison, empty) ;
        setText(empty ? null : livraison.getStatut()+"    "+livraison.getDate_livraison()+"       "+livraison.getTotal()+"TND");
    
    }
});
    }    

    @FXML
    private void GoPanier(MouseEvent event) throws IOException {
        
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/AffichagePanier.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }

    @FXML
    private void GoLivraison(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/AffichageLivraison.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }

    @FXML
    private void GoModifierLivraison(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/ModifierLivraison.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }

    @FXML
    private void GoAjoutLivraison(MouseEvent event) throws IOException {
      Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/AjoutLivraison.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();  
    }
    
    @FXML
    private void VoirAdresse(MouseEvent event) throws URISyntaxException, IOException {
        error.setText("");
         if(listview.getSelectionModel().getSelectedItem()!=null){
             Livraison livraison = listview.getSelectionModel().getSelectedItem();
              Desktop.getDesktop().browse(new URI("https://www.google.com/maps/dir/Mourouj1/"+livraison.getAdresse()));
         }else{
             error.setText("Vous devez choisir une livraison");
         }
    }
    
}
