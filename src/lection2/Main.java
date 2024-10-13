package lection2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the login");
        String login = in.next();
        System.out.println("Please enter the password");
        String password = in.next();
        System.out.println("Please enter the password again");
        String confirmPassword = in.next();

        /* Hardcore input for easy testing
        String login = "user_1";
        String password = "123";
        String confirmPassword = "321";
         */

        boolean isDataCorrect = Authorization.authorization(login, password, confirmPassword);
        System.out.println(isDataCorrect);
    }
}