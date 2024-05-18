package business.ordering;

import java.util.ArrayList;
import java.util.Date;

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
    //fields for statistics
    private Date orderCreate; //TODO add times on order create and finish
    private Date orderFinish;

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
    public void setOrder(ArrayList<Dish> order){
        this.order = order;
    }

    //used in order statistics table
    public long getOrderTotalTime() {
        long totalTime = orderFinish.getTime() - orderCreate.getTime();
        return totalTime;
    }

    public int getId() {
        return id;
    }


}
