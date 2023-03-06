/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package antika;


import Models.User;
import Services.UserService;
import Utilities.Type;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nadab
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       
        User currentUser = new User();
        currentUser.setId_user(1);
        currentUser.setType(Type.ARTISTE);
        currentUser.setEmail("nada.bkh@gmail.com");
        currentUser.setNom("Nada");

        UserService userService = new UserService();
        userService.login(currentUser);
       
     
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/enchereAcceuil.fxml"));
           Scene scene = new Scene(root);
            primaryStage.setTitle("Antika"); 
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
