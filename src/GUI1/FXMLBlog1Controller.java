/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import Models.Blog;
import Service.BlogService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dridi
 */
public class FXMLBlog1Controller implements Initializable {

    @FXML
    private Label tf_titre;
    @FXML
    private TextField titre;
    @FXML
    private TextField artiste;
    @FXML
    private TextField contenu;
    @FXML
    private TextField etiquette;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TO
    }    

    @FXML
    private void btn_envoyer(ActionEvent event) {
        BlogService s=new BlogService();
        contenu.getText();
        artiste.getText();
        etiquette.getText();
        titre.getText();
        Blog b=new Blog(titre.getText(),artiste.getText(),contenu.getText(),etiquette.getText());
        s.AjouterBlog(b);
    }
    
}
