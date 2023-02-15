/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Panier;
import java.util.List;

/**
 *
 * @author shily
 */
public interface PanierInterface {
    public void AjouterPanier(Panier p);

    public void ModifierPanier(Panier p,int x);

    public void SupprimerPanier(Panier p);

    public List<Panier> RechercherPanier(int id_panier);

    public List<Panier> AfficherPanier();

    public Panier getPanierById(int id_panier);

    public List<Panier>  TriePanier();


    
}
