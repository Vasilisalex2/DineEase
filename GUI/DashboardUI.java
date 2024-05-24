package GUI;
import business.Business;
import users.*;

import javax.swing.*;

public class DashboardUI extends JFrame {
    public DashboardUI(Person user, Business business){
        setTitle("Dashboard");
        setSize(460,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //frame.setResizable(false);
        setVisible(true);

        JButton storageButton = new JButton("Storage");
        storageButton.setBounds(160, 80, 100, 30);
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(160, 30, 100, 30);

        add(menuButton);
        add(storageButton);

        storageButton.addActionListener(e->{
                if(user instanceof Owner){
                    new StorageHandlingOUI((Owner)user , business);
                    dispose();
                }
                else{
                    new StorageHandlingUI((Worker)user,business);
                    dispose();
                }
        });
        menuButton.addActionListener(e->{
            new MenuUI(user,business,business.getMenu());
            dispose();
        });


    }
}
