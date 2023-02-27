/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Panier;
import Models.Produit;
import Models.User;
import Services.PanierService;
import Services.ProduitService;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class AjoutPanierController implements Initializable {


    @FXML
    private ListView<Produit> listview;
    @FXML
    private Text error;

    PanierService panierService= new PanierService();
    ProduitService produitService= new ProduitService();
    UserService userService= new UserService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listview.getItems().addAll(produitService.getAllProduit());
listview.setCellFactory(lv -> new ListCell<Produit>() {
    @Override
    public void updateItem(Produit produit, boolean empty) {
        super.updateItem(produit, empty) ;
        setText(empty ? null : produit.getTitre()+"   "+produit.getPrix()+"TND");
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
    private void AjoutProduitPanier(MouseEvent event) throws SQLException {
         error.setText("");
        if(listview.getSelectionModel().getSelectedItem()!=null){
            Produit produit = listview.getSelectionModel().getSelectedItem();
        User user = userService.getUser(1);
        if(panierService.getPanierUserProduit(user.getId_user(), produit.getId_produit()).getId_panier()>0){
            System.out.println(panierService.getPanierUserProduit(user.getId_user(), produit.getId_produit()));
            error.setText("le produit existe déjà dans votre panier");
        }
        else{
            Panier panier=new Panier(1, user, produit);
            panierService.ajouter(panier);
        }
        }
        else{
            error.setText("Vous devez selecionner un produit");
        }
        
    }
    
}
