/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListenerLivraison;
import Models.Livraison;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class LivraisonController {

    @FXML
    private Text date;
    
    private Livraison livraison ;
    @FXML
    private Text adresse;
@FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(livraison);
    }
    private MyListenerLivraison myListener;

    /**
     * Initializes the controller class.
     */
    public void setData(Livraison livraison, MyListenerLivraison myListener){
        this.myListener=myListener;
        this.livraison = livraison;
        if(livraison.getStatut().equals("Livrée")){
            adresse.setFill(Color.GREEN);
            date.setFill(Color.GREEN);
        }
        if(livraison.getStatut().equals("Annulée")){
            adresse.setFill(Color.RED);
            date.setFill(Color.RED);
        }
        date.setText(livraison.getDate_livraison()+"");
        adresse.setText(livraison.getAdresse());
    }
    
}
