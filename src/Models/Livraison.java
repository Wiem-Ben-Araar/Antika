/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author shily
 */
public class Livraison {
    private int id_livraison;
    private Panier panier;
    private String adresse;
    private String statut;
    private Date date_livraison;
    private float total;

    public Livraison(int id_livraison, Panier panier, String adresse, String statut, Date date_livraison, float total) {
        this.id_livraison = id_livraison;
        this.panier = panier;
        this.adresse = adresse;
        this.statut = statut;
        this.date_livraison = date_livraison;
        this.total = total;
    }

    public Livraison(Panier panier, String adresse, String statut, Date date_livraison, float total) {
        this.panier = panier;
        this.adresse = adresse;
        this.statut = statut;
        this.date_livraison = date_livraison;
        this.total = total;
    }

    public Livraison() {
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", panier=" + panier + ", adresse=" + adresse + ", statut=" + statut + ", date_livraison=" + date_livraison + ", total=" + total + '}';
    }
    
    
}
