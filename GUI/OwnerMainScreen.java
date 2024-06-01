package GUI;

/**
 * This class has Timetable and statistics tools for the business owner
 * An instance of this class is generated from the main dashboard of the owner
 *
 * @author NIKOS
 * @version 1.0
 */

import business.Business;
import business.GeneralTask;
import business.Subscription;
import business.Task;
import business.management.CheckInOutEvent;
import business.management.Transaction;
import business.timetable.Objection;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import users.Worker;
import business.timetable.Event;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class OwnerMainScreen extends JFrame {
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTable checkInOutWorkerStats;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane4;
    private JTable avgStayTable;
    private JTable orderCompTimeTable;
    private JTable topPicksTable;
    private JTable subscriptionsTable;
    private JTabbedPane tabbedPane6;
    private JTable transactionsTable;
    private JTabbedPane tabbedPane7;
    private JComboBox eventWorkers;
    private JComboBox daysComboBox;
    private JComboBox startTimeComboBox;
    private JComboBox durationComboBox;
    private JButton addEventButton;
    private JComboBox payWorkers;
    private JTextField payAmount;
    private JButton payWorkerButton;
    private JTable peakHoursTable;
    private JTable timeTableTable;
    private JTextField eventTitle;
    private JTable objectionsTable;


    Business business;

    public OwnerMainScreen(Business business) {

        //JFrame frame = new JFrame("OwnerMainScreen");
        setSize(800, 600);

        setTitle("OwnerMainScreen");
        //setContentPane(new OwnerMainScreen().mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        setContentPane(mainPanel);

        this.business = business;

        populateCheckInOutWorkerStatsTable();
        populateSubsTable();
        populateTransactionsTable();
        addWorkersToComboBox(payWorkers);

        populatePeakHoursTable();
        populateAvgStayTable();
        populateOrderCompTimeTable();
        populateTopPicksTable();
        populateTimeTableTable();
        createEventButton();

        populateEventFormBoxes();

        createTransactionButton();
        populateObjectionsTable();

    }

    //TODO add objections table
    //TODO what to do with order stats

    //****************************
    //TIMETABLE METHODS
    //****************************

    //<editor-fold desc="TIMETABLE METHODS">

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

        timeTableTable.setModel(model);
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

    //add event
    public void addEventToTable(DefaultTableModel model, Event event, int row, int column) {
        //repeat for the duration of event
        //Code doesnt check for out of bounds conditions
        for (int i = 0; i < Integer.parseInt(event.getDuration()); i++) {
            model.setValueAt(event.getWorker().getFullName() + " (" + event.getTitle() + ")", row, column);
            row++;
        }
    }

    //add event form methods
    public void populateEventFormBoxes() {
        addWorkersToComboBox(eventWorkers);

        String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : Days) {
            daysComboBox.addItem(day);
        }
        String[] times = {"08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16",
                "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-00",
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08"};
        String[] durations = {"1", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24"};

        for (String time : times) {
            startTimeComboBox.addItem(time);
        }
        for (String duration : durations) {
            durationComboBox.addItem(duration);
        }
    }

    public void createEventButton() {
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Event event = new Event(
                        (Worker) eventWorkers.getSelectedItem(), eventTitle.getText(),
                        (String) daysComboBox.getSelectedItem(), (String) startTimeComboBox.getSelectedItem(),
                        (String) durationComboBox.getSelectedItem()
                );

                business.getTimetable().createEvent(event);

                System.out.println("Successfully added event");
                populateTimeTableTable();
            }
        });
    }

    public void populateObjectionsTable() {
        String[] columnNames = {"Waiter", "Message"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Objection objection : business.getTimetable().getObjections()) {

            model.addRow(new Object[]{objection.getEvent().getWorker().getFullName(), objection.getDescription()});
        }

        objectionsTable.setModel(model);

    }
    //</editor-fold>

    //****************************
    //ORDER STATS METHODS
    //****************************

    public void populateTopPicksTable() {

        String[] columnNames = {"Dish", "Times Purchased"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        Map<Integer, Integer> dishFreq;
        dishFreq = business.getOrderStatistics().calculateOrderPopularity(business.getOrderHistory());

        for (Map.Entry<Integer, Integer> entry : dishFreq.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            model.addRow(new Object[]{key, value});
        }

        topPicksTable.setModel(model);
    }

    public void populateOrderCompTimeTable() {
//        //WORKING CODE
//        String[] columnNames = {"Order", "Time(hh:mm)"};
//
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//
//        for (Order order : business.getOrders()) {
//            model.addRow(new Object[]{order.getId(), order.getOrderTotalTime()});
//
//        }
//        orderCompTimeTable.setModel(model);
        //PREVIEW CODE
        String[] columnNames = {"Order", "Time(hh:mm)"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        Random random = new Random();


        for (int i = 0; i < 30; i++) {
            model.addRow(new Object[]{i, "0:" + random.nextInt(10, 59)});
        }
        orderCompTimeTable.setModel(model);
    }

    //****************************
    //CUSTOMER STATS METHODS
    //****************************

    //<editor-fold desc="CUSTOMER STATS METHODS">
    public void populateAvgStayTable() {

        String[] columnNames = {"Day", "Stay(hh:mm)"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        model.addRow(new Object[]{"Monday", business.getClientStatistics().avgStayTime("Monday")});
        model.addRow(new Object[]{"Tuesday", business.getClientStatistics().avgStayTime("Tuesday")});
        model.addRow(new Object[]{"Wednesday", business.getClientStatistics().avgStayTime("Wednesday")});
        model.addRow(new Object[]{"Thursday", business.getClientStatistics().avgStayTime("Thursday")});
        model.addRow(new Object[]{"Friday", business.getClientStatistics().avgStayTime("Friday")});
        model.addRow(new Object[]{"Saturday", business.getClientStatistics().avgStayTime("Saturday")});
        model.addRow(new Object[]{"Sunday", business.getClientStatistics().avgStayTime("Sunday")});

        avgStayTable.setModel(model);
    }

    public void populatePeakHoursTable() {

        String[] columnNames = {"Day", "Peak"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        model.addRow(new Object[]{"Monday", business.getClientStatistics().calculatePeakHours("Monday")});
        model.addRow(new Object[]{"Tuesday", business.getClientStatistics().calculatePeakHours("Tuesday")});
        model.addRow(new Object[]{"Wednesday", business.getClientStatistics().calculatePeakHours("Wednesday")});
        model.addRow(new Object[]{"Thursday", business.getClientStatistics().calculatePeakHours("Thursday")});
        model.addRow(new Object[]{"Friday", business.getClientStatistics().calculatePeakHours("Friday")});
        model.addRow(new Object[]{"Saturday", business.getClientStatistics().calculatePeakHours("Saturday")});
        model.addRow(new Object[]{"Sunday", business.getClientStatistics().calculatePeakHours("Sunday")});

        peakHoursTable.setModel(model);
    }
    //</editor-fold>

    //****************************
    //TRANSACTIONS METHODS
    //****************************

    public void populateTransactionsTable() {

        String[] columnNames = {"Type", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Transaction transaction : business.getLogistics().getTransactions()) {
            model.addRow(new Object[]{transaction.getTransactionType(), transaction.getAmount()});
        }
        transactionsTable.setModel(model);
    }


    public void createTransactionButton() {
        //Worker selection is irrelevant because transaction only takes into account the type and the amount
        payWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double amount = Double.parseDouble(payAmount.getText());
                Transaction transaction = new Transaction("Outgoing", amount);
                business.getLogistics().getTransactions().add(transaction);

                populateTransactionsTable();

                // Perform any additional operations with the transaction
                System.out.println("Transaction created: " +
                        transaction.getTransactionType() + "," + transaction.getAmount());
            }
        });
    }

    //****************************
    //WORKER STATS METHODS
    //****************************
    public void populateCheckInOutWorkerStatsTable() {

        String[] columnNames = {"Full Name", "Type", "Date", "Sent Task"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        ArrayList<Worker> workers = business.getWorkers();
        for (Worker worker : workers) {
            for (CheckInOutEvent checkInOutEvent : worker.getWorkerTimeLog()) {

                String type = checkInOutEvent.getType();
                LocalDateTime date = checkInOutEvent.getDate();

                model.addRow(new Object[]{worker, type, date});
            }
        }

        checkInOutWorkerStats.setModel(model);

        checkInOutWorkerStats.getColumn("Sent Task").setCellRenderer(new ButtonRendererWorkerTask("Send Task"));
        checkInOutWorkerStats.getColumn("Sent Task").setCellEditor(new ButtonEditorWorkerTask(checkInOutWorkerStats));
    }

    class ButtonRendererWorkerTask extends JButton implements TableCellRenderer {
        public ButtonRendererWorkerTask(String label) {
            setText(label);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditorWorkerTask extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JTable table;
        private JButton button;
        private Worker worker;

        public ButtonEditorWorkerTask(JTable table) {
            this.table = table;
            this.button = new JButton("Send Task");
            this.button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            this.worker = (Worker) table.getValueAt(row, 0);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Task task = new GeneralTask("Meet me after shift", GeneralTask.taskType.random);
            worker.getTaskList().addTask(task);
            System.out.println("Task added successfully for " + worker.getFullName());
            fireEditingStopped();
        }
    }

    //****************************
    //SUBSCRIPTIONS METHODS
    //****************************
    //<editor-fold desc="SUBSCRIPTIONS METHODS">

    public void populateSubsTable() {

        String[] columnNames = {"Full Name", "OrderID", "Frequency", "Delete"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Subscription subscription : business.getSubscriptionList()) {
            String fullName = subscription.getCustomer().getFullName();
            String orderID = String.valueOf(subscription.getOrder().getId());
            String frequency = subscription.getFrequency();

            model.addRow(new Object[]{fullName, orderID, frequency, new SubDeleteButton()});
        }

        subscriptionsTable.setModel(model);
        subscriptionsTable.getColumn("Delete").setCellRenderer(new SubDeleteButton());
        subscriptionsTable.getColumn("Delete").setCellEditor(new SubDeleteButtonEditor(subscriptionsTable, business.getSubscriptionList()));

//        //PREVIEW CODE
//        String[] columnNames = {"Full Name", "OrderID", "Frequency", "Delete"};
//
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        // create a row to repeat
//        String randomFullName = "John Jack";
//        String frequency = "Weekly";
//
//
//        for (int i = 0; i < 30; i++) {
//            model.addRow(new Object[]{randomFullName, String.valueOf(i), frequency});
//        }
//
//        subscriptionsTable.setModel(model);
//        subscriptionsTable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Delete"));
    }


    //class to create buttons for subscription deletion
    class SubDeleteButton extends JButton implements TableCellRenderer {
        private JButton button;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setForeground(Color.BLACK);
            setBackground(Color.RED);
            setText("Delete");

            return this;
        }

    }

    //class to create event listeners for subscription deletion buttons
    class SubDeleteButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private int row;
        private JTable table;
        private ArrayList<Subscription> subscriptionList;

        public SubDeleteButtonEditor(JTable table, ArrayList<Subscription> subscriptionList) {
            this.table = table;
            this.subscriptionList = subscriptionList;
            button = new JButton("Delete");
            button.setOpaque(true);
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Delete";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            subscriptionList.remove(row); //using the row as index to remove the subscription
            System.out.println("Subscription Deleted");
            ((DefaultTableModel) table.getModel()).removeRow(row);
            populateSubsTable(); //redraw table
            fireEditingStopped();
        }
    }

    // </editor-fold>

    //****************************
    //GENERAL METHODS
    //****************************

    //class to create buttons for table rows
    class ButtonRenderer implements TableCellRenderer {
        private final JButton button;

        public ButtonRenderer(String string) {
            button = new JButton(string);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return button;
        }
    }

    public void addWorkersToComboBox(JComboBox comboBox) {
        //Worker selection is irrelevant because transaction only takes into account the type and the amount
        for (Worker worker : business.getWorkers()) {
            comboBox.addItem(worker);
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(panel1, gbc);
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setEnabled(true);
        tabbedPane1.setTabLayoutPolicy(0);
        panel1.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Timetable", panel2);
        tabbedPane7 = new JTabbedPane();
        panel2.add(tabbedPane7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane7.addTab("Timetable", panel3);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel3.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        timeTableTable = new JTable();
        scrollPane1.setViewportView(timeTableTable);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(8, 4, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane7.addTab("Add event", panel4);
        final JLabel label1 = new JLabel();
        label1.setText("Select worker");
        panel4.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(6, 0, 2, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eventWorkers = new JComboBox();
        panel4.add(eventWorkers, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Select day");
        panel4.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        daysComboBox = new JComboBox();
        panel4.add(daysComboBox, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Starting time");
        panel4.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startTimeComboBox = new JComboBox();
        panel4.add(startTimeComboBox, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Duration");
        panel4.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        durationComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        durationComboBox.setModel(defaultComboBoxModel1);
        panel4.add(durationComboBox, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel4.add(spacer2, new GridConstraints(6, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel4.add(spacer3, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addEventButton = new JButton();
        addEventButton.setText("Add Event");
        panel4.add(addEventButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Event title");
        panel4.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eventTitle = new JTextField();
        panel4.add(eventTitle, new GridConstraints(4, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane7.addTab("Objections", panel5);
        final JScrollPane scrollPane2 = new JScrollPane();
        panel5.add(scrollPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        objectionsTable = new JTable();
        scrollPane2.setViewportView(objectionsTable);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Logistics", panel6);
        tabbedPane6 = new JTabbedPane();
        panel6.add(tabbedPane6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane6.addTab("Transactions", panel7);
        final JScrollPane scrollPane3 = new JScrollPane();
        panel7.add(scrollPane3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        transactionsTable = new JTable();
        scrollPane3.setViewportView(transactionsTable);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane6.addTab("Pay Worker", panel8);
        final JLabel label6 = new JLabel();
        label6.setText("Select Worker");
        panel8.add(label6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        payWorkers = new JComboBox();
        panel8.add(payWorkers, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Add amount");
        panel8.add(label7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        payAmount = new JTextField();
        panel8.add(payAmount, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel8.add(spacer4, new GridConstraints(3, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel8.add(spacer5, new GridConstraints(3, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        panel8.add(spacer6, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        payWorkerButton = new JButton();
        payWorkerButton.setText("Pay Worker");
        panel8.add(payWorkerButton, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Statistics", panel9);
        tabbedPane2 = new JTabbedPane();
        panel9.add(tabbedPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Workers Stats Check In/Out Log", panel10);
        final JScrollPane scrollPane4 = new JScrollPane();
        panel10.add(scrollPane4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        checkInOutWorkerStats = new JTable();
        scrollPane4.setViewportView(checkInOutWorkerStats);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Orders statistics", panel11);
        tabbedPane4 = new JTabbedPane();
        panel11.add(tabbedPane4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane4.addTab("Order completion time", panel12);
        final JScrollPane scrollPane5 = new JScrollPane();
        panel12.add(scrollPane5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        orderCompTimeTable = new JTable();
        scrollPane5.setViewportView(orderCompTimeTable);
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane4.addTab("Top picks", panel13);
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel13.add(panel14, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane6 = new JScrollPane();
        panel14.add(scrollPane6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        topPicksTable = new JTable();
        scrollPane6.setViewportView(topPicksTable);
        final JPanel panel15 = new JPanel();
        panel15.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Customer statitstics", panel15);
        final JTabbedPane tabbedPane3 = new JTabbedPane();
        panel15.add(tabbedPane3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel16 = new JPanel();
        panel16.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane3.addTab("Day peak hours", panel16);
        final JScrollPane scrollPane7 = new JScrollPane();
        panel16.add(scrollPane7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        peakHoursTable = new JTable();
        scrollPane7.setViewportView(peakHoursTable);
        final JPanel panel17 = new JPanel();
        panel17.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane3.addTab("Day avg. stay", panel17);
        final JScrollPane scrollPane8 = new JScrollPane();
        panel17.add(scrollPane8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        avgStayTable = new JTable();
        scrollPane8.setViewportView(avgStayTable);
        final JPanel panel18 = new JPanel();
        panel18.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Subscriptions", panel18);
        final JScrollPane scrollPane9 = new JScrollPane();
        panel18.add(scrollPane9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        subscriptionsTable = new JTable();
        scrollPane9.setViewportView(subscriptionsTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
