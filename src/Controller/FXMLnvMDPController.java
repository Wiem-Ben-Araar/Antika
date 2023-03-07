/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.User;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLnvMDPController implements Initializable {

    @FXML
    private TextField amdp;
    @FXML
    private TextField cmdp;
    @FXML
    private TextField nmdp;
    @FXML
    private TextField email;
    @FXML
    private Text info;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier(MouseEvent event) {
        UserService userService= new UserService();
        info.setText("");
        if(!amdp.getText().isEmpty() && !cmdp.getText().isEmpty() && !nmdp.getText().isEmpty() && !email.getText().isEmpty() ){
            if(userService.afficherUserbyEmail(email.getText())!=null){
                User user = userService.afficherUserbyEmail(email.getText());
                if(user.getMot_de_passe().equals(amdp.getText())){
                    if(nmdp.getText().equals(cmdp.getText())){
                        user.setMot_de_passe(nmdp.getText());
                    userService.modifierUser(user.getId_user(), user);
                    info.setText("mot de passe modifier");
                    }else{
                        info.setText("confirmation mot de passe incorrect");
                    }
                }else{
                    info.setText("mot de passe incorrect");
                }
                
            }else {
                 info.setText("Email n'existe pas");
            }
            
        }else{
            info.setText("Il faut remplir tout les champs");
        }
    }

    @FXML
    private void revenir_login(MouseEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXML.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();   
    }
    
}
