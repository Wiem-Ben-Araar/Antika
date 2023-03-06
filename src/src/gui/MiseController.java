package gui;

import Models.Enchere;
import Models.Evenement;
import Models.Mise;
import Models.Produit;
import Services.EnchereService;
import Services.MiseService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import gui.DisplayEncheresController;
import java.sql.Date;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class MiseController implements Initializable {

    @FXML
    private CheckBox Fifty;
    @FXML
    private CheckBox hundredFifty;
    @FXML
    private CheckBox twoHundred;
    @FXML
    private CheckBox hundred;
    @FXML
    private Button miseBT;
    @FXML
    private ImageView productImage;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;
    @FXML
    private Label ProductDesc;
    @FXML
    private Label miseAmount;

    private int amountToAdd;

    private Enchere selectedEnchere;
    private Produit currentProduit;
    private ListView<Enchere> EnchereDetailsList;
    private List <Enchere> enchereList;
    private MiseService miseService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        miseService = new MiseService();
        EnchereService enchereService = new EnchereService();
        
        
        
         enchereService = new EnchereService();
        currentProduit = ProduitService.currentProduit;
        enchereList = enchereService.getEncheres();
        List<Produit> Produits = new ArrayList<>();

        for(Enchere enchere: enchereList) {
            EnchereDetailsList.getItems().add(enchere);
        }

        EnchereDetailsList
            .getSelectionModel()
            .selectedItemProperty()
            .addListener((ObservableValue<? extends Enchere> observable, Enchere oldValue, Enchere newValue) -> {
                selectedEnchere = newValue;
                productName.setText(String.valueOf(newValue.getProduitName()));
                productPrice.setText(String.valueOf(newValue.getProduit()));
                ProductDesc.setText(String.valueOf(newValue.getCreateur()));

                selectedEnchere = newValue;
            });
    }

    @FXML
    private void addFifty(MouseEvent event) {
        unSelectCheckBoxes();
        Fifty.setSelected(true);
        amountToAdd = 50;
    }

    @FXML
    private void addHundredFifty(MouseEvent event) {
        unSelectCheckBoxes();
        hundredFifty.setSelected(true);
        amountToAdd = 150;
    }

    @FXML
    private void addTwoHundred(MouseEvent event) {
        unSelectCheckBoxes();
        twoHundred.setSelected(true);
        amountToAdd = 200;
    }

    @FXML
    private void addHundred(MouseEvent event) {
        unSelectCheckBoxes();
        hundred.setSelected(true);
        amountToAdd = 100;
    }

    @FXML
    private void addMise(MouseEvent event) {
        // lire l'enchére passer de l'écran précedente
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Enchere enchere = (Enchere) stage.getUserData();

        Mise mise = new Mise();
        mise.setEnchere(enchere);
        mise.setCreateur(UserService.currentUser);

        List<Mise> miseList = miseService.getMisesByEnchere(enchere);
        if(miseList.isEmpty()) {
            mise.setMontant(amountToAdd);
        } else {
            Mise lastMise = miseList.get(0);
            mise.setMontant(lastMise.getMontant() + amountToAdd);
        }
        miseService.createMise(mise);
        JOptionPane.showMessageDialog(null, "Mise ajouté avec succée.");
    }

    private void unSelectCheckBoxes() {
        Fifty.setSelected(false);
        hundredFifty.setSelected(false);
        twoHundred.setSelected(false);
        hundred.setSelected(false);
    }

}
