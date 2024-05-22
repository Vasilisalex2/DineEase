package business.management;

import java.util.Date;

/**
 * class for details of check in/out for workers and customers
 *
 * @author NAME
 * @version 1.0
 */

public class CheckInOutEvent {
    //public enum CheckType {Check_In, Check_Out}
    private String type; //CheckIn or CheckOut
    private Date date;

    public CheckInOutEvent(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
}
