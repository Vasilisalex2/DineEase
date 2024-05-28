package ui.owner;

import business.Business;
import business.management.CheckInOutEvent;
import users.Worker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class OwnerMainScreen {
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTable checkInOutWorkerStats;
    private JTable table2;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane4;
    private JTable avgStayTable;
    private JTable orderCompTimeTable;
    private JTable table6;
    private JTable topPicksTable;
    private JTable subscriptionsTable;
    private JTabbedPane tabbedPane6;
    private JTable transactionsTable;
    private JTabbedPane tabbedPane7;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton button1;
    private JPanel CheckInOutScroll;
    private JComboBox payWorkers;
    private JTextField textField1;
    private JButton payWorkerButton;
    private JTable peakHoursTable;
    private JTable timeTableTable;


    Business business;

    public OwnerMainScreen() {
        populateCheckInOutWorkerStatsTable();
        populateSubsTable();
        populateTransactionsTable();
        addWorkersToComboBox();
        populatePeakHoursTable();
        populateAvgStayTable();
        populateOrderCompTimeTable();
        populateTopPicksTable();
        populateTimeTableTable();
    }

    //****************************
    //TIMETABLE METHODS
    //****************************

    public void populateTimeTableTable() {
        //TODO add working code
//        String[] columnNames = {"X", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//
//        model.addRow(new Object[]{"08-09", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"09-10", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"11-12", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"13-14", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"15-16", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"17-18", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"19-20", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"21-22", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"23-00", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"00-01", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"01-02", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"02-03", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"04-05", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"05-06", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"06-07", "-", "-", "-", "-", "-", "-", "-"});
//        model.addRow(new Object[]{"07-08", "-", "-", "-", "-", "-", "-", "-"});

        //PREVIEW CODE
        String[] columnNames = {"X", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        model.addRow(new Object[]{"08-09", "Johnathan", "Roberto", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"09-10", "Johnathan", "Roberto", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"11-12", "Johnathan", "Roberto", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"13-14", "Johnathan", "Roberto", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"15-16", "Johnathan", "Jack", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"17-18", "Johnathan", "Jack", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"19-20", "Johnathan", "Jack", "Bill", "-", "-", "-", "-"});
        model.addRow(new Object[]{"21-22", "Tiffany", "Jack", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"23-00", "Tiffany", "Jack", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"00-01", "Tiffany", "Jack", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"01-02", "Tiffany", "Will", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"02-03", "Tiffany", "Will", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"04-05", "Tiffany", "Will", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"05-06", "Tiffany", "Will", "-", "-", "-", "-", "-"});
        model.addRow(new Object[]{"06-07", "-", "-", "Will", "-", "-", "-", "-"});
        model.addRow(new Object[]{"07-08", "-", "-", "Will", "-", "-", "-", "-"});

        timeTableTable.setModel(model);
    }

    //****************************
    //ORDER STATS METHODS
    //****************************

    public void populateTopPicksTable() {
//        //WORkING CODE
//        String[] columnNames = {"Dish", "Times Purchased"};
//
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        Map<Integer,Integer> dishFreq;
//        dishFreq = business.getOrderStatistics().calculateOrderPopularity(business.getOrderHistory());
//
//        for (Map.Entry<Integer, Integer> entry : dishFreq.entrySet()) {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//            model.addRow(new Object[]{key, value});
//        }

        //PREVIEW CODE
        String[] columnNames = {"Dish", "Times Purchased"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        for (int i = 0; i < 30; i++) {
            model.addRow(new Object[]{i, i});
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


        for (int i = 0; i < 30; i++) {
            model.addRow(new Object[]{i, "0:30"});
        }
        orderCompTimeTable.setModel(model);
    }

    //****************************
    //CUSTOMER STATS METHODS
    //****************************
    public void populateAvgStayTable() {
//        //WORKING CODE
//        String[] columnNames = {"Day", "Stay(hh:mm)"};
//
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        model.addRow(new Object[]{"Monday", business.getClientStatistics().avgStayTime("Monday")});
//        model.addRow(new Object[]{"Tuesday", business.getClientStatistics().avgStayTime("Tuesday")});
//        model.addRow(new Object[]{"Wednesday", business.getClientStatistics().avgStayTime("Wednesday")});
//        model.addRow(new Object[]{"Thursday", business.getClientStatistics().avgStayTime("Thursday")});
//        model.addRow(new Object[]{"Friday", business.getClientStatistics().avgStayTime("Friday")});
//        model.addRow(new Object[]{"Saturday", business.getClientStatistics().avgStayTime("Saturday")});
//        model.addRow(new Object[]{"Sunday", business.getClientStatistics().avgStayTime("Sunday")});
//
//        peakHoursTable.setModel(model);
        //PREVIEW CODE

        String[] columnNames = {"Day", "Stay(hh:mm)"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        model.addRow(new Object[]{"Monday", "0:30"});
        model.addRow(new Object[]{"Tuesday", "1:30"});
        model.addRow(new Object[]{"Wednesday", "1:00"});
        model.addRow(new Object[]{"Thursday", "0:45"});
        model.addRow(new Object[]{"Friday", "1:05"});
        model.addRow(new Object[]{"Saturday", "2:00"});
        model.addRow(new Object[]{"Sunday", "2:30"});

        avgStayTable.setModel(model);
    }

    public void populatePeakHoursTable() {
//        //WORKING CODE
//        String[] columnNames = {"Day", "Peak"};
//
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        model.addRow(new Object[]{"Monday", business.getClientStatistics().calculatePeakHours("Monday")});
//        model.addRow(new Object[]{"Tuesday", business.getClientStatistics().calculatePeakHours("Tuesday")});
//        model.addRow(new Object[]{"Wednesday", business.getClientStatistics().calculatePeakHours("Wednesday")});
//        model.addRow(new Object[]{"Thursday", business.getClientStatistics().calculatePeakHours("Thursday")});
//        model.addRow(new Object[]{"Friday", business.getClientStatistics().calculatePeakHours("Friday")});
//        model.addRow(new Object[]{"Saturday", business.getClientStatistics().calculatePeakHours("Saturday")});
//        model.addRow(new Object[]{"Sunday", business.getClientStatistics().calculatePeakHours("Sunday")});
//
//        peakHoursTable.setModel(model);
        //PREVIEW CODE

        String[] columnNames = {"Day", "Peak"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        model.addRow(new Object[]{"Monday", "8:00"});
        model.addRow(new Object[]{"Tuesday", "14:00"});
        model.addRow(new Object[]{"Wednesday", "11:00"});
        model.addRow(new Object[]{"Thursday", "18:00"});
        model.addRow(new Object[]{"Friday", "20:00"});
        model.addRow(new Object[]{"Saturday", "23:00"});
        model.addRow(new Object[]{"Sunday", "00:00"});

        peakHoursTable.setModel(model);
    }


    //****************************
    //TRANSACTIONS METHODS
    //****************************

    public void populateTransactionsTable() {
        //TODO add working code
//        checkInOutWorkerStats = new JTable();
//
//        ArrayList<Worker> workers = business.getWorkers();
//        for (Worker worker : workers) {
//            ArrayList<String> fullName = new ArrayList<>();
//            ArrayList<String> type = new ArrayList<>();
//            ArrayList<Date> date = new ArrayList<>();
//
//            fullName.add(worker.getFullName());
//
//            for (CheckInOutEvent checkInOutEvent : worker.getWorkerTimeLog()) {
//                type.add(checkInOutEvent.getType());
//                date.add(checkInOutEvent.getDate());
//            }
//        }
//        checkInOutWorkerStats = new JTable(fullname ? ????????);
        //PREVIEW CODE
        String[] columnNames = {"Type", "Amount"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // create a row to repeat
        //String randomType = "Incoming";
        double amount = 15.42;


        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                model.addRow(new Object[]{"Incoming", amount + i});
            } else {
                model.addRow(new Object[]{"Outgoing", amount + i + 1});
            }
        }

        transactionsTable.setModel(model);
        //checkInOutWorkerStats.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Send Event"));

    }

    //logistics combobox
    public void addWorkersToComboBox() {
        //TODO add working code
        //PREVIEW CODE
        String[] exampleNames = {"Wilson", "Robert", "Ben", "Jack", "David"};
        for (String name : exampleNames) {
            payWorkers.addItem(name);
        }
    }

    public void createTransactionButton() {
        //TODO add working code
        //payWorkerButton
    }

    //****************************
    //WORKER STATS METHODS
    //*********************************
    public void populateCheckInOutWorkerStatsTable() {
        //WORKING CODE NO FUNCTIONAL BUTTON
//        String[] columnNames = {"Full Name", "Type", "Date", "Sent Event"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        ArrayList<Worker> workers = business.getWorkers();
//        for (Worker worker : workers) {
//
//            String fullName = worker.getFullName();
//
//            for (CheckInOutEvent checkInOutEvent : worker.getWorkerTimeLog()) {
//
//                String type = checkInOutEvent.getType();
//                Date date = checkInOutEvent.getDate();
//
//                model.addRow(new Object[]{fullName, type, date});
//            }
//        }
//        //checkInOutWorkerStats = new JTable(fullname?????????);
//
//        checkInOutWorkerStats = new JTable(model);
//        checkInOutWorkerStats.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

        //PREVIEW CODE
        String[] columnNames = {"Full Name", "Type", "Date", "Sent Event"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // create a row to repeat
        String randomFullName = "John Jack";
        String randomType = "Check-in";
        Date currentDate = new Date();


        for (int i = 0; i < 30; i++) {
            model.addRow(new Object[]{randomFullName, randomType, currentDate});
        }

        checkInOutWorkerStats.setModel(model);
        checkInOutWorkerStats.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Send Event"));

    }


    public void populateSubsTable() {
        //TODO add working code
        //PREVIEW CODE
        String[] columnNames = {"Full Name", "OrderID", "Frequency", "Delete"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // create a row to repeat
        String randomFullName = "John Jack";
        String frequency = "Weekly";


        for (int i = 0; i < 30; i++) {
            model.addRow(new Object[]{randomFullName, String.valueOf(i), frequency});
        }

        subscriptionsTable.setModel(model);
        subscriptionsTable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Delete"));
    }


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

    public static void main(String[] args) {
        JFrame frame = new JFrame("OwnerMainScreen");
        frame.setContentPane(new OwnerMainScreen().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setEnabled(true);
        panel1.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Storage", panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Timetable", panel3);
        tabbedPane7 = new JTabbedPane();
        panel3.add(tabbedPane7, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane7.addTab("Timetable", panel4);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel4.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        timeTableTable = new JTable();
        scrollPane1.setViewportView(timeTableTable);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane7.addTab("Add event", panel5);
        final JLabel label1 = new JLabel();
        label1.setText("Select worker");
        panel5.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 2, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        panel5.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Select day");
        panel5.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        panel5.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Starting time");
        panel5.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox3 = new JComboBox();
        panel5.add(comboBox3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("End time");
        panel5.add(label4, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox4 = new JComboBox();
        panel5.add(comboBox4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button1 = new JButton();
        button1.setText("Button");
        panel5.add(button1, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Logistics", panel6);
        tabbedPane6 = new JTabbedPane();
        panel6.add(tabbedPane6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane6.addTab("Transactions", panel7);
        transactionsTable = new JTable();
        panel7.add(transactionsTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane6.addTab("Pay Worker", panel8);
        final JLabel label5 = new JLabel();
        label5.setText("Select Worker");
        panel8.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        payWorkers = new JComboBox();
        panel8.add(payWorkers, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Add amount");
        panel8.add(label6, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        panel8.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel8.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        payWorkerButton = new JButton();
        payWorkerButton.setText("Pay Worker");
        panel8.add(payWorkerButton, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panel8.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel8.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Statistics", panel9);
        tabbedPane2 = new JTabbedPane();
        panel9.add(tabbedPane2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Workers statistics", panel10);
        tabbedPane3 = new JTabbedPane();
        panel10.add(tabbedPane3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        CheckInOutScroll = new JPanel();
        CheckInOutScroll.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane3.addTab("Check In/Out Log", CheckInOutScroll);
        final JScrollPane scrollPane2 = new JScrollPane();
        CheckInOutScroll.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        checkInOutWorkerStats = new JTable();
        scrollPane2.setViewportView(checkInOutWorkerStats);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane3.addTab("Late/Overtime", panel11);
        table2 = new JTable();
        panel11.add(table2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Orders statistics", panel12);
        tabbedPane4 = new JTabbedPane();
        panel12.add(tabbedPane4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane4.addTab("Order completion time", panel13);
        orderCompTimeTable = new JTable();
        panel13.add(orderCompTimeTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane4.addTab("Avarage compl. time per item", panel14);
        table6 = new JTable();
        panel14.add(table6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel15 = new JPanel();
        panel15.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane4.addTab("Top picks", panel15);
        topPicksTable = new JTable();
        panel15.add(topPicksTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel16 = new JPanel();
        panel16.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane2.addTab("Customer statitstics", panel16);
        final JTabbedPane tabbedPane5 = new JTabbedPane();
        panel16.add(tabbedPane5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel17 = new JPanel();
        panel17.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane5.addTab("Day peak hours", panel17);
        final JScrollPane scrollPane3 = new JScrollPane();
        panel17.add(scrollPane3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        peakHoursTable = new JTable();
        scrollPane3.setViewportView(peakHoursTable);
        final JPanel panel18 = new JPanel();
        panel18.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane5.addTab("Day avg. stay", panel18);
        final JScrollPane scrollPane4 = new JScrollPane();
        panel18.add(scrollPane4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        avgStayTable = new JTable();
        scrollPane4.setViewportView(avgStayTable);
        final JPanel panel19 = new JPanel();
        panel19.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Subscriptions", panel19);
        final JScrollPane scrollPane5 = new JScrollPane();
        panel19.add(scrollPane5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        subscriptionsTable = new JTable();
        scrollPane5.setViewportView(subscriptionsTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
