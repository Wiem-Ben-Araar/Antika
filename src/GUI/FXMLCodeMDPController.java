/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.UserService;
import Models.User;
import Utilities.MaConnexion;
import java.io.IOException;


import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.PasswordAuthentication;


/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class FXMLCodeMDPController implements Initializable {

    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label statusLabel;
 PreparedStatement pst;
    ResultSet rs;
    
   MaConnexion cnx=new MaConnexion(); 
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void SendCodeButton(String recepient) {
      
    }

   @FXML
private void SendCodeButton(MouseEvent event) {
    String email = emailField.getText();
    
    UserService userService = new UserService();
    User user = userService.afficherUserbyEmail(email);
    
    if (!email.isEmpty()) {
        // Créer une session JavaMail avec les informations du compte de messagerie
        String username = "wbenaraar@gmail.com";
        String password = "svxayesbenklvobs";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Générer un code aléatoire
            Random random = new Random();
            int code = 100000 + random.nextInt(900000);
            String codeStr = Integer.toString(code);

            // Créer un message de récupération de mot de passe
            String subject = "Récupération de mot de passe";
            String messageBody = "Bonjour,\n\n" +
                    "Voici votre code :" + codeStr + "\n\n"+
                    "Cordialement,\n" +
                    "Antika";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(messageBody);

            // Mettre à jour le mot de passe dans la base de données
            user.setMot_de_passe(codeStr);
            userService.modifierUser(user.getId_user(), user);

            // Envoyer le message
            Transport.send(message);

            // Afficher un message de confirmation à l'utilisateur
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Un e-mail de récupération de mot de passe a été envoyé à " + email);
            alert.showAndWait();

        } catch (MessagingException e) {
            // Afficher un message d'erreur si l'envoi du message échoue
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Impossible d'envoyer l'e-mail de récupération de mot de passe. Veuillez réessayer plus tard.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
}


    @FXML
    private void ModifierMotDePasse(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLnvMDP.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
}