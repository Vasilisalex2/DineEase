package business.ordering;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Item {
    private int quantity;
    private int lowerLimit;
    private int higherLimit;
    private String name;
    public Item(){
        this.quantity = 10;
        this.lowerLimit = 20;
        this.name = "Σακουλα 40 Κιλων Αλευρι για ζυμη που φουσκωνει";

    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    public void setLowerLimit(int newQuantity){
        this.lowerLimit = newQuantity;
    }
    public void setHigherLimit(int newQuantity){
        this.higherLimit = newQuantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getLowerLimit(){
        return this.lowerLimit;
    }
    public int getHigherLimit(){
        return this.higherLimit;
    }
    public String getName(){
        return this.name;
    }
}
