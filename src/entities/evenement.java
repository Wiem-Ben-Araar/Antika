
package entities;

import java.sql.Date;

/**
 *
 * @author sarra
 */
public class evenement {
    int identifiant;
    String nom;
    String lieu;
    String date;
    int capacite;
    String description;

    public evenement() {
    }

    public evenement(int identifiant, String nom, String lieu, String date, int capacite, String description) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.capacite = capacite;
        this.description = description;
    }
    

      public evenement(String nom) {
        this.nom = nom;
       
    }
          

    public evenement(String nom, String lieu, String date, int capacite, String description) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.capacite = capacite;
        this.description = description;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    public String toString() {
        return "event{" + "identifiant=" + identifiant + ", nom=" + nom + ", lieu=" + lieu + ", date=" + date + ", capacite=" + capacite + ", description=" + description + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final evenement other = (evenement) obj;
        if (this.identifiant != other.identifiant) {
            return false;
        }
        return true;
    }
    
}