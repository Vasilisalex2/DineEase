package GUI;

import business.Business;
import users.Owner;
import users.Worker;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {
    private JButton checkInButton;
    private JButton checkOutButton;
    private JLabel dashboardLabel;

    public DashboardUI(Person user, Business business, Point location) {
        setTitle("Dashboard");
        setSize(460, 680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton storageButton = new JButton("Storage");
        storageButton.setBounds(160, 80, 100, 30);
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(160, 30, 100, 30);
        JButton resButton = new JButton("Reservation");
        resButton.setBounds(160, 130, 100, 30);
        JButton taskButton = new JButton("Tasks");
        taskButton.setBounds(160, 180, 100, 30);
        JButton checkInButton = new JButton("Check-in");
        checkInButton.setBounds(160, 230, 100, 30);
        JButton checkOutButton = new JButton("Check-out");
        checkOutButton.setBounds(160, 280, 100, 30);

        storageButton.addActionListener(e -> {
            if (user instanceof Owner) {
                new StorageHandlingOUI((Owner) user, business, this.getLocation());
                dispose();
            } else {
                new StorageHandlingUI((Worker) user, business, this.getLocation());
                dispose();
            }
        });
        menuButton.addActionListener(e -> {
            new MenuUI(user, business, business.getMenu(), this.getLocation());
            dispose();
        });
        resButton.addActionListener(e -> {
            new ReservationUI(user, business, this.getLocation());
            dispose();
        });
        taskButton.addActionListener(e -> {
            new TasksUI((Worker) user, business, this.getLocation());
            dispose();
        });

        menuButton.setBackground(Color.BLUE);
        menuButton.setForeground(Color.WHITE);

        storageButton.setBackground(Color.BLUE);
        storageButton.setForeground(Color.WHITE);

        resButton.setBackground(Color.BLUE);
        resButton.setForeground(Color.WHITE);

        taskButton.setBackground(Color.BLUE);
        taskButton.setForeground(Color.WHITE);

        add(menuButton);
        add(storageButton);
        add(resButton);

        if (user instanceof Worker) {
            add(taskButton);


            checkInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EntranceUI entranceUI = new EntranceUI(business);
                }
            });
            add(checkInButton);


            checkOutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    CurBillUI curBillUI = new CurBillUI(business);
                }
            });
            add(checkOutButton);
        }

        setVisible(true);
    }
}

