/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author dridi
 */
public class Artiste {
    private int id_artiste; 
    private String nom ; 

    public Artiste() {
    }

    public Artiste(int id_artiste, String nom) {
        this.id_artiste = id_artiste;
        this.nom = nom;
    }

    public Artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public Artiste(String nom) {
        this.nom = nom;
    }

    public int getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return  nom ;
    }
    
}
