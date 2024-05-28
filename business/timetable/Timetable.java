package business.timetable;

import java.util.ArrayList;

/**
 * This is the main class of the business Timetable. It has all the events of the workers and what job everyone has.
 * The class has also an arraylist of objections that the worker have for events
 *
 * @author NIKOS
 * @version 1.0
 */

public class Timetable {

    private ArrayList<Event> events;
    private ArrayList<Objection> objections;

    public Timetable() {
        this.events = new ArrayList<>();
        this.objections = new ArrayList<>();
    }

    public void createEvent(Event event) {
        events.add(event);
    }
    public void createObjection(Objection objection) {
        objections.add(objection);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
    public ArrayList<Objection> getObjections() {
        return objections;
    }
  
}
