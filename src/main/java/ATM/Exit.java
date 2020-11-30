package ATM;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Exit extends TransactionsHistory {

    public static void exit(int clientNum) {

        String chlist;
        String savlist;
        String mmarlist;

        System.out.println("Thank you for being our client\n" +
                "Would you like your receipt : Y/N");
        if (InputValidation.inputValidationStrYorN().equalsIgnoreCase("Y")) {
            System.out.println("\n\nReceipt for " + DataBase.readExcelFile(0, clientNum, 3));
            System.out.println(cList);
            if (!cList.isEmpty()) {
                 chlist = Arrays.toString(cList.toArray()).replace(", ", "").replace("[", "").replace("]", "");
            } else {
                 chlist = "No transactions\n";
            }
            if (!sList.isEmpty()) {
                savlist = Arrays.toString(sList.toArray()).replace(", ", "").replace("[", "").replace("]", "");
            } else {
                savlist = "No transactions\n";
            }
            if (!mmList.isEmpty()) {
                mmarlist = Arrays.toString(mmList.toArray()).replace(", ", "").replace("[", "").replace("]", "");
            } else {
                mmarlist = "No transactions\n";
            }

            System.out.println( "Savings: \n" + savlist +
                                "Checking: \n" + chlist +
                                "Money Market: \n" + mmarlist);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            System.out.println(formatter.format(date));
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TransactionsHistory.clearData();
        }
        WelcomeScreen.WelcomeScreen();
    }
}
