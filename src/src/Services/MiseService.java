package Services;

import Models.Enchere;
import Models.Evenement;
import Models.Mise;
import Models.Produit;
import Models.User;
import Utilities.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MiseService {
    private Connection connection;
     public static Mise currentMise;

    public MiseService() {connection = MaConnexion.getInstance().getCnx();}

    public void createMise(Mise mise) {
        if(mise == null) {
            System.err.println("[createMise] Trying to add a null entity");
            return ;
        } else if(mise.getCreateur() == null) {
            System.err.println("[createMise] Mise createur can't be null");
            return ;
        } else if(mise.getEnchere() == null) {
            System.err.println("[createMise] Mise enchere can't be null");
            return ;
        }
        String request = "INSERT INTO mise(montant, createur, enchere) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, mise.getMontant());
            preparedStatement.setInt(2, mise.getCreateur().getId_user());
            preparedStatement.setInt(3, mise.getEnchere().getEnchere_id());
            preparedStatement.executeUpdate();
            System.out.println("Votre mise est ajouté avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Mise> getMisesByEnchere(Enchere enchere) {
        List<Mise> mises = new ArrayList<>();
        try {
            String request = "SELECT * FROM mise WHERE enchere = " + enchere.getEnchere_id() + " ORDER BY mise_id DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Mise mise = createMiseFromResultSet(resultSet);
                mises.add(mise);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return mises;
    }
    
     public List<Mise> getMisesByEnchereDate(Enchere enchere) {
        List<Mise> mises = new ArrayList<>();
        try {
            String request = "SELECT * FROM mise WHERE enchere = " + enchere.getDate_fermeture() + " ORDER BY mise_id DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Mise mise = createMiseFromResultSet(resultSet);
                mises.add(mise);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return mises;
    }

    private Mise createMiseFromResultSet(ResultSet resultSet) throws SQLException {
        int miseId = resultSet.getInt(1);
        int montant = resultSet.getInt(2);
        Timestamp dateCreation = resultSet.getTimestamp(3);
        User createur = createUserWithId(resultSet.getInt(4));
        Enchere enchere = createEnchereWithId(resultSet.getInt(5));
        return new Mise(miseId, createur, enchere, dateCreation, montant);
    }

    private User createUserWithId(int userId) {
        User user = new User();
        user.setId_user(userId);
        return user;
    }

    private Enchere createEnchereWithId(int enchereId) {
        Enchere enchere = new Enchere();
        enchere.setEnchere_id(enchereId);
        return enchere;
    }
    
    public String createMiseOnSelectedEnchere(Enchere enchere, Produit produit) {
        
        EnchereService enchereService = new EnchereService();
        Mise mise = new Mise();
        enchere = enchereService.getEnchereById(enchere.getEnchere_id());
        if(enchere.getDate_fermeture().getTime() <= new java.util.Date().getTime()) {
            System.err.println("Enchère fermé !");
            return "Enchere Fermé";
        }
        
        String request = "INSERT INTO mise(montant, createur, enchere) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, mise.getMontant());
            preparedStatement.setInt(2, mise.getCreateur().getId_user());
            preparedStatement.setInt(3, mise.getEnchere().getEnchere_id());
            preparedStatement.executeUpdate();
            System.out.println("Votre mise est ajouté avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return "";
    }

}
