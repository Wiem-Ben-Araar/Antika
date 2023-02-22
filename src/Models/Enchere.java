package Models;

import java.sql.Timestamp;
import java.util.Objects;

public class Enchere {
    private int enchere_id;
    private int prix_initale;
    private int prix_finale;
    private Timestamp date_creation;
    private Timestamp date_fermeture;
    private User gagnant;
    private User createur;
    private Produit produit;

    public Enchere() {}

    public Enchere(int enchere_id, int prix_initale, int prix_finale, Timestamp date_creation, Timestamp date_fermeture, User gagnant, User createur, Produit produit) {
        this.enchere_id = enchere_id;
        this.prix_initale = prix_initale;
        this.date_creation = date_creation;
        this.date_fermeture = date_fermeture;
        this.gagnant = gagnant;
        this.createur = createur;
        this.produit = produit;
        this.prix_finale = prix_finale;
    }

    public int getEnchere_id() {
        return enchere_id;
    }

    public void setEnchere_id(int enchere_id) {
        this.enchere_id = enchere_id;
    }

    public int getPrix_initale() {
        return prix_initale;
    }

    public int getPrix_finale() {
        return prix_finale;
    }

    public void setPrix_initale(int prix_initale) {
        this.prix_initale = prix_initale;
    }

    public void setPrix_finale(int prix_finale) {
        this.prix_finale = prix_finale;
    }

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public Timestamp getDate_fermeture() {
        return date_fermeture;
    }

    public void setDate_fermeture(Timestamp date_fermeture) {
        this.date_fermeture = date_fermeture;
    }

    public User getGagnant() {
        return gagnant;
    }

    public void setGagnant(User gagnant) {
        this.gagnant = gagnant;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enchere enchere = (Enchere) o;

        if (enchere_id != enchere.enchere_id) return false;
        if (prix_initale != enchere.prix_initale) return false;
        if (prix_finale != enchere.prix_finale) return false;
        if (!Objects.equals(date_creation, enchere.date_creation))
            return false;
        if (!Objects.equals(date_fermeture, enchere.date_fermeture))
            return false;
        if (!Objects.equals(gagnant, enchere.gagnant)) return false;
        if (!Objects.equals(createur, enchere.createur)) return false;
        return Objects.equals(produit, enchere.produit);
    }

    @Override
    public int hashCode() {
        int result = enchere_id;
        result = 31 * result + prix_initale;
        result = 31 * result + prix_finale;
        result = 31 * result + (date_creation != null ? date_creation.hashCode() : 0);
        result = 31 * result + (date_fermeture != null ? date_fermeture.hashCode() : 0);
        result = 31 * result + (gagnant != null ? gagnant.hashCode() : 0);
        result = 31 * result + (createur != null ? createur.hashCode() : 0);
        result = 31 * result + (produit != null ? produit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Enchere{" +
                "enchere_id=" + enchere_id +
                ", prix_initale=" + prix_initale +
                ", prix_finale=" + prix_finale +
                ", date_creation=" + date_creation +
                ", date_fermeture=" + date_fermeture +
                ", gagnant=" + gagnant +
                ", createur=" + createur +
                ", produit=" + produit +
                '}';
    }
}
