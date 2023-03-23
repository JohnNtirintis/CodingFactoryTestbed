package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Ασκηση 1, ch2
 *
 * Υλοποιηση προγραμματος που μετατρεπει
 * Μοναδες κελσιου σε φαρενχαϊτ
 *
 * @author Ntirintis Ioannis-Panagiotis
 */

public class FahrenheitToCelsius {
    public static void main(String[] args) {

        //Fahrenheit to celsius formula: (5/9)(F-32)
        Scanner in = new Scanner(System.in);
        System.out.println("Παρακαλω εισαγεται μια ακεραια τιμη θερμοκρασιας fahrenheit: ");
        int fr = in.nextInt();

        //We have to change the formula that converts Fahrenheit to Celsius
        //Because it will always result to 0, due to the 5/9 expression
        int result = 5 * (fr - 32) / 9;

        System.out.printf("%d Βαθμοι φαρενχαϊτ αντιστοιχουν σε %d μοναδες κελσιου. \n", fr, result);
    }
}
