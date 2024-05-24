package GUI;

import business.Business;
import business.ordering.Dish;
import business.ordering.Order;
import users.Basket;
import users.Customer;
import users.Person;

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
                if(user.getClass() == Customer.class){
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
                        new BusinessUI(user, business);
                        dispose();
                    }
                    else{
                        System.out.println("You are not checked IN");
                    }
                }
        });
        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(button, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        loadPanel(user);

        setVisible(true);

    }

    private void loadPanel(Person user){
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
                loadPanel(user);
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
                        loadPanel(user);
                        System.out.println("Dish updated");
                    } else {
                        System.err.println("Invalid input: " + text);
                    }
            });



            dishPanel.add(dishName, BorderLayout.WEST);
            JPanel rightPanel = new JPanel();
            rightPanel.add(Box.createHorizontalGlue());
            rightPanel.add(inputField);
            rightPanel.add(butQuantity);
            rightPanel.add(dishButton);
            dishPanel.add(rightPanel, BorderLayout.EAST);
            topPanel.add(dishPanel);
        }
    }
}
