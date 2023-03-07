/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ReclamationInterface;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import Models.Reclamation;
import org.controlsfx.control.Rating;
import Services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Dali
 */
public class AjoutReclamationController implements Initializable {

    @FXML
    private TextField descTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField idPTF;
    @FXML
    private TextField dateTF;
    @FXML
    private Rating notetf;

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
    private void ajouterReclamation(ActionEvent event) 
    {
        String commentText = descTF.getText();
            LocalDate localDate = LocalDate.now();
		if (descTF.getText().isEmpty() || emailTF.getText().isEmpty() ) 
                {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setTitle("Controle de saisie");
                    al.setHeaderText("Erreur de saisie !");
                    al.setContentText("Les données sont vides !");
                    al.show();
		}
                else if (commentText.toLowerCase().contains("fuck") || commentText.toLowerCase().contains("pute") || commentText.toLowerCase().contains("merde") || commentText.toLowerCase().contains("salot")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur");
                            alert.setHeaderText(null);
                            alert.setContentText("Veuillez respecter les ethiques de notre communité");
                            alert.showAndWait();
        }
                else
                {
                    ReclamationInterface rs = new ReclamationService();
                    Reclamation r = new Reclamation();
                    r.setDescription(descTF.getText());
                    r.setEmail(emailTF.getText());
                    r.setId(MarketProduitController.a);
                    r.setDate(Date.valueOf(localDate));  
                    r.setNote((int) notetf.getRating());
                    rs.addReclamation(r); 
                }
    }

}
