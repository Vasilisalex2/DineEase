package GUI;
import business.Business;
import users.*;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {
    public DashboardUI(Person user, Business business,Point location){
        setTitle("Dashboard");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //frame.setResizable(false);

        JButton storageButton = new JButton("Storage");
        storageButton.setBounds(160, 80, 100, 30);
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(160, 30, 100, 30);
        JButton resButton = new JButton("Reservation");
        resButton.setBounds(160, 130, 100, 30);
        JButton taskButton = new JButton("Tasks");
        taskButton.setBounds(160, 180, 100, 30);

        storageButton.addActionListener(e->{
                if(user instanceof Owner){
                    new StorageHandlingOUI((Owner)user , business,this.getLocation());
                    dispose();
                }
                else{
                    new StorageHandlingUI((Worker)user,business,this.getLocation());
                    dispose();
                }
        });
        menuButton.addActionListener(e->{
            new MenuUI(user,business,business.getMenu(),this.getLocation());
            dispose();
        });
        resButton.addActionListener(e->{
            new ReservationUI(user,business,this.getLocation());
            dispose();
        });
        taskButton.addActionListener(e->{
            new TasksUI((Worker)user,business,this.getLocation());
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
        if(user instanceof Worker){
            add(taskButton);
        }
        setVisible(true);
    }
}
