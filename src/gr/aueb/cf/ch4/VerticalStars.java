package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Prints n vertical stars
 *
 * @author Ntirintis John
 */
public class VerticalStars {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stars;

        System.out.println("Please enter the amount of n vertical stars you want: ");
        stars = sc.nextInt();

        for(int i = 0; i <= stars; i++){
            System.out.println("*");
        }
    }
}
