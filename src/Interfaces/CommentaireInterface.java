/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Commentaire;
import java.util.List;

/**
 *
 * @author dridi
 */
public interface CommentaireInterface {
    public void AjouterCommentaire(Commentaire object);

    public void ModifierCommentaire(Commentaire object, int id);

    public List<Commentaire> AfficherCommentaireByBlog(int id);
    
    public List<Commentaire> AfficherCommentaireByUser(int id);
            
    public void SupprimerCommentaire(Commentaire object);

    public List<Commentaire> RechercherCommentaire(String object);

    public List<Commentaire> AfficherCommentaire();

    public Commentaire getCommentaireId(int object);

    public List<Commentaire>  TrieCommentaire(String object);
}
