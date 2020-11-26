package ATM;

import java.util.Scanner;

public class InputValidation {

    public static int inputValidationInt() {

        Scanner sc = new Scanner(System.in);
        int number = 0;
        do {
            while (!sc.hasNextInt() && number <= 0) {
            System.out.println("Incorrect input!\n" +
                               "Please try again");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);
        return number;
    }

    public static String inputValidationStr() {

        String str = "";
        Scanner sc = new Scanner(System.in);

        do {
            while (sc.hasNext("[0-9]")) {
                System.out.println("Incorrect input!\n" +
                                   "Please try again");
                sc.nextLine();
            }
            str = sc.nextLine();
        } while (str.isEmpty());
        return str;
    }
}
