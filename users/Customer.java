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

public class Customer extends Person {
    private boolean checkedIN;
    public Customer(){
        super();
        this.checkedIN = false;
    }
    public boolean isCheckedIN(){
        return this.checkedIN;
    }
}