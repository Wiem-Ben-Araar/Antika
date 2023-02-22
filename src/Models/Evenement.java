package Models;

import java.sql.Date;
import java.util.Objects;

public class Evenement {
    private int evenement_id;
    private String nom;
    private String lieu;
    private Date evenement_date;
    private int capacite;
    private String description;

    public Evenement() {}

    public Evenement(int evenement_id, String nom, String lieu, Date date, int capacite, String description) {
        this.evenement_id = evenement_id;
        this.nom = nom;
        this.lieu = lieu;
        this.evenement_date = date;
        this.capacite = capacite;
        this.description = description;
    }

    public int getEvenement_id() {
        return evenement_id;
    }

    public void setEvenement_id(int evenement_id) {
        this.evenement_id = evenement_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getEvenement_date() {
        return evenement_date;
    }

    public void setEvenement_date(Date evenement_date) {
        this.evenement_date = evenement_date;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evenement evenement = (Evenement) o;

        if (evenement_id != evenement.evenement_id) return false;
        if (capacite != evenement.capacite) return false;
        if (!Objects.equals(nom, evenement.nom)) return false;
        if (!Objects.equals(lieu, evenement.lieu)) return false;
        if (!Objects.equals(evenement_date, evenement.evenement_date)) return false;
        return Objects.equals(description, evenement.description);
    }

    @Override
    public int hashCode() {
        int result = evenement_id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (lieu != null ? lieu.hashCode() : 0);
        result = 31 * result + (evenement_date != null ? evenement_date.hashCode() : 0);
        result = 31 * result + capacite;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "evenement_id=" + evenement_id +
                ", nom='" + nom + '\'' +
                ", lieu='" + lieu + '\'' +
                ", evenement_date=" + evenement_date +
                ", capacite=" + capacite +
                ", description='" + description + '\'' +
                '}';
    }
}
