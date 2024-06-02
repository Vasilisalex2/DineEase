package users;

import business.Table;
import business.ordering.OrderHistory;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Customer extends Person {
    private boolean checkedIN;
    private OrderHistory orders;
    private Table table;
    public Customer(String fullName){
        super(fullName);
        this.orders = new OrderHistory();
        this.checkedIN = false;
    }
    public boolean isCheckedIN(){
        return this.checkedIN;
    }
    public void setCheckedIN(boolean checkedIN){
        this.checkedIN = checkedIN;
    }
    public OrderHistory getOrderHistory(){
        return this.orders;
    }
    public void setTable(Table table){
        this.table = table;
    }
    public Table getTable(){
        return this.table;
    }
}