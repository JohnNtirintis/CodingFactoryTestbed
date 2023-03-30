package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Menu Application, repeatedly showing a menu until a user -
 * - enters 5
 *
 * @author Ioannis-Panagiotis Ntirintis
 */
public class MenuApp {
    public static void main(String[] args) {

        int choice = 0;

        //Initiating Scanner for user input
        Scanner in = new Scanner(System.in);

        //Do while loop to repeatedly ask for a user input and to show the menu
        //Until the user enters the num 5
        do {
            System.out.println("Δωστε αριθμο για επιλογη στο menu:");
            System.out.println("1. Εισαγωγη");
            System.out.println("2. Διαγραφη");
            System.out.println("3. Ενημερωση");
            System.out.println("4. Αναζητηση");
            System.out.println("5. Εξοδος");

            choice = in.nextInt();
            if(choice == 1){
                System.out.println("Επιλεξατε Εισαγωγη");
            }
            else if (choice == 2){
                System.out.println("Επιλεξατε Διαγραφη");
            }
            else if (choice == 3){
                System.out.println("Επιλεξατε Ενημερωση");
            }
            else if (choice == 4){
                System.out.println("Επιλεξατε Αναζητηση");
            }
            else if (choice == 5){
                System.out.println("Επιλεξατε Εξοδο");
            }
            //If the user enters an incorrect value an error message will appear to notify and guide them
            else {
                System.out.println("Παρακαλω δωστε μια τιμη μεταξυ 1 εως και 5.");
            }
        }while(choice != 5);
    }
}
