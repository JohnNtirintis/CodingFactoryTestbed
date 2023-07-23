package gr.aueb.cf.ch11;

import gr.aueb.cf.ch11.model.User;
import gr.aueb.cf.ch11.model.UserCredentials;

/**
 * @author Ntirintis John
 */
public class Main {
    public static void main(String[] args) {
        User user = new User(123456, "John", "Ntirintis");
        UserCredentials userCred = new UserCredentials(789456, "John2", "Ntirintis2");

        System.out.println(user);
        System.out.println(userCred);
    }
}
