package ATM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Scanner;

public class WelcomeScreen {

    public static void WelcomeScreen() {

        System.out.println(
                        "\t-= Welcome =-\n" +
                        "\t-= Group 1 =-\n" +
                        "  -= ATM Project =-\n" +
                        "Please Enter Card Number");
        disableWarning2();
        Scanner sc = new Scanner(System.in);
        String cardNum = sc.nextLine();

//        String cardNum = InputValidation.inputValidationStr();

        for (int i = 1; i <= DataBase.lengthOfList(); i++) {
            if (cardNum.equals(DataBase.readExcelFile(i, 0))) {
                if (DataBase.readExcelFile(i, 1).equals("0")) {
                    if (isPinCorrect(i)) {
                        MainMenu.menu(i);
                    }
                } else {
                    System.out.println( "Your account is blocked\n" +
                                        "Please call the office\n\n\n");
                }
            }
        }
    }

    public static boolean isPinCorrect(int clientNum) {

        boolean result = false;
        for (int i = 3; i > 0; i--) {
            System.out.println("Enter your PIN");
            Scanner sc = new Scanner(System.in);
            String pin = sc.nextLine();
            if (pin.equals(DataBase.readExcelFile(clientNum, 2))) {
                System.out.println("Welcome " + DataBase.readExcelFile(clientNum, 3));
                result = true;
                break;
            } else {
                System.out.println("Try again\n" +
                        "Remaining attempts: " + (i-1));
                if (i == 1) {
                    System.out.println("Account is blocked - call the office\n\n\n");
                    DataBase.writeExcelFile("1", clientNum, 1);
                    break;
                }
            }
        }
        return result;
    }

    public static void disableWarning1() {
        System.err.close();
        System.setErr(System.out);
    }

    public static void disableWarning2() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
        }
    }
}