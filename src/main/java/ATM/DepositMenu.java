package ATM;

import java.util.Scanner;


public class DepositMenu {

    public enum accountType {
        ACCOUNT_CHECKING,
        ACCOUNT_SAVINGS,
        ACCOUNT_MONEY_MARKET
    };

    int amt = 0;
    double balance;

    /**
     * Create methods for Deposit Menu that will give the customer account options, deposit options and
     * will print transaction history.
     */

    public static void depositMenu(int clientNum) {
        System.out.println("Choose which account to deposit?\n" +
                "1. Checking account\n" +
                "2. Savings account\n" +
                "3. Money Market\n" +
                "4. Back to MM\n" +
                "5. Exit");

        options(clientNum);
    }
    public static void options(int clientNum) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        accountType type = accountType.ACCOUNT_CHECKING;
        int numAccountColumn = 0;
        int accountSheet = 0;
        switch (choice) {
            case 1:
                type = accountType.ACCOUNT_CHECKING;
                numAccountColumn = 6;
                accountSheet = 1;
                break;
            case 2:
                type = accountType.ACCOUNT_SAVINGS;
                numAccountColumn = 5;
                accountSheet = 2;
                break;
            case 3:
                type = accountType.ACCOUNT_MONEY_MARKET;
                numAccountColumn = 4;
                accountSheet = 3;
                break;
            case 4:
                MainMenu.menu(clientNum);
                break;
            default:
                System.out.println("Wrong choice, please try again");
                MainMenu.menu(clientNum);
        }

        int numAccounts = Integer.parseInt(DataBase.readExcelFile(0, clientNum, numAccountColumn));
        System.out.println("NumAccounts: " + numAccounts);
        int accNum[] = new int[numAccounts];
        int balance[] = new int[numAccounts];
        int withdarawl[] = new int[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            String accDetails[] = DataBase.readExcelFile(accountSheet, i + 1, clientNum).split("#");
            accNum[i] = Integer.parseInt(accDetails[0]);
            balance[i] = Integer.parseInt(accDetails[1]);
            withdarawl[i] = Integer.parseInt(accDetails[2]);
            System.out.println(i + 1 + ". " + accNum[i]);
        }
        System.out.print("Select Account: ");

        choice = sc.nextInt() - 1;  // Ash will let me know what is the(-) for
        System.out.println("Selected Account: " + accNum[choice] + ", balance: " + balance[choice]);

        System.out.println("How do you like to deposit?\n1.Cash\n2.Check");
        Scanner scan = new Scanner(System.in);
        int depositChoice = scan.nextInt();
        if (depositChoice == 1) {
            System.out.println("Enter the amount");
            int amt = scan.nextInt();
            balance[choice] += amt;
            String accDetailsStr = accNum[choice] + "#" + balance[choice] + "#" + withdarawl[choice];
            DataBase.writeExcelFile(accountSheet, accDetailsStr, choice + 1, clientNum);
            System.out.println("Deposit Successful! Amount deposited: " + amt + ", balance: " + balance[choice]);
        } else {
            System.out.println("Enter the check number");
            // Ask Dmitrii to create check number on DataBase
            int checkNum = scan.nextInt();
            System.out.println("Enter the amount");
            int amt = scan.nextInt();
            balance[choice] += amt;
            String accDetailsStr = accNum[choice] + "#" + balance[choice] + "#" + withdarawl[choice];
            DataBase.writeExcelFile(accountSheet, accDetailsStr, choice + 1, clientNum);
            System.out.println("Deposit Successful! Amount deposited: " + amt + ", balance: " + balance[choice]);

        }
    }

}






