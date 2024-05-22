package business.ordering;

import java.util.ArrayList;

/**
 * Class that contains an arraylist of orders for the business
 *
 * @author NAME
 * @version 1.0
 */

public class OrderHistory {
    private ArrayList<Order> orders;
    public OrderHistory() {
        this.orders = new ArrayList<Order>();
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
