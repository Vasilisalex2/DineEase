package GUI;

import business.Business;
import business.Table;
import business.ordering.Dish;
import users.Basket;
import users.Person;
import users.Worker;

import javax.swing.*;
import java.awt.*;

public class DishUI extends JFrame {
    public DishUI(Person user, Business business, Dish dish){
        setTitle("Dish UI - " + dish.getName());
        setSize(460,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel desc = new JPanel();
        JPanel inputPanel = new JPanel();

        JLabel label = new JLabel("Details for: " + dish.getName());
        desc.add(label);
        JButton button = new JButton("Add To Basket");

        JTextField inputField = new JTextField(2);
        JTextField tableField = new JTextField(2);

        button.addActionListener(e->{

            if(user instanceof Worker){
                System.out.println(tableField.getText());
                String table = tableField.getText();
                if (table.matches("\\d+")) {
                    //dish.setTable(business.getTables().get(Integer.parseInt(table)));
                    dish.setTable(business.getTable(Integer.parseInt(table)));
                } else {
                    System.err.println("Invalid input: " + table);
                }
            }
            System.out.println(inputField.getText());
            String text = inputField.getText();

            if (text.matches("\\d+")) {
                user.getBasket().addToBasket(dish,Integer.parseInt(text));
                new MenuUI(user,business, business.getMenu());
                dispose();
            } else {
                System.err.println("Invalid input: " + text);
            }
        });
        inputPanel.add(inputField);
        if(user instanceof Worker){
            inputPanel.add(tableField);

        }
        inputPanel.add(button);
        add(desc, BorderLayout.NORTH);
        add(inputPanel);

        setVisible(true);
    }


}
