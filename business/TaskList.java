package business;

import business.ordering.Order;
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

public class TaskList {
    private ArrayList<Order> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    public ArrayList<Order> getTasks() {
        return tasks;
    }
    public void setTasks(ArrayList<Order> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Order task) {
        this.tasks.add(task);
    }
  
}
