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
import org.controlsfx.control.Rating;

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
    private Rating tf_note;

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
    private void btn_envoyer(ActionEvent event) throws SQLException {  
        MaConnexion cnx=new MaConnexion();
      String requete="insert into avis (commentaire,note)values(?,?)";
       
      pst=cnx.cnx.prepareStatement(requete);
        pst.setString(1,tf_commentaire.getText());
        pst.setInt(2,(int)tf_note.getRating());
         System.out.println();
        
            
        pst.execute();  
    }
    
}