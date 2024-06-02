package business;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private static int lastResId = 0;
    private int resId;
    private int customerId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Business business; // Reference to the business instance associated with this reservation
    private int customerNumber ;
    private int tableId;
    // Constructor
    public Reservation(Business business, int customerId, LocalDate date, LocalTime startTime,LocalTime endTime, int customerNumber, int tableId) {
        this.resId = ++lastResId;
        this.customerId = customerId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.business = business; // Set the reference to the associated business instance
        this.customerNumber = customerNumber;
        this.tableId = tableId;
    }

    // Accessor methods
    public int getResId() {
        return resId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }

    // Accessor method for table ID
    public int getTableId() {
        return tableId;
    }


    public String showCheckIn() {
        String Details =   "Reservation{" +
                " \nresId=" + resId +
                ", \ncustomerId='" + customerId + '\'' +
                ", \ndate='" + date + '\'' +
                ", \ntime='" + startTime + '\'' +
                ", \ncustomerNumber=" + customerNumber +
                ", \ntableId=" + tableId +
                '}';

        return Details ;
    }

}