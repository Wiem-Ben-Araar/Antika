package Services;

import Models.CalendarRequest;
import Models.Evenement;
import Models.Reservation;
import Models.User;
import Utilities.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {

    private Connection connection;

    public ReservationService() {
        connection = MaConnexion.getInstance().getCnx();
    }

    public String createReservation(Evenement evenement, User user) {
        EvenementService evenementService = new EvenementService();
        Evenement event = evenementService.getEvenementById(evenement.getEvenement_id());
        if(event.getCapacite() <= getReservationsByEvenementId(event.getEvenement_id()).size()) {
            System.err.println("Evenement complet !");
            return "complet";
        }
        if(event.getEvenement_date().getTime() <= new Date().getTime()) {
            System.err.println("Evenement passé !");
            return "evenement passe";
        }
        List<Reservation> reservations = getReservationsByEvenementId(evenement.getEvenement_id());
        boolean dejaFaitReservation = reservations
                .stream()
                .map(reservation -> reservation.getUser().getId_user())
                .anyMatch(userId -> userId == user.getId_user());
        if(dejaFaitReservation) {
            System.err.println("Deja participé !");
            return "deja participe";
        }
        String request = "INSERT INTO reservation(evenement, user) VALUES (?, ?)";
        try {
            // Save Reservation
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, evenement.getEvenement_id());
            preparedStatement.setInt(2, user.getId_user());
            preparedStatement.executeUpdate();
            System.out.println("Votre reservation est ajouté avec succés.");
            // Send Email
            EmailService emailService = new EmailService();
            CalendarRequest calendarRequest = new CalendarRequest(event, user);
            emailService.sendCalendarInvite(calendarRequest);
            return "Votre reservation est ajouté avec succés";
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return "";
    }

    public List<Reservation> getReservationsByEvenementId(int evenementId) {
        List<Reservation> reservations = new ArrayList<>();
        try {
            String request = "SELECT * FROM reservation WHERE evenement = " + evenementId;
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){
                int reservationId = resultSet.getInt(1);

                int eventId = resultSet.getInt(2);
                Evenement evenement = new Evenement();
                evenement.setEvenement_id(eventId);
                int userId = resultSet.getInt(3);

                User user = new User();
                user.setId_user(userId);

                Reservation reservation = new Reservation(reservationId, evenement, user);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reservations;
    }

    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        try {
            String request = "SELECT * FROM reservation WHERE user = " + userId;
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){
                int reservationId = resultSet.getInt(1);

                int eventId = resultSet.getInt(2);
                Evenement evenement = new Evenement();
                evenement.setEvenement_id(eventId);

                int userIdResult = resultSet.getInt(3);
                User user = new User();
                user.setId_user(userIdResult);

                Reservation reservation = new Reservation(reservationId, evenement, user);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reservations;
    }

    public Reservation getReservationByReservationId(int reservationId) {
        Reservation reservation = new Reservation();
        try {
            String request = "SELECT * FROM reservation WHERE reservation_id = " + reservationId;
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){

                int eventId = resultSet.getInt(2);
                Evenement evenement = new Evenement();
                evenement.setEvenement_id(eventId);

                int userIdResult = resultSet.getInt(3);
                User user = new User();
                user.setId_user(userIdResult);

                reservation.setReservation_id(reservationId);
                reservation.setUser(user);
                reservation.setEvenement(evenement);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reservation;
    }

    public void deleteReservation(int reservation_id) {
        Reservation reservation = getReservationByReservationId(reservation_id);
        EvenementService evenementService = new EvenementService();
        Evenement event = evenementService.getEvenementById(reservation.getEvenement().getEvenement_id());
        if(event.getEvenement_date().getTime() >= new Date().getTime()) {
            System.err.println("Tu peux pas supprimé une reservation pour un evenement deja passé !");
            return;
        }
        String request = "DELETE FROM reservation WHERE reservation_id = " + reservation_id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.executeUpdate();
            System.out.println("Votre reservation est supprimé avec succés.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
