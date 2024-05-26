package GUI;

import business.Business;
import business.ordering.*;
import business.ordering.Menu;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SuggestionsUI extends JFrame {
    public SuggestionsUI(Customer user, Business business, Point location) {
        setTitle("SuggestionsUI");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        ArrayList<Dish> dishes = createSuggestions(business.getMenu(),user.getOrderHistory());
        for (Dish dish : dishes) {
            JPanel dishPanel = createDishPanel(user, business, dish);
            mainPanel.add(dishPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            new BusinessUI((Customer) user,business,this.getLocation());
            dispose();
        });

        panel2.add(backButton);

        add(panel2, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createDishPanel(Person user, Business business, Dish dish) {
        JPanel dishPanel = new JPanel();
        dishPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton dishButton = new JButton(dish.getName());
        dishButton.setPreferredSize(new Dimension(410, 50));
        dishButton.setBackground(Color.BLUE);
        dishButton.setForeground(Color.WHITE);
        dishButton.addActionListener((ActionEvent e) -> {
            new DishUI(user, business, dish, this.getLocation());
            dispose();
        });


        dishPanel.add(dishButton);
        return dishPanel;
    }

    private ArrayList<Dish> createSuggestions(Menu menu, OrderHistory orderHistory){
        return menu.getMenu();
    }

}


