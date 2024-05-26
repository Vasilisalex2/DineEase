package business;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class GeneralTask extends Task {
    private taskType type;
    private Table table;
    private String description;
    public enum taskType{
        tableCall
    }
    public GeneralTask(){
        super();

    }

    public void setType(taskType type) {
        this.type = type;
    }
    public void setTable(Table table) {
        this.table = table;
    }
    public String getDescription() {
        return description;
    }
}
