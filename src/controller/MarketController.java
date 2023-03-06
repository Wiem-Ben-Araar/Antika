package controller;

import models.Produit;
import services.ProduitService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import gui.MyListener;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Rating;
import services.ReclamationService;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nomtf;
    @FXML
    private Label genretf;
    @FXML
    private Label prixtf;
    @FXML
    private ImageView imgtf;
    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    
    
    

    private List<Produit> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    ProduitService gs = new ProduitService();
    @FXML
    private Button supprimer;
    
    @FXML
    private Pagination pagination;
    @FXML
    private Button Modifier;
    @FXML
    private TextField find;
    @FXML
    private Rating note;
    @FXML
    private Label id;
    
    public static int a ;
 

    private List<Produit> getData() {
        List<Produit> fruits = new ArrayList<>();
        
        fruits =gs.fetchProduit();
        
        

        return fruits;
    }

    private void setChosenFruit(Produit fruit) {
        
        nomtf.setText(fruit.getNom());
        genretf.setText(fruit.getGenre());
        prixtf.setText(Float.toString(fruit.getPrix()));
        id.setText(Integer.toString(fruit.getId()));
        byte[] blobData = /* your blob data here */ fruit.getImg();
        // Convert blob data to input stream
        InputStream is = new ByteArrayInputStream(blobData);
        // Create an Image object from input stream
        Image image = new Image(is);
        // Create an ImageView object and set its content to the Image object
        imgtf.setImage(image);
        a = Integer.valueOf(id.getText());
    }
   
     // image = new Image(getClass().getResourceAsStream(fruit.getImg()));
       // imgtf.setImage(image);
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fruits.addAll(getData());
        if (fruits.size() > 0) 
        {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
              
                @Override
                public void onClickListener(Produit t) {
                         setChosenFruit(t);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) 
            {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../gui/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i),myListener);

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

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        gs.supprimerProduit(Integer.valueOf(id.getText()));
    }

    @FXML
    private void ajout(ActionEvent event) {
                   try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AjoutProduit.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
           // stage.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
     
    }

    @FXML
    private void modif(ActionEvent event) {
        
          FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("../gui/ModifierProduit.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
                            ModifierProduitController ModifierProduitController = loader.getController();
                            ModifierProduitController.setTextField(nomtf.getText(),genretf.getText(),prixtf.getText());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            a = Integer.valueOf(id.getText());
    }
    

    @FXML
    private void update(ActionEvent event) {
    // Effacer toutes les lignes actuelles de la grille
    grid.getChildren().clear();
    grid.getRowConstraints().clear();
    // Regénérer la grille avec les données mises à jour
    int column = 0;
    int row = 1;
    try {
        for (int i = 0; i < fruits.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../gui/item.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemController livraisonitemController = fxmlLoader.getController();
            livraisonitemController.setData(fruits.get(i),myListener);

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

            GridPane.setMargin(anchorPane, new Insets(10));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void chercher(ActionEvent event) {
        gs.recherche(find.getText());
    }

    @FXML
    private void ajoutr(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AjoutReclamation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void affichr(ActionEvent event) {
        try {
            ReclamationService rs= new ReclamationService();
            
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AfficheReclamation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

 
    

}
