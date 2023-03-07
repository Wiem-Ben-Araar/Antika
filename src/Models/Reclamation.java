/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Dali
 */
public class Reclamation {
    private int id_Reclamation;
    private String description;
    private String email;
    private Date date;
    //private Produit produit;
    private int Id;
    private int note;

    public Reclamation() {
    }

    public Reclamation(int Id) {
        this.Id = Id;
    }


    public Reclamation(int id_Reclamation, String description, String email, Date date, int Id) {
        this.id_Reclamation = id_Reclamation;
        this.description = description;
        this.email = email;
        this.date = date;
        this.Id = Id;
    }

   /* public Reclamation(int id_Reclamation, String description, String email, Date date, Produit produit, int Id) {
        this.id_Reclamation = id_Reclamation;
        this.description = description;
        this.email = email;
        this.date = date;
        this.produit = produit;
        this.Id = Id;
    }*/

    public Reclamation(String description, String email, Date date, int note) {
        this.description = description;
        this.email = email;
        this.date = date;
        this.note = note;
    }
    

    public Reclamation(String description, String email, Date date, int Id,int note) {
        this.description = description;
        this.email = email;
        this.date = date;
        this.Id = Id;
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    

    public int getId_Reclamation() {
        return id_Reclamation;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

  

    public void setId_Reclamation(int id_Reclamation) {
        this.id_Reclamation = id_Reclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_Reclamation=" + id_Reclamation + ", description=" + description + ", email=" + email + ", date=" + date + ", Id=" + Id + ",note=" +note+ '}';
    }
    
}

