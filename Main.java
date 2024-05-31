import GUI.BusinessUI;
import GUI.DashboardUI;

import business.Business;
import business.DineEase;
import business.Reservation;
import business.Table;
import business.ordering.Bill;
import business.ordering.Dish;
import business.ordering.Order;
import business.timetable.*;
import business.timetable.Event;
import users.*;

import javax.swing.*;
import java.awt.*;
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


        //***************
        //INITIALIZE DATA
        //***************

        DineEase app = new DineEase();
        //Business
        Business businessDemo = new Business(1);
        app.addBusiness(businessDemo);
        Business business = app.getBusinesses().get(0);

        //Owner
        Person owner = new Owner("Alice");

        //Waiters
        Worker waiter = new Waiter("Bob");
        Worker waiter1 = new Waiter("John");
        Worker waiter2 = new Waiter("Kevin");

        //Customers
        Customer customer1 = new Customer("Robert");
        System.out.println(customer1.getID());
        Customer customer2 = new Customer("David");
        Person customer3 = new Customer("John");
        Person customer4 = new Customer("Michael");
        Person customer5 = new Customer("William");
        Person customer6 = new Customer("Richard");
        Person customer7 = new Customer("Joseph");
        Person customer8 = new Customer("Thomas");
        Person customer9 = new Customer("Charles");
        Person customer10 = new Customer("Christopher");
        Person customer11 = new Customer("Daniel");
        Person customer12 = new Customer("Matthew");
        Person customer13 = new Customer("Anthony");
        Person customer14 = new Customer("Mark");
        Person customer15 = new Customer("Donald");
        Person customer16 = new Customer("Steven");
        Person customer17 = new Customer("Paul");

        //Timetable and events
        Timetable timetable = new Timetable();
        Event event = new Event(waiter, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 1), LocalTime.of(10, 0), 8);
        Event event1 = new Event(waiter1, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 2), LocalTime.of(10, 0), 8);
        Event event2 = new Event(waiter1, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 3), LocalTime.of(10, 0), 8);
        Event event3 = new Event(waiter2, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 4), LocalTime.of(10, 0), 8);
        Event event4 = new Event(waiter2, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 5), LocalTime.of(10, 0), 8);
        Event event5 = new Event(waiter, "Phone orders", "Empty", "Cash register", LocalDate.of(2024, 8, 6), LocalTime.of(10, 0), 8);

        timetable.createEvent(event);
        timetable.createEvent(event1);
        timetable.createEvent(event2);
        timetable.createEvent(event3);
        timetable.createEvent(event4);
        timetable.createEvent(event5);
        Point location = new Point(0, 0);

        Table tableA1 = new Table();
        System.out.println(tableA1.getTableId());
        Table tableA2 = new Table();
        Table tableA3 = new Table();
        Table tableA4 = new Table();
        Table tableA5 = new Table();
        Table tableA6 = new Table();
        businessDemo.addTable(tableA1);
        businessDemo.addTable(tableA6);

        Dish dish1 = new Dish("Pizza");
        Dish dish2 = new Dish("Burger");
        Dish dish3 = new Dish("Salad");
        dish1.setPrice(9);
        dish2.setPrice(8);
        dish3.setPrice(7);
        // Create some orders
        Order order1 = new Order();
        order1.setTableId(tableA1.getTableId());
        order1.addToOrder(dish1);
        order1.addToOrder(dish2);
        businessDemo.addOrder(order1);


        Reservation reservation1 = new Reservation(businessDemo, customer1.getID(), "2024-05-11", "15:00", 8, tableA1.getTableId());
        businessDemo.addReservation(reservation1);
        Objection objection = new Objection(event2, "I am unavailable after 4");
        Objection objection1 = new Objection(event4, "I'll be there by 10:10");
         DashboardUI dashboardUI1 = new DashboardUI(waiter,businessDemo,location);

      //  BusinessUI dashboardUI = new BusinessUI(customer1,businessDemo,location);


    }
}