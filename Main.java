import GUI.BusinessesUI;
import GUI.DashboardUI;
import business.*;
import business.management.CheckInOutEvent;
import business.management.Transaction;
import business.ordering.Dish;
import business.ordering.Item;
import business.ordering.Order;
import business.timetable.Event;
import business.timetable.Objection;
import business.timetable.Timetable;
import users.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


class MainUI extends JFrame {
    public MainUI() {
        setTitle("Main Screen");
        setSize(460, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        DineEase app = new DineEase();
       // Business businessDemo = new Business(1);
       // app.addBusiness(businessDemo);
        Business businessDemo = app.getBusinesses().get(0);
        businessDemo.setDescription("A new restaurant in town open for the bold. Who will dare to taste our creations? ");

        businessDemo.addReview(new StoreRating("Vasilis","I didnt like the store. I voted against it!"));
        businessDemo.addReview(new StoreRating("Nikos","Such a fantastic experience. This was not just dinner, but an experience and show of art. Every dish was an experience. We waited with anticipation for each. It was worth it.\n" +
                "We had a small glitch with the reservation. We reserved it on. Fork. But - the email (which I never pay attention to) said reservation was denied even though Fork said it was confirmed. Lesson learned. Sphere was very good and"));
        businessDemo.addReview(new StoreRating("Rosalia","Very good!"));
        businessDemo.addReview(new StoreRating("Thodoris","Firstly I must mention to you that my friends and I, we like trying new cuisines & flavours, we go out for food at least twice a month and we usually don't pay over 20-25e per person. I must also declare to you that we don't have strange willing on food.\n" +
                "\n" +
                "We decided to go to this restaurant as we wanted to eat traditional greek cuisine and we read for this place in Athinorama Magazine (a kind of guide magazine published every week for Athens city)."));
        businessDemo.addReview(new StoreRating("Georgia","The restaurant is beautiful, the staff was very nice, but the food was just OK... we went for the 4 course menu and the dishes were mediocre.. while we did specify ahead all dietary restrictions (pregnant) I was accepting the kitchen to make adjustments- meaning, to make something accordingly...but they just gave us both the same dished at took out many elements from the dish.\n" +
                "I also took the wine route and the wine selection was meh.... I didn't come for a Michelin restaurant to get a 20 euro small glass of Riesling.."));
        businessDemo.addReview(new StoreRating("Eren",""));




        for(int i = 0; i < 25; i++){
            businessDemo.getStorage().getStorage().add(new Item());
        }

        //Waiters
        Worker waiter = new Waiter("Bob");
        Worker waiter1 = new Waiter("John");
        Worker waiter2 = new Waiter("Kevin");




        //Owner
       // Person owner = new Owner("Alice");

        businessDemo.getWorkers().add(waiter);
        businessDemo.getWorkers().add(waiter1);
        businessDemo.getWorkers().add(waiter2);

        //Customers
        Customer customer = new Customer("Dany");
        Customer customer1 = new Customer("Robert");
        Customer customer2 = new Customer("David");
        Customer customer3 = new Customer("John");
        Customer customer4 = new Customer("Michael");
        Customer customer5 = new Customer("William");
        Customer customer6 = new Customer("Richard");
        Customer customer7 = new Customer("Joseph");
        Customer customer8 = new Customer("Thomas");
        Customer customer9 = new Customer("Charles");
        Customer customer10 = new Customer("Christopher");
        Customer customer11 = new Customer("Daniel");
        Customer customer12 = new Customer("Matthew");
        Customer customer13 = new Customer("Anthony");
        Customer customer14 = new Customer("Mark");
        Customer customer15 = new Customer("Donald");
        Customer customer16 = new Customer("Steven");
        Customer customer17 = new Customer("Paul");

        //Timetable and events
        Timetable timetable = new Timetable();


        business.timetable.Event event = new business.timetable.Event(waiter, "Dishes", "Monday", "08-09", "8");
        business.timetable.Event event1 = new business.timetable.Event(waiter1, "Phone orders", "Sunday", "11-12", "6");
        business.timetable.Event event2 = new business.timetable.Event(waiter1, "Table orders", "Friday", "00-01", "8");
        business.timetable.Event event3 = new business.timetable.Event(waiter2, "Cleaning", "Saturday", "11-12", "4");
        business.timetable.Event event4 = new business.timetable.Event(waiter2, "Kitchen", "Tuesday", "00-01", "7");
        business.timetable.Event event5 = new Event(waiter, "Phone orders", "Thursday", "11-12", "8");

        timetable.createEvent(event);
        timetable.createEvent(event1);
        timetable.createEvent(event2);
        timetable.createEvent(event3);
        timetable.createEvent(event4);
        timetable.createEvent(event5);
        Objection objection = new Objection(event2, "I am unavailable after 4");
        Objection objection1 = new Objection(event4, "I'll be there by 10:10");

        timetable.getObjections().add(objection);
        timetable.getObjections().add(objection1);

        businessDemo.setTimetable(timetable);

        Order order = new Order();
        //Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        Transaction transaction = new Transaction("Incoming", 58.67);
        Transaction transaction1 = new Transaction("Outgoing", 538.67);
        Transaction transaction2 = new Transaction("Outgoing", 158.32);
        Transaction transaction3 = new Transaction("Incoming", 358.67);
        Transaction transaction4 = new Transaction("Incoming", 584.44);
        Transaction transaction5 = new Transaction("Outgoing", 586.67);
        Transaction transaction6 = new Transaction("Incoming", 558.60);
        Transaction transaction7 = new Transaction("Incoming", 258.67);
        Transaction transaction8 = new Transaction("Outgoing", 58.45);
        Transaction transaction9 = new Transaction("Incoming", 58.36);

        businessDemo.getLogistics().getTransactions().add(transaction);
        businessDemo.getLogistics().getTransactions().add(transaction1);
        businessDemo.getLogistics().getTransactions().add(transaction2);
        businessDemo.getLogistics().getTransactions().add(transaction3);
        businessDemo.getLogistics().getTransactions().add(transaction4);
        businessDemo.getLogistics().getTransactions().add(transaction5);
        businessDemo.getLogistics().getTransactions().add(transaction6);
        businessDemo.getLogistics().getTransactions().add(transaction7);
        businessDemo.getLogistics().getTransactions().add(transaction8);
        businessDemo.getLogistics().getTransactions().add(transaction9);





        Subscription subscription =new Subscription(customer1,order,"Daily");
        Subscription subscription1 =new Subscription(customer2,order2,"Daily");
        Subscription subscription2 =new Subscription(customer3,order4,"Daily");

        businessDemo.getSubscriptionList().add(subscription);
        businessDemo.getSubscriptionList().add(subscription1);
        businessDemo.getSubscriptionList().add(subscription2);




        LocalDateTime dateTime = LocalDateTime.parse("2017-04-12T14:45:36");
        LocalDateTime dateTime1 = LocalDateTime.parse("2008-09-05T08:12:24");
        LocalDateTime dateTime2 = LocalDateTime.parse("2011-12-16T11:32:48");
        LocalDateTime dateTime3 = LocalDateTime.parse("2004-06-20T23:50:52");
        LocalDateTime dateTime4 = LocalDateTime.parse("2015-02-08T05:25:09");
        LocalDateTime dateTime5 = LocalDateTime.parse("2001-11-03T15:30:43");
        LocalDateTime dateTime6 = LocalDateTime.parse("2002-01-24T19:05:14");
        LocalDateTime dateTime7 = LocalDateTime.parse("2013-07-27T06:41:37");

        CheckInOutEvent checkInOutEvent = new CheckInOutEvent("CheckIn", dateTime);
        CheckInOutEvent checkInOutEvent1 = new CheckInOutEvent("CheckIn", dateTime1);
        CheckInOutEvent checkInOutEvent2 = new CheckInOutEvent("CheckOut", dateTime2);
        CheckInOutEvent checkInOutEvent3 = new CheckInOutEvent("CheckIn", dateTime3);
        CheckInOutEvent checkInOutEvent4 = new CheckInOutEvent("CheckOut", dateTime4);
        CheckInOutEvent checkInOutEvent5 = new CheckInOutEvent("CheckIn", dateTime5);
        CheckInOutEvent checkInOutEvent6 = new CheckInOutEvent("CheckOut", dateTime6);
        CheckInOutEvent checkInOutEvent7 = new CheckInOutEvent("CheckIn", dateTime7);

        waiter.getWorkerTimeLog().add(checkInOutEvent);
        waiter1.getWorkerTimeLog().add(checkInOutEvent1);
        waiter2.getWorkerTimeLog().add(checkInOutEvent2);
        waiter.getWorkerTimeLog().add(checkInOutEvent);
        waiter1.getWorkerTimeLog().add(checkInOutEvent3);
        waiter.getWorkerTimeLog().add(checkInOutEvent4);
        waiter1.getWorkerTimeLog().add(checkInOutEvent5);
        waiter2.getWorkerTimeLog().add(checkInOutEvent6);
        waiter.getWorkerTimeLog().add(checkInOutEvent7);
        waiter2.getWorkerTimeLog().add(checkInOutEvent3);







        Point location = new Point(0, 0);

        Table tableA1 = new Table();
        System.out.println(tableA1.getTableId());
        Table tableA2 = new Table();
        Table tableA3 = new Table();
        Table tableA4 = new Table();
        Table tableA5 = new Table();
        Table tableA6 = new Table();
        businessDemo.addTable(tableA1);
        businessDemo.addTable(tableA2);
        businessDemo.addTable(tableA3);
        businessDemo.addTable(tableA4);
        businessDemo.addTable(tableA5);
        businessDemo.addTable(tableA6);

        Dish dish1 = new Dish("Pizza");
        Dish dish2 = new Dish("Burger");
        Dish dish3 = new Dish("Salad");
        dish1.setPrice(9);
        dish2.setPrice(8);
        dish3.setPrice(7);
        // Create some orders
        Order order1 = new Order();
        order1.setTableId(tableA1.getTableId());
        order1.addToOrder(dish1);
        order1.addToOrder(dish2);
        businessDemo.addOrder(order1);
        businessDemo.getOrderHistory().addOrder(order1);
        LocalDate date = LocalDate.of(2024, 5, 11);
        LocalTime startTime = LocalTime.of(15, 0); // 3:00 PM
        LocalTime endTime = LocalTime.of(23, 0);

        Reservation reservation1 = new Reservation(businessDemo, customer.getID(), date, startTime, endTime, 11, tableA1.getTableId());
        businessDemo.addReservation(reservation1);



        JButton ownerButton = new JButton("Owner");
        ownerButton.setPreferredSize(new Dimension(100, 100));
        ownerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ownerButton.setBackground(Color.BLUE);
        ownerButton.setForeground(Color.WHITE);
        ownerButton.addActionListener(e -> {
           Owner owner = new Owner("Name");//todo add a name
            owner.setBusiness(businessDemo);
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
            worker.setBusiness(businessDemo);

           Order orderT = new Order();
            Dish dish = new Dish("Παπια με τηγανητο ρυζι");
            dish.setQuantity(10);
            orderT.addToOrder(dish);
            orderT.addToOrder(new Dish("Παγωτο Βανιλια"));
            worker.addToTaskList(orderT);

            new DashboardUI(worker,worker.getBusiness(),app,new Point(200,100));
            dispose();
        });
        JButton customerButton = new JButton("Customer");
        customerButton.setPreferredSize(new Dimension(100, 100));
        customerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerButton.setBackground(Color.BLUE);
        customerButton.setForeground(Color.WHITE);
        customerButton.addActionListener(e -> {



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