/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Expertise;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author dridi
 */
public interface ExpertiseInterfaces {
    public void AjouterExpertise(Expertise E);

    public void ModifierExpertise(Expertise object,int id_expert);

    public void SupprimerExpertise(int id_expert);

    public List<Expertise> RechercherExpertise(String object);

    public List<Expertise> AfficherExpertise();
    


}
