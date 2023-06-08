package gr.aueb.cf.ch9;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    // Static scanner so it can be available globally
    // We could also use a scanner in main, and pass it to the functions that need/use it in their args/params.
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Feel free to change this path to any path you want
        String filePath = "C:/tmp/grading.txt";

        // Holds the count of students
        // Helps with the indexing
        int count = 0;

        // 2D array to store data for 4 students
        // and for 5 variables for each student:
        // FirstName LastName Grade1 Grade2 Average(Of the 2 grades)
        String[][] student = new String[4][5];

        // try-with-resources that inits a print writer that will be used later to print/write the data in a txt file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filePath))){
            // A for loop to traverse through the 2d students array and insert values
            for(int i = 0; i < student.length; i++) {
                student[count][0] = getFirstName();
                student[count][1] = getLastName();
                int[] grades = getGrades();
                student[count][2] = String.valueOf(grades[0]);
                student[count][3] = String.valueOf(grades[1]);
                student[count][4] = String.valueOf((grades[0] + grades[1]) / 2.0);

                // Increase the count to access the data from the next student.
                count++;
            }
            for (String[] strings : student) {
                // Accesses each element of the students array and prints it to the file
                // Using the PrintWriter pw
                for (int j = 0; j < strings.length; j++) {
                    pw.print(strings[j]);
                    // Checks to see if it's not in the last element of the array
                    // If its true (it's not in the last element) it will print a space
                    // to separate the words/numbers for readability purposes.
                    if (j < strings.length - 1) {
                        pw.print(" ");
                    }
                }
                // Change line for the next student
                pw.println();
            }
        } catch (IOException e){
            log(e);
            System.out.println("Desired File was not located or it doesnt exist.");
        }
    }
    /**
     * Logs the given exception to a log file with the date/time that the exception occurred
     *
     * @param e The exception to log
     * @param message Optional additional message to include in the log entry
     */
    public static void log(Exception e, String... message){
        try (PrintStream ps = new PrintStream(new FileOutputStream("C:/tmp/exe-logger.txt", true))){
            ps.println(LocalDateTime.now() + "\n" + e.toString());
            ps.printf("%s", (message.length == 1) ? message[0] : "");
        } catch (FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * Prompts the user to enter the first name of a student,
     * checks it for validity, and returns it.
     * The method will keep asking for input until a valid first name is provided.
     * A valid name contains only letters from the alphabet.
     *
     * @return A valid first name of a student
     */
    public static String getFirstName(){
        String firstName = "";
        System.out.println("Please enter the first name of the student");
        while(true){
            try{
                firstName = sc.nextLine();
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

    /**
     * Prompts the user to enter the last name of a student,
     * checks it for validity, and returns it.
     * The method will keep asking for input until a valid last name is provided.
     * A valid last name contains only letters from the alphabet.
     *
     * @return A valid last name of a student
     */
    public static String getLastName(){
        String lastName = "";
        while(true){
            System.out.println("Please enter the last name of the student");
            try{
                lastName = sc.nextLine();
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
