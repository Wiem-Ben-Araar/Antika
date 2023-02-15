/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

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

    public Reclamation() {
    }

    public Reclamation(int id_Reclamation, String description, String email, Date date) {
        this.id_Reclamation = id_Reclamation;
        this.description = description;
        this.email = email;
         this.date = date;
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

    @Override
    public String toString() {
        return "Reclamation{" + "id_Reclamation=" + id_Reclamation + ", description=" + description + ", email=" + email + ", date=" + date + '}';
    }
    
}

