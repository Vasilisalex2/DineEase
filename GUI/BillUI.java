package GUI;

import business.Business;
import business.Table;
import business.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BillUI extends JFrame {
    private JPanel BillUI;
    private JLabel Bill;
    private JButton callWaiterButton;
    private JButton onlinePaymentButton;
    private JTextPane BillInformation;
    private JButton removeBillButton;
    private Business business;
    private int tableId;
    private String BusinessName;

    public BillUI(String billDetails, int tableId, String BusinessName1, String userRole) {
        setTitle("Bill UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(BillUI);
        setVisible(true);
        this.BusinessName = BusinessName1;
        this.tableId = tableId;
        setBillDetails(billDetails);

        if ("worker".equals(userRole)) {
            removeBillButton.setVisible(true);
            onlinePaymentButton.setVisible(false);
            callWaiterButton.setVisible(false);
        } else {
            removeBillButton.setVisible(false);
            onlinePaymentButton.setVisible(true);
            callWaiterButton.setVisible(true);
        }


        onlinePaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentUI payment = new PaymentUI();
            }
        });

        callWaiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWaiterTask(tableId);
            }
        });
        removeBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBill(tableId);
            }
        });
    }

    public void setBillDetails(String billDetails) {
        BillInformation.setText(billDetails);
    }
    private Task createWaiterTask(int tableId) {
        String description = "Waiter in table " + tableId;
        Date currentTime = new Date(); // Current date and time
        Task waiterTask = new Task(description, currentTime);
        System.out.println("New Task created: " + waiterTask); // Print the task details
        return waiterTask;
    }
    private void removeBill(int tableId) {

        business= Main.findBusinessByName(BusinessName);
        Bill billToRemove = business.getBill(tableId);
        if (billToRemove != null) {
            business.removeBill(billToRemove);
            Table table = business.getTable(tableId);
            if (table != null) {
                table.freeTable();
                JOptionPane.showMessageDialog(this, "Bill removed and table " + tableId + " is now available.");
            } else {
                JOptionPane.showMessageDialog(this, "Table with ID " + tableId + " not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No bill found for table ID: " + tableId);
        }
    }
}

