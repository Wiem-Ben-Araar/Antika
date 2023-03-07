/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author shily
 */
public class Panier {
    private int id_panier;
    private int quantite;
    private double total;
    private User user;
    private Produit produit;
    public Panier() {
    }

    public Panier(int id_panier, int quantite, double total, User user, Produit produit) {
        this.id_panier = id_panier;
        this.user = user;
        this.produit = produit;
        this.quantite = quantite;
        this.total = total;
    }

    public Panier(int quantite, User user, Produit produit) {
        this.quantite = quantite;
        this.user = user;
        this.produit = produit;
    }

    public Panier(int quantite, double total,User user, Produit produit) {
        this.user = user;
        this.produit = produit;
        this.quantite = quantite;
        this.total = total;
    }
    
    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", user=" + user + ", produit=" + produit + ", quantite=" + quantite + ", total=" + total + '}';
    }

 
    
}
    
   
