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
        tableCall,
        random
    }
    public GeneralTask(String description, taskType type){
        this.description = description;
        this.type = type;
        if(type == taskType.tableCall){
            description = description + " from table : " + Integer.toString(table.getTableId());
        }
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
