package GUI;

import business.Business;
import business.ordering.Item;
import users.Cook;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StorageHandlingUI extends JFrame {
    private JPanel topPanel;
    public StorageHandlingUI(Person user, Business business,Point location) {
        //new JFrame("StorageHandling");
        setTitle("Storage Handling");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        loadPanel(user,business);

        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);

        JButton button = new JButton("Back");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        //Button Order
        button.addActionListener(e -> {
            new DashboardUI(user, business,this.getLocation());
            dispose();
        });

        bottomPanel.add(button);



        setVisible(true);

    }

    private void loadPanel(Person user,Business business){
        ArrayList<Item> storage;
        if(user instanceof Cook){
            storage = business.getStorage().getStorage();
        }
        else {
            storage = business.getStorage().getStorage2();
        }
        for (Item item : storage) {
            JPanel itemPanel = createItemPanel(item, user,business);
            topPanel.add(itemPanel);

        }
        topPanel.revalidate();
        topPanel.repaint();
    }
    private JPanel createItemPanel(Item item,Person user, Business business) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        JLabel itemName = new JLabel(item.getName());

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
                loadPanel(user,business);
                System.out.println("Quantity updated");
            } else {
                System.err.println("Invalid input: " + text);
            }
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));

        rightPanel.add(inputQuantity);
        rightPanel.add(quantButton);

        itemPanel.add(itemName, BorderLayout.WEST);
        itemPanel.add(rightPanel, BorderLayout.EAST);
        return itemPanel;
    }
}
