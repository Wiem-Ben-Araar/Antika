/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproduit;

/**
 *
 * @author Dali
 */
import java.sql.Date;
import models.Produit;
import models.Reclamation;
import services.ProduitService;
import services.ReclamationService;

/**
 *
 * @author Dali
 */
public class GestionProduit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // service init
        ProduitService ps = new ProduitService();
        Produit p = new Produit();
        p.setNom("mmmmmm");
        p.setGenre("aaa");
        p.setPrix(1222);
        //p.setImg("b.jpg");
        //ps.addProduit(p);
       // String desc="dalo";
        //System.out.println(ps.fetchProduit());
        Date date = new Date(2023,8,2);
        ReclamationService rs = new ReclamationService();
        //Reclamation r = new Reclamation("tttt","ttttt",date,2);
      //  ps.supprimerProduit(1);
        ps.afficherProduitbyId(7);
        rs.afficherReclamationbyId(7);
        //rs.addReclamation(r);
        //rs.modifierReclamation(1,desc );
       // System.out.println(rs.fetchReclamation());
       
        // ps.modifierProduit(p, 3);
        //rs.supprimerReclamation(17);
        //ps.supprimerProduit(45);
       // rs.ajouterReclamation(r, p);
       //rs.addReclamation(r);
    }
}