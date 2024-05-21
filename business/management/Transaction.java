package business.management;

/**
 * This class defines a transaction of the business. A transaction can be any incoming or outgoing payment
 * An incoming payment comes from the customers and an outgoing payments is connected to supplier payment
 *
 * @author NIKOS
 * @version 1.0
 */

public class Transaction {

    private String transactionType; //Incoming or Outgoing
    private double amount;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
