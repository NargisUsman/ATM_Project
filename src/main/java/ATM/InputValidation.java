package ATM;

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
}
