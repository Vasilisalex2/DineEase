package GUI;

import business.Business;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessUI extends JFrame{
    public BusinessUI(Customer user,Business business,Point location){
        setTitle(business.getName() + "UI");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(contentPanel, BorderLayout.NORTH);

        // Top panel for dish names and buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(460, 136));
        contentPanel.add(topPanel);
        //topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        contentPanel.add(bottomPanel);

        loadPanel(topPanel, business,user);

        JButton menuButton = new JButton("Menu");
        menuButton.setPreferredSize(new Dimension(150, 100));
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //menuButton.setAlignmentY(Component.TOP_ALIGNMENT);
        //menuButton.setBounds(160, 30, 100, 30);

        menuButton.setBackground(Color.BLUE);
        menuButton.setForeground(Color.WHITE);

        menuButton.addActionListener(e -> {
                new MenuUI(user,business, business.getMenu(),this.getLocation());
                dispose();
        });

        JButton resButton = new JButton("Reservation");
        resButton.setPreferredSize(new Dimension(150, 100));
        resButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //resButton.setAlignmentY(Component.TOP_ALIGNMENT);
        //menuButton.setBounds(160, 30, 100, 30);

        resButton.setBackground(Color.BLUE);
        resButton.setForeground(Color.WHITE);

        resButton.addActionListener(e -> {
            new ReservationUI(user,business,this.getLocation());
            dispose();
        });

        bottomPanel.add(Box.createVerticalStrut(60));
        bottomPanel.add(menuButton);
        bottomPanel.add(Box.createVerticalStrut(30));
        bottomPanel.add(resButton);

        setVisible(true);
    }
    private void loadPanel(JPanel panel,Business business,Customer user){
        Color LIGHT_BLUE = new Color(173, 216, 230);

        JLabel nameLabel = new JLabel(business.getName());
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font boldFont = new Font(nameLabel.getFont().getName(), Font.BOLD, 16);
        nameLabel.setFont(boldFont);
        panel.add(nameLabel, BorderLayout.NORTH);

        // Main panel with description and buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
        panel.add(mainPanel, BorderLayout.CENTER);

        // West panel for description
        JTextArea descriptionArea = new JTextArea(business.getDescription());
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBackground(LIGHT_BLUE);
        //descriptionArea.setForeground(Color.WHITE);
        mainPanel.add(new JScrollPane(descriptionArea), BorderLayout.CENTER);

        // East panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1));
        JButton reviewsButton = new JButton("Reviews");
        reviewsButton.setBackground(Color.BLUE);
        reviewsButton.setForeground(Color.WHITE);
        JButton mapButton = new JButton("Map");
        mapButton.setBackground(Color.BLUE);
        mapButton.setForeground(Color.WHITE);
        reviewsButton.setPreferredSize(new Dimension(100, 100));
        mapButton.setPreferredSize(new Dimension(100, 100));

        reviewsButton.addActionListener(e -> {
            new ReviewsUI(user,business);
            dispose();
        });

        buttonsPanel.add(reviewsButton);
        //buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        buttonsPanel.add(mapButton);
        mainPanel.add(buttonsPanel, BorderLayout.EAST);

    }}