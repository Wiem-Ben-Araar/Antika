/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Expertise;
import Services.ExpertiseService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dridi
 */
public class FXMLModifierExpertiseController implements Initializable {

    @FXML
    private TextField prixestime;
    @FXML
    private TextField condition;
    @FXML
    private Text notif;
    @FXML
    private ListView<Expertise> lview;

    ExpertiseService expertiseService = new ExpertiseService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lview.getItems().addAll(expertiseService.AfficherExpertise());
lview.setCellFactory(lv -> new ListCell<Expertise>() {
    @Override
    public void updateItem(Expertise expertise, boolean empty) {
        super.updateItem(expertise, empty) ;
        setText(empty ? null : expertise.getId_artiste().getNom()+"   "+expertise.getId_produit().getNom()+"     "+expertise.getPrix_estimé()+"      "+expertise.getCondition_produit());
    }
});
    }    

    @FXML
    private void ModifierExpertise(MouseEvent event) {
        notif.setText("");
        if(lview.getSelectionModel().getSelectedItem()!=null){
            if(!prixestime.getText().isEmpty() && !condition.getText().isEmpty()){
                Expertise expertise = lview.getSelectionModel().getSelectedItem();
                expertise.setCondition_produit(condition.getText());
                expertise.setPrix_estimé(Float.parseFloat(prixestime.getText()));
                expertiseService.ModifierExpertise(expertise, expertise.getId_expert());
                notif.setText("Expertise modifier");
                lview.getItems().clear();
                lview.getItems().addAll(expertiseService.AfficherExpertise());
lview.setCellFactory(lv -> new ListCell<Expertise>() {
    @Override
    public void updateItem(Expertise expertise, boolean empty) {
        super.updateItem(expertise, empty) ;
        setText(empty ? null : expertise.getId_artiste().getNom()+"   "+expertise.getId_produit().getNom()+"     "+expertise.getPrix_estimé()+"      "+expertise.getCondition_produit());
    }
});
            }else{
                notif.setText("Vous devez remplir tout les champs");
            }
        }else{
            notif.setText("Il faut choisir une expertise");
        }
    }

    @FXML
    private void SupprimerExpertise(MouseEvent event) {
         notif.setText("");
        if(lview.getSelectionModel().getSelectedItem()!=null){
           expertiseService.SupprimerExpertise(lview.getSelectionModel().getSelectedItem().getId_expert());
           notif.setText("Expertise supprimé");
            lview.getItems().clear();
                lview.getItems().addAll(expertiseService.AfficherExpertise());
lview.setCellFactory(lv -> new ListCell<Expertise>() {
    @Override
    public void updateItem(Expertise expertise, boolean empty) {
        super.updateItem(expertise, empty) ;
        setText(empty ? null : expertise.getId_artiste().getNom()+"   "+expertise.getId_produit().getNom()+"     "+expertise.getPrix_estimé()+"      "+expertise.getCondition_produit());
    }
});
        }else{
            notif.setText("Il faut choisir une expertise");
        }
    }
    @FXML
    public void qrcode(MouseEvent event) throws WriterException{
          notif.setText("");
        if(lview.getSelectionModel().getSelectedItem()!=null){
            Expertise exp = lview.getSelectionModel().getSelectedItem();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "https://drive.google.com/file/d/1jjgenbUGnvHoxwcXK_UJV1Yo8vGlsEGq/view";
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        System.out.println("Success...");
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        
    }

    @FXML
    private void CreerExpertise(MouseEvent event) throws IOException {
         Parent affichage = FXMLLoader
        .load(getClass().getResource("../GUI/FXMLExpertise.fxml"));
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
