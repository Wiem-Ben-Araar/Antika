/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Livraison;
import Services.LivraisonService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shily
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    private ListView<Livraison> listview;
    @FXML
    private Text error;
    @FXML
    private TextField adresse;
    @FXML
    private DatePicker datelivraison;

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
    private void ModifierLivraison(MouseEvent event) {
        error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            Livraison livraison =listview.getSelectionModel().getSelectedItem();
             if(!adresse.getText().isEmpty() && datelivraison.getValue()!=null){
                Date dateLiv = new Date(Date.valueOf(datelivraison.getValue()).getTime());
                livraison.setAdresse(adresse.getText());
                livraison.setDate_livraison(dateLiv);
                livraisonService.ModifierLivraison(livraison,livraison.getId_livraison());
                
             }
             else if(!adresse.getText().isEmpty() && datelivraison.getValue()==null){
                 livraison.setAdresse(adresse.getText());
                livraisonService.ModifierLivraison(livraison,livraison.getId_livraison());
             }
             else if(adresse.getText().isEmpty() && datelivraison.getValue()!=null){
                 Date dateLiv = new Date(Date.valueOf(datelivraison.getValue()).getTime());
                livraison.setDate_livraison(dateLiv);
                livraisonService.ModifierLivraison(livraison,livraison.getId_livraison()); 
             }
             else{
                 error.setText("Vous devez remplir au moin un champ");
             }
             listview.getItems().clear();
              listview.getItems().addAll(livraisonService.GetLivraison(1));
listview.setCellFactory(lv -> new ListCell<Livraison>() {
    @Override
    public void updateItem(Livraison livraison, boolean empty) {
        super.updateItem(livraison, empty) ;
        setText(empty ? null : livraison.getStatut()+"    "+livraison.getDate_livraison()+"       "+livraison.getTotal()+"TND");
    
    }
});
        }else{
             error.setText("Vous devez choisir une livraison");
        }
        
    }
    @FXML
    private void AnnulerLivraison(MouseEvent event) {
        error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            Livraison livraison =listview.getSelectionModel().getSelectedItem();
            livraison.setStatut("Annulée");
             livraisonService.ModifierLivraison(livraison,livraison.getId_livraison());
             listview.getItems().clear();
               listview.getItems().addAll(livraisonService.GetLivraison(1));
listview.setCellFactory(lv -> new ListCell<Livraison>() {
    @Override
    public void updateItem(Livraison livraison, boolean empty) {
        super.updateItem(livraison, empty) ;
        setText(empty ? null : livraison.getStatut()+"    "+livraison.getDate_livraison()+"       "+livraison.getTotal()+"TND");
    
    }
});
        }else{
            error.setText("Vous devez choisir une livraison");
        }
    }
        @FXML
    private void GetValeurs(MouseEvent event) {
        Livraison livraison =listview.getSelectionModel().getSelectedItem();
        adresse.setText(livraison.getAdresse());
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


    


    
}
