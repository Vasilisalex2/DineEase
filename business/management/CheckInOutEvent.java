package business.management;

import java.time.LocalDateTime;

/**
 * class for details of check in/out for workers and customers
 *
 * @author NAME
 * @version 1.0
 */

public class CheckInOutEvent {
    //public enum CheckType {Check_In, Check_Out}
    private String type; //CheckIn or CheckOut
    private LocalDateTime date;

    public CheckInOutEvent(String type, LocalDateTime date) {
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
