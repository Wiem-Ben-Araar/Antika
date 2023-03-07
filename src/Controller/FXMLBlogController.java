/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListenerBlog;
import Models.Blog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class FXMLBlogController {

    @FXML
    private Label titre;
    
    private Blog blog;
    
    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(blog);
    }
    private MyListenerBlog myListener;

    /**
     * Initializes the controller class.
     */
    public void setData(Blog blog, MyListenerBlog myListener){
        this.myListener=myListener;
        this.blog = blog;
        titre.setText(blog.getTitre());
    }
    
}
