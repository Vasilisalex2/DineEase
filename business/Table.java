package business;

import users.Customer;

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

public class Table {
    private int tableId;
    private ArrayList<Reservation> reservations;
    //private String status; //reserved or free
    private enum eStatus{
        FREE,
        RESERVED,
        OCCUPIED;


    }
    private eStatus status;
    private Customer customer;
    private static int lastTableID = 0;
    private int capacity;
    private String occupiedBy ;


    public Table() {
        this.tableId = lastTableID++;
        this.status = eStatus.FREE;
        this.occupiedBy = "";
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void removeCustomer() {
        this.customer = null;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public int getTableId() {
        return tableId;
    }
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public int getCapacity() {
        return capacity;
    }
    public eStatus getStatus() {
        return status;
    }
    public String occupiedBy() {
        return occupiedBy;
    }
    public void reserveTable() {
        if (status.equals("FREE")) {
            status = eStatus.valueOf("Reserved");
        }
    }
    public void freeTable() {
        if (status.equals("RESERVED")) {
            status = eStatus.valueOf("Free");
            occupiedBy = "";
        }
    }
    public void notFreeTable() {
        if (status.equals("Free")) {
            status = eStatus.valueOf("Occupied");
            occupiedBy = "";
        }
    }
    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                ", occupiedBy='" + occupiedBy + '\'' +
                '}';
    }
}
