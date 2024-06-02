package GUI;

import business.Business;
import business.DineEase;
import business.timetable.TimerUI;
import users.Owner;
import users.Worker;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {

    public DashboardUI(Person user, Business business, DineEase app, Point location) {
        setTitle("Dashboard");
        setSize(460, 680);
        setLocation(location);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JButton storageButton = new JButton("Storage");
        storageButton.setBounds(155, 80, 150, 30);
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(155, 30, 150, 30);
        JButton resButton = new JButton("Reservation");
        resButton.setBounds(155, 130, 150, 30);
        JButton taskButton = new JButton("Tasks");
        taskButton.setBounds(155, 180, 150, 30);
        JButton checkInButton = new JButton("Check-in");
        checkInButton.setBounds(155, 230, 150, 30);
        JButton checkOutButton = new JButton("Check-out");
        checkOutButton.setBounds(155, 280, 150, 30);

        checkOutButton.setBackground(Color.BLUE);
        checkOutButton.setForeground(Color.WHITE);
        checkInButton.setBackground(Color.BLUE);
        checkInButton.setForeground(Color.WHITE);

        storageButton.addActionListener(e -> {
            if (user instanceof Owner) {
                new StorageHandlingOUI((Owner) user, business, app,this.getLocation());
                dispose();
            } else {
                new StorageHandlingUI((Worker) user, business,app, this.getLocation());
                dispose();
            }
        });
        menuButton.addActionListener(e -> {
            new MenuUI(user, business, business.getMenu(),app, this.getLocation());
            dispose();
        });
        resButton.addActionListener(e -> {
            new ReservationUI(user, business,app, this.getLocation());
            dispose();
        });
        taskButton.addActionListener(e -> {
            new TasksUI((Worker) user, business, app,this.getLocation());
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
            JButton workerTimetableButton = new JButton("Timetable");
            workerTimetableButton.setBounds(155, 430, 150, 30);
            workerTimetableButton.setBackground(Color.BLUE);
            workerTimetableButton.setForeground(Color.WHITE);

            workerTimetableButton.addActionListener(e -> {
                new WorkerTimetable(business);
                //dispose();
            });
            add(workerTimetableButton);
            add(taskButton);



            JButton checkInOutWorkerButton = new JButton("Check-In/Out Worker");
            checkInOutWorkerButton.setBounds(155, 380, 150, 30); // Adjust size and position as needed
            checkInOutWorkerButton.setBackground(Color.BLUE);
            checkInOutWorkerButton.setForeground(Color.WHITE);
            checkInOutWorkerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                ScannerWorkerUI scanner = new ScannerWorkerUI(((Worker) user));
                }
            });
            add(checkInOutWorkerButton);
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

            JButton breakButton = new JButton("Break");
            breakButton.setBounds(155, 330, 150, 30); // Adjust size and position as needed
            breakButton.setBackground(Color.BLUE);
            breakButton.setForeground(Color.WHITE);
            breakButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TimerUI(500);
                }
            });
            add(breakButton);
        }
        else {
            JButton ownerButton = new JButton("Business Handling");
            ownerButton.setBounds(155, 180, 150, 30);
            ownerButton.setBackground(Color.BLUE);
            ownerButton.setForeground(Color.WHITE);
            ownerButton.addActionListener(e -> {
                new OwnerMainScreen(business);
            });
            add(ownerButton);

        }

        setVisible(true);
    }
}

