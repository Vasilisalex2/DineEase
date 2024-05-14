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
    private String description;
    private String place;
    private String date;
    private String time;
    private String duration;

    public Event(Worker worker, String title, String description, String place, String date, String time, String duration) {
        this.worker = worker;
        this.title = title;
        this.description = description;
        this.place = place;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

  
}
