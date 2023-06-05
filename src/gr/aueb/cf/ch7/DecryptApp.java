package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Decrypts a user given text (string)
 *
 * @author Ntirintis John
 */
public class DecryptApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String text = "";

        System.out.println("Please enter the text you want to decrypt:");

        // Gets user input
        text = sc.nextLine();

        System.out.println(decryption(text));
    }

    /**
     * Decrypts the given text by subtracting 1 from the ASCII value of the characters
     *
     * @param encrypted     the encrypted text
     * @return              the decrypted text
     */
    public static String decryption(String encrypted){
        String decrypted = "";

        // Traverse through the encrypted text
        for(int i = 0; i < encrypted.length(); i++){
            // On a given char, get its ASCII value and then subtract 1
            // Finally, add it to the decrypted string
            decrypted += encrypted.charAt((int) i) - 1;
        }

        return decrypted;
    }
}
