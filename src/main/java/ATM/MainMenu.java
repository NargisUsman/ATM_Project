package ATM;

import java.util.Scanner;

public class MainMenu {

    /**
     * create a method that printing questions ang getting answers
     * then connect client choices with menu options and methods for thous options
     */

    public static void menu(int clientNum) {

        //Client client = new Client();
        //???how to pass information about client???

        System.out.println("\t-= Main Menu =-\n" +
                "Choose from the following:\n" +
                "1. Deposit\n" +
                "2. Withdraw\n" +
                "3. Transfer\n" +
                "4. Balance\n" +
                "5. Exit");

        options(clientNum);
    }

    public static void options(int clientNum) {

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                //call Deposit Method
//                    DepositClass.deposit(clientNum);
                System.out.println("DepositClass.deposit(clientNum)");
                break;
            case 2:
                //call Withdraw Method
//                    WithdrawClass.deposit(clientNum);
                System.out.println("WithdrawClass.deposit(clientNum)");
                break;
            case 3:
                //call Transfer Method
//                    TransferClass.deposit(clientNum);
                System.out.println("TransferClass.deposit(clientNum)");
                break;
            case 4:
                //call Balance Method
//                    BalanceClass.deposit(clientNum);
                System.out.println("BalanceClass.deposit(clientNum)");
                break;
            case 5:
                //call Exit Method
//                    ExitClass.deposit(clientNum);
                Exit.exit(clientNum);
                //System.out.println("ExitClass.deposit(clientNum)");
                break;
            default:
                System.out.println("Wrong input, please try again");
                options(clientNum);
        }
    }
}
