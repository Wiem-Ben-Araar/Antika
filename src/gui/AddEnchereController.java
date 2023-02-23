/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Models.Enchere;
import Models.Produit;
import Models.User;
import Services.EnchereService;
import Services.UserService;
import Utilities.MaConnexion;
import Utilities.Type;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class AddEnchereController implements Initializable {

    @FXML
    private DatePicker dateFermetureTF;
    @FXML
    private TextField prixInitialeTF;
    @FXML
    private Button createEnchereButton;
    @FXML
    private Button getEnchereButton1;
    @FXML
    private Button deleteEnchereButton1;

    /**
     * Initializes the controller class.
     */
    
    Enchere enchere = new Enchere();
    List<Enchere> encheres = new ArrayList<>();
    EnchereService enchereService = new EnchereService();
    ObservableList<Enchere> data = FXCollections.observableArrayList(enchereService.getEncheres());
     /**
     * Initializes the controller class.
     */
    ObservableList<Enchere> eventList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createEnchere(ActionEvent event) {
        
        User user = new User();  
        
        Produit produit = new Produit();
        
        Enchere enchere = new Enchere();
        EnchereService enchereService = new EnchereService();
       
        enchere.setPrix_initale(300);
        enchere.setDate_fermeture(Timestamp.valueOf(LocalDateTime.now()));
        enchere.setCreateur(user);
        enchere.setProduit(produit);
        enchere.setPrix_initale(300);
            
        enchereService.createEnchere(enchere);
        
    }

    @FXML
    private Enchere getEncheres(ActionEvent event) throws SQLException {
        
      Connection  connection = MaConnexion.getInstance().getCnx();
      String request = "SELECT * FROM enchere";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
               int enchereId = resultSet.getInt(1);
        int prixInitale = resultSet.getInt(2);
        int prixFinale = resultSet.getInt(3);
        Timestamp dateCreation = resultSet.getTimestamp(4);
        Timestamp dateFermeture = resultSet.getTimestamp(5);
        int gagnantId = resultSet.getInt(6);
        int createurId = resultSet.getInt(7);
        int produitId = resultSet.getInt(8);

       /* User gagnant = createUserWithId(gagnantId);
        User createur = createUserWithId(createurId);
        Produit produit = createProduitWithId(produitId);*/

        //return new Enchere(enchereId, prixInitale, prixFinale, dateCreation, dateFermeture, gagnant, createur, produit);
                encheres.add(enchere);

              
    }   return null;
}

    @FXML
    private void deleteEnchere(ActionEvent event, int produit_id) throws SQLException {
        Enchere enchere= new Enchere();
         EnchereService enchereService = new EnchereService();
           // encheres= table.getSelectionModel().getSelectedItems();
            Connection connection = MaConnexion.getInstance().getCnx();  
            
           String request = "DELETE FROM enchere WHERE produit_id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(request);
      preparedStatement.setInt(1, produit_id);

      // execute the preparedstatement
      preparedStatement.executeUpdate();
                      // enchere_id.clear();
                       //dateFermetureTF.clear();
                     /*  tflieu.clear();
                       tfdate.getEditor().clear();
                       tfcapacite.clear();
                       tfdescription.clear();*/
                 
      
     
    }
}
    
    
