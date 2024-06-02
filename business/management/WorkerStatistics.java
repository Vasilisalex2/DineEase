package business.management;

import users.Worker;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * class to fetch check in and out events and has functionality to fined late workers or worker that have worked over
 * their shift
 *
 * @author NIKOS
 * @version 1.0
 */

public class WorkerStatistics {

    private ArrayList<Worker> workers;

    public WorkerStatistics(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public void fetchEvents() {
        for (Worker worker : workers) {
            // do i need this for each or should i just parse the objects
            for (CheckInOutEvent checkInOutEvent : worker.getWorkerTimeLog()) {
                LocalDateTime date = checkInOutEvent.getDate();
                String type = checkInOutEvent.getType();
            }

        }
    }
}
