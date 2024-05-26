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
    String fullName; //add field
    private Basket basket;

    public Person(){
        this.id = 0;

        this.basket = new Basket();
    }

//    public Person(int id, String fullName, Basket basket) {
//        this.id = id;
//        this.fullName = fullName;
//        this.basket = basket;
//    }

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
}
