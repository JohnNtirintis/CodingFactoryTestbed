package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Encrypts a user given text (string)
 *
 * @author Ntirintis John
 */
public class EncryptApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String text = "";

        System.out.println("Please enter the text you want to encrypt:");

        // Gets user input
        text = sc.nextLine();

        System.out.println(encryption(text));
    }

    /**
     * Encrypts a given String by taking each character separately and changing it to the ASCII value
     * @param text  String that must be encrypted
     * @return      Returns the encrypted String
     */
    public static String encryption(String text){
        String encrypted = "";
        int letter = 0;
        // Traversing through the un-encrypted string
        for(int i = 0; i < text.length(); i++){
            // Taking its character of the string separately, finding its ASCII value
            // and adding it to the encrypted string.
            letter = (int) text.charAt(i);
            encrypted += Integer.toString(letter);
        }
        return encrypted;
    }
}
