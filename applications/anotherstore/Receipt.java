package applications.anotherstore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> receiptItems = new ArrayList<>();
    private double totalPrice;
    private int receiptNumber;

    public double getTotalForProduct(ReceiptItem receiptItem) {
        receiptItem.setTotalPrice(receiptItem.getPricePerUnit()*receiptItem.getQuantity());
        return receiptItem.getTotalPrice();
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void addReceiptItem(ReceiptItem receiptItem) {
        this.getReceiptItems().add(receiptItem);
    }

    public double getTotal() {
        for (ReceiptItem receiptItem : receiptItems) {
            {
                totalPrice = totalPrice + getTotalForProduct(receiptItem);
            }
        }
        return totalPrice;
    }

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }
}