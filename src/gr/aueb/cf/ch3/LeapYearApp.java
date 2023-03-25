package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Application that checks if a year is leap or not
 *
 * @author Ioannis-Panagiotis Ntirintis
 */
public class LeapYearApp {
    public static void main(String[] args) {

        //Creating scanner for user input
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the year you want to check if its leap or not: ");
        int year = in.nextInt();

        //Checking to see if it's a leap
        //Used multiple if statements instead of 1 large one,
        //to make it more readable
        if(year % 4 == 0 && year % 100 != 0){
            System.out.println("It is a leap year.");
        }
        else if(year % 4 == 0 && year % 100 != 0 && year % 400 != 0){
            System.out.println("It is a leap year.");
        }
        else if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0){
            System.out.println("It is a leap year.");
        }
        else{
            System.out.println("It's not a leap year.");
        }
    }
}
