package gr.aueb.cf.ch9;

import java.io.*;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program reads the Name, Surname, and two Grades of students,
 * calculates the average grade, and prints the Name, Surname, and average grade
 * for each student to the file primOut.txt.
 * It also logs any errors to the log file log.txt.
 *
 * @author Ntirintis John
 */
public class SchoolGradingApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;

        String[][] student = new String[4][5];

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("C:/tmp/exe1.txt"))){
            for(int i = 0; i < student.length; i++) {
                student[count][0] = getFirstName();
                student[count][1] = getLastName();
                int[] grades = getGrades();
                student[count][2] = String.valueOf(grades[0]);
                student[count][3] = String.valueOf(grades[1]);
                student[count][4] = String.valueOf((grades[0] + grades[1]) / 2.0);
                count++;
            }
            for (String[] strings : student) {
                for (int j = 0; j < strings.length; j++) {
                    pw.print(strings[j]);
                    if (j < strings.length - 1) {
                        pw.print(" ");
                    }
                }
                pw.println();
            }
        } catch (IOException e){
            log(e);
            System.out.println("Desired File was not located or it doesnt exist.");
        }
    }

    public static void log(Exception e, String... message){
        try (PrintStream ps = new PrintStream(new FileOutputStream("C:/tmp/exe-logger.txt", true))){
            ps.println(LocalDateTime.now() + "\n" + e.toString());
            ps.printf("%s", (message.length == 1) ? message[0] : "");
        } catch (FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }

    public static String getFirstName(){
        String firstName = "";
        System.out.println("Please enter the first name of the student");
        while(true){
            try{
                firstName = sc.next();
                // Makes sure that the entire string is letters from the alphabet
                if(firstName.trim().matches("^[a-zA-Z]+$")){
                    return firstName;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                log(e);
                System.out.println("Please enter only letters from the alphabet and no special characters or any numbers.");
            }
        }
    }

    public static String getLastName(){
        String lastName = "";
        while(true){
            System.out.println("Please enter the last name of the student");
            try{
                lastName = sc.next();
                // Makes sure that the entire string is letters from the alphabet
                if(lastName.trim().matches("^[a-zA-Z]+$")){
                    return lastName;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                log(e);
                System.out.println("Please enter only letters from the alphabet and no special characters or any numbers.");
            }
        }
    }

    /**
     * Asks the user to input two grades for a student.
     * If the input is not valid, it will continue to ask until valid input is provided.
     *
     * @return  an int[] array with 2 grades of a student
     * @throws IllegalArgumentException if the int are not in range 1-10
     * @throws InputMismatchException if the user doesn't input int
     */
    public static int[] getGrades() {
        int[] grades = new int[2];
        int input;

        for(int i = 0; i < grades.length; i++){
            boolean validInput = false;
            while(!validInput){
                try {
                    System.out.println("Please enter grade " + (i+1) + " of the student. Must be between 1 and 10.");
                    // Checking to see if user input is valid and meets the requirements
                    if(sc.hasNextInt()){
                        input = sc.nextInt();
                        if(input < 1 || input > 10){
                            throw new IllegalArgumentException();
                        }
                        grades[i] = input;
                        // If all the requirements were met and the input was valid, set the validInput to true,
                        // Thus breaking the loop and returning the values.
                        validInput = true;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("Please enter a num ranging between 1 and 10.");
                    // Clear the scanner to prepare it for another input
                    sc.nextLine();

                } catch (InputMismatchException ex){
                    System.out.println("Please enter an integer.");
                    // Clear the scanner to prepare it for another input
                    sc.nextLine();
                }
            }
        }
        return grades;
    }
}
