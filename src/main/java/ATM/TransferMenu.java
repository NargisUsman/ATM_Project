package ATM;

import java.util.Scanner;

public class TransferMenu {

    public enum accountType {
        ACCOUNT_CHECKING,
        ACCOUNT_SAVINGS,
        ACCOUNT_MONEY_MARKET
    }

    public static void transferMenu(int clientNum) {
        System.out.println("Choose which account to transfer from?\n" +
                "1. Checking account\n" +
                "2. Savings account\n" +
                "3. Money Market\n" +
                "4. Back to Main Menu\n" +
                "5. Exit");

        options(clientNum);
    }

    public static void options(int clientNum) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        accountType type = accountType.ACCOUNT_CHECKING;
        int numAccountColumn = 0;
        int accountSheet = 0;
        switch (from) {
            case 1:
                type = accountType.ACCOUNT_CHECKING;
                numAccountColumn = 6;
                accountSheet = 1;
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
                from = sc.nextInt() - 1;  // Ash will let me know what is the(-) for
                System.out.println("Selected Account: " + accNum[from] + ", balance: " + balance[from]);
                break;
            case 2:
                type = accountType.ACCOUNT_SAVINGS;
                numAccountColumn = 5;
                accountSheet = 2;
                numAccounts = Integer.parseInt(DataBase.readExcelFile(0, clientNum, numAccountColumn));
                System.out.println("NumAccounts: " + numAccounts);
                int accID[] = new int[numAccounts];
                int bal[] = new int[numAccounts];
                int withdrwl[] = new int[numAccounts];
                for (int i = 0; i < numAccounts; i++) {
                    String accDetails[] = DataBase.readExcelFile(accountSheet, i + 1, clientNum).split("#");
                    accID[i] = Integer.parseInt(accDetails[0]);
                    bal[i] = Integer.parseInt(accDetails[1]);
                    withdrwl[i] = Integer.parseInt(accDetails[2]);
                    System.out.println(i + 1 + ". " + accID[i]);
                }
                System.out.print("Select Account: ");
                from = sc.nextInt() - 1;  // Ash will let me know what is the(-) for
                System.out.println("Selected Account: " + accID[from] + ", balance: " + bal[from]);
                break;
            case 3:
                type = accountType.ACCOUNT_MONEY_MARKET;
                System.out.println("Cannot have any transfers in Money Market");
                break;
            case 4:
                MainMenu.menu(clientNum);
                break;
            default:
                System.out.println("Wrong choice, please try again");
                MainMenu.menu(clientNum);
        }

        System.out.println("Which account transfer to?\n1.Checking\n2.Saving");
        Scanner scan = new Scanner(System.in);
        int transTo = scan.nextInt();
        int numAccounts = Integer.parseInt(DataBase.readExcelFile(0, clientNum, numAccountColumn));
        System.out.println("NumAccounts: " + numAccounts);
        int accNum[] = new int[numAccounts];
        int balance[] = new int[numAccounts];
        int withdarawl[] = new int[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            String accDetails[] = DataBase.readExcelFile(transTo, i + 1, clientNum).split("#");
            accNum[i] = Integer.parseInt(accDetails[0]);
            balance[i] = Integer.parseInt(accDetails[1]);
            withdarawl[i] = Integer.parseInt(accDetails[2]);
            System.out.println(i + 1 + ". " + accNum[i]);
        }
        System.out.print("Select Account: ");
        transTo = sc.nextInt() - 1;  // Ash will let me know what is the(-) for
        System.out.println("Selected Account: " + accNum[transTo] + ", balance: " + balance[transTo]);
        System.out.println("Enter the amount");
        scan = new Scanner(System.in);
        int amt = scan.nextInt();
        if (amt < balance[from]) {
            balance[transTo] += amt;
            balance[from] -= amt;
        } else {
            System.out.println("Insufficient amount");
            return;
        }
        String accDetailsStr = accNum[transTo] + "#" + balance[transTo] + "#" + withdarawl[transTo];
        DataBase.writeExcelFile(accountSheet, accDetailsStr, transTo + 1, clientNum);
        String accDetail = accNum[from] + "#" + balance[from] + "#" + withdarawl[from];
        DataBase.writeExcelFile(accountSheet, accDetail, from + 1, clientNum);
        System.out.println("Transfer is Successful!");

        System.out.println("The account " + accNum[transTo] + " has this amount $" + balance[transTo]);
        System.out.println("The account " + accNum[from] + " has this amount $" + balance[from]);

        System.out.println("Are you done or do you like to go back to Main Menu?\n1. Main Menu\n2. Exit");
        int x = scan.nextInt();
        if (x == 1) {
            MainMenu.menu(clientNum);
        } else {
            Exit.exit(clientNum);
        }

    }
}
