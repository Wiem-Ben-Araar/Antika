/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class ItemController implements Initializable {

    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private ImageView img;
    
private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(user);
    }

    private User user;
    private MyListener myListener;

    public void setData(User user, MyListener myListener) {
        this.user = user;
        this.myListener = myListener;
        nomLabel.setText(user.getNom());
        prenomLabel.setText(user.getPrenom());
      
        
     //   byte[] blobData = /* your blob data here */ user.getImage();

        // Convert blob data to input stream
    //    InputStream is = new ByteArrayInputStream(blobData);

        // Create an Image object from input stream
    //    Image image = new Image(is);

        // Create an ImageView object and set its content to the Image object
  //      img.setImage(image);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * Initializes the controller class.
     */
   
       
   
}
