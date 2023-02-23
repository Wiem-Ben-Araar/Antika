/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import Models.Commentaire;
import Service.BlogService;
import Service.CommentaireService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dridi
 */
public class FXMLCommentaire1Controller implements Initializable {

    @FXML
    private TextField commentaire;
    @FXML
    private VBox afficherCommentaire;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
               
    }    

    @FXML
    private void envoyerCommentaire(ActionEvent event) {
        Commentaire c=new Commentaire(commentaire.getText()); 
        CommentaireService b=new CommentaireService();
        b.AjouterCommentaire(c);
    }

    @FXML
    private void supprimer(ActionEvent event) {
         Commentaire c=new Commentaire(commentaire.getText()); 
        CommentaireService b=new CommentaireService();
        b.SupprimerCommentaire1(Integer.parseInt(commentaire.getText()));
    }

    @FXML
    
    private void modifier(ActionEvent event) {
         Commentaire c=new Commentaire(commentaire.getText()); 
        CommentaireService b=new CommentaireService();
        b.ModifierCommentaire(c,53);

    }
    
    
}
