package GUI;

import business.Business;
import business.timetable.Event;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This class shares the same methods as the Timetable JPanel in OwnerMainScreen, but it can only load the timetable.
 * Objection functionality is not implemented
 *
 * @author NIKOS
 * @version 1.0
 */
public class WorkerTimetable extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton addObjectionFeatureNotButton;
    public Business business;

    public WorkerTimetable(Business business) {
        setSize(800, 600);
        setTitle("WorkerTimetable");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(panel1);

        this.business = business;
        populateTimeTableTable();
    }


    public void populateTimeTableTable() {

        String[] columnNames = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        model.addRow(new Object[]{"08-09", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"09-10", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"10-11", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"11-12", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"12-13", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"13-14", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"14-15", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"15-16", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"16-17", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"17-18", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"18-19", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"19-20", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"20-21", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"21-22", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"22-23", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"23-00", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"00-01", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"01-02", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"02-03", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"03-04", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"04-05", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"05-06", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"06-07", "-", "-", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"07-08", "-", "-", "-", "-", "-", "-", "-"});

        table1.setModel(model);
        populateEvents(model);


    }

    //search business for events
    public void populateEvents(DefaultTableModel model) {
        //ArrayList<Event> events = ;
        for (Event event : business.getTimetable().getEvents()) {
            switch (event.getDay()) {
                case "Monday" -> addEventToTable(model, event, findEventTime(event), 1);
                case "Tuesday" -> addEventToTable(model, event, findEventTime(event), 2);
                case "Wednesday" -> addEventToTable(model, event, findEventTime(event), 3);
                case "Thursday" -> addEventToTable(model, event, findEventTime(event), 4);
                case "Friday" -> addEventToTable(model, event, findEventTime(event), 5);
                case "Saturday" -> addEventToTable(model, event, findEventTime(event), 6);
                case "Sunday" -> addEventToTable(model, event, findEventTime(event), 7);
                default -> {
                }
            }
        }
    }

    //find event details
    public int findEventTime(Event event) {
        return switch (event.getStartTime()) {
            case "08-09" -> 0;
            case "09-10" -> 1;
            case "11-12" -> 2;
            case "13-14" -> 3;
            case "15-16" -> 4;
            case "17-18" -> 5;
            case "19-20" -> 6;
            case "21-22" -> 7;
            case "23-00" -> 8;
            case "00-01" -> 9;
            case "01-02" -> 10;
            case "02-03" -> 11;
            case "04-05" -> 12;
            case "05-06" -> 13;
            case "06-07" -> 14;
            case "07-08" -> 15;
            default -> {
                System.out.println("Wrong time");
                yield -1;
            }
        };
    }

    //add event to table
    public void addEventToTable(DefaultTableModel model, Event event, int row, int column) {
        //repeat for the duration of event
        //Code doesnt check for out of bounds conditions
        for (int i = 0; i < Integer.parseInt(event.getDuration()); i++) {
            model.setValueAt(event.getWorker().getFullName() + " (" + event.getTitle() + ")", row, column);
            row++;
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        addObjectionFeatureNotButton = new JButton();
        addObjectionFeatureNotButton.setText("Add objection(Feature not yet implemented)");
        panel1.add(addObjectionFeatureNotButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
