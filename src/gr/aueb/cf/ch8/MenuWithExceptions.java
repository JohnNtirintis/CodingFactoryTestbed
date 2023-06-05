package gr.aueb.cf.ch8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * A simple program that prints a menu with 5 options for the user,
 * then lets the user decide which option to pick by asking for their choice using a scanner,
 * finally it prints their choice.
 *
 * @author Ntirintis John
 */

public class MenuWithExceptions {
    final static Scanner sc = new Scanner(System.in);
    // Path to the .txt to log the errors
    // You can also change it to your desired path location if needed
    final static Path PATH = Paths.get("C:\\tmp\\log-menu.txt");

    public static void main(String[] args) {
        int choice = 0;
        do{
            try {
                printMenu();
                System.out.println("Please enter your choice:");
                choice = getChoice();
                printChoice(choice);
            } catch (IllegalArgumentException e){
                System.err.println("Invalid int. Please input an int ranging from 1 to 5.");
            }
        }while(choice != 5);
    }

    public static int getChoice(){
        while(true){
            // Checks to see if the user input was an int,
            // If true then insert the value in the choice var
            if(sc.hasNextInt()){
                return sc.nextInt();
            }
            else {
                System.out.println("Please enter an int.");
                // clear the current line of input, to prepare it for a new input
                sc.nextLine();
            }
        }
    }

    public static void printMenu(){
        System.out.println("1. Tell me a joke about Java.");
        System.out.println("2. Tell me a riddle.");
        System.out.println("3. Tell me the answer of the riddle");
        System.out.println("4. Marco");
        System.out.println("5. Exit");
    }

    public static void printChoice(int choice) throws IllegalArgumentException{
        try {
            switch (choice) {
                case 1 -> System.out.println("What's an object-oriented way to become wealthy? \n Inheriting from a wealthy class!");
                case 2 -> System.out.println("I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?");
                case 3 -> System.out.println("Answer: An echo.");
                case 4 -> System.out.println("Polo");
                case 5 -> System.out.println("Quitting Application. Goodbye.");
                // Can add user-friendly explanation here if needed
                // In this case, the error is handled in the main
                // Where the user-friendly message is also printed to guide the user
                default -> throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            log(e);
            throw e;
        }
    }

    public static void log(Exception e, String... message){
        // Creating a try with arguments.
        // In this case we create a PrintStream object with the file output set to PATH that we declared earlier
        try (PrintStream ps = new PrintStream(new FileOutputStream(PATH.toFile(), true))){
            // logs the time during the error and then logs the error it self
            ps.println(LocalDateTime.now() + "\n" + e.toString());
            ps.printf("%s ", (message.length == 1) ? message[0] : "");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
