package GUI;

import business.Business;
import business.StoreRating;
import business.Table;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReservationUI extends JFrame {
    public ReservationUI(Person user, Business business) {
        setTitle("Reservation UI");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadPanel(topPanel, business, business.getTables());

        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(e -> {
            if (user instanceof Customer) {
                new BusinessUI((Customer) user, business);
            } else {
                new DashboardUI(user, business);
            }
            dispose();
        });

        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        //bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(button);


        setVisible(true);
    }

    private void loadPanel(JPanel panel, Business business, ArrayList<Table> tables) {
        JDialog popup = new JDialog();
        for (Table table : tables) {
            JButton tableButton = new JButton(Integer.toString(table.getTableId()));

            tableButton.addActionListener(e -> {
                if (popup.isVisible()) {
                    popup.setVisible(false);
                    showPopup(table, popup);
                } else {
                    showPopup(table, popup);
                }
            });

            tableButton.setBackground(Color.BLUE);
            tableButton.setForeground(Color.WHITE);

            panel.add(tableButton);
        }
        panel.revalidate();
        panel.repaint();
    }

    private void showPopup(Table table, JDialog popup) {

        //popup = new JDialog(this, "Input Popup", true);
        popup.setTitle(Integer.toString(table.getTableId()));
        popup.setSize(300, 200);
        popup.setLocationRelativeTo(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Field 1:"));
        panel.add(new JTextField(10));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Field 2:"));
        panel.add(new JTextField(10));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Field 3:"));
        panel.add(new JTextField(10));

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {

        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> popup.dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        popup.add(panel, BorderLayout.CENTER);
        popup.add(buttonPanel, BorderLayout.SOUTH);
        popup.setVisible(true);
    }
}
