/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author dridi
 */
public class Expertise {
     private int id_expert;
    private Produit id_produit;
    private Artiste id_artiste;
     private float prix_estimé ;
     private String condition_produit;
    private Date date_expertise;

    public Expertise() {
    }

    public Expertise(Produit id_produit, Artiste id_artiste, float prix_estimé, String condition_produit, Date date_expertise) {
        this.id_produit = id_produit;
        this.id_artiste = id_artiste;
        this.prix_estimé = prix_estimé;
        this.condition_produit = condition_produit;
        this.date_expertise = date_expertise;
    }

    public Expertise(float prix_estimé, String condition_produit, Date date_expertise) {
        this.prix_estimé = prix_estimé;
        this.condition_produit = condition_produit;
        this.date_expertise = date_expertise;
    }

    public Expertise(int id_expert, Produit id_produit, Artiste id_artiste, float prix_estimé, String condition_produit, Date date_expertise) {
        this.id_expert = id_expert;
        this.id_produit = id_produit;
        this.id_artiste = id_artiste;
        this.prix_estimé = prix_estimé;
        this.condition_produit = condition_produit;
        this.date_expertise = date_expertise;
    }

    public Expertise(Produit id_produit) {
        this.id_produit = id_produit;
    }

    public Expertise(Produit id_produit, Artiste id_artiste, float prix_estimé, String condition_produit) {
        this.id_produit = id_produit;
        this.id_artiste = id_artiste;
        this.prix_estimé = prix_estimé;
        this.condition_produit = condition_produit;
    }

    public Expertise(float prix_estimé, String condition_produit) {
        this.prix_estimé = prix_estimé;
        this.condition_produit = condition_produit;
    }

    
    public int getId_expert() {
        return id_expert;
    }

    public void setId_expert(int id_expert) {
        this.id_expert = id_expert;
    }

    public Produit getId_produit() {
        return id_produit;
    }

    public void setId_produit(Produit id_produit) {
        this.id_produit = id_produit;
    }

    public Artiste getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(Artiste id_artiste) {
        this.id_artiste = id_artiste;
    }

    public float getPrix_estimé() {
        return prix_estimé;
    }

    public void setPrix_estimé(float prix_estimé) {
        this.prix_estimé = prix_estimé;
    }

    public String getCondition_produit() {
        return condition_produit;
    }

    public void setCondition_produit(String condition_produit) {
        this.condition_produit = condition_produit;
    }

    public Date getDate_expertise() {
        return date_expertise;
    }

    public void setDate_expertise(Date date_expertise) {
        this.date_expertise = date_expertise;
    }
    
    
}
