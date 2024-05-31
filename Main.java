import GUI.BusinessUI;
import GUI.DashboardUI;

import business.Business;
import business.DineEase;
import business.Subscription;
import business.management.Transaction;
import business.ordering.Order;
import business.Reservation;
import business.Table;
import business.ordering.Bill;
import business.ordering.Dish;
import business.ordering.Order;
import business.timetable.*;
import ui.owner.OwnerMainScreen;
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

        businessDemo.getWorkers().add(waiter);
        businessDemo.getWorkers().add(waiter1);
        businessDemo.getWorkers().add(waiter2);

        //Customers
        Customer customer1 = new Customer("Robert");
        Customer customer2 = new Customer("David");
        Customer customer3 = new Customer("John");
        Customer customer4 = new Customer("Michael");
        Customer customer5 = new Customer("William");
        Customer customer6 = new Customer("Richard");
        Customer customer7 = new Customer("Joseph");
        Customer customer8 = new Customer("Thomas");
        Customer customer9 = new Customer("Charles");
        Customer customer10 = new Customer("Christopher");
        Customer customer11 = new Customer("Daniel");
        Customer customer12 = new Customer("Matthew");
        Customer customer13 = new Customer("Anthony");
        Customer customer14 = new Customer("Mark");
        Customer customer15 = new Customer("Donald");
        Customer customer16 = new Customer("Steven");
        Customer customer17 = new Customer("Paul");

        //Timetable and events
        Timetable timetable = new Timetable();
        businessDemo.setTimetable(timetable);



        Event event = new Event(waiter, "Phone orders", "Monday", "08-09", "8");
        Event event1 = new Event(waiter1, "Phone orders", "Sunday", "11-12", "6");
        Event event2 = new Event(waiter1, "Phone orders", "Friday", "00-01", "8");
        Event event3 = new Event(waiter2, "Phone orders", "Saturday", "11-12", "4");
        Event event4 = new Event(waiter2, "Phone orders", "Tuesday", "00-01", "7");
        Event event5 = new Event(waiter, "Phone orders", "Thursday", "11-12", "8");

        timetable.createEvent(event);
        timetable.createEvent(event1);
        timetable.createEvent(event2);
        timetable.createEvent(event3);
        timetable.createEvent(event4);
        timetable.createEvent(event5);
        Objection objection = new Objection(event2, "I am unavailable after 4");
        Objection objection1 = new Objection(event4, "I'll be there by 10:10");

        Order order = new Order();
        //Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        Transaction transaction = new Transaction("Incoming", 58.67);
        Transaction transaction1 = new Transaction("Outgoing", 538.67);
        Transaction transaction2 = new Transaction("Outgoing", 158.32);
        Transaction transaction3 = new Transaction("Incoming", 358.67);
        Transaction transaction4 = new Transaction("Incoming", 584.44);
        Transaction transaction5 = new Transaction("Outgoing", 586.67);
        Transaction transaction6 = new Transaction("Incoming", 558.60);
        Transaction transaction7 = new Transaction("Incoming", 258.67);
        Transaction transaction8 = new Transaction("Outgoing", 58.45);
        Transaction transaction9 = new Transaction("Incoming", 58.36);

        businessDemo.getLogistics().getTransactions().add(transaction);
        businessDemo.getLogistics().getTransactions().add(transaction1);
        businessDemo.getLogistics().getTransactions().add(transaction2);
        businessDemo.getLogistics().getTransactions().add(transaction3);
        businessDemo.getLogistics().getTransactions().add(transaction4);
        businessDemo.getLogistics().getTransactions().add(transaction5);
        businessDemo.getLogistics().getTransactions().add(transaction6);
        businessDemo.getLogistics().getTransactions().add(transaction7);
        businessDemo.getLogistics().getTransactions().add(transaction8);
        businessDemo.getLogistics().getTransactions().add(transaction9);





        Subscription subscription =new Subscription(customer1,order,"Daily");
        Subscription subscription1 =new Subscription(customer2,order2,"Daily");
        Subscription subscription2 =new Subscription(customer3,order4,"Daily");

        businessDemo.getSubscriptionList().add(subscription);
        businessDemo.getSubscriptionList().add(subscription1);
        businessDemo.getSubscriptionList().add(subscription2);

        OwnerMainScreen ownerMainScreen = new OwnerMainScreen(businessDemo);





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

        DashboardUI dashboardUI1 = new DashboardUI(waiter,businessDemo,location);

      //  BusinessUI dashboardUI = new BusinessUI(customer1,businessDemo,location);


    }
}