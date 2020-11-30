package ATM;

import java.util.Scanner;

public class Withdraw extends TransactionsHistory {
    public enum accountType {
        ACCOUNT_CHECKING,
        ACCOUNT_SAVINGS,
        ACCOUNT_MONEY_MARKET
    };
    static int [] bills = new int[]{ 100, 50, 20, 10, 5, 1};

    public static void menu(int clientNum, boolean feeWithDrawal) {
        String title = "Withdraw Menu";
        String titlePrompt = "Choose from the following:\n";
        if (feeWithDrawal) {
            title = "Fee Withdraw Menu";
            titlePrompt = "Choose from the following for deducting the fees:\n";
        }

        System.out.println("\t-= " + title + " =-\n" +
                "" + titlePrompt +
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
        boolean userConsentForFee = false;

        switch (choice) {
            case 1:
                // Checking;
                type = accountType.ACCOUNT_CHECKING;
                numAccountColumn = 6;
                accountSheet = 1;
                break;
            case 2:
                // Savings
                type = accountType.ACCOUNT_SAVINGS;
                numAccountColumn = 5;
                accountSheet = 2;
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
        int allowableWithdrawals[] = new int[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            String accDetails[] = DataBase.readExcelFile(accountSheet, i + 1, clientNum).split("#");
            accNum[i] = Integer.parseInt(accDetails[0]);
            balance[i] = Integer.parseInt(accDetails[1]);
            allowableWithdrawals[i] = Integer.parseInt(accDetails[2]);
            System.out.println((i + 1) + ". " + accNum[i]);
        }
        System.out.print("Select Account: ");

        choice = sc.nextInt() - 1;
        System.out.println("Selected Account: " + accNum[choice] + ", balance: " + balance[choice]);

        int amt = 0;
        if (!feeWithDrawal) {
            System.out.print("Enter the amount to withdraw: ");
            amt = sc.nextInt();
        } else {
            // Fee withdrawal. No need to ask user.
            // Amount to withdraw is 2 USD
            amt = 2;
        }

        if (amt > balance[choice]) {
            System.out.println("Insufficient funds!");
            return;
        }
        if(amt < 0){
                System.out.println("Invalid Input");
                return;
        }

        if (!feeWithDrawal && type == accountType.ACCOUNT_SAVINGS &&
                allowableWithdrawals[choice] == 0) {
            System.out.println("There will be a fee of $2 for this withdrawal! Do you want to continue? Y or N");
            sc.nextLine();
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                System.out.println("User aborted transaction, returning!");
                return;
            }
            userConsentForFee = true;
        }

        balance[choice] -= amt;
        if (!feeWithDrawal) {
            if (allowableWithdrawals[choice] > 0)
                allowableWithdrawals[choice]--;
        }

        String accDetailsStr = accNum[choice] + "#" + balance[choice] + "#" + allowableWithdrawals[choice];
        DataBase.writeExcelFile(accountSheet, accDetailsStr, choice + 1, clientNum);

        sList.add("Account #" + accNum[choice] + " - amount of withdrawal: $" + amt + "check: #" + " current balance: $" + balance[choice] + "\n");


        if (!feeWithDrawal && userConsentForFee) {
            // Call menu() and option() once again to deduct the fees.
            menu(clientNum, true);
        }

        if (feeWithDrawal) {
            System.out.println("Fee(2 USD) Deducted from Account: ");
            return;
        } else
            System.out.println("Withdrawal Successful from Account: " + accNum[choice] +
                    ", Amount WithDrawn: " + amt + ",balance: " + balance[choice]);


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

        System.out.println("Are you done or do you like to go back to Main Menu?\n1. Main Menu\n2. Exit");
        int x = sc.nextInt();
        if(x == 1) {
            MainMenu.menu(clientNum);
        } else {
            Exit.exit(clientNum);
        }
    }

}

