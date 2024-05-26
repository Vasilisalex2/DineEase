package business.ordering;

import java.util.ArrayList;

public class Bills {
    private ArrayList<Bill> bills;

    public Bills() {
        this.bills = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    // Άλλες μέθοδοι για τη διαχείριση των τιμολογίων μπορούν να προστεθούν εδώ
}