package ATM;

public class Exit {

    public static void exit(int clientNum) {
        System.out.println("Thank you for being our client\n" +
                "Would you like your receipt : Y/N");
        if (InputValidation.inputValidationStrYorN().equalsIgnoreCase("Y")) {
            TransactionsHistory.transactions(clientNum);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WelcomeScreen.WelcomeScreen();
    }
}
