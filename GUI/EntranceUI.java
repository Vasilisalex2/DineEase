package GUI;

import business.Business;
import business.DineEase;
import business.Table;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntranceUI extends JFrame {
    private JPanel EntranceUI;
    private JTextField tableid;
    private JTextArea tableIdTextArea;
    private JTextPane numberOfPeopleTextPane;
    private JTextField numberofpeople;
    private JButton continueButton;
    private JTextField businessNameField;
    private JLabel businessNameLabel;
    private int tableid1;
    private int numberofpeople1;
    private String status1;
    private JTextPane nubmerOfPeopleTextPane;
    private JTextPane businessTextPane;
    private String businessName1;
    private String Details;

    public EntranceUI() {
        setTitle("EntranceUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(EntranceUI);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleContinueButton();
            }
        });
    }

    private void handleContinueButton() {

            tableid1 = Integer.parseInt(tableid.getText());
            numberofpeople1 = Integer.parseInt(numberofpeople.getText());
            businessName1 = businessNameField.getText(); // Get the entered business name

            Table selectedTable = null;
            Business selectedBusiness = null;

            // Search for the business by name
            for (Business business : DineEase.getBusinesses()) {
                if (business.getName().equalsIgnoreCase(businessName1)) {
                    selectedBusiness = business;

                    // Search for the table by ID in the selected business
                    for (Table table : selectedBusiness.getTables()) {
                        if (table.getTableId() == tableid1) {
                            selectedTable = table;
                            break;
                        }
                    }
                    break; // Exit the loop if the business is found
                }
            }
                // Check if the table is found within the business
                if (selectedTable != null) {
                    // Check the number of people against the table capacity
                    if (numberofpeople1 > selectedTable.getCapacity()) {
                        JOptionPane.showMessageDialog(null, "The number of people exceeds the capacity of table " + tableid1 + " in " + businessName1 + ".");
                    } else {
                        // Check the status of the selected table
                        if (selectedTable.getStatus().equalsIgnoreCase("FREE")) {
                            // Change the status of the selected table
                            selectedTable.notFreeTable();

                            // Print the details of the selected table after status change
                            System.out.println("Selected Table Details (After Status Change):");
                            System.out.println(selectedTable.toString());
                             MenuUI menuUI = new MenuUI("","","");
                             dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Table with ID " + tableid1 + " is not free in " + businessName1 + ".");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Table with ID " + tableid1 + " not found in " + businessName1 + ".");
                }

    }

}

