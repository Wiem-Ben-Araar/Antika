
package utilities ;



import java.sql.DriverManager;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaConnexion {
    //DB Credentials
    final String USERNAME = "root";
    final String PASSWORD = "";
    final String URL = "jdbc:mysql://127.0.0.1:3306/antika";
//var
    Connection cnx;
    //1 privatisation du constructeur
    //2 créer une instance static de MaConnection
    static MaConnexion instance;
    
    
    //constructeur
    public MaConnexion() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection etablie avec succes !!!");
        } catch (SQLException e) {
        }

    }
    
    //3 getter static
    public static MaConnexion getInstance() {
        if(instance == null){
            instance = new MaConnexion();
        }
        return instance;
    }

    public static void setInstance(MaConnexion instance) {
        MaConnexion.instance = instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public PreparedStatement prepareStatement(String requete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

