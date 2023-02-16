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
public class Commentaire {
    private int id_commentaire;
    private String contenu;
    private Blog blog;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu, Blog blog) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.blog = blog;
    }

    public Commentaire(String contenu, Blog blog) {
        this.contenu = contenu;
        this.blog = blog;
    }

 
    public int getId_commentaire() {
        return id_commentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", contenu=" + contenu + ", blog=" + blog + '}';
    }
    
    
    
}
