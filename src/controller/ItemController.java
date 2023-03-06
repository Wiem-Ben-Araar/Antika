package controller;

import models.Produit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import gui.MyListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);
    }

    private Produit fruit;
    private MyListener myListener;

    public void setData(Produit fruit, MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getNom());
        priceLable.setText( Float.toString(fruit.getPrix()));
        byte[] blobData = /* your blob data here */ fruit.getImg();

        // Convert blob data to input stream
        InputStream is = new ByteArrayInputStream(blobData);

        // Create an Image object from input stream
        Image image = new Image(is);

        // Create an ImageView object and set its content to the Image object
        img.setImage(image);
    }
}
