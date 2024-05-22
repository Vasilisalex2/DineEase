package GUI;

import business.Business;
import business.ordering.Dish;
import users.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishUI extends JFrame {
    public DishUI(Person user, Business business, Dish dish){
        setTitle("Dish UI - " + dish.getName());
        setSize(460,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel desc = new JPanel();
        JPanel basketButton = new JPanel();
        JPanel inputP = new JPanel();

        JLabel label = new JLabel("Details for: " + dish.getName());
        desc.add(label);
        JButton button = new JButton("Add To Basket");

        JTextField inputField = new JTextField(2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(inputField.getText());
                String text = inputField.getText();

                if (text.matches("\\d+")) {
                    user.getBasket().addToBasket(dish,Integer.parseInt(text));
                    new MenuUI(user,business, business.getMenu());
                    dispose();
                } else {
                    System.err.println("Invalid input: " + text);
                }
            }
        });
        inputP.add(inputField);
        inputP.add(button);
        add(desc);
        add(inputP);
    }

}
