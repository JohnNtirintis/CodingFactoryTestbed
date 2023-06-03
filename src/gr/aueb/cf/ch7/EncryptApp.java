package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * @author Ntirintis John
 */
public class EncryptApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String text = "";

        System.out.println("Please enter the text you want to encrypt:");

        text = sc.nextLine();

        System.out.println(encryption(text));
    }

    public static String encryption(String text){
        String encrypted = "";
        int letter = 0;
        for(int i = 0; i < text.length(); i++){
            letter = (int) text.charAt(i);
            encrypted += Integer.toString(letter);
        }
        return encrypted;
    }
}
