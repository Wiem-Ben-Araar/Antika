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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLAvisController implements Initializable {
  PreparedStatement pst;
    @FXML
    private TextField tf_commentaire;
    @FXML
    private TextField tf_note;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_envoyer(ActionEvent event) throws SQLException {  //Mezel mayekhdemch l bouton envoyer
        MaConnexion cnx=new MaConnexion();
      String requete="insert into avis (commentaire,note)values(?,?)";
       
      pst=cnx.cnx.prepareStatement(requete);
        pst.setString(1,tf_commentaire.getText());
        pst.setString(2,tf_note.getText());
        
            
        pst.execute();  
    }
    
}
