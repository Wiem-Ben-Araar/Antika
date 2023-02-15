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
public class Panier {
    private int id_panier;
    private float total;
    private  String statut;
    private Date date_creation;
    private int code_promo;

    public Panier(int id_panier, float total, String statut, Date date_creation, int code_promo) {
        this.id_panier = id_panier;
        this.total = total;
        this.statut = statut;
        this.date_creation = date_creation;
        this.code_promo = code_promo;
    }

    public Panier(float total, String statut, Date date_creation, int code_promo) {
        this.total = total;
        this.statut = statut;
        this.date_creation = date_creation;
        this.code_promo = code_promo;
    }
       public Panier() {
    }

    public int getId_panier() {
        return id_panier;
    }

    public float getTotal() {
        return total;
    }

    public String getStatut() {
        return statut;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public int getCode_promo() {
        return code_promo;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setCode_promo(int code_promo) {
        this.code_promo = code_promo;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", total=" + total + ", statut=" + statut + ", date_creation=" + date_creation + ", code_promo=" + code_promo + '}';
    }
       
}



















