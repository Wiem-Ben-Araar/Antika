/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Panier;
import Services.LivraisonService;
import Services.PanierService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.management.resource.internal.TotalResourceContext;

/**
 * FXML Controller class
 *
 * @author shily
 */
public class AffichagePanierController implements Initializable {

    @FXML
    private ListView<Panier> listview;
    @FXML
    private Text error;

    LivraisonService livraisonService= new LivraisonService();
    PanierService panierService= new PanierService();
    @FXML
    private Label total1;
    double resultat = panierService.sommeProduit(1);
    @FXML
    private Label tot;
    @FXML
    private Text remise;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      listview.getItems().addAll(panierService.getPanier(1));
      resultat = panierService.sommeProduit(1);
      
      if(livraisonService.CountLivraison(1)>9){
          remise.setText("Vous avez eu une remise de 20% aprés votre 10éme commande");
          resultat = (resultat*80)/100;
          
      }
          total1.setText(resultat+"");
listview.setCellFactory(lv -> new ListCell<Panier>() {
    @Override
    public void updateItem(Panier panier, boolean empty) {
        super.updateItem(panier, empty) ;
        setText(empty ? null : panier.getProduit().getNom()+"   "+panier.getProduit().getPrix()+"TND     X"+panier.getQuantite()+"      "+panier.getTotal()+"TND");

    }
});
    }    

    @FXML
    private void Decrement(MouseEvent event) {
        error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            Panier selectedPanier = listview.getSelectionModel().getSelectedItem();
            panierService.decrementQuantite(selectedPanier);
            resultat = panierService.sommeProduit(1);
      
      if(livraisonService.GetLivraison(1).size()>9){
          remise.setText("Vous avez eu une remise de 20% aprés votre 10éme commande");
          resultat = (resultat*80)/100;
          
      }
          total1.setText(resultat+"");
            listview.getItems().clear();
             listview.getItems().addAll(panierService.getPanier(1));
listview.setCellFactory(lv -> new ListCell<Panier>() {
    @Override
    public void updateItem(Panier panier, boolean empty) {
        super.updateItem(panier, empty) ;
        setText(empty ? null : panier.getProduit().getNom()+"   "+panier.getProduit().getPrix()+"TND       X"+panier.getQuantite()+"        "+panier.getTotal()+"TND");
    }
});
        }
        else{
            error.setText("Vous devez choisir un produit");
        }
    }

    @FXML
    private void Increment(MouseEvent event) {
         error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            System.out.println(listview.getSelectionModel().getSelectedItem());
            Panier selectedPanier = listview.getSelectionModel().getSelectedItem();
            panierService.incrementQuantite(selectedPanier);
            resultat = panierService.sommeProduit(1);
      
      if(livraisonService.GetLivraison(1).size()>9){
          remise.setText("Vous avez eu une remise de 20% aprés votre 10éme commande");
          resultat = (resultat*80)/100;
          
      }
          total1.setText(resultat+"");
            listview.getItems().clear();
             listview.getItems().addAll(panierService.getPanier(1));
listview.setCellFactory(lv -> new ListCell<Panier>() {
    @Override
    public void updateItem(Panier panier, boolean empty) {
        super.updateItem(panier, empty) ;
        setText(empty ? null : panier.getProduit().getNom()+"   "+panier.getProduit().getPrix()+"TND     X"+panier.getQuantite()+"      "+panier.getTotal()+"TND");
    }
});
        }
        else{
            error.setText("Vous devez choisir un produit");
        }
        
    }

    @FXML
    private void GoAjoutPanier(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/AjoutPanier.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();

    }

    @FXML
    private void GoSupprimerPanier(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/SuppressionPanier.fxml"));
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
