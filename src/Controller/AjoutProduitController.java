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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import Models.Produit;
import Services.ProduitService;

/**
 * FXML Controller class
 *
 * @author Dali
 */
public class AjoutProduitController implements Initializable {

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
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void AjouterProduit(ActionEvent event) throws IOException
    { 
        byte[] imageData = imageToString(imageView.getImage());
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
        ProduitInterface ps = new ProduitService();
        Produit p = new Produit();
        p.setNom(nomTF.getText());
        p.setGenre(genreTF.getText());
        p.setPrix(Float.parseFloat(prixTF.getText()));
        p.setImg(imageData);
        System.out.println("image convertit");
        ps.addProduit(p);
        }
                        
    }

    @FXML
    private void retour(ActionEvent event) {
                     try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/MarketProduit.fxml"));
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

