package users;

import business.Task;
import business.TaskList;
import business.management.CheckInOutEvent;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * worker class extends the class and has additional fields and methods for persons who work at the business
 * @author NAME
 * @version 1.0
 */

public class Worker extends Person {
    private ArrayList<CheckInOutEvent> workerTimeLog;
    private TaskList taskList;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Worker (String fullName){
        super(fullName);
        this.taskList = new TaskList();
        this.workerTimeLog = new ArrayList<>();

    }

    @Override
    public String toString() {
        return fullName;
    }

    public TaskList getTaskList() {
        return taskList;
    }
    public void addToTaskList(Task task) {
        this.taskList.addTask(task);
    }

    public ArrayList<CheckInOutEvent> getWorkerTimeLog() {
        return workerTimeLog;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void addCheckInOutEvent(CheckInOutEvent event) {
        this.workerTimeLog.add(event);
    }
}