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
    private int id = 0;
    String fullName;
    private Basket basket;

    private static int lastId = 0;

    //TODO do we need this constructor? add basket with setter after the object creation?
    public Person(){
        this.id = 0;

        this.basket = new Basket();
    }

    public Person(String fullName) {
        this.id = ++lastId;
        this.fullName = fullName;
    }

    public int getID() {
        return id;
    }
    public Basket getBasket() {
        return basket;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
