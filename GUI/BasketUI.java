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
import java.util.HashMap;
import java.util.Map;

public class BasketUI extends JFrame{
    private JPanel topPanel;
    public BasketUI(Person user, Business business,Point location){
        setTitle("Basket");
        setSize(460, 680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Top panel for dish names and buttons
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            new MenuUI(user,business,business.getMenu(),this.getLocation());
            dispose();
        });

        JButton orderButton = new JButton("Order");
        orderButton.setBackground(Color.BLUE);
        orderButton.setForeground(Color.WHITE);
        //Button Order
        orderButton.addActionListener(e->{
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
                        new BusinessUI((Customer)user, business,this.getLocation());
                        dispose();
                    }
                    else{
                        System.out.println("You are not checked IN");
                    }
                }
                else{
                    Basket basket = user.getBasket();

// Group dishes by table ID
                    Map<Integer, ArrayList<Dish>> dishesByTable = new HashMap<>();

                    for (Dish dish : basket.getBasket()) {
                        int tableId = dish.getId();
                        // Check if the table ID already exists in the map
                        if (dishesByTable.containsKey(tableId)) {
                            // If the table ID exists, add the dish to the existing list
                            dishesByTable.get(tableId).add(dish);
                        } else {
                            // If the table ID doesn't exist, create a new list and add the dish
                            ArrayList<Dish> dishesForTable = new ArrayList<>();
                            dishesForTable.add(dish);
                            dishesByTable.put(tableId, dishesForTable);
                        }
                    }

// Create orders for each group of dishes with the same table ID
                    for (Map.Entry<Integer, ArrayList<Dish>> entry : dishesByTable.entrySet()) {
                        int tableId = entry.getKey();
                        ArrayList<Dish> dishesForTable = entry.getValue();

                        Order order = new Order();
                        order.createOrder(dishesForTable);
                        business.addToTaskList(order);
                    }

                    basket.clearBasket();

                    new DashboardUI(user, business,this.getLocation());
                    dispose();
                }
        });
        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        bottomPanel.add(orderButton);

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
            dishButton.setBackground(Color.BLUE);
            dishButton.setForeground(Color.WHITE);
            dishButton.addActionListener(e -> {
                basket.remove(dish);
                topPanel.removeAll();
                topPanel.revalidate();
                topPanel.repaint();
                loadPanel(user,business);
                System.out.println("Dish removed");
            });


            JButton butQuantity = new JButton("Change Quantity");
            butQuantity.setBackground(Color.BLUE);
            butQuantity.setForeground(Color.WHITE);
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
                butTable.setBackground(Color.BLUE);
                butTable.setForeground(Color.WHITE);
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
