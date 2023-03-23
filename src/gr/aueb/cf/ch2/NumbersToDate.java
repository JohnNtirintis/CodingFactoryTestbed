package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Ασκηση 2, ch2
 *
 * Εισαγωγη και εκτυπωση ημερομηνιας
 *
 * @author Ntirintis Ioannis-Panagiotis
 */

public class NumbersToDate {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλω εισαγεται την ημερα: ");
        int day = in.nextInt();

        System.out.println("Παρακαλω εισαγεται τον μηνα: ");
        int month = in.nextInt();

        System.out.println("Παρακαλω εισαγεται το ετος: ");
        int year = in.nextInt();

        System.out.printf("%d/%d/%d", day, month,year);

    }
}
