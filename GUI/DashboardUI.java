package GUI;
import business.Business;
import business.ordering.Item;
import users.Customer;
import users.Owner;
import users.Person;
import users.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {
    public DashboardUI(Person user, Business business){
        //Business business
        JFrame frame = new JFrame("Business");
        frame.setSize(460,680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //frame.setResizable(false);
        frame.setVisible(true);

        JButton menuButton = new JButton("Storage");
        menuButton.setBounds(160, 30, 100, 30);

        frame.add(menuButton);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user instanceof Owner){
                    new StorageHandlingOUI((Owner)user , business);
                    //BusinessUI.setVisible(false);
                    frame.dispose();
                }
                else{
                    new StorageHandlingUI((Worker)user,business);
                    //BusinessUI.setVisible(false);
                    frame.dispose();
                }
            }
        });


    }
    public static void main(String[] args) {
        Business business = new Business(10);
        Owner user = new Owner();
        business.getStorage().getStorage().add(new Item());
        business.getStorage().getStorage().add(new Item());
        business.getStorage().getStorage().add(new Item());
        business.getStorage().getStorage().add(new Item());
        for(int i = 0; i < 40; i++){
            business.getStorage().getStorage().add(new Item());
        }
        DashboardUI dashboardUI = new DashboardUI(user,business);
    }
}
