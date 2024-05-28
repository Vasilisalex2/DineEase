package business.timetable;

import users.Worker;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate date;
    private LocalTime time;
    private int duration;

    public Event(Worker worker, String title, String description, String place, LocalDate date, LocalTime time, int duration) {
        this.worker = worker;
        this.title = title;
        this.description = description;
        this.place = place;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

  
}
