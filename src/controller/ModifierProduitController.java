/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.ProduitInterface;
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
import models.Produit;
import services.ProduitService;

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

        
        /*String resIDLIVREUE = nomTF.getText();
        String resEtat = genreTF.getText();
        Float price = Float.valueOf(prixTF.getText());
        int resIDTROC = Integer.valueOf(id.getText());
        byte[] imageData = imageToString(imageView.getImage());*/
        ProduitService  psd = new ProduitService ();
        r.setNom(nomTF.getText());
        r.setGenre(genreTF.getText());
//        r.setId(Integer.parseInt(id.getText()));
        r.setPrix(Float.valueOf(prixTF.getText()));  
        psd.modifierProduit(r,MarketController.a);
        //l.setImg(imageData);

       // l = new Produit(resIDTROC,resIDLIVREUE,resEtat,price,imageData);


        //psd.modifierProduit(l,MarketController.a);
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
} 

