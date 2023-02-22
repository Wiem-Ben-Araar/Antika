package Models;

import java.sql.Timestamp;
import java.util.Objects;

public class Mise {
    private int mise_id;
    private User createur;
    private Enchere enchere;
    private Timestamp date_creation;
    private int montant;

    public Mise() {
    }

    public Mise(int mise_id, User createur, Enchere enchere, Timestamp date_creation, int montant) {
        this.mise_id = mise_id;
        this.createur = createur;
        this.enchere = enchere;
        this.date_creation = date_creation;
        this.montant = montant;
    }

    public int getMise_id() {
        return mise_id;
    }

    public void setMise_id(int mise_id) {
        this.mise_id = mise_id;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
    }

    public Enchere getEnchere() {
        return enchere;
    }

    public void setEnchere(Enchere enchere) {
        this.enchere = enchere;
    }

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mise mise = (Mise) o;

        if (mise_id != mise.mise_id) return false;
        if (montant != mise.montant) return false;
        if (!Objects.equals(createur, mise.createur)) return false;
        if (!Objects.equals(enchere, mise.enchere)) return false;
        return Objects.equals(date_creation, mise.date_creation);
    }

    @Override
    public int hashCode() {
        int result = mise_id;
        result = 31 * result + (createur != null ? createur.hashCode() : 0);
        result = 31 * result + (enchere != null ? enchere.hashCode() : 0);
        result = 31 * result + (date_creation != null ? date_creation.hashCode() : 0);
        result = 31 * result + montant;
        return result;
    }

    @Override
    public String toString() {
        return "Mise{" +
                "mise_id=" + mise_id +
                ", createur=" + createur +
                ", enchere=" + enchere +
                ", date_creation=" + date_creation +
                ", montant=" + montant +
                '}';
    }
}
