package business;
import business.management.ClientStatistics;
import business.management.OrderStatistics;
import business.management.Storage;
import business.ordering.Menu;
import business.ordering.Order;
import business.ordering.Dish;
import business.ordering.OrderHistory;
import business.timetable.Timetable;
import users.Worker;

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

public class Business {
    private int id;
    private ArrayList<Worker> workers;
    private Menu menu;
    private TaskList taskList; //TODO why would the business have a tasklist? each worker has a separate tasklist
    private ArrayList<Subscription> subscriptionList;
    private Timetable timetable;
    private Storage storage;
    private ArrayList<Table> tables;
    private ClientStatistics clientStatistics;
    private OrderStatistics orderStatistics;
    private OrderHistory orderHistory;

    public Business(int id){
        this.storage = new Storage();
        this.menu = new Menu();
        this.id = id;
        this.taskList = new TaskList();
        this.tables = new ArrayList<Table>();
        for(int i =0; i<100; ++i){
            menu.addToMenu(new Dish("Ok" + i));
        }
        for(int i =0; i<10; ++i){
            tables.add(new Table());
        }
        menu.addToMenu(new Dish("A"));
        menu.addToMenu(new Dish("B"));
        menu.addToMenu(new Dish("C"));
    }
    public int getID(){
        return id;
    }
    public Menu getMenu(){
        return this.menu;
    }
    public void addToTaskList(Order task){
      taskList.addTask(task);
  }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public Storage getStorage(){
        return storage;
    }
    public ArrayList<Table> getTables() {
        return tables;
    }
    public Table getTable(int index){
        for (Table t: tables){
            if(t.getTableId() == index){
                return t;
            }
        }
        return null;
    }

    public ClientStatistics getClientStatistics() {
        return clientStatistics;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public OrderStatistics getOrderStatistics() {
        return orderStatistics;
    }

    public void Test(){

    }
}
