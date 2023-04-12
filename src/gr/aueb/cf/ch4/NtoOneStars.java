package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Prints from n to 1 Stars
 *
 * @author Ntirintis John
 */
public class NtoOneStars {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stars;

        System.out.println("Please give the amount of stars you want: ");
        stars = sc.nextInt();

//        First loop handles the vertica part
//        It makes sure that the "levels" of the "triangle" are correct
        for(int i = 0; i < stars; i++){
            // Second loop handles the horizontal part
            // It makes sure that the line has the correct amount of stars
            // it slowly decreases until it only prints 1 star
            for(int j = stars - 1; j > i; j--){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
