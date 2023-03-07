/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.ItemController;
import Interfaces.MyListener;
import Models.Panier;
import Models.Produit;
import Models.User;
import Services.UserService;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
    private VBox chosenFruitCard;
    @FXML
    private TextField nomField;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label id;
    private User selectedUser ;
    public   static int p;

    private List<User> getData() {
        List<User> users = new ArrayList<>();
        
        users =gs.afficherUser();
        
        

        return users;
    }

    private void setChosenU(User u) {
      
      //image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //fruitImg.setImage(image);
        nom.setText(u.getNom());
        prenom.setText(u.getPrenom());
        email.setText(u.getEmail());
        adresse.setText(u.getAdresse());
        id.setText(Integer.toString(u.getId_user()));
        p=Integer.valueOf(id.getText());
        
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
                         selectedUser=u;
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../GUI/item.fxml"));
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
    private void supprimer(ActionEvent event) throws IOException {
        
        if(selectedUser.getId_user()>0){
            gs.supprimerUser(selectedUser.getId_user());
             Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/Market.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
        }
        
    }
    @FXML
private void btn_recherche(ActionEvent event) {
    String recherche = nomField.getText();
    System.out.println("Critères de recherche : " + recherche);
    
    // Récupérer la liste des personnes filtrées par nom
    List<User> listeFiltree = gs.RechercherUser(recherche);
    if (listeFiltree.size() > 0) {
            setChosenU(listeFiltree.get(0));
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
            for (int i = 0; i < listeFiltree.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../GUI/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(listeFiltree.get(i),myListener);

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
    // Afficher la liste filtrée
    for (User user : listeFiltree) {
        System.out.println(user.toString());
    }
}



    @FXML
    private void GoUser(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLListUser.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoAvis(ActionEvent event) throws IOException {
         Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLListAvis.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoReclamation(ActionEvent event) throws IOException {
          Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AfficheReclamation.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoBlog(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLBlogComment.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoPanier(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AffichagePanier.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoLivraison(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AffichageLivraison.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoEvenement(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/AcceuilEvenement.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoProduit(ActionEvent event) throws IOException {
          Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/MarketProduit.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoExpertise(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/FXMLModifierExpertise.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }

    @FXML
    private void GoEnchere(ActionEvent event) throws IOException {
        Parent  ConnexionPage =FXMLLoader.load(getClass().getResource("../GUI/enchereAcceuil.fxml"));
       Scene ConnexionPageScene =new Scene(ConnexionPage);
    Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
    
    appStage.setScene(ConnexionPageScene);
    appStage.show();
    }
    

}



