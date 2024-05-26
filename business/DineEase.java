package business;

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

        Business test = new Business(10);
        businesses.add(test);
        for(int i =0; i < 30; i++){
            businesses.add(new Business(i));
        }
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
