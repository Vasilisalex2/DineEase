package business.management;

/**
 * This class calculates statistics based on the data of check ins-outs. Business owner can see peak hours and
 * average stay time of customers
 *
 * @author NIKOS
 * @version 1.0
 */

public class ClientStatistics {

    //this is just a dummy class to populate the table
    public String calculatePeakHours (String day) {
        switch (day.toLowerCase()) {
            case "monday":
                return "8:00";
            case "tuesday":
                return "14:00";
            case "wednesday":
                return "11:00";
            case "thursday":
                return "18:00";
            case "friday":
                return "20:00";
            case "saturday":
                return "23:00";
            case "sunday":
                return "00:00";
            default:
                return "Unknown day";
        }
    }

    //this is just a dummy class to populate the table
    public String avgStayTime(String day) {
        switch (day.toLowerCase()) {
            case "monday":
                return "0:30";
            case "tuesday":
                return "1:30";
            case "wednesday":
                return "1:00";
            case "thursday":
                return "0:45";
            case "friday":
                return "1:05";
            case "saturday":
                return "2:00";
            case "sunday":
                return "2:30";
            default:
                return "Unknown day";
        }
    }
}
