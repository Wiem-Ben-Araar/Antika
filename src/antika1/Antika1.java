/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antika1;

import Service.BlogService;
import java.sql.Date;
import java.util.List;
import Models.Blog;
import Models.Commentaire;
import Service.CommentaireService;

/**
 *
 * @author dridi
 */
public class Antika1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  BlogService bs = new BlogService();
        Date date = new Date(2022, 23, 2);
        Blog e1 = new Blog("aaa","belhadj",  date, "fdhiha", "moumathel machhour","tahfouna");
        Blog e2 = new Blog("mounira","dridi",date, "fdhiha", "moumathel machhour","tahfouna");
       Blog e3 = new Blog("mounira","dridi", date, "fdhiha", "moumathel machhour","tahfouna");
        Blog e4 = new Blog("mounira","dridi",date, "fdhiha", "moumathel machhour","tahfouna");
        Blog e5 = new Blog("dali","belhadj", date, "fdhiha", "moumathel machhour","tahfouna");
        ////ajout blog
        //bs.AjouterBlog(e1);
        ////modifier blog
        //bs.ModifierBlog(e5,53);
        //supprimer blog
        //bs.SupprimerBlog(53);
       // crud commentaire
        CommentaireService cs = new CommentaireService();
        Commentaire c1 = new Commentaire("hello",e1);
        Commentaire c2 = new Commentaire("bonjour",e1);
        //cs.AjouterCommentaire(c1);
     
        //c1.setId_commentaire(13);
       
//       cs.ModifierCommentaire(c2, 53);//54
//       cs.SupprimerCommentaire1(47);//59
       
       
          }
    
}
