package business;
import business.management.ClientStatistics;
import business.management.Logistics;
import business.management.OrderStatistics;
import business.management.Storage;
import business.ordering.*;
import business.timetable.Timetable;
import users.Worker;

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

public class Business {
    private int id;
    private String name;
    private String description;
    private ArrayList<Worker> workers;
    private Menu menu;
    private TaskList taskList;
    private ArrayList<Subscription> subscriptionList;
    private Timetable timetable;
    private Storage storage;
    private ArrayList<Table> tables;
    private ClientStatistics clientStatistics;
    private OrderStatistics orderStatistics;
    private OrderHistory orderHistory;
    private ArrayList<StoreRating> reviews;
    private ArrayList<Reservation> reservations;
    private ArrayList<Bill> bills;
    private static ArrayList<Order> orders;
    private Logistics logistics;

    public Business(int id){
        this.reservations = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.bills = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<StoreRating>();
        this.storage = new Storage();
        this.name = "TEST";
        this.menu = new Menu();
        this.id = id;
        this.taskList = new TaskList();
        this.tables = new ArrayList<Table>();
        this.subscriptionList = new ArrayList<>();
        this.logistics = new Logistics();
        this.workers =new ArrayList<>();
        this.timetable = new Timetable();
        this.orderStatistics = new OrderStatistics();
        this.orderHistory = new OrderHistory();
        for(int i =0; i<100; ++i){
            menu.addToMenu(new Dish("Ok" + i));
        }
        for(int i =0; i<10; ++i){
            tables.add(new Table());
        }
        menu.addToMenu(new Dish("A"));
        menu.addToMenu(new Dish("B"));
        menu.addToMenu(new Dish("C"));
    }
    public int getID(){
        return id;
    }
    public Menu getMenu(){
        return this.menu;
    }
    public void addToTaskList(Order task){
      taskList.addTask(task);
  }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public Storage getStorage(){
        return storage;
    }
    public ArrayList<Table> getTables() {
        return tables;
    }
    public Table getTable(int index){
        for (Table t: tables){
            if(t.getTableId() == index){
                return t;
            }
        }
        return null;
    }

    public ClientStatistics getClientStatistics() {
        return clientStatistics;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public OrderStatistics getOrderStatistics() {
        return orderStatistics;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public ArrayList<StoreRating> getReviews(){
        return reviews;
    }
    public void addReview(StoreRating review){
        reviews.add(review);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void addTable(Table table) {
        tables.add(table);
    }
    public void addBill(Bill bill) {
        bills.add(bill);
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }



    public void printTables() {
        System.out.println("Tables for " + name + ":");
        for (Table table : tables) {
            System.out.println(table);
        }
    }



    // Accessor method for reservations
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public String isTableFree(int tableId, ArrayList<Table> tables) {
        for (Table table : tables) {
            if (table.getTableId() == tableId && table.getStatus() == Table.eStatus.FREE) {
                return "Yes";
            }
        }
        return "No";
    }

    public String showCheckInWithoutRes(int tableId, String customerName) {
        // Check if the table exists in the business's tables list
        for (Table table : tables) {
            if (table.getTableId() == tableId) {
                // If the table exists, occupy it
                table.notFreeTable();
                // Return the check-in details
                return "Check-in details without reservation:\nTable ID: " + tableId + "\nCustomer Name: " + customerName;
            }
        }
        // If the table doesn't exist, return a message
        return "Table with ID " + tableId + " not found.";
    }

    public String showBusiness() {
        String details = "Business Name: " + name + "\n";


        return details;}
    public boolean hasCustomer(int customerId) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerId() == customerId) {
                return true;
            }
        }
        return false;
    }

    public int getTableIdByCustomerId(int customerId) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerId() == customerId) {
                return reservation.getTableId();
            }
        }
        return -1;
    }
    public Order findOrderByTableId(int tableId) {
        for (Order order : orders) {
            if (order.getTableId() == tableId) {
                return order;
            }
        }
        return null; // Επιστρέφουμε null αν δεν βρεθεί παραγγελία με το συγκεκριμένο tableId
    }
    public Bill getBill(int tableId) {
        for (Bill bill : bills) {
            if (bill.getTableId() == tableId) {
                return bill;
            }
        }
        return null;
    }
    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public  Table getTable1(int tableId) {
        for (Table table : tables) {
            if (table.getTableId() == tableId) {
                return table;
            }
        }
        return null; // If no table with the given ID is found
    }
    public Reservation reservationCheck(int customerId) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerId() == customerId) {
                // Update table status to "Occupied" for the reservation's table ID
                for (Table table : tables) {
                    if (table.getTableId() == reservation.getTableId()) {
                        table.notFreeTable(); // Update table status
                        System.out.println("Reservation found for " + name + ":");
                        reservation.showCheckIn();
                        return reservation;
                    }
                }
            }
        }
        System.out.println("No reservation found for " + customerId);
        return null;
    }

    public ArrayList<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public Logistics getLogistics() {
        return logistics;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
}