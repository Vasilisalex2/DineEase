import business.Business;
import business.ordering.Dish;
import business.ordering.Menu;
import users.Customer;
import users.Person;

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

public class DineEase {
    private ArrayList<Business> businesses;
    private ArrayList<Person> users;

    public DineEase(){
        businesses = new ArrayList<>();
        users = new ArrayList<>();

        Business test = new Business(1);
        businesses.add(test);
    }
    public void addBusiness(Business business){
        businesses.add(business);
    }
    public void addUser(Person user){
        users.add(user);
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }
    public ArrayList<Person> getUsers() {
        return users;
    }
}
