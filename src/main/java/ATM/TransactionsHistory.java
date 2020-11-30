package ATM;

import java.util.ArrayList;
import java.util.List;

public class TransactionsHistory {

    /**
     * Create a List variable to collect data after every performed transaction during the client session
     * Print the created list if the client asked during the Exit step
     * Clear data for new customer
     */

    static List<String> cList = new ArrayList<>();
    static List<String> sList = new ArrayList<>();
    static List<String> mmList = new ArrayList<>();

    public static void clearData () {

        sList.clear();
        cList.clear();
        mmList.clear();
    }
}
