/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Evenement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author nadab
 */
public interface EvenementInterface {
    
      public void createEvenement(Evenement evenement);
      public void deleteEvenement(Evenement evenement);
      public List<Evenement> getEvenementsByLieu(String lieu);
      public List<Evenement> getEvenementsByNom(String nom);
      public Evenement getEvenementById(int evenement_id);
      public List<Evenement> getEvenements();
      public void updateEvenement(Evenement evenement);
      
    
}
