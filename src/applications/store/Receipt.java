package applications.store;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    double total;
    int number = 0;
    Map<Product, Integer> productList = new HashMap<>();


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        this.setNumber(this.number + 1);
        System.out.println("                   Receipt nr. " + this.getNumber());
        System.out.println("---------------");
        System.out.println("Products bought: ");
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            Product key = entry.getKey();
            int value = entry.getValue();
            System.out.println(value + "X " + key.getName() + "     " + key.getPrice() + " RON " + key.getPrice() + "X" + value + "  " + key.getPrice() * value);
            total = total + key.getPrice() * value;
        }
        this.setTotal(total);
        System.out.println("                   TOTAL: " + this.getTotal() + " RON");
        System.out.println("                   Have a nice day!");


    }
}
