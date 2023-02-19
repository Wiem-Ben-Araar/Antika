/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilities.MaConnexion;
import java.net.URL;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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
    private ObservableList<String> drop_list = FXCollections.observableArrayList("Artiste","Client");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice_box.setItems(drop_list);
    }

    

    @FXML
    private void btn_créermoncompte(ActionEvent event) throws SQLException {
      MaConnexion cnx=new MaConnexion();
      String requete="insert into user (nom,prenom,email,telephone,adresse,type,mot_de_passe)values(?,?,?,?,?,?,?)";
       
      pst=cnx.cnx.prepareStatement(requete);
        pst.setString(1,tf_nom.getText());
        pst.setString(2,tf_prenom.getText());
        pst.setString(3,tf_email.getText());
         pst.setString(4,tf_telephone.getText());
          pst.setString(5,tf_adresse.getText());
          pst.setString(6,choice_box.getValue());
           pst.setString(7,tf_motedepasse.getText());
           
            
        pst.execute();  
    }
  

    
 
        }    

  

   
    
    

