package GUI;

import business.Business;
import users.Owner;

import javax.swing.*;

public class StorageHandlingOUI extends JFrame{
    private JPanel panel;
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

        storageMenuItem.addActionListener(e -> {
            getContentPane().removeAll();
            add(new StorageHandlingOUI1(user, business));
            revalidate();
            repaint();
        });
        lowStorageMenuItem.addActionListener(e -> {
            getContentPane().removeAll();
            add(new StorageHandlingOUI2(user, business));
            revalidate();
            repaint();
        });

        setVisible(true);
    }
}
