package business.timetable;

/**
 * This class has the attributes of an Objection object in the Timetable class
 *
 * @author NIKOS
 * @version 1.0
 */

public class Objection {
    private Event event;
    private String description;


    public Objection(Event event, String description) {
        this.event = event;
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public String getDescription() {
        return description;
    }
}
