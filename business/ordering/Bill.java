package business.ordering;

public class Bill {
    private Order order;
    private double totalPrice = 0;
    private int tableId;
    public Bill(Order order, int tableId) {
        this.order = order;
        totalPrice = getTotalPrice();
     this.tableId = tableId;
    }

    public Order getOrder() {

        return order;
    }

    public double getTotalPrice() {
        return calculateTotalPrice();
    }

    private double calculateTotalPrice() {

        for (Dish dish : order.getOrder()) {
            totalPrice += dish.getPrice() * dish.getQuantity();
        }
        return totalPrice;
    }

    public String generateBillDetails() {
        // Παράγετε τις λεπτομέρειες του τιμολογίου χρησιμοποιώντας τα δεδομένα του τιμολογίου
        String billDetails = "Bill for Table ID: " + order.getTableId() + "\n" + "Order Items:\n";
        for (Dish dish : order.getOrder()) {
            double dishTotal = dish.getPrice() * dish.getQuantity();
            billDetails += dish.getName() + " - Quantity: " + dish.getQuantity()
                    + ", Price per unit: $" + dish.getPrice()
                    + ", Total: $" + dishTotal + "\n";
        }
        billDetails += "Total Price: $" + getTotalPrice() + "\n";
        return billDetails;
    }
    public int getTableId() {
        return tableId;
    }
}