package GUI;

import business.Business;
import business.ordering.Dish;
import business.ordering.Order;
import users.Basket;
import users.Customer;
import users.Person;
import users.Worker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BasketUI extends JFrame{
    private JPanel topPanel;
    public BasketUI(Person user, Business business){
        setTitle("Basket");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Top panel for dish names and buttons
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Order");
        //Button Order
        button.addActionListener(e->{
                if(user instanceof Customer){
                    if(((Customer) user).isCheckedIN()){
                        Basket basket = user.getBasket();
                        Order order = new Order();
                        //for (Dish dish : basket.getBasket()) {
                         //   order.addToOrder(dish);
                          //  basket.getBasket().remove(dish);
                        //}
                        order.createOrder(basket.getBasket());
                        basket.clearBasket();
                        business.addToTaskList(order);
                        ((Customer) user).getOrderHistory().addOrder(order);
                        new BusinessUI((Customer)user, business);
                        dispose();
                    }
                    else{
                        System.out.println("You are not checked IN");
                    }
                }
                else{
                    Basket basket = user.getBasket();
                    Order order = new Order();
                    //for (Dish dish : basket.getBasket()) {
                    //   order.addToOrder(dish);
                    //  basket.getBasket().remove(dish);
                    //}
                    order.createOrder(basket.getBasket());
                    basket.clearBasket();
                    business.addToTaskList(order);
                    //((Customer) user).getOrderHistory().addOrder(order);
                    new DashboardUI(user, business);
                    dispose();
                }
        });
        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(button, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        loadPanel(user,business);

        setVisible(true);

    }

    private void loadPanel(Person user,Business business){
        ArrayList<Dish> basket = user.getBasket().getBasket();
        for (Dish dish : basket) {
            JPanel dishPanel = new JPanel(new BorderLayout());
            JLabel dishName = new JLabel(dish.getName());
            JButton dishButton = new JButton("Remove Dish");
            dishButton.addActionListener(e -> {
                basket.remove(dish);
                topPanel.removeAll();
                topPanel.revalidate();
                topPanel.repaint();
                loadPanel(user,business);
                System.out.println("Dish removed");
            });


            JButton butQuantity = new JButton("Change Quantity");
            JTextField inputField = new JTextField(2);
            inputField.setText(Integer.toString(dish.getQuantity()));
            butQuantity.addActionListener(e->{
                    String text = inputField.getText();
                    if (text.matches("\\d+")) {
                        dish.setQuantity(Integer.parseInt(text));
                        topPanel.removeAll();
                        topPanel.revalidate();
                        topPanel.repaint();
                        loadPanel(user,business);
                        System.out.println("Dish updated");
                    } else {
                        System.err.println("Invalid input: " + text);
                    }
            });

            dishPanel.add(dishName, BorderLayout.WEST);
            JPanel rightPanel = new JPanel();
            rightPanel.add(Box.createHorizontalGlue());

            if(user instanceof Worker){
                JButton butTable = new JButton("Change Table");
                JTextField inputTable = new JTextField(2);
                inputTable.setText(Integer.toString(dish.getTable().getTableId()));
                butTable.addActionListener(e->{
                    String text = inputTable.getText();
                    if (text.matches("\\d+")) {
                        dish.setTable(business.getTable(Integer.parseInt(text)));
                        topPanel.removeAll();
                        topPanel.revalidate();
                        topPanel.repaint();
                        loadPanel(user,business);
                        System.out.println("Dish updated");
                    } else {
                        System.err.println("Invalid input: " + text);
                    }
                });
                rightPanel.add(inputTable);
                rightPanel.add(butTable);
            }


            rightPanel.add(inputField);
            rightPanel.add(butQuantity);
            rightPanel.add(dishButton);
            dishPanel.add(rightPanel, BorderLayout.EAST);
            topPanel.add(dishPanel);
        }
    }
}
