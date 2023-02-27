/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Livraison;
import Models.Panier;
import Models.User;
import Services.LivraisonService;
import Services.PanierService;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
public class AjoutLivraisonController implements Initializable {
 @FXML
    private ListView<Panier> listview;
    @FXML
    private Text error;
    @FXML
    private TextField adresse;
    @FXML
    private DatePicker datelivraison;
    
    PanierService panierService= new PanierService();
    UserService userService= new UserService();
    LivraisonService livraisonService= new LivraisonService();
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
    private void AjoutLivraison(MouseEvent event) throws SQLException {
        error.setText("");
        User user = userService.getUser(1);
        if(panierService.getPanier(1).size()>0){
            if(!adresse.getText().isEmpty() && datelivraison.getValue()!=null){
                Date dateLiv = new Date(Date.valueOf(datelivraison.getValue()).getTime());
                Livraison livraison = new Livraison(adresse.getText(), "En cours", user, dateLiv);
                livraisonService.AjouterLivraison(livraison);
            }
            else{
                error.setText("Vous devez remplir tout les champs");
            }
        }else{
            error.setText("Votre panier est vide");
        }
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
