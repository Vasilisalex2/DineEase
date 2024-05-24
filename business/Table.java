package business;

import users.Customer;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Table {
    private int tableId;
    //private String status; //reserved or free
    private enum eStatus{
        FREE,
        RESERVED,
        OCCUPIED
    }
    private eStatus status;
    private Customer customer;
    private static int lastTableID = 0;

    public Table() {
        this.tableId = lastTableID++;
        this.status = eStatus.FREE;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void removeCustomer() {
        this.customer = null;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public int getTableId() {
        return tableId;
    }
}
