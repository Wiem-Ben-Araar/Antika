
package pi;
import tools.Connexion;
import entities.evenement;
import service.Serviceevenement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author nadab
 */
public class Pi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        evenement e = new evenement(74,"Saint Patrick","PlayBar","17/03/22",300,"by libertad esprit");
        Serviceevenement pcd=new Serviceevenement();
        pcd.Ajoutevenement(e);
       
        System.out.println(pcd.Readevenement());
        pcd.modifier(1,e);
        pcd.supprimerevenement(e); 
        
        
         Scanner input = new Scanner(System.in);
    
    int option = 0;
 
        // Do - While loop
        do {
            menu();
            option = input.nextInt();
 
            // Switch case
            switch (option) {
 
            // Case 1
            case 1:
 
                // Display message
                System.out.print(
                    "What is the event id Number ? ");
 
                int identifiant = input.nextInt();
 
                // Display message
                System.out.print(
                    "What is the event capacity ? ");
 
                int capacite = input.nextInt();
                input.nextLine();
 
                // Display message
                System.out.print(
                    "What is the event Date ? ");
 
                String date = input.nextLine();
                
                System.out.print(
                    "What is the event place ? ");
 
                String lieu = input.nextLine();
                
                System.out.print(
                    "What is the event description ? ");
 
                String description = input.nextLine();
                
                System.out.print(
                    "What is the event Name ? ");
 
                String nom = input.nextLine();
 
                // Create event object and pass constructor
                // parameters.
                e = new evenement(identifiant, nom, lieu, date, capacite, description);
                // Call add() event
                pcd.Ajoutevenement(e);
                System.out.println(e.toString());
 
                // Break statement used to terminate program
                // from here only once it entered this case
                break;
 
            // Case 2
            case 2:
 
                // Display message
                System.out.print(
                    "What is the event id number ? ");
                int eId = input.nextInt();
 
                // Invoke remove/delete record
                pcd.supprimerevenement(e);
 
                break;
 
            // Case 3
            case 3:
 
                // Display message
                System.out.print(
                    "What is the event id number? ");
 
                int eIdNo = input.nextInt();
                pcd.modifier(eIdNo, e);
 
                break;
 
            // Case 4
            case 4:
 
                // Display message
                System.out.print(
                    "What is the events id ? ");
                int eventId = input.nextInt();
 
               /* if (!pcd.afficherevenement()) {
                    System.out.println(
                        "event id does not exist\n");
                }*/
                pcd.searchByReference(eventId);
 
                break;
 
            // Case 5
            case 5:
                 System.out.print(
                    "What is the events id ? ");
                int Id = input.nextInt();
                pcd.SearchById(Id);
                break;
 
            // Case 6
            case 9:
 
                // Display message
                System.out.println(
                    "\nThank you for using the program. Goodbye!\n");
                System.exit(0);
 
                break;
 
            // Case 7: Default case
            // If none above case executes
            default:
 
                // Print statement
                System.out.println("\nInvalid input\n");
                break;
            }
        }
 
        // Checking condition
        while (option != 9);
    }
    // Method 2
    // Menu - Static menu for displaying options
    public static void menu()
    {
 
        // Printing statements displaying menu on console
        System.out.println("MENU");
        System.out.println("1: Add Event");
        System.out.println("2: Delete Event");
        System.out.println("3: Update Event");
        System.out.println("4: Search Event");
        System.out.println("5: Display Event");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
    }
        
       
        
         
       
        
        // TODO code application logic here
    }
    

