/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FXMain1 extends Application {
    
 @Override
public void start(Stage primaryStage) throws IOException {

try {
Parent root=FXMLLoader.load(getClass().getResource("FXMLBlog1.fxml"));

Scene scene = new Scene(root);

primaryStage.setTitle("Antika");
primaryStage.setScene(scene);
primaryStage.show();
} catch (IOException ex) {
Logger.getLogger(FXMain1.class.getName()).log(Level.SEVERE, null, ex);
}

//Parent root=FXMLLoader.load(getClass().getResource("FXMLCommenatire1.fxml"));
//Scene scene = new Scene(root1);

//primaryStage.setTitle("Antika");
//primaryStage.setScene(scene);
//primaryStage.show(); //
}
    public static void main(String[] args) {
        launch(args);
    }
    
}