package business.management;

import business.ordering.Order;
import business.ordering.OrderHistory;
import business.ordering.Dish;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to calculate statistics for orders
 *
 * @author NIKOS
 * @version 1.0
 */

public class OrderStatistics {

    public Map<Integer,Long> calculateOrderTimes(OrderHistory orderHistory) {
        Map times = new HashMap();
        for (Order order : orderHistory.getOrders()) {
            times.put(order.getId(),order.getOrderTotalTime());
        }
        return times;
    }
    public Map<Integer,Integer> calculateOrderPopularity(OrderHistory orderHistory) {
        Map<Integer,Integer> popularity = new HashMap();
        for (Order order : orderHistory.getOrders()) {
            //getOrder = get Dishes
            for (Dish dish : order.getOrder()) {
                //Iterate through each dish and increment its value on the map by one for each occurrence
                popularity.put(dish.getId(), popularity.getOrDefault(dish.getId(), 0) + 1);
            }
        }
        return popularity;
    }

}
