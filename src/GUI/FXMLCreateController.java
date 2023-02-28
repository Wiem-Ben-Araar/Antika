package GUI;

import Models.User;
import Services.UserService;
import Utilities.MaConnexion;
import Utilities.Type;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLCreateController implements Initializable {
      PreparedStatement pst;
   
    
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_telephone;
    @FXML
    private TextField tf_adresse;
    @FXML
    private TextField tf_motedepasse;
    @FXML
    private ChoiceBox<String> choice_box;
        @FXML
    private Text erreur;
        private boolean status;
    private ObservableList<String> drop_list = FXCollections.observableArrayList("ARTISTE","CLIENT");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice_box.setItems(drop_list);
        
    }

    

    @FXML
    private void btn_créermoncompte(ActionEvent event) throws SQLException {
        UserService us = new UserService();
         status = true;
         if(!tf_email.getText().contains("@gmail"))
         { status = false;
             erreur.setText("Verifier l'email");
         }
         if(tf_nom.getText().isEmpty()||tf_email.getText().isEmpty()||tf_telephone.getText().isEmpty()||tf_adresse.getText().isEmpty()||tf_motedepasse.getText().isEmpty()||tf_prenom.getText().isEmpty()){
             status = false;
             erreur.setText("Verifier les informations");
         }
         if(status){
             erreur.setText("");
               User user = new User(tf_nom.getText(), tf_prenom.getText(), tf_email.getText(), tf_telephone.getText(), tf_adresse.getText(), Type.valueOf(choice_box.getValue()), tf_motedepasse.getText());
        us.ajouterUser2(user);
        System.out.println("User ajouté ");
         }
      
       
        
    }

    @FXML
    private void btn_revenirlogin(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("FXML.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();   
    }
  

    
 
        }    

