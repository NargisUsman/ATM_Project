package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    /**
     * create a method that printing questions ang getting answers
     * then connect client choices with menu options and methods for thous options
     */

    public static void menu(int clientNum) {

        System.out.println("""
                
                     -= Main Menu =-
                Choose from the following:
                1. Deposit
                2. Withdraw
                3. Transfer
                4. Balance
                5. Exit""");

        options(clientNum);
    }

    public static void options(int clientNum) {


    int choice = InputValidation.inputValidationMenu(clientNum);

        switch (choice) {
            case 1:
                //call Deposit Method
                DepositMenu.depositMenu(clientNum);
                break;
            case 2:
                //call Withdraw Method
                Withdraw.menu(clientNum, false);
                break;
            case 3:
                //call Transfer Method
                TransferMenu.transferMenu(clientNum);
                break;
            case 4:
                //call Balance Method
                //BalanceClass.menu(clientNum);
                System.out.println("We are working on this feature and it will be here soon");
                System.out.println("Thank you for your interest");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MainMenu.menu(clientNum);
                break;
            case 5:
                //call Exit Method
                Exit.exit(clientNum);
                break;
            default:
                System.out.println("Wrong input, please try again");
                options(clientNum);
        }
    }
}
