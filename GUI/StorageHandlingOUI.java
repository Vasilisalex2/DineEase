package GUI;

import business.Business;
import users.Owner;

import javax.swing.*;
import java.awt.*;

public class StorageHandlingOUI extends JFrame{
    public StorageHandlingOUI(Owner user, Business business) {
        setTitle("Storage Handling");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenuItem storageMenuItem = new JMenuItem("Storage");
        JMenuItem lowStorageMenuItem = new JMenuItem("Low In Storage");

        menubar.add(storageMenuItem);
        menubar.add(lowStorageMenuItem);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton button = new JButton("Back");
        button.addActionListener(e -> {
            new DashboardUI(user, business);
            dispose();
        });
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
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
