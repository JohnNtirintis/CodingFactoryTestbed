package gr.aueb.cf.ch4;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

/**
 * Prints NxN Stars
 *
 * @author Ntirintis John
 */
public class NxNStars {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int verticalStars;
        int horizontalStars;

        System.out.println("Please enter the amount of vertical stars you want" +
                " and then enter the amount of horizontal stars");
        verticalStars = sc.nextInt();
        horizontalStars = sc.nextInt();

        // First for loop handles the vertical part
        for(int i = 0; i <= verticalStars; i++){
            // Second loop handles the horizontal part
            for(int j = 0; j <= horizontalStars; j++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
