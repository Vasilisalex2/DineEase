package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.Business;
import business.DineEase;
import business.ordering.Bill;

public class StoresUI extends JFrame {
    private JPanel StoresUI;
    private JButton scanButton;
    private JTextField customerNameField;
    private JScrollBar scrollBar1;
    private JButton checkOutButton;
    public String customerName;
    public String customerName1;

    public StoresUI() {
        setTitle("Stores UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(StoresUI);
        // Add action listener to scanButton
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve text from the text field and assign it to customerName

                customerName = customerNameField.getText();

                dispose();
            }
        });


        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerIdText = customerNameField.getText();
                if (customerIdText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a customer ID.");
                    return;
                }
                try {
                    int customerId = Integer.parseInt(customerIdText);
                    Business business = findBusinessWithCustomer(customerId);
                    if (business != null) {
                        int tableId = business.getTableIdByCustomerId(customerId);
                        if (tableId != -1) {
                            Bill bill = new Bill(business.findOrderByTableId(tableId), tableId);
                            String billDetails = bill.generateBillDetails();
                            BillUI billUI = new BillUI(billDetails, tableId ,"","customer");
                        } else {
                            JOptionPane.showMessageDialog(null, "No table found for customer ID: " + customerId);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No business found with customer ID: " + customerId);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid customer ID.");
                }
            }
        });

    }

    // Method to retrieve customerName
    public String getCustomerName() {
        return customerName;
    }

    // Method to retrieve customerName
    public String getCustomerName1() {
        return customerName1;
    }
    private Business findBusinessWithCustomer(int customerId) {
        for (Business business : DineEase.getBusinesses()) {
            if (business.hasCustomer(customerId)) {
                return business;
            }
        }
        return null;
    }
}


