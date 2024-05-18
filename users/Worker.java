package users;

import business.management.CheckInOutEvent;

import java.util.ArrayList;
import java.util.Date;

/**
 * worker class extends the class and has additional fields and methods for persons who work at the business
 * @author NAME
 * @version 1.0
 */

public class Worker extends Person {
    private ArrayList<CheckInOutEvent> workerTimeLog;

    public ArrayList<CheckInOutEvent> getWorkerTimeLog() {
        return workerTimeLog;
    }
}