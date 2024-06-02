package GUI;

import business.Business;
import business.ordering.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StorageHandlingOUI1 extends JPanel {
    private JPanel topPanel;

    public StorageHandlingOUI1( Business business) {
        setLayout(new BorderLayout());


        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        loadPanel(business);

        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }


    private void loadPanel(Business business){
        ArrayList<Item> storage = business.getStorage().getStorage();
        for (Item item : storage) {
            JPanel itemPanel = createItemPanel(item, business);
            topPanel.add(itemPanel);

        }
        topPanel.revalidate();
        topPanel.repaint();
    }
    private JPanel createItemPanel(Item item, Business business) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        JLabel itemName = new JLabel(item.getName());

        JButton removeButton = new JButton("Remove Item");
        removeButton.setBackground(Color.BLUE);
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(e -> {
            business.getStorage().removeItem(item);
            topPanel.removeAll();
            topPanel.revalidate();
            topPanel.repaint();
            loadPanel(business);
            System.out.println("Item removed");
        });

        JTextField inputQuantity = new JTextField(2);
        inputQuantity.setText(Integer.toString(item.getQuantity()));

        JButton quantButton = new JButton("Change Quantity");
        quantButton.setBackground(Color.BLUE);
        quantButton.setForeground(Color.WHITE);
        quantButton.addActionListener(e-> {
            String text = inputQuantity.getText();
            if (text.matches("\\d+")) {
                item.setQuantity(Integer.parseInt(text));
                topPanel.removeAll();
                loadPanel(business);
                System.out.println("Quantity updated");
            } else {
                System.err.println("Invalid input: " + text);
            }
        });

        JTextField inputLower = new JTextField(2);
        inputLower.setText(Integer.toString(item.getLowerLimit()));
        JButton lowerButton = new JButton("Change Lower Limit");
        lowerButton.setBackground(Color.BLUE);
        lowerButton.setForeground(Color.WHITE);
        lowerButton.addActionListener(e-> {
            String text = inputLower.getText();
            if (text.matches("\\d+")) {
                item.setLowerLimit(Integer.parseInt(text));
                topPanel.removeAll();
                loadPanel(business);
                System.out.println("Lower Limit updated");
            } else {
                System.err.println("Invalid input: " + text);
            }
        });
        JTextField inputHigher = new JTextField(2);
        inputHigher.setText(Integer.toString(item.getHigherLimit()));
        JButton higherButton = new JButton("Change Higher Limit");
        higherButton.setBackground(Color.BLUE);
        higherButton.setForeground(Color.WHITE);
        higherButton.addActionListener(e-> {
            String text = inputHigher.getText();
            if (text.matches("\\d+")) {
                item.setHigherLimit(Integer.parseInt(text));
                topPanel.removeAll();
                loadPanel(business);
                System.out.println("Higher Limit updated");
            } else {
                System.err.println("Invalid input: " + text);
            }
        });



        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));

        rightPanel.add(inputQuantity);
        rightPanel.add(quantButton);
        rightPanel.add(inputLower);
        rightPanel.add(lowerButton);
        rightPanel.add(inputHigher);
        rightPanel.add(higherButton);
        rightPanel.add(removeButton);

        JScrollPane scrollPane = new JScrollPane(itemName);

        itemPanel.add(scrollPane, BorderLayout.WEST);
        itemPanel.add(rightPanel, BorderLayout.EAST);
        return itemPanel;
    }
}