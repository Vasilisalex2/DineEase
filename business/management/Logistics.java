package business.management;
import java.util.ArrayList;

/**
 * This class contains objects of the class Transaction inside an Arraylist in order to extract useful data
 *
 * @author NIKOS
 * @version 1.0
 */

public class Logistics {
    private ArrayList<Transaction> transactions;

    public Logistics() {
        transactions = new ArrayList<>();
    }


    public void createTransaction(double amount){
        Transaction transaction = new Transaction("Outgoing", amount);
        transactions.add(transaction);
    }
    public int numOfInTransactions() {
        int numOfInTransactions = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("Incoming")) numOfInTransactions++;
        }
        return numOfInTransactions;
    }

    public int numOfOutTransactions() {
        int numOfOutTransactions = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("Incoming")) numOfOutTransactions++;
        }
        return numOfOutTransactions;
    }

    public double calculateIncoming() {
        double incoming = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("Incoming")) {
                incoming += transaction.getAmount();
            }
        }
        return incoming;
    }

    public double calculateOutgoing() {
        double outgoing = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("Outgoing")) {
                outgoing += transaction.getAmount();
            }
            outgoing += transaction.getAmount();
        }
        return outgoing;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
