package GUI;

import business.Business;
import business.DineEase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurBillUI extends JFrame {
    private JPanel CurBill;
    private JTextField tableId;
    private JButton showBillButton;
    private JFormattedTextField insertTableIdFormattedTextField;
    private int tableid;
    private Business business;
    private String BusinessName1;
    public CurBillUI(String BusinessName) {

        setTitle("CurBill UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(CurBill);
        showBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableid = Integer.parseInt(tableId.getText());
                   BusinessName1 = BusinessName;
                    business= DinEase.findBusinessByName(BusinessName1);
                    Bill bill = business.getBill(tableid);
                    if (bill != null) {
                        String billDetails = bill.generateBillDetails();
                        BillUI billUI = new BillUI(billDetails, tableid, BusinessName, "worker");
                    } else {
                        JOptionPane.showMessageDialog(null, "No bill found for Table ID: " + tableid);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid table ID.");
                }
            }
        });
    }
}
