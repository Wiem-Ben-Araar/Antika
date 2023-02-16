/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MaConnexion {
   
    static String URL ="jdbc:mysql://127.0.0.1/3,14" ;
    static String USR ="root" ;
    static String PWD ="" ;
    
    
    Connection cnx ;
    
    public static MaConnexion instance;

    // 
    public MaConnexion() {
       try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MaConnexion getInstance() {
        if (instance == null)
            instance=new MaConnexion();
        return instance;
    }
    
    
    
}
