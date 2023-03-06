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
import java.sql.SQLException;

public class MaConnexion {
    public String url = "jdbc:mysql://localhost:3306/antika";
    public String login = "root";
    public String pwd = "";
    Connection cnx;

    public static MaConnexion instance;
    
    public MaConnexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url ,login ,pwd);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
           System.err.print(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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

}
