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
    private String frequency; // order frequency Daily/Weekly/Monthly

    public Subscription(Customer customer, Order order, String frequency) {
        this.customer = customer;
        this.order = order;
        this.frequency = frequency;

    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public String getFrequency() {
        return frequency;
    }
}
