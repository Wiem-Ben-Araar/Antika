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
public class Avis {
   private int id_avis;
    private String commentaire;
      private int note;

    public Avis() {
    }

    public Avis(String commentaire, int note) {
        this.commentaire = commentaire;
        this.note = note;
    }

    public Avis(int id_avis, String commentaire, int note) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
        this.note = note;
    }

    public int getId_avis() {
        return id_avis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", commentaire=" + commentaire + ", note=" + note + '}';
    }

    

}