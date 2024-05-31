package business.timetable;

import users.Worker;


/**
 * This class has the attributes of an Event object in the Timetable class
 *
 * @author NIKOS
 * @version 1.0
 */

public class Event {
    private Worker worker;
    private String title;
    private String day;

//    time is formated like this
//    String[] times = {
//            "08-09", "09-10", "11-12", "13-14", "15-16", "17-18",
//            "19-20", "21-22", "23-00", "00-01", "01-02", "02-03",
//            "04-05", "05-06", "06-07", "07-08"
//    };
    private String startTime;
    private String duration;


    public Event(Worker worker, String title, String day, String startTime, String endTime) {
        this.worker = worker;
        this.title = title;
        this.day = day;
        this.startTime = startTime;
        this.duration = endTime;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getTitle() {
        return title;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDuration() {
        return duration;
    }
}
