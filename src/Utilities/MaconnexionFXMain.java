/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dridi
 */
public class MaconnexionFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      try {
Parent root=FXMLLoader.load(getClass().getResource("../GUI1/FXMLCommentaire1.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("FXMLCommentaire1");
        primaryStage.setScene(scene);
        primaryStage.show();
   } catch (IOException ex) {
System.out.println("Err"+ex.getMessage());
ex.printStackTrace();
}
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
