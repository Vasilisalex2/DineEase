package GUI;

import business.Business;
import business.ordering.Dish;
import users.Person;
import users.Worker;

import javax.swing.*;
import java.awt.*;

public class DishUI extends JFrame {
    public DishUI(Person user, Business business, Dish dish, Point location) {
        setTitle("Dish UI - " + dish.getName());
        setSize(460, 680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Details for: " + dish.getName());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(titleLabel);

        topPanel.add(contentPane);

        Color LIGHT_BLUE = new Color(173, 216, 230);

        // Display dish description (non-editable)
        JTextArea descTextArea = new JTextArea(dish.getDescription());
        descTextArea.setEditable(false);
        descTextArea.setLineWrap(true);
        descTextArea.setWrapStyleWord(true);
        descTextArea.setBackground(LIGHT_BLUE);
        JScrollPane descScrollPane = new JScrollPane(descTextArea);
        descScrollPane.setPreferredSize(new Dimension(0, 300));
        topPanel.add(descScrollPane);


        // Input field for table ID (only for workers)
        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel tableLabel = new JLabel("Table ID:");
        JTextField tableField = new JTextField(5);
        if (user instanceof Worker) {
            tablePanel.add(tableLabel);
            tablePanel.add(tableField);
            contentPane.add(tablePanel);
        }

        // Input field for quantity
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(5);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityField);
        contentPane.add(quantityPanel);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            new MenuUI(user,business,business.getMenu(),this.getLocation());
            dispose();
        });


        JButton addButton = new JButton("Add To Basket");
        addButton.setBackground(Color.BLUE);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> {
            // Get quantity
            String quantityText = quantityField.getText();
            if (quantityText.matches("\\d+")) {
                int quantity = Integer.parseInt(quantityText);
                // Add to basket
                user.getBasket().addToBasket(dish, quantity);
                // Navigate back to menu
                new MenuUI(user, business, business.getMenu(), this.getLocation());
                dispose();
            } else {
                System.err.println("Invalid input for quantity: " + quantityText);
            }

            if (user instanceof Worker) {
                String tableText = tableField.getText();
                if (tableText.matches("\\d+")) {
                    int tableId = Integer.parseInt(tableText);
                    dish.setTable(business.getTable(tableId));
                } else {
                    System.err.println("Invalid input for table ID: " + tableText);
                }
            }
        });



        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        bottomPanel.add(addButton);

        add(topPanel, BorderLayout.NORTH);
        add(contentPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
