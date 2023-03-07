/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListenerBlog;
import Models.Blog;
import Models.Commentaire;
import Models.Expertise;
import Models.User;
import Services.BlogService;
import Services.CommentaireService;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class FXMLBlogCommentController implements Initializable {

    private Label titre;
    private Label artiste;
    private Label date;
    private Label etiquette;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    Image image = new Image("/GUI/star.png");
    private MyListenerBlog myListener;
    
    private BlogService blogService = new BlogService();
    private UserService userService = new UserService();
    private CommentaireService commentaireService = new CommentaireService();
    @FXML
    private ListView<Commentaire> lview;
    @FXML
    private TextField commentaire;

    private Blog blog;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Blog> blogs = new ArrayList();
        blogs.addAll(blogService.AfficherBlogs());
        if(blogs.size() > 0){
            setChosenBlog(blogs.get(0));
            myListener = new MyListenerBlog() {
                @Override
                public void onClickListener(Blog blog) {
                    setChosenBlog(blog);
                }
            };
        }
        int column =0;
        int row=1;
        try {
        for(int i=0; i <blogs.size(); i++){
           
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/FXMLBlog.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            FXMLBlogController blogController = fxmlLoader.getController();
            
            blogController.setData(blogs.get(i),myListener);
            if(column == 3){
                column=0;
                row++;
            }
            
            grid.add(anchorPane, column++, row);
            
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
            GridPane.setMargin(anchorPane, new Insets(10));
            }
            } catch (IOException ex) {
                Logger.getLogger(FXMLBlogCommentController.class.getName()).log(Level.SEVERE, null, ex);
            
          
            
        }
    }
private void setChosenBlog(Blog blog){
this.blog = blog;
lview.getItems().clear();
   lview.getItems().addAll(commentaireService.AfficherCommentaireByBlog(blog.getId_blog()));
    lview.setCellFactory(lv -> new ListCell<Commentaire>() {
        private ImageView imageView = new ImageView();
        
    @Override
    public void updateItem(Commentaire commentaire, boolean empty) {
        
        super.updateItem(commentaire, empty) ;
        setText(empty ? null : commentaire.getUser().getPrenom()+" "+commentaire.getUser().getNom()+" : "+commentaire.getContenu());
        if(commentaireService.AfficherCommentaireByUser(1).size()>10){
            imageView.setImage(image);
            setGraphic(imageView);
        }
    }
});
    
}    

    @FXML
    private void Commenter(MouseEvent event) {
        
            if(!commentaire.getText().isEmpty()){
                Commentaire c = new Commentaire(commentaire.getText(), blog, userService.afficherUserbyID(1));
                commentaireService.AjouterCommentaire(c);
                lview.getItems().clear();
                lview.getItems().addAll(commentaireService.AfficherCommentaireByBlog(blog.getId_blog()));
    lview.setCellFactory(lv -> new ListCell<Commentaire>() {
        private ImageView imageView = new ImageView();
        
    @Override
    public void updateItem(Commentaire commentaire, boolean empty) {
        
        super.updateItem(commentaire, empty) ;
        setText(empty ? null : commentaire.getUser().getPrenom()+" "+commentaire.getUser().getNom()+" : "+commentaire.getContenu());
        if(commentaireService.AfficherCommentaireByUser(1).size()>10){
            imageView.setImage(image);
            setGraphic(empty ? null : imageView);
        }
    }
});
            }
        }
@FXML
    private void Detail(MouseEvent event) throws IOException {
          Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLBlogDetail.fxml"));
        Scene affichageScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageScene);
        window.show();
    }

    @FXML
    private void Expertise(MouseEvent event) throws IOException {
            Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLExpertise.fxml"));
        Scene affichageScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageScene);
        window.show();
        
    }

    @FXML
    private void AjouterBlog(MouseEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLBlog1.fxml"));
        Scene affichageScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageScene);
        window.show();
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
