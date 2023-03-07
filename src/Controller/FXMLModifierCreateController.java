/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.User;
import Services.UserService;
import Utilities.Type;
import java.io.File;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLModifierCreateController implements Initializable {

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
    private ChoiceBox<?> choice_box;
    @FXML
    private PasswordField tf_motedepasse;
    @FXML
    private Text erreur;
    @FXML
    private PasswordField tf_confirmermotdepasse;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void btn_revenirlogin(ActionEvent event) throws IOException {
             Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXML.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();  
    }

    @FXML
    private void btn_insert_image(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        // Set the file filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "."));
        
        // Show the dialog and wait for the user to select a file
        File file = fileChooser.showOpenDialog(imageView.getScene().getWindow());
            

        // If a file was selected, load it into the ImageView
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } 
    }

    @FXML
    private void btn_modifier(ActionEvent event) {
        User u = new User();

        UserService  psd = new UserService ();
        u.setNom(tf_nom.getText());
        u.setPrenom(tf_prenom.getText());
        u.setEmail(tf_email.getText());
        u.setTelephone(tf_telephone.getText());
        u.setMot_de_passe(tf_motedepasse.getText());
        u.setConfirmer_motdepasse(tf_confirmermotdepasse.getText());
  
  // psd.modifierUser(u.getId(), u);
        
    }
  void setTextField(String nom, String prenom, String email,String telephone,String adresse,String mot_de_passe,String confirmer_motdepasse) {

        tf_nom.setText(nom);
        tf_prenom.setText(prenom);
        tf_email.setText(email);
        tf_telephone.setText(telephone);
        tf_adresse.setText(adresse);
        tf_motedepasse.setText(mot_de_passe);
       tf_confirmermotdepasse.setText (confirmer_motdepasse);

    }  
}
