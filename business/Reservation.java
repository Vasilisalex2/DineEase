package business;

import GUI.CheckInUI;

public class Reservation {
    private static int lastResId = 0;
    private int resId;
    private int customerId;
    private String date;
    private String time;
    private Business business; // Reference to the business instance associated with this reservation
    private int customerNumber ;
    private int tableId;
    // Constructor
    public Reservation(Business business, int customerId, String date, String time, int customerNumber, int tableId) {
        this.resId = ++lastResId;
        this.customerId = customerId;
        this.date = date;
        this.time = time;
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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
                ", \ntime='" + time + '\'' +
                ", \ncustomerNumber=" + customerNumber +
                ", \ntableId=" + tableId +
                '}';

        return Details ;
    }


}