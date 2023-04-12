package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Prints n horizontal stars
 *
 * @author Ntirintis Ioannis-Panaagiotis
 */
public class HorizontalStars {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stars;

        System.out.println("Please enter the number (integer) of stars you want: ");
        stars = sc.nextInt();

        for(int i = 0; i <= stars; i++){
            System.out.print("*");
        }
    }
}
