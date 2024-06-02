package users;

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

    public Person(String fullName){
        this.id = ++lastId;
        this.basket = new Basket();
    }

    public int getID() {
        return id;
    }
    public Basket getBasket() {
        return this.basket;
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
