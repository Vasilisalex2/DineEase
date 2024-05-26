package business;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class StoreRating {
    private String customerName;
    private String review;
    public StoreRating(String customerName, String review) {
        this.customerName = customerName;
        this.review = review;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getReview() {
        return review;
    }
  
}
