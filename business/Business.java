package business;
import business.ordering.Menu;
import business.ordering.Order;
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

    public Business(int id){
      this.menu = new Menu();
      this.id = id;
      this.taskList = new TaskList();
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
}
