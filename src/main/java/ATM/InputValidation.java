package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidation {

    public static String inputValidationFourDigits() {

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNext("[0-9]{4}")) {
            System.out.println("That's not a correct input!");
            sc.next();
        }
        return sc.next();
    }

    public static String inputValidationStrYorN() {

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNext("[YyNn]{1}")) {
            System.out.println("That's not a correct input!");
            sc.next();
        }
        return sc.next();
    }

    public static int inputValidationMenu(int clientNum) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        try {
            choice =sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, please try again");
            MainMenu.options(clientNum);
        }
        return choice;
    }
}
