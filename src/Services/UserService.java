/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;
import Utilities.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmedshil
 */
public class UserService {
    Connection connection=MyConnection.getInstance().getConnection();
    PreparedStatement ste ;
    public User getUser(int id) throws SQLException {
       User user =new User();

           
            String req="SELECT * FROM user where id_user="+id;
            if(connection.prepareStatement(req) !=null){
                ste =connection.prepareStatement(req);
            ResultSet resultat=ste.executeQuery();
          while(resultat.next()){
               user = new User(resultat.getInt(1),resultat.getString(2),resultat.getString(3));
          }
            }
            
          
       
   
        return user;
    }
}
