package users;

import java.util.ArrayList;
import business.ordering.Dish;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Basket {
    ArrayList<Dish> basket;

    public Basket(){
        this.basket = new ArrayList<Dish>();
    }
    public ArrayList<Dish> getBasket() {
        return basket;
    }
    public void addToBasket(Dish dish, int quantity){
        dish.setQuantity(quantity);
        this.basket.add(dish);
    }
    public void removeFromBasket(Dish dish){
        this.basket.remove(dish);
    }
    public void clearBasket(){
        this.basket.clear();
    }
}
