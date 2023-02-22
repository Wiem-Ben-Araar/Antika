package Services;

import Models.Enchere;
import Models.Mise;
import Models.Produit;
import Models.User;
import Utilities.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnchereService {

    Connection connection;

    public EnchereService() {
        connection = MaConnexion.getInstance().getCnx();
    }

    public void createEnchere(Enchere enchere) {
        if(enchere == null) {
            System.err.println("[CreateEnchere] Trying to add a null entity");
            return ;
        } else if(enchere.getCreateur() == null) {
            System.err.println("[CreateEnchere] Creator can't be null");
            return ;
        } else if(enchere.getProduit() == null) {
            System.err.println("[CreateEnchere] Product can't be null");
            return ;
        }
        String request = "INSERT INTO enchere(prix_initale, date_fermeture, createur, produit) VALUES (? , ? , ? , ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, enchere.getPrix_initale());
            preparedStatement.setTimestamp(2, enchere.getDate_fermeture());
            preparedStatement.setInt(3, enchere.getCreateur().getId_user());
            preparedStatement.setInt(4, enchere.getProduit().getId());
            preparedStatement.executeUpdate();
            System.out.println("Votre enchère est ajouté avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteEnchere(Enchere enchere) {
        if(enchere == null) {
            System.err.println("[deleteEnchere] Trying to delete a null entity");
            return ;
        }
        String request = "DELETE FROM enchere WHERE enchere_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, enchere.getEnchere_id());
            preparedStatement.executeUpdate();
            System.out.println("Votre enchère est supprimé avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteEnchereByProduitId(int produit_id) {
        String request = "DELETE FROM enchere WHERE produit_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, produit_id);
            preparedStatement.executeUpdate();
            System.out.println("Votre enchère est supprimé avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void updateDateFermetureEnchere(Timestamp dateFermeture) {
        String request = "UPDATE enchere set date_fermeture = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setTimestamp(1, dateFermeture);
            preparedStatement.executeUpdate();
            System.out.println("Votre enchère est modifié avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void closeEnchere(Enchere enchere) {
        MiseService miseService = new MiseService();
        List<Mise> mises = miseService.getMisesByEnchere(enchere);
        if(mises.isEmpty()) {
            System.err.println("Trying to close enchere without mise");
            return ;
        }
        Mise lastMise = mises.get(0);
        int montant = lastMise.getMontant();
        User gagnant = lastMise.getCreateur();

        String request = "UPDATE enchere set prix_finale = ?, gagnant = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, montant);
            preparedStatement.setInt(2, gagnant.getId_user());
            preparedStatement.executeUpdate();
            System.out.println("Votre enchère est fermé avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Enchere> getEncheres() {
        List<Enchere> encheres = new ArrayList<>();
        try {
            String request = "SELECT * FROM enchere";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Enchere enchere = createEnchereFromResultSet(resultSet);
                encheres.add(enchere);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return encheres;
    }

    private static Produit createProduitWithId(int produitId) {
        Produit produit = new Produit();
        produit.setId(produitId);
        return produit;
    }

    private User createUserWithId(int userId) {
        User user = new User();
        user.setId_user(userId);
        return user;
    }

    public Enchere getEnchereById(int enchere_id) {
        Enchere enchere = null;
        try {
            String request = "SELECT * FROM enchere WHERE enchere_id = " + enchere_id;
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){
                enchere = createEnchereFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return enchere;
    }

    private Enchere createEnchereFromResultSet(ResultSet rs) throws SQLException {
        int enchereId = rs.getInt(1);
        int prixInitale = rs.getInt(2);
        int prixFinale = rs.getInt(3);
        Timestamp dateCreation = rs.getTimestamp(4);
        Timestamp dateFermeture = rs.getTimestamp(5);
        int gagnantId = rs.getInt(6);
        int createurId = rs.getInt(7);
        int produitId = rs.getInt(8);

        User gagnant = createUserWithId(gagnantId);
        User createur = createUserWithId(createurId);
        Produit produit = createProduitWithId(produitId);

        return new Enchere(enchereId, prixInitale, prixFinale, dateCreation, dateFermeture, gagnant, createur, produit);
    }
}
