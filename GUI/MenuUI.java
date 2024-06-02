package GUI;

import business.Business;
import business.DineEase;
import business.GeneralTask;
import business.ordering.Dish;
import business.ordering.Menu;
import users.Customer;
import users.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MenuUI extends JFrame {
    private boolean butDisable;
    private DineEase app;

    public MenuUI(Person user, Business business, Menu menu,DineEase dineEase, Point location) {
        butDisable = false;
        app = dineEase;
        setTitle("Menu");
        setSize(460, 680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        ArrayList<Dish> dishes = menu.getMenu();
        for (Dish dish : dishes) {
            JPanel dishPanel = createDishPanel(user, business, dish);
            mainPanel.add(dishPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel2 = createPanel2(user, business);
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
            new DishUI(user, business, dish, app,this.getLocation());
            dispose();
        });


        dishPanel.add(dishButton);
        return dishPanel;
    }

    private JPanel createPanel2(Person user, Business business) {
        JPanel panel2 = new JPanel();

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            if(user instanceof Customer) {
                new BusinessUI((Customer) user,business, app,this.getLocation());
            }
            else{
                new DashboardUI(user,business,app,this.getLocation());
            }
            dispose();
        });
        JButton butBasket = new JButton("Basket");
        butBasket.setBackground(Color.BLUE);
        butBasket.setForeground(Color.WHITE);
        butBasket.addActionListener(e -> {
            new BasketUI(user, business,app,this.getLocation());
            dispose();
        });
        JButton butWaiter = new JButton("Call Waiter");
        butWaiter.setBackground(Color.BLUE);
        butWaiter.setForeground(Color.WHITE);
        butWaiter.addActionListener(e -> {
            if (user instanceof Customer && !butDisable && ((Customer) user).isCheckedIN()) {
                GeneralTask callWaiter = new GeneralTask("Table Call", GeneralTask.taskType.tableCall);
                callWaiter.setTable(((Customer) user).getTable());
                butDisable = true;
            }
        });

        panel2.add(backButton);
        panel2.add(butBasket);
        panel2.add(butWaiter);

        return panel2;
    }
}
