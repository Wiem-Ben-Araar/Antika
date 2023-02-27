/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author shily
 */
public class Livraison {
    private int id_livraison;
    private String adresse;
    private String statut;
    private User user;
    private Date date_livraison;
    private float total;

    public Livraison() {
    }

    public Livraison(int id_livraison, String adresse, String statut, Date date_livraison, float total) {
        this.id_livraison = id_livraison;
        this.adresse = adresse;
        this.statut = statut;
        this.date_livraison = date_livraison;
        this.total = total;
    }

    public Livraison(String adresse, String statut, User user, Date date_livraison) {
        this.adresse = adresse;
        this.statut = statut;
        this.user = user;
        this.date_livraison = date_livraison;
    }
    public Livraison(String adresse, String statut, Date date_livraison, float total) {
        this.adresse = adresse;
        this.statut = statut;
        this.date_livraison = date_livraison;
        this.total = total;
    }
    
    public int getId_livraison() {
        return id_livraison;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getStatut() {
        return statut;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public float getTotal() {
        return total;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", adresse=" + adresse + ", statut=" + statut + ", user=" + user + ", date_livraison=" + date_livraison + ", total=" + total + '}';
    }

 

}

