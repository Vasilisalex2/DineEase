package business.ordering;

import business.Task;

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

public class Order extends Task {
    private ArrayList<Dish> order;

    //add a static variable to uniquely identify orders, the fact that is static makes it common to all order objects
    private static int lastId = 0;
    private int id = 0;


    public Order(){
        this.order = new ArrayList<>();
        this.id = ++lastId;
    }
    public ArrayList<Dish> getOrder() {
        return order;
    }
    public void addToOrder(Dish dish){
        this.order.add(dish);
    }
    public void createOrder(ArrayList<Dish> order){
        this.order = order;
    }

    public int getId() {
        return id;
    }

}
