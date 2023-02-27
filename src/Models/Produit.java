/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ahmedshil
 */
public class Produit {
    private int id_produit;
	 private double prix;
	 private String titre;
	public Produit(int id_produit, double prix, String titre) {
		super();
		this.id_produit = id_produit;
		this.prix = prix;
		this.titre = titre;
	}
	public Produit(double prix, String titre) {
		super();
		this.prix = prix;
		this.titre = titre;
	}
	public Produit() {
		super();
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", prix=" + prix + ", titre=" + titre + '}';
    }
	 
	 
	 
}
