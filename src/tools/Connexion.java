/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sarra
 */

public class Connexion {
  //DB CREDENTIALS
    final static String URL = "jdbc:mysql://127.0.0.1:3306/3,14";
    final static String LOGIN = "root";
    final static String PWD = "";
    
    //Connection init
    static Connexion instance = null;
    private Connection cnx;
    
    //constructor
    private Connexion() {
        
        
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                 String URL = "jdbc:mysql://localhost:3306/3,14";
            String LOGIN = "root";
            String PWD = "";

            cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            if (cnx != null) {
            System.out.println("Connexion avec succes");
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            
            ex.printStackTrace();
        }
        // TODO Auto-generated catch block

    }
    
    //getters
    public static Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}