package business.ordering;
//import business.ordering.Dish;
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

public class Menu {
    private ArrayList<Dish> menu;
    private int id;
    public Menu(){
        this.menu = new ArrayList<>();
        Dish test1 = new Dish("");
        Dish test2 = new Dish("");
        menu.add(test1);
        menu.add(test2);

    }

    public ArrayList<Dish> getMenu(){
        return this.menu;
    }
    public void addToMenu(Dish dish){
        this.menu.add(dish);
    }


}

