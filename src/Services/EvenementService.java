package Services;

import Models.Evenement;
import Models.User;
import Utilities.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementService {

    private Connection connection;

    public EvenementService() {
        connection = MaConnexion.getInstance().getCnx();
    }

    public void createEvenement(Evenement evenement) {
        if(evenement == null) {
            System.err.println("[createEvenement] Trying to add a null entity");
            return ;
        }
        String request = "INSERT INTO evenement(nom, lieu, evenement_date, capacite, description, createur) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, evenement.getNom());
            preparedStatement.setString(2, evenement.getLieu());
            preparedStatement.setDate(3, evenement.getEvenement_date());
            preparedStatement.setInt(4, evenement.getCapacite());
            preparedStatement.setString(5, evenement.getDescription());
            preparedStatement.setInt(6, evenement.getCreateur().getId_user());
            preparedStatement.executeUpdate();
            System.out.println("Votre evenement est ajouté avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteEvenement(Evenement evenement) {
        if(evenement == null) {
            System.err.println("[deleteEvenement] Trying to delete a null entity");
            return ;
        }
        String request = "DELETE FROM evenement WHERE evenement_id = " + evenement.getEvenement_id();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.executeUpdate();
            System.out.println("Votre evenement est supprimé avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Evenement> getEvenementsByLieu(String lieu) {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String request = "SELECT * FROM evenement WHERE lieu LIKE '%" + lieu + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Evenement evenement = createEvenementFromResultSet(resultSet);
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return evenements;
    }

    public List<Evenement> getEvenementsByCreateur(int createurId) {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String request = "SELECT * FROM evenement WHERE createur = " + createurId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Evenement evenement = createEvenementFromResultSet(resultSet);
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return evenements;
    }

    public List<Evenement> getEvenementsByNom(String nom) {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String request = "SELECT * FROM evenement WHERE nom LIKE '%" + nom + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                Evenement evenement = createEvenementFromResultSet(resultSet);
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return evenements;
    }

    public Evenement getEvenementById(int evenement_id) {
        Evenement evenement = null;
        try {
            String request = "SELECT * FROM evenement WHERE evenement_id = " + evenement_id+"";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){
                evenement = createEvenementFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return evenement;
    }

    public List<Evenement> getEvenements() {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String request = "SELECT * FROM evenement";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(resultSet.getInt(1));
            evenement.setNom( resultSet.getString(2));
            evenement.setLieu( resultSet.getString(3));
            evenement.setDescription( resultSet.getString(4));
            evenement.setCapacite( resultSet.getInt(5)); 
            evenement.setEvenement_date( resultSet.getDate(6));
            evenements.add(evenement);
                //statement.execute(request);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return evenements;
    }

    public void updateEvenement(Evenement evenement) {
        String request = "UPDATE evenement set nom = ?, lieu = ?, evenement_date = ?, capacite = ?, description = ? where evenement_id = " + evenement.getEvenement_id();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, evenement.getNom());
            preparedStatement.setString(2, evenement.getLieu());
            preparedStatement.setDate(3, evenement.getEvenement_date());
            preparedStatement.setInt(4, evenement.getCapacite());
            preparedStatement.setString(5, evenement.getDescription());
            preparedStatement.executeUpdate();
            System.out.println("Votre evenement est modifié avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Evenement createEvenementFromResultSet(ResultSet resultSet) throws SQLException {
        int evenementId = resultSet.getInt(1);
        String nom = resultSet.getString(2);
        String lieu = resultSet.getString(3);
        String description = resultSet.getString(4);
        int capacite = resultSet.getInt(5);
        Date evenementDate = resultSet.getDate(6);
        int createurId = resultSet.getInt(7);
        User createur = new User();
        createur.setId_user(createurId);
        return new Evenement(evenementId, nom, lieu, evenementDate, capacite, description, createur);
    }
}
