/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Livraison;
import Services.LivraisonService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    private void ValiderLivraison(MouseEvent event) {
        error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            Livraison livraison =listview.getSelectionModel().getSelectedItem();
            livraison.setStatut("Livrée");
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
    private void GoUser(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLListUser.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoAvis(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLListAvis.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoReclamation(ActionEvent event) throws IOException {
          Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AfficheReclamation.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoBlog(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLBlogComment.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoPanier(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AffichagePanier.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoLivraison(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AffichageLivraison.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoEvenement(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AcceuilEvenement.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoProduit(ActionEvent event) throws IOException {
          Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/MarketProduit.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoExpertise(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLModifierExpertise.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoEnchere(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/enchereAcceuil.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }
    
}
