package Controller;

import Models.User;
import Services.UserService;
import Utilities.MaConnexion;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private PasswordField tf_confirmermotdepasse;

        @FXML
    private Text erreur;
        private boolean status;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField id;
   public static int p;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    

 @FXML
private void btn_créermoncompte(ActionEvent event) throws SQLException, IOException {
    UserService us = new UserService();
    status = true;
    if (!tf_email.getText().contains("@")) {
        status = false;
        erreur.setText("Verifier l'email");
    }
    if (tf_nom.getText().isEmpty() || tf_email.getText().isEmpty() || tf_telephone.getText().isEmpty()
            || tf_adresse.getText().isEmpty() || tf_motedepasse.getText().isEmpty() || tf_prenom.getText().isEmpty()
            || tf_confirmermotdepasse.getText().isEmpty() || !tf_motedepasse.getText().equals(tf_confirmermotdepasse.getText())) {
        status = false;
        erreur.setText("Verifier les informations");
    }

    if (us.userExiste(tf_email.getText())) {
        status = false;
        erreur.setText("Cet email est déjà utilisé");
    }

    if (status) {
        erreur.setText("");
        User user = new User(tf_nom.getText(), tf_prenom.getText(), tf_email.getText(), tf_telephone.getText(),
                tf_adresse.getText(), "ROLE_USER", tf_motedepasse.getText());
        us.ajouterUser2(user);
        System.out.println("User ajouté ");
          Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLWelcome.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }
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
    private void btn_modifier(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader ();
          loader.setLocation(getClass().getResource("../GUI/FXMLModifierCreate.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
                            FXMLModifierCreateController ModifierUserController = loader.getController();
                            ModifierUserController.setTextField(tf_nom.getText(),tf_prenom.getText(),tf_email.getText(),tf_telephone.getText(),tf_adresse.getText(), tf_motedepasse.getText());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            p = Integer.valueOf(id.getText());
        
    }
  

   
 
        }    

