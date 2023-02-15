/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Reclamation;

/**
 *
 * @author Dali
 */
public interface ReclamationInterface {
    public void addReclamation(Reclamation p);
    public Reclamation afficherReclamationbyId(int id);
    //list : select
    public List<Reclamation> fetchReclamation();
}
