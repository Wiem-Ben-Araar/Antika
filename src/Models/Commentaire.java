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
    private User user ;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu, Blog blog, User user) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.blog = blog;
        this.user = user;
    }

    public Commentaire(String contenu, Blog blog, User user) {
        this.contenu = contenu;
        this.blog = blog;
        this.user = user;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenu() {
        return contenu;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", contenu=" + contenu + ", blog=" + blog + ", user=" + user + '}';
    }

 
    
    
}
