package users;

import java.lang.reflect.Array;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Person{
    private int id;
    private Basket basket;
    public Person(){
        this.id = 0;
        this.basket = new Basket();
    }

    public int getID() {
        return id;
    }
    public Basket getBasket() {
        return basket;
    }
}
