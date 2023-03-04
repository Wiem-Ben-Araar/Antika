/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.ItemController;
import Interfaces.MyListener;
import Models.User;
import Services.UserService;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class MarketController implements Initializable {
       @FXML
    private Label adresse;
      @FXML
    private Label email;
       @FXML
    private Label nom;
      @FXML
    private Label prenom;


    @FXML
    private GridPane grid;
    
    
    

    private List<User> users = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    UserService gs = new UserService();
    @FXML
    private Button supprimer;
    @FXML
    private Button profile;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private TextField nomField;
    @FXML
    private ScrollPane scrollPane;

    private List<User> getData() {
        List<User> users = new ArrayList<>();
        
        users =gs.afficherUser();
        
        

        return users;
    }

    private void setChosenU(User p) {
      
      //image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //fruitImg.setImage(image);
        nom.setText(p.getNom());
        prenom.setText(p.getPrenom());
        email.setText(p.getEmail());
        adresse.setText(p.getAdresse());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        users.addAll(getData());
        if (users.size() > 0) {
            setChosenU(users.get(0));
            myListener = new MyListener() {
               

                @Override
                public void onClickListener(User u) {
                         setChosenU(u);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(users.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
    }

    @FXML
    private void profile(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProfil.fxml"));
            Scene scene = new Scene(root);
            Stage stage;
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show(); 
        
    }



@FXML
private void btn_recherche(MouseEvent event) {
    
}


}



