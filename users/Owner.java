package users;

import business.Business;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Owner extends Person {

    private Business business;
    public Owner(String fullName) {
        super(fullName);
    }

    public Business getBusiness() {
        return business;
    }
    public void setBusiness(Business business) {
        this.business = business;
    }
  
}