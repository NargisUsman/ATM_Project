package ATM;

import java.util.Scanner;


public class DepositMenu {

    private static int balance = 0;

    /**
     * Create methods for Deposit Menu that will give the customer account options, deposit options and
     *  will print transaction history.
     */

    public static void depositMenu(){
        System.out.println("Choose which account to deposit?\n" +
                "1. Checking account\n" +
                "2. Savings account\n" +
                "3. Money Market\n" +
                "4. Back to MM\n" +
                "5. Exit");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option) {
            case 1:
                //DepositMenu.checkingOptions();
                break;
            case 2:
                //DepositMenu.savingsOptions();
                break;
            case 3:
                //DepositMenu.moneyMarketOptions();
                break;
            case 4:
                //MainMenu.menu();
                break;
            case 5:
                System.out.println("Exit");
            default:
                System.out.println("Wrong input, please try again");

        }

    }

//    public static void checkingOptions() {
//        if (DataBase.readExcelFile() > 1) {
//            System.out.println("Which account to deposit?");
//            for (int i = 0; i <= DataBase.lengthOfList(); i++) {
//                System.out.println("Checking account" + DataBase.readExcelFile());
//            }
//        } else {
//            System.out.println("Enter the amount you like to deposit");
//            Scanner scan = new Scanner(System.in);
//            int amount = scan.nextInt();
//            if (amount > 0) {
//                System.out.println("How do you want to deposit?\n1 Cash\n2 Check");
//                Scanner scan1 = new Scanner(System.in);
//                int result = scan1.nextInt();
//                if (result == 1) {
//                    balance += amount;
//                } else {
//                    System.out.println("Enter the check number");
//                    Scanner scan2 = new Scanner(System.in);
//                    String checkNum = scan2.nextLine();
//                    DataBase.writeExcelFile(checkNum, 0, 1);
//                    System.out.println("Enter the amount");
//                    Scanner scan3 = new Scanner(System.in);
//                    int checkAmount = scan3.nextInt();
//                    balance += checkAmount;
//                }
//            }
//        }
//    }
//
//    public static void savingsOptions() {
//        if(DataBase.readExcelFile()>1) {
//            System.out.println("Which account to deposit?");
//            for(int i =0; i<=DataBase.lengthOfList(); i++) {
//                System.out.println("Savings account" + DataBase.readExcelFile());
//            }
//        } else {
//            System.out.println("Enter the amount you like to deposit");
//            Scanner scan = new Scanner(System.in);
//            int amount = scan.nextInt();
//            if(amount>0) {
//                System.out.println("How do you want to deposit?\n1 Cash\n2 Check");
//                Scanner scan1 = new Scanner(System.in);
//                int result = scan1.nextInt();
//                if(result==1) {
//                    balance+=amount;
//                } else {
//                    System.out.println("Enter the check number");
//                    Scanner scan2 = new Scanner(System.in);
//                    String checkNum = scan2.nextLine();
//                    DataBase.writeExcelFile(checkNum, 0, 1);
//                    System.out.println("Enter the amount");
//                    Scanner scan3 = new Scanner(System.in);
//                    int checkAmount = scan3.nextInt();
//                    balance += checkAmount;
//                }
//            }
//        }
//
//    }
//
//    public static void moneyMarketOptions() {
//        if(DataBase.readExcelFile()>1) {
//            System.out.println("Which account to deposit?");
//            for(int i =0; i<=DataBase.lengthOfList(); i++) {
//                System.out.println("Money Market account" + DataBase.readExcelFile());
//            }
//        } else {
//            System.out.println("Enter the amount you like to deposit");
//            Scanner scan = new Scanner(System.in);
//            int amount = scan.nextInt();
//            if(amount>0) {
//                System.out.println("How do you want to deposit?\n1 Cash\n2 Check");
//                Scanner scan1 = new Scanner(System.in);
//                int result = scan1.nextInt();
//                if(result==1) {
//                    balance+=amount;
//                } else {
//                    System.out.println("Enter the check number");
//                    Scanner scan2 = new Scanner(System.in);
//                    String checkNum = scan2.nextLine();
//                    DataBase.writeExcelFile(checkNum, 0, 1);
//                    System.out.println("Enter the amount");
//                    Scanner scan3 = new Scanner(System.in);
//                    int checkAmount = scan3.nextInt();
//                    balance += checkAmount;
//                }
//            }
//        }
//    }

    public void printReceipt () {
        System.out.println("Do you want to print the transaction history?");
        Scanner scan = new Scanner(System.in);
        String msg = scan.nextLine();
        //TransactionsHistory.transactions();
    }

}









