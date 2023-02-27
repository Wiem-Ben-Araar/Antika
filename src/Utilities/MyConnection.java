/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author shily
 */
public class MyConnection {
     String url = "jdbc:mysql://localhost:3306/antika";
     String login = "root";
     String pwd = "";
    public  static MyConnection db;
    public Connection con;
    private MyConnection() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static MyConnection getInstance()
    {if(db==null)
        db=new MyConnection();
    return db;
    }     
}