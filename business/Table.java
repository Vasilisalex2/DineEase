package business;

import users.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public enum eStatus{
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
        this.reservations = new ArrayList<>();
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
        reservations = getReservations();
        boolean overlap = false;
        if (reservations != null) {
            for (Reservation r : reservations) {
                if (r.getDate().isEqual(reservation.getDate())) {
                    if (reservation.getStartTime().isBefore(r.getEndTime()) && reservation.getEndTime().isAfter(r.getStartTime())) {
                        overlap = true;
                        break; // Exit the loop early since overlap is already true
                    }
                }
            }
        }
        // Check if the end time is after the start time
        if (reservation.getEndTime().isBefore(reservation.getStartTime())) {
            overlap = true;
        }
        // Check if the reservation date and time are after the current date and time
        if (reservation.getDate().isBefore(LocalDate.now()) ||
                (reservation.getDate().isEqual(LocalDate.now()) && reservation.getStartTime().isBefore(LocalTime.now()))) {
            overlap = true;
        }
        if(!overlap){
            reservations.add(reservation);
            System.out.println("Added");
        }
        else{
            System.out.println("Not Added");
        }
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
        if (status == eStatus.FREE) {
            status = eStatus.RESERVED;
        }
    }
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public void freeTable() {
        if (status == eStatus.RESERVED || status == eStatus.OCCUPIED) {
            status = eStatus.FREE;
            occupiedBy = "";
        }
    }

    public void notFreeTable() {
        if (status == eStatus.FREE || status == eStatus.RESERVED) {
            status = eStatus.OCCUPIED;
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
