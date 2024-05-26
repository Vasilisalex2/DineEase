package GUI;

import business.Business;
import users.Customer;
import business.DineEase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BusinessesUI extends JFrame {
    private JPanel topPanel;
    public BusinessesUI(Customer user, DineEase dinease, Point location){
        setSize(460, 680);
        setLocation(location);
        setLayout(new BorderLayout());


        // Top panel for dish names and buttons
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        loadPanel(user,dinease.getBusinesses());

        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }


    private void loadPanel(Customer user,ArrayList<Business> businesses){
        for (Business business : businesses) {
            JPanel itemPanel = createItemPanel(user,business);
            topPanel.add(itemPanel);

        }
        topPanel.revalidate();
        topPanel.repaint();
    }
    private JPanel createItemPanel(Customer user,Business business) {
        JPanel itemPanel = new JPanel();

        JButton button = new JButton(business.getName());
        button.setPreferredSize(new Dimension(430, 50));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        button.addActionListener(e->{
            new BusinessUI(user,business,this.getLocation());
            dispose();
        });

        itemPanel.add(button);

        return itemPanel;
    }
}

