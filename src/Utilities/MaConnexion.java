/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author wiemb
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class MaConnexion {
    public String url="jdbc:mysql://localhost:3306/final";
    public String login="root";
    public String pwd="";
    public Connection cnx;

    public static MaConnexion instance;
    
    public  MaConnexion(){
        try {
           cnx = DriverManager.getConnection(url ,login ,pwd);
           System.out.println("Connexion etablie avec succes!");
           
        } catch (SQLException ex) {
           System.err.print(ex.getMessage());
        }
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
    public static MaConnexion getInstance(){
        if(instance == null){
        instance = new MaConnexion();
        }
        return instance;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public PreparedStatement pst(String update_user_SET_reset_code___WHERE_email_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
