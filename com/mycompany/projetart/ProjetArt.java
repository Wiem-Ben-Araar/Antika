/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetart;

import java.sql.Date;
import models.Produit;
import models.Reclamation;
import services.ProduitService;
import services.ReclamationService;

/**
 *
 * @author admin
 */
public class ProjetArt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // service init
        ProduitService ps = new ProduitService();
        Produit p = new Produit();
        p.setNom("Sadio Mane");
        p.setGenre("homme");
        p.setPrix(10);
        ps.addProduit(p);
        
        System.out.println(ps.fetchProduit());
        Date date = new Date(2023,8,2);
        ReclamationService rs = new ReclamationService();
        Reclamation r = new Reclamation();
        r.setDescription("abababa");
        r.setEmail("dali.bhj@esprit.com");
        r.setDate(date);
        rs.addReclamation(r);
        System.out.println(rs.fetchReclamation());
        rs.supprimerReclamation(20);
        ps.supprimerProduit(45);

    }
}
