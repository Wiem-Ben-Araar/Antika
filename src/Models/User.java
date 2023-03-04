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
    private String confirmer_motdepasse;
    private byte[] image;
    private Avis avis;

    public User(int id_user, String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe, String confirmer_motdepasse, byte[] image, Avis avis) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
        this.confirmer_motdepasse = confirmer_motdepasse;
        this.image = image;
        this.avis = avis;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe, String confirmer_motdepasse, byte[] image, Avis avis) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
        this.confirmer_motdepasse = confirmer_motdepasse;
        this.image = image;
        this.avis = avis;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe, String confirmer_motdepasse, byte[] image) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
        this.confirmer_motdepasse = confirmer_motdepasse;
        this.image = image;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, Type type, String mot_de_passe, String confirmer_motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.type = type;
        this.mot_de_passe = mot_de_passe;
        this.confirmer_motdepasse = confirmer_motdepasse;
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

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getConfirmer_motdepasse() {
        return confirmer_motdepasse;
    }

    public byte[] getImage() {
        return image;
    }

    public Avis getAvis() {
        return avis;
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

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setConfirmer_motdepasse(String confirmer_motdepasse) {
        this.confirmer_motdepasse = confirmer_motdepasse;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setAvis(Avis avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", type=" + type + ", mot_de_passe=" + mot_de_passe + ", confirmer_motdepasse=" + confirmer_motdepasse + ", image=" + image + ", avis=" + avis + '}';
    }

    
}