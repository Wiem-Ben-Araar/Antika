package entities;
import java.sql.Time;

/**
 *
 * @author nadab
 */
public class enchere {
    double prixInitial;
    double prixFinal;
    Time deadline;
    double montantAjouter;
    String gagnant;

    public enchere() {
    }

    public enchere(double prixInitial, double prixFinal, Time deadline, double montantAjouter, String gagnant ) {
        this.prixInitial = prixInitial;
        this.prixFinal = prixFinal;
        this.deadline = deadline;
        this.montantAjouter = montantAjouter;
        this.gagnant = gagnant;
    }

    public double getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(double prixInitial) {
        this.prixInitial = prixInitial;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }

    public Time getDeadline() {
        return deadline;
    }

    public void setDeadline(Time deadline) {
        this.deadline = deadline;
    }

    public double getMontantAjouter() {
        return montantAjouter;
    }

    public void setMontantAjouter(double montantAjouter) {
        this.montantAjouter = montantAjouter;
    }

    public String getGagnant() {
        return gagnant;
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }
   
    @Override
    public String toString() {
        return "enchere{" + "Pix Initial=" + prixInitial + ", Prix Final=" + prixFinal + ", Deadline=" + deadline + ", Montant Ajouter=" + montantAjouter + ", Gagnant=" + gagnant + '}';
    }     
}

