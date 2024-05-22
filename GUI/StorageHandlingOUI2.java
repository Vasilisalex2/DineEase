package GUI;

import business.Business;
import business.ordering.Item;
import users.Owner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class StorageHandlingOUI2 extends JPanel {
    private JPanel topPanel;

    public StorageHandlingOUI2(Owner user, Business business) {


        setSize(460, 680);
        setLayout(new BorderLayout());


        // Top panel for dish names and buttons
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        loadPanel(business);

        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }


    private void loadPanel(Business business){
        // Create table model with two columns: Name and Quantity
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity"}, 0);

        // Create JTable with the table model
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Item> storage = business.getStorage().getStorage();
        for (Item item : storage) {
            if(item.getHigherLimit()>item.getQuantity()) {
                tableModel.addRow(new Object[]{item.getName(), item.getQuantity()});
            }
        }
        topPanel.revalidate();
        topPanel.repaint();
    }

}
