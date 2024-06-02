import GUI.BusinessesUI;
import GUI.DashboardUI;
import business.Business;
import business.DineEase;
import business.StoreRating;
import business.ordering.Dish;
import business.ordering.Item;
import business.ordering.Order;
import users.*;

import javax.swing.*;
import java.awt.*;

class MainUI extends JFrame {
    public MainUI() {
        setTitle("Main Screen");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        DineEase app = new DineEase();
        Business business = app.getBusinesses().get(0);
        business.setDescription("A new restaurant in town open for the bold. Who will dare to taste our creations? ");

        business.addReview(new StoreRating("Vasilis","I didnt like the store. I voted against it!"));
        business.addReview(new StoreRating("Nikos","Such a fantastic experience. This was not just dinner, but an experience and show of art. Every dish was an experience. We waited with anticipation for each. It was worth it.\n" +
                "We had a small glitch with the reservation. We reserved it on. Fork. But - the email (which I never pay attention to) said reservation was denied even though Fork said it was confirmed. Lesson learned. Sphere was very good and"));
        business.addReview(new StoreRating("Rosalia","Very good!"));
        business.addReview(new StoreRating("Thodoris","Firstly I must mention to you that my friends and I, we like trying new cuisines & flavours, we go out for food at least twice a month and we usually don't pay over 20-25e per person. I must also declare to you that we don't have strange willing on food.\n" +
                "\n" +
                "We decided to go to this restaurant as we wanted to eat traditional greek cuisine and we read for this place in Athinorama Magazine (a kind of guide magazine published every week for Athens city)."));
        business.addReview(new StoreRating("Georgia","The restaurant is beautiful, the staff was very nice, but the food was just OK... we went for the 4 course menu and the dishes were mediocre.. while we did specify ahead all dietary restrictions (pregnant) I was accepting the kitchen to make adjustments- meaning, to make something accordingly...but they just gave us both the same dished at took out many elements from the dish.\n" +
                "I also took the wine route and the wine selection was meh.... I didn't come for a Michelin restaurant to get a 20 euro small glass of Riesling.."));
        business.addReview(new StoreRating("Eren",""));




        for(int i = 0; i < 25; i++){
            business.getStorage().getStorage().add(new Item());
        }

        JButton ownerButton = new JButton("Owner");
        ownerButton.setPreferredSize(new Dimension(100, 100));
        ownerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ownerButton.setBackground(Color.BLUE);
        ownerButton.setForeground(Color.WHITE);
        ownerButton.addActionListener(e -> {
            Owner owner = new Owner("Name");//todo add a name
            owner.setBusiness(business);
            new DashboardUI(owner,owner.getBusiness(),app,new Point(200,100));
            dispose();
        });
        JButton workerButton = new JButton("Worker");
        workerButton.setPreferredSize(new Dimension(100, 100));
        workerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        workerButton.setBackground(Color.BLUE);
        workerButton.setForeground(Color.WHITE);
        workerButton.addActionListener(e -> {
            Cook worker = new Cook("Name");//todo add a name
            worker.setBusiness(business);

            Order order = new Order();
            Dish dish = new Dish("Παπια με τηγανητο ρυζι");
            dish.setQuantity(10);
            order.addToOrder(dish);
            order.addToOrder(new Dish("Παγωτο Βανιλια"));
            worker.addToTaskList(order);

            new DashboardUI(worker,worker.getBusiness(),app,new Point(200,100));
            dispose();
        });
        JButton customerButton = new JButton("Customer");
        customerButton.setPreferredSize(new Dimension(100, 100));
        customerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerButton.setBackground(Color.BLUE);
        customerButton.setForeground(Color.WHITE);
        customerButton.addActionListener(e -> {
            Customer customer = new Customer("Dany");

            new BusinessesUI(customer,app,new Point(200,100));
            dispose();
        });


        add(Box.createVerticalStrut(60));
        add(ownerButton);
        add(Box.createVerticalStrut(30));
        add(workerButton);
        add(Box.createVerticalStrut(30));
        add(customerButton);
        setVisible(true);
    }
}

public class Main {

    public static void main(String[] args) {
        new MainUI();
    }

}