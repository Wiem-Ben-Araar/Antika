package Models;

import java.util.Objects;

public class Reservation {
    private int reservation_id;
    private Evenement evenement;
    private User user;

    public Reservation() {}

    public Reservation(int reservation_id, Evenement evenement, User user) {
        this.reservation_id = reservation_id;
        this.evenement = evenement;
        this.user = user;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (reservation_id != that.reservation_id) return false;
        if (!Objects.equals(evenement, that.evenement)) return false;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        int result = reservation_id;
        result = 31 * result + (evenement != null ? evenement.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", evenement=" + evenement +
                ", user=" + user +
                '}';
    }
}
