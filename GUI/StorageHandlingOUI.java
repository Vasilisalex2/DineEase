package GUI;

import business.Business;
import users.Owner;

import javax.swing.*;
import java.awt.*;

public class StorageHandlingOUI extends JFrame{
    public StorageHandlingOUI(Owner user, Business business, Point location) {
        setTitle("Storage Handling");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(location);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenuItem storageMenuItem = new JMenuItem("Storage");
        JMenuItem lowStorageMenuItem = new JMenuItem("Low In Storage");

        menubar.add(storageMenuItem);
        menubar.add(lowStorageMenuItem);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        JButton button = new JButton("Back");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> {
            new DashboardUI(user, business,this.getLocation());
            dispose();
        });
        bottomPanel.add(button);

        storageMenuItem.addActionListener(e -> {
            topPanel.removeAll();
            topPanel.add(new StorageHandlingOUI1(user, business));
            revalidate();
            repaint();
        });
        lowStorageMenuItem.addActionListener(e -> {
            topPanel.removeAll();
            topPanel.add(new StorageHandlingOUI2(user, business));
            revalidate();
            repaint();
        });

        setVisible(true);
    }
}
