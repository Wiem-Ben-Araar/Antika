/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utilities.Type;

/**
 *
 * @author wiemb
 */
public class User {
    
    private int id_user;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private Type type;
    private String mot_de_passe;

    public User(int id_user, String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
    }
     public User() {
       
    }

   

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public Type getType() {
        return type;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    
    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", type=" + type + '}';
    }
}
