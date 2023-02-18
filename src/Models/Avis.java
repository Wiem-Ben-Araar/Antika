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
      private User user;

    public Avis() {
    }

    public Avis(String commentaire, int note, User user) {
        this.commentaire = commentaire;
        this.note = note;
        this.user = user;
    }

    public Avis(int id_avis, String commentaire, int note,User user) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
        this.note = note;
        this.user = user;
    }

    public Avis(String magnifique, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", commentaire=" + commentaire + ", note=" + note + ", user=" + user + '}';
    }

    

    

}