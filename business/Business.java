package business;
import business.ordering.Menu;
import business.ordering.Order;

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
    private Menu menu;
    private TaskList taskList;
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
}
