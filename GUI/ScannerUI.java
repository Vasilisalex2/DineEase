package GUI;

import GUI.MenuUI;
import business.Business;
import business.Table;
import business.DineEase;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScannerUI extends JFrame {
    private JTextField tableId;
    private JButton okButton;
    private JTextField BusinessName;
    private JPanel ScannerUI;
    int tableid1;
    String businessName1;

    public ScannerUI() {
        setTitle("Scanner UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(ScannerUI);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableid1 = Integer.parseInt(tableId.getText());
                businessName1 = BusinessName.getText(); // Get the entered business name

                Table selectedTable = null;
                Business selectedBusiness = null;


                for (Business business : DineEase.getBusinesses()) {
                    if (business.getName().equalsIgnoreCase(businessName1)) {
                        selectedBusiness = business;


                        for (Table table : selectedBusiness.getTables()) {
                            if (table.getTableId() == tableid1) {
                                selectedTable = table;
                                break;
                            }
                        }
                        break;
                    }
                }

                if (selectedTable != null) {

                    if (selectedTable.getStatus() == Table.eStatus.FREE) {

                        selectedTable.notFreeTable();


                        System.out.println("Selected Table Details (After Status Change):");
                        System.out.println(selectedTable.toString());
                       // MenuUI menuUI = new MenuUI();

                    } else {
                        JOptionPane.showMessageDialog(null, "Table with ID " + tableid1 + " is not free in " + businessName1 + ".");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Table with ID " + tableid1 + " not found in " + businessName1 + ".");
                }
            }
        });
    }
}
