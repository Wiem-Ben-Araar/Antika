/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Models.Enchere;
import Models.Produit;
import Services.EnchereService;
import Services.UserService;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import Services.ProduitService;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class AddEnchereController implements Initializable {

    @FXML
    private TextField prixInitialeTF;
    @FXML
    private Button createEnchereButton;
    private TableColumn<Enchere, Integer> prixInitTF;
    private TableColumn<Enchere, Integer> prixFinalTF;
    private TableColumn<Enchere, Timestamp> CreationTF;
    private TableColumn<Enchere, Timestamp> FermetureTF;
    private TableColumn<Enchere, Integer> winnerTF;
    private TableColumn<Enchere, Integer> creatorTF;
    private TableColumn<Enchere, Integer> productTF;
    private TableView<Enchere> display;
    @FXML
    private TextField productID;
    private ProduitService produitService = new ProduitService();;

    /**
     * Initializes the controller class.
     */
    
   /* Enchere enchere = new Enchere();
    List<Enchere> encheres = new ArrayList<>();
    EnchereService enchereService = new EnchereService();
    ObservableList<Enchere> data = FXCollections.observableArrayList(enchereService.getEncheres());
     /**
     * Initializes the controller class.
     */
   // ObservableList<Enchere> eventList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Produit produit1 = produitService.afficherProduitbyId(1);
    }    

  
    @FXML
    private void createEnchere(MouseEvent event) {
        try {
            
        Produit produit = produitService.afficherProduitbyId(Integer.parseInt(prixInitialeTF.getText()));   
        Enchere enchere = new Enchere();
        EnchereService enchereService = new EnchereService();
        UserService userService = new UserService();
        enchere.setPrix_initale(Integer.parseInt(prixInitialeTF.getText()));
        enchere.setProduit(produit);
        //enchere.setDate_fermeture(Timestamp.valueOf(LocalDateTime.now()));
        enchere.setCreateur(userService.afficherUserbyID(1));
        
        enchereService.createEnchere(enchere);
        
        } catch(IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir une date valide.");
        }
        JOptionPane.showMessageDialog(null, "L'evenement a été ajouté avec succés.");
    }

    @FXML
    private void createEnchere(ActionEvent event) {
    }
}
    
    
