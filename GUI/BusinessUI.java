package GUI;

import business.Business;
import business.DineEase;
import business.Reservation;
import business.ordering.Bill;
import jdk.jshell.SourceCodeAnalysis;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessUI extends JFrame{
    private JTextField customerNameField;
    private JScrollBar scrollBar;

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
     //   bottomPanel.add(bottomPanel);
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
        resButton.setBackground(Color.BLUE);
        resButton.setForeground(Color.WHITE);

        resButton.addActionListener(e -> {
            new ReservationUI(user,business,this.getLocation());
            dispose();
        });

        JButton sugButton = new JButton("Suggestions");
        sugButton.setPreferredSize(new Dimension(150, 100));
        sugButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sugButton.setBackground(Color.BLUE);
        sugButton.setForeground(Color.WHITE);

        sugButton.addActionListener(e -> {
            new SuggestionsUI(user,business,this.getLocation());
            dispose();
        });

        JButton scanButton = new JButton("Scan");
        scanButton.setPreferredSize(new Dimension(100, 100));
        scanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scanButton.setBackground(Color.BLUE);
        scanButton.setForeground(Color.WHITE);



        JButton checkOutButton = new JButton("Check-out");
        checkOutButton.setPreferredSize(new Dimension(100, 100));
        checkOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkOutButton.setBackground(Color.BLUE);
        checkOutButton.setForeground(Color.WHITE);


        bottomPanel.add(Box.createVerticalStrut(60));
        bottomPanel.add(menuButton);
        bottomPanel.add(Box.createVerticalStrut(30));
        bottomPanel.add(resButton);
        bottomPanel.add(Box.createVerticalStrut(30));
        bottomPanel.add(sugButton);
        bottomPanel.add(Box.createVerticalStrut(30));
        bottomPanel.add(checkOutButton);
        bottomPanel.add(Box.createVerticalStrut(30));
        bottomPanel.add(scanButton);



        setVisible(true);

        scanButton.addActionListener(e -> {

            int customerId = user.getID();
            Reservation reservationFound = DineEase.reservationCheck(customerId);
            if (reservationFound != null) {
                // A reservation is found for the customer, open the CheckInUI
                CheckInUI checkInUI = new CheckInUI(user, business,location);
                // You can pass the reservation object to the CheckInUI constructor if needed
                String Details = reservationFound.showCheckIn();
                checkInUI.setReservationDetails(Details);
                dispose(); // Close the current window
            } else {
                // No reservation found, open the scanner UI
                ScannerUI scannerUI = new ScannerUI();
                dispose(); // Close the current window
            }

        });




        checkOutButton.addActionListener(e -> {

                    int customerId = user.getID();

                        int tableId = business.getTableIdByCustomerId(customerId);
                        if (tableId != -1) {
                            Bill bill = new Bill(business.findOrderByTableId(tableId), tableId);
                            String billDetails = bill.generateBillDetails();
                            BillUI billUI = new BillUI(billDetails, tableId, business, "customer");
                        } else {
                            JOptionPane.showMessageDialog(null, "No table found for customer ID: " + customerId);
                        }


        });


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
            new ReviewsUI(user,business,this.getLocation());
            dispose();
        });

        buttonsPanel.add(reviewsButton);
        //buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        buttonsPanel.add(mapButton);
        mainPanel.add(buttonsPanel, BorderLayout.EAST);



    }

}