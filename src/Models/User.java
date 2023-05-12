/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author wiemb
 */
public class User {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private String roles;
    private String password;
    private Avis avis;

    public User(int id, String nom, String prenom, String email, String telephone, String adresse, String roles, String password, Avis avis) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.roles = roles;
        this.password = password;
        this.avis = avis;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, String roles, String password,Avis avis) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.roles = roles;
        this.password = password;
        this.avis = avis;
    }

    public User(String nom, String prenom, String email, String telephone, String adresse, String roles, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.roles = roles;
        this.password = password;
    }


    public User() {
    }

    public int getId_user() {
        return id;
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

    public String getType() {
        return roles;
    }

    public String getMot_de_passe() {
        return password;
    }


    public Avis getAvis() {
        return avis;
    }

    public void setId_user(int id_user) {
        this.id = id_user;
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

    public void setType(String roles) {
        this.roles = roles;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.password = mot_de_passe;
    }

    public void setAvis(Avis avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id+ ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", type=" + roles + ", mot_de_passe=" + password +'}';
    }

    
}