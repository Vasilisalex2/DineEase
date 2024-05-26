package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashbooardUI extends JFrame {
    private JPanel Dashboard;
    private JLabel dashboardLabel;
    private JButton checkInButton;
    private JButton checkOutButton;

    public DashbooardUI() {
        setTitle("DashboardUI UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(Dashboard);
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntranceUI entranceUI = new EntranceUI();
            }
        });
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String BusinessA= "Business A";
                CurBillUI curBillUI = new CurBillUI(BusinessA);
            }
        });
    }
}
