import GUI.DashbooardUI;
import business.Business;
import business.DineEase;
import business.timetable.*;
import users.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
//        int test = 1;
//        Scanner scanner = new Scanner(System.in);
//        //Customer
//        test = scanner.nextInt();
//
//
////        Cook worker = new Cook();
////        Customer customer = new Customer();
////        for(int i = 0; i < 40; i++){
////            business.getStorage().getStorage().add(new Item());
////        }
//        if (test == 1) {
////            customer.setCheckedIN(true);
////            BusinessUI businessUI = new BusinessUI(customer,business);
//        }
//        //Waiter
//        else if (test == 2) {
////            DashboardUI dashboardUI = new DashboardUI(worker,business);
//        }
//        //Owner
//        else if (test == 3) {
////            DashboardUI dashboardUI = new DashboardUI(owner,business);
//        }
//
//
//        //***************
//        //INITIALIZE DATA
//        //***************
//
//        DineEase app = new DineEase();
//        //Business
//        Business businessDemo = new Business(1);
//        app.addBusiness(businessDemo);
//        Business business = app.getBusinesses().get(0);
//
//        //Owner
//        Person owner = new Owner("Alice");
//
//        //Waiters
//        Worker waiter = new Waiter("Bob");
//        Worker waiter1 = new Waiter("John");
//        Worker waiter2 = new Waiter("Kevin");
//
//        //Customers
//        Person customer1 = new Customer("Robert");
//        Person customer2 = new Customer("David");
//        Person customer3 = new Customer("John");
//        Person customer4 = new Customer("Michael");
//        Person customer5 = new Customer("William");
//        Person customer6 = new Customer("Richard");
//        Person customer7 = new Customer("Joseph");
//        Person customer8 = new Customer("Thomas");
//        Person customer9 = new Customer("Charles");
//        Person customer10 = new Customer("Christopher");
//        Person customer11 = new Customer("Daniel");
//        Person customer12 = new Customer("Matthew");
//        Person customer13 = new Customer("Anthony");
//        Person customer14 = new Customer("Mark");
//        Person customer15 = new Customer("Donald");
//        Person customer16 = new Customer("Steven");
//        Person customer17 = new Customer("Paul");
//
//        //Timetable and events
//        Timetable timetable = new Timetable();
//        Event event = new Event(waiter, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 1), LocalTime.of(10, 0), 8);
//        Event event1 = new Event(waiter1, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 2), LocalTime.of(10, 0), 8);
//        Event event2 = new Event(waiter1, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 3), LocalTime.of(10, 0), 8);
//        Event event3 = new Event(waiter2, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 4), LocalTime.of(10, 0), 8);
//        Event event4 = new Event(waiter2, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 5), LocalTime.of(10, 0), 8);
//        Event event5 = new Event(waiter, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 6), LocalTime.of(10, 0), 8);
//
//        timetable.createEvent(event);
//        timetable.createEvent(event1);
//        timetable.createEvent(event2);
//        timetable.createEvent(event3);
//        timetable.createEvent(event4);
//        timetable.createEvent(event5);
//
//        Objection objection = new Objection(event2, "I am unavailable after 4");
//        Objection objection1 = new Objection(event4, "I'll be there by 10:10");
        DashbooardUI dashbooardUI = new DashbooardUI();
        //JFrame jFrame = new JFrame(DashbooardUI);

    }
}