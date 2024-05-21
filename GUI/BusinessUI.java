package GUI;

import business.Business;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessUI extends JFrame{
    public BusinessUI(Person user,Business business){
        //Business business
        JFrame frame = new JFrame("Business");
        frame.setSize(460,680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //frame.setResizable(false);
        frame.setVisible(true);

        //JPanel panel = new JPanel();
        //panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // Set the border with padding

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(160, 30, 100, 30);

        frame.add(menuButton);
        //panel.add(menuButton);
        //frame.add(panel);
        //getContentPane().add(menuButton);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuUI(user,business, business.getMenu());
                //BusinessUI.setVisible(false);
                frame.dispose();
            }
        });


    }
    public static void main(String[] args) {
        Business business = new Business(10);
        Customer user = new Customer();
        user.setCheckedIN(true);
        BusinessUI businessUI = new BusinessUI(user,business);
    }
}