/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.ReclamationInterface;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Reclamation;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Dali
 */
public class ModifierReclamationController implements Initializable {
    @FXML
    private TextField idrTF;
    @FXML
    private TextField descTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField dateTF;
    @FXML
    private TextField idPTF;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void modifierReclamation(ActionEvent event) {
                        LocalDate localDate = LocalDate.now();
           		if ( idrTF.getText().isEmpty()){

			Alert al = new Alert(Alert.AlertType.INFORMATION);
			al.setTitle("Controle de saisie");
			al.setHeaderText("Erreur de saisie !");
			al.setContentText("Entrer l'ID et les champs qui veut modifier !");
			al.show();
		}
                        else
                
                {
                        ReclamationInterface rs = new ReclamationService();
        Reclamation r = new Reclamation();
        
        r.setDescription(descTF.getText());
        r.setEmail(emailTF.getText());
        r.setId(Integer.parseInt(idPTF.getText()));
        r.setDate(Date.valueOf(localDate));  
        rs.modifierReclamation(r, Integer.valueOf(idrTF.getText()));
    }
    
    }
}
