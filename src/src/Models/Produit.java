package Models;

import java.util.logging.Logger;

/**
 *
 * @author Dali
 */
public class Produit {

    public static void add(Produit p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    private int Id;
    private String nom;
    private String genre;
    private float prix;

    public Produit() {
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "Id=" + Id + ", nom=" + nom + ", genre=" + genre + ", prix=" + prix + '}';
    }
    private static final Logger LOG = Logger.getLogger(Produit.class.getName());

}
