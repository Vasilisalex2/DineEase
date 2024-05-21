package users;

import business.ordering.Order;
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
    public Customer(){
        super();
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
}