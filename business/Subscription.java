package business;

import business.ordering.Order;
import users.Customer;

/**
 * objects of this class are customers' subscriptions to a business for reoccurring orders
 *
 * @author NIKOS
 * @version 1.0
 */

public class Subscription {
    private Customer customer = null;
    private Order order = null;
    private String time = null; // order frequency

    public Subscription(Customer customer, Order order, String time) {
        this.customer = customer;
        this.order = order;
        this.time = time;

    }
  
}
