/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Panier;
import Services.PanierService;
import java.io.IOException;
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
public class SuppressionPanierController implements Initializable {

    @FXML
    private Text error;
    @FXML
    private ListView<Panier> listview;

    /**
     * Initializes the controller class.
     */
  PanierService panierService= new PanierService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      listview.getItems().addAll(panierService.getPanier(1));
listview.setCellFactory(lv -> new ListCell<Panier>() {
    @Override
    public void updateItem(Panier panier, boolean empty) {
        super.updateItem(panier, empty) ;
        setText(empty ? null : panier.getProduit().getTitre()+"   "+panier.getProduit().getPrix()+"TND     X"+panier.getQuantite()+"      "+panier.getTotal()+"TND");
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
    private void GoLivraison(MouseEvent event) {
        
    }

    @FXML
    private void SupprimerPanier(MouseEvent event) {
         error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            panierService.supprimerP(listview.getSelectionModel().getSelectedItem().getId_panier());
            listview.getItems().clear();
             listview.getItems().addAll(panierService.getPanier(1));
listview.setCellFactory(lv -> new ListCell<Panier>() {
    @Override
    public void updateItem(Panier panier, boolean empty) {
        super.updateItem(panier, empty) ;
        setText(empty ? null : panier.getProduit().getTitre()+"   "+panier.getProduit().getPrix()+"TND     X"+panier.getQuantite()+"      "+panier.getTotal()+"TND");
    }
});
        }else{
            error.setText("Vous devez choisir un produit");
        }
    }
    
}
