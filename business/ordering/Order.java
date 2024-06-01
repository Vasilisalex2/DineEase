package business.ordering;

import business.Table;
import business.Task;

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

public class Order extends Task {
    private ArrayList<Dish> order;
    //fields for statistics
    private Date orderCreate; //TODO add times on order create and finish
    private Date orderFinish;

    //add a static variable to uniquely identify orders, the fact that is static makes it common to all order objects
    private static int lastId = 0;
    private int id = 0;
    private int tableId;

    public Order(){
        orderCreate = new Date();
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
        this.orderCreate = new Date();
    }

    //used in order statistics table
    public long getOrderTotalTime() {
        long totalTime = orderFinish.getTime() - orderCreate.getTime();
        return totalTime;
    }

    public int getId() {
        return id;
    }
    public String getDescription(){
        String temp = "";
        for (Dish dish : this.order) {
            temp = temp + dish.getName() + " quantity: "+dish.getQuantity() + "\n";
        }
        return temp;
    }
    public void setOrderFinish() {
        this.orderFinish = new Date();
    }

    public int getTableId() {
        return tableId;
    }


    public void setTableId(int tableId) {
        this.tableId = tableId;
    }


}
