/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.User;
import Services.UserService;
import Utilities.Type;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLListUserController implements Initializable {
@FXML
    private ListView<User> lview;
private UserService userService = new UserService();

    @FXML
    private Text info;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Associer la liste observable au ListView
        List<User> users = new ArrayList();
        users = userService.afficherUser();
        lview.getItems().addAll(users);
        lview.setCellFactory(lv -> new ListCell<User>() {
    @Override
    public void updateItem(User user, boolean empty) {
        super.updateItem(user, empty) ;
        setText(empty ? null : user.getNom()+"    "+user.getPrenom());
    
    }
});
      
    } 

    @FXML
    private void AjoutUser(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLCreate.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }

    @FXML
    private void SupprimerUser(MouseEvent event) {
        if(lview.getSelectionModel().getSelectedItem()!=null){
            User user = lview.getSelectionModel().getSelectedItem();
            userService.supprimerUser(user.getId_user());
            info.setText("Utilisateur supprimé");
             lview.getItems().clear();
        lview.getItems().addAll(userService.afficherUser());
        lview.setCellFactory(lv -> new ListCell<User>() {
    @Override
    public void updateItem(User user, boolean empty) {
        super.updateItem(user, empty) ;
        setText(empty ? null : user.getNom()+"    "+user.getPrenom());
    
    }
});
        }else{
            info.setText("Il faut choisir un utilisateur");
        }
    }
    
}
