import business.Business;
import business.ordering.Dish;
import business.ordering.Menu;
import business.ordering.Order;
import users.Customer;
import users.Person;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        int mode = 1;

        //download app f.e.
        DineEase app = new DineEase();
        //log in (as customer)
        Customer user = new Customer();
        app.addUser(user);
        //Επιλογη Καταστηματος
        if(mode == 1){
            //choose business
            Business cBusiness = app.getBusinesses().get(0);
            mode = 2;
            //Παραγγελια ή απλα Μενου
            if(mode == 2){
                //open Menu
                Menu cMenu = cBusiness.getMenu();
                for (Dish d : cMenu.getMenu()) {
                    System.out.println(d.getQuantity());
                }
                //choose Dish in Menu
                Dish cDish = cMenu.getMenu().get(0);
                //add Dish to Basket
                int quantity = 1;
                user.getBasket().addToBasket(cDish.clone(),quantity);
                for (Dish d : user.getBasket().getBasket()) {
                    System.out.println(d.getQuantity());
                }
                //Change Dish's quantity
                Dish uDish = user.getBasket().getBasket().get(0);
                int newQuantity = 10;
                uDish.setQuantity(newQuantity);
                //remove Dish
                user.getBasket().removeFromBasket(uDish);
                //Order
                Order order = new Order();
                order.setOrder(user.getBasket().getBasket());
                cBusiness.addToTaskList(order);
                if(user.isCheckedIN()){

                }
                else{

                }

                //System.out.println(test3.getClass().getName());
                for (Dish d : user.getBasket().getBasket()) {
                    System.out.println(d.getQuantity());
                }
            }
            else if(mode == 20) {

            }
        }
        else if(mode ==10){

        }
    }

}