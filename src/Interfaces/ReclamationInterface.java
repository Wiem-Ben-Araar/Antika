/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import Models.Reclamation;

/**
 *
 * @author Dali
 */
public interface ReclamationInterface {
    public void addReclamation(Reclamation r) ;
     public List<Reclamation> afficherReclamationbyId(int Id) ;
         public void modifierReclamation(Reclamation l, int x) ;
               public List<Reclamation> recherche(String desc) ;
    //list : select
    public List<Reclamation> fetchReclamation();
}
