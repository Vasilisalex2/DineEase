package business.ordering;

import java.util.ArrayList;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Order {
    private ArrayList<Dish> order;
    public Order(){
        this.order = new ArrayList<>();
    }
    public ArrayList<Dish> getOrder() {
        return order;
    }
    public void addToOrder(Dish dish){
        this.order.add(dish);
    }
    public void setOrder(ArrayList<Dish> order){
        this.order = order;
    }
}
