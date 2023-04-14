package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * An app containing many methods,
 * the prints a menu with 6 options
 *
 * @author Ntirintis John
 */
public class StarsMenuApp {

    // Using the keyword static,
    // to make the scanner global (global scope)
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        // Continues until the user inputs 6 (which is the option to quit the app)
        while(true){
            printMenu();
            choice = getChoice();

            if(choice == 6) break;

            int stars = getNumStars();
            printChoice(choice, stars);
        }
    }
    public static void printMenu(){
        System.out.println("1. Print n horizontal stars");
        System.out.println("2. Print n vertical stars");
        System.out.println("3. Print n lines with n stars");
        System.out.println("4. Print 1 to n stars");
        System.out.println("5. Print n to 5 stars");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }
    public static int getChoice(){

        return sc.nextInt();
    }
    public static int getNumStars(){

        System.out.println("Enter the amount of stars: ");

        return sc.nextInt();
    }
    public static void printChoice(int choice, int stars){
        switch(choice){
            case 1:
                printHorizontalStars(stars);
                break;
            case 2:
                printVerticalStars(stars);
                break;
            case 3:
                printNxNStars(stars);
                break;
            case 4:
                printOneToNStars(stars);
                break;
            case 5:
                printNToOneStars(stars);
                break;
            case 6:
                System.out.println("Quitting App");
                break;
            default:
                System.out.println("Please enter a correct value: ");
                break;
        }
    }
    public static void printHorizontalStars(int stars){
        for(int i = 0; i <= stars; i++){
            System.out.print("*");
        }
        //Empty line so the output is more readable
        System.out.println();
    }
    public static void printVerticalStars(int stars){
        for(int i = 0; i <= stars; i++){
            System.out.println("*");
        }
    }
    public static void printNxNStars(int stars){
        for(int i = 0; i <= stars; i++){
            for(int j = 0; j <= stars; j++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
    public static void printOneToNStars(int stars){
        for(int i = 0; i < stars; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
    public static void printNToOneStars(int stars){
        for(int i = 1; i <= stars; i++){
            for(int j = stars; j > i; j--){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
