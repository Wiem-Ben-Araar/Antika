package Controller;


import Models.Produit;
import Services.ProduitService;
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

import Interfaces.MyListenerProduit;
import Models.Panier;
import Models.User;
import Services.PanierService;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Rating;
import Services.ReclamationService;
import Services.UserService;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MarketProduitController implements Initializable {
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
    private PanierService panierService = new PanierService();
    

    private List<Produit> fruits = new ArrayList<>();
    private Image image;
    private MyListenerProduit myListener;
    ProduitService gs = new ProduitService();
    UserService userService = new UserService();
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
    @FXML
    private Label idr;
 
    Produit produitChoisie = new Produit();
    @FXML
    private Label nbrprod;

    private List<Produit> getData() {
        List<Produit> fruits = new ArrayList<>();
        
        fruits =gs.fetchProduit();
        
        

        return fruits;
    }

    private void setChosenFruit(Produit fruit) {
        produitChoisie = fruit;
        nomtf.setText(fruit.getNom());
        genretf.setText(fruit.getGenre());
        prixtf.setText(Float.toString(fruit.getPrix()));
        id.setText(Integer.toString(fruit.getId()));
        nbrprod.setText(Integer.toString(gs.nmbrProduitPanier(fruit.getId())));
        String blobData = /* your blob data here */ fruit.getImg();
        // Convert blob data to input stream
        //InputStream is = new ByteArrayInputStream(blobData);
        // Create an Image object from input stream
        //Image image = new Image(is);
        // Create an ImageView object and set its content to the Image object
        //imgtf.setImage(image);
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
            myListener = new MyListenerProduit() {
              
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
                fxmlLoader.setLocation(getClass().getResource("../GUI/itemProduit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemProduitController itemController = fxmlLoader.getController();
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
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutProduit.fxml"));
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
          loader.setLocation(getClass().getResource("../GUI/ModifierProduit.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MarketProduitController.class.getName()).log(Level.SEVERE, null, ex);
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
            fxmlLoader.setLocation(getClass().getResource("../GUI/itemProduit.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemProduitController livraisonitemController = fxmlLoader.getController();
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
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutReclamation.fxml"));
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
    private void AjoutProduitPanier(ActionEvent event) throws SQLException {
        if(produitChoisie.getId()>0){
            System.out.println("commance");
        User user = userService.afficherUserbyID(1);
        if(panierService.getPanierUserProduit(user.getId_user(), produitChoisie.getId()).getId_panier()>0){
            System.out.println(panierService.getPanierUserProduit(user.getId_user(), produitChoisie.getId()));
            System.out.println("le produit existe déjà dans votre panier");
        }
        else{
            Panier panier=new Panier(1, user, produitChoisie);
            panierService.ajouter(panier);
            System.out.println("nouvel panier créé");
        }
        }
        else{
            System.out.println("Vous devez selecionner un produit");
        }
        
    }
    @FXML
    private void affichr(ActionEvent event) {
        try {
            ReclamationService rs= new ReclamationService();
            
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheReclamation.fxml"));
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
