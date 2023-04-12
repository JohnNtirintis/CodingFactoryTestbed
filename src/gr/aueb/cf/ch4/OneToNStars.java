package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Prints from 1 to N stars
 *
 * @author Ntirintis John
 */
public class OneToNStars {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stars;

        System.out.println("Please give the amount of stars you want: ");
        stars = sc.nextInt();

        // Always prints at least 1-star
        // Prints as many stars as the user will input
        for(int i = stars; i >= 0; i--){
            for(int j = stars; j > i; j--){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
