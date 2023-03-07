/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.User;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author wiemb
 */
public class ItemController  {

    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private ImageView img;
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(u);
    }

    private User u;
    private MyListener myListener;

    public void setData(User u, MyListener myListener) {
        this.u = u;
        this.myListener = myListener;
        nomLabel.setText(u.getNom());
        prenomLabel.setText(u.getPrenom());
      
        
     //   byte[] blobData = /* your blob data here */ user.getImage();

        // Convert blob data to input stream
    //    InputStream is = new ByteArrayInputStream(blobData);

        // Create an Image object from input stream
    //    Image image = new Image(is);

        // Create an ImageView object and set its content to the Image object
  //      img.setImage(image);
    }

   

    /**
     * Initializes the controller class.
     */
   
       
   
}
