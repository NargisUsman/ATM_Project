package ATM;

import java.util.Scanner;

public class Withdraw {
    public enum accountType {
        ACCOUNT_CHECKING,
        ACCOUNT_SAVINGS,
        ACCOUNT_MONEY_MARKET
    };
    static int [] bills = new int[]{ 100, 50, 20, 10, 5, 1};

    double balance;
    double amount;


    public static void menu(int clientNum, boolean feeWithDrawal) {
        String title = "Withdraw Menu";
        if (feeWithDrawal)
            title = "Fee Withdraw Menu";

        System.out.println("\t-= " + title + " =-\n" +
                "Choose from the following:\n" +
                "1. Checking\n" +
                "2. Savings\n" +
                "3. Money Market\n" +
                "4. Back to Main Menu\n");

        options(clientNum, feeWithDrawal);
    }

    public static void options(int clientNum, boolean feeWithDrawal) {

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        accountType type = accountType.ACCOUNT_CHECKING;
        int numAccountColumn = 0;
        int accountSheet = 0;

        switch (choice) {
            case 1:
                // Checking;
                type = accountType.ACCOUNT_CHECKING;
                numAccountColumn = 6;
                accountSheet = 1;
                //WithDrawMethods.CheckingAcc(clientNum);
                break;
            case 2:
                // Savings
                type = accountType.ACCOUNT_SAVINGS;
                numAccountColumn = 5;
                accountSheet = 2;
                //WithDrawMethods.SavingsAcc(clientNum);
                break;
            case 3:
                // Money Market
                type = accountType.ACCOUNT_MONEY_MARKET;
                System.out.println("Cannot Withdraw from this account(s) !");
                MainMenu.menu(clientNum);
                break;
            case 4:
                // Main Menu Screen
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
        int withdrawals[] = new int[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            String accDetails[] = DataBase.readExcelFile(accountSheet, i + 1, clientNum).split("#");
            accNum[i] = Integer.parseInt(accDetails[0]);
            balance[i] = Integer.parseInt(accDetails[1]);
            withdrawals[i] = Integer.parseInt(accDetails[2]);
            System.out.println(i+ 1 + ". " + accNum[i]);
        }
        System.out.print("Select Account: ");

        choice = sc.nextInt() - 1;
        System.out.println("Selected Account: " + accNum[choice] + ", balance: " + balance[choice]);

        int amt = 2;
        if (!feeWithDrawal) {
            System.out.print("Enter the amount to withdraw: ");
            amt = sc.nextInt();
        }

        if (amt > balance[choice]) {
            System.out.println("Insufficient funds!");
            return;
        }

        if (!feeWithDrawal && type == accountType.ACCOUNT_SAVINGS &&
            withdrawals[choice] >= 6) {
            System.out.println("There will be a fee of 2$ for withdrawal!");
            menu(clientNum, true);

        }

        balance[choice] -= amt;
        if (!feeWithDrawal)
            withdrawals[choice]++;

        String accDetailsStr = accNum[choice] + "#" + balance[choice] + "#" + withdrawals[choice];
        DataBase.writeExcelFile(accountSheet, accDetailsStr, choice + 1, clientNum);
        System.out.println("Withdrawal Successful! Amount WithDrawn: " + amt + ",balance: " + balance[choice]);

        if (feeWithDrawal)
            return;

        int numBills[] = new int[bills.length];
        int tmpAmt = amt;
        for (int i = 0; i < bills.length && tmpAmt > 0; i++) {
            numBills[i] = tmpAmt / bills[i];
            tmpAmt = tmpAmt % bills[i];
        }
        System.out.println("Bills delivered:");
        for (int i = 0; i < bills.length; i++) {
            if (numBills[i] == 0)
                continue;
            System.out.println(bills[i] + " : " + numBills[i]);
        }
    }

}

