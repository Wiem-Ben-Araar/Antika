package GUI;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
//
/**
 *
 * @author wiemb
 */
public class NewFXMain extends Application {
   
    @Override
    public void start(Stage primaryStage) throws IOException {
     
        try {
            Parent root=FXMLLoader.load(getClass().getResource("Market.fxml"));
           
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Antika");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
       
      
         Parent root2=FXMLLoader.load(getClass().getResource("FXMLAvis.fxml"));
         Scene scene = new Scene(root2);
          primaryStage.setTitle("Antika");
            primaryStage.setScene(scene);
            primaryStage.show();
      */     
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
