import GUI.BusinessUI;
import GUI.DashboardUI;
import business.Business;
import business.ordering.Item;
import users.Cook;
import users.Customer;
import users.Owner;

import java.util.Scanner;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        int test = 0;
        Scanner scanner = new Scanner(System.in);
        //Customer
        test = scanner.nextInt();
        DineEase app = new DineEase();
        Business business = app.getBusinesses().get(0);
        Owner user = new Owner();
        Cook worker = new Cook();
        Customer customer = new Customer();
        for(int i = 0; i < 40; i++){
            business.getStorage().getStorage().add(new Item());
        }
        if(test == 1){
            customer.setCheckedIN(true);
            BusinessUI businessUI = new BusinessUI(customer,business);
        }
        //Waiter
        else if(test == 2){
            DashboardUI dashboardUI = new DashboardUI(worker,business);
        }
        //Owner
        else if(test == 3){
            DashboardUI dashboardUI = new DashboardUI(user,business);
        }
    }

}