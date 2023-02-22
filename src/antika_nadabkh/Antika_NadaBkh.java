
package antika_nadabkh;

import Models.*;
import Services.EnchereService;
import Services.EvenementService;
import Services.MiseService;
import Services.UserService;
import Utilities.Type;
import java.awt.BorderLayout;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author nadab
 */
public class Antika_NadaBkh {

    
    public static void main(String[] args) {
      Evenement event = new Evenement();
      EvenementService serviceEvenement = new EvenementService();
     /* event.setNom("aaa");
      event.setLieu("ddd");
      event.setEvenement_date(java.sql.Date.valueOf(LocalDate.now()));
      event.setDescription("cccc");
      event.setCapacite(50);*/
      serviceEvenement.deleteEvenement(event, 3);
    }
    
}
