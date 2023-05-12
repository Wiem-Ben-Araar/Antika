/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.logging.Logger;

/**
 *
 * @author Dali
 */
public class Produit {


   
    private int Id;
    private String nom;
    private String genre;
    private float prix;
    private String img;

    public Produit() {
    }

    public Produit(int Id, String nom, String genre, float prix, String img) {
        this.Id = Id;
        this.nom = nom;
        this.genre = genre;
        this.prix = prix;
        this.img = img;
        
    }

    public Produit(String nom, String genre, float prix,String img) {
        this.nom = nom;
        this.genre = genre;
        this.prix = prix;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
        return "Produit{" + "Id=" + Id + ", nom=" + nom + ", genre=" + genre + ", prix=" + prix + ", img=" + img +  '}';
    }

   

   
   
    private static final Logger LOG = Logger.getLogger(Produit.class.getName());



}

