/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ProduitInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import Models.Produit;
import Services.ProduitService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dali
 */
public class ModifierProduitController implements Initializable {

    @FXML
    private TextField nomTF;
    @FXML
    private TextField genreTF;
    @FXML
    private TextField prixTF;
    @FXML
    private VBox VBox;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField id;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     
    
   

    @FXML
    private void ChooseImage(ActionEvent event) {
        // Create a FileChooser dialog
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        // Set the file filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        // Show the dialog and wait for the user to select a file
        File file = fileChooser.showOpenDialog(imageView.getScene().getWindow());

        // If a file was selected, load it into the ImageView
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
        
    private byte[] imageToString(Image image) throws IOException 
    {
        // Convert the Image to a BufferedImage
        javafx.scene.image.Image fxImage = image;
        java.awt.image.BufferedImage awtImage = SwingFXUtils.fromFXImage(fxImage, null);

        // Convert the BufferedImage to a byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(awtImage, "jpg", baos);
        byte[] Blobs = baos.toByteArray();

        return Blobs;
    }
     @FXML
    private void ModifierProduit(ActionEvent event) throws IOException
    { 
        
        if ( nomTF.getText().isEmpty() || genreTF.getText().isEmpty() || prixTF.getText().isEmpty())
        {

			Alert al = new Alert(Alert.AlertType.INFORMATION);
			al.setTitle("Controle de saisie");
			al.setHeaderText("Erreur de saisie !");
			al.setContentText("Les données sont vides !");
			al.show();
        }
        else
        {
            Produit r = new Produit();

        ProduitService  psd = new ProduitService ();
        r.setNom(nomTF.getText());
        r.setGenre(genreTF.getText());
//        r.setId(Integer.parseInt(id.getText()));
        r.setPrix(Float.valueOf(prixTF.getText()));  
        psd.modifierProduit(r,MarketProduitController.a);
        //l.setImg(imageData);

       // l = new Produit(resIDTROC,resIDLIVREUE,resEtat,price,imageData);


        //psd.modifierProduit(l,MarketProduitController.a);
        }
                        
    }
       void setTextField(String nom, String genre, String price) {

        nomTF.setText(nom);
        genreTF.setText(genre);
        prixTF.setText(price);

    }

    @FXML
    private void retour(ActionEvent event) {
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

