package ATM;

public class TransactionsHistory {

    public static void transactions(int clientNum) {

        /**
         * Create a List variable to collect data after every performed transaction during the client session
         * Print the created list if the client asked during the Exit step
         * Clear data for new customer
         */
        System.out.println(
                "Transactions Receipt for " + DataBase.readExcelFile(0, clientNum, 3) +
                "\nSavings account:\n" +
                "Deposited - $320\n" +
                "Balance:\n" +
                "4410747032 - $423.323.2323,02\n" +
                "\nChecking account:\n" +
                "4410747033 - $2323,02\n" +
                "\nMoney Market account:\n" +
                "4410747034 - $423.323.2323,02\n" +
                "today is monday 12/12/2012\n" +
                "Have a nice day\n\n\n");
            }
}
