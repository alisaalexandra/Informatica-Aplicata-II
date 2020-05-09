package applications.anotherstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashRegister {
    private int currentReceiptNumber = 0;
    private List<Receipt> receipts = new ArrayList<>();
    private List<StockItem> stocktItems = new ArrayList<>();
    private String storeName;
    private String fiscalIdentifier;
    private Receipt newReceipt = null;
    private boolean ok = false;

    public List<StockItem> getStocktItems() {
        return stocktItems;
    }

    public void setStocktItems(List<StockItem> stocktItems) {
        this.stocktItems = stocktItems;
    }

    public int getCurrentReceiptNumber() {
        return currentReceiptNumber;
    }

    public void setCurrentReceiptNumber(int currentReceiptNumber) {
        this.currentReceiptNumber = currentReceiptNumber;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public void startNewSell() {
        if (!ok) {
            newReceipt = new Receipt();
            currentReceiptNumber = currentReceiptNumber + 1;
            newReceipt.setReceiptNumber(currentReceiptNumber);
            ok = true;
        }
    }

    public void registerNewProduct(Product newProduct, int quantity) {
        if (ok) {
            for (StockItem si : stocktItems) {
                if (si.getProduct().getName().equalsIgnoreCase(newProduct.getName()) && si.getQuantity() >= quantity) {
                    ReceiptItem receiptItem = new ReceiptItem(si.getProduct().getName(), quantity, si.getProduct().getPrice());
                    newReceipt.addReceiptItem(receiptItem);
                    break;
                }
            }
        }
    }

    public void finalizeSell() {
        if (ok) {
            System.out.println("Receipt no." + newReceipt.getReceiptNumber());
            System.out.println("---------------------");
            for (ReceiptItem ri : newReceipt.getReceiptItems()) {
                System.out.println(ri.getProductName() + "    " + ri.getPricePerUnit() + "X" + ri.getQuantity() + " BUC   " + newReceipt.getTotalForProduct(ri) + " RON");
            }
            System.out.println("---------------------");
            System.out.println("TOTAL: " + newReceipt.getTotal() + " RON");
            System.out.println("Have a nice day!");
            System.out.println("");
            receipts.add(newReceipt);
            newReceipt = null;
        }
        ok = false;
    }


    public void removeProductFromSell(Product product, int quantity) {
        if (ok = true) {
            for (ReceiptItem ri : newReceipt.getReceiptItems()) {
                if (ri.getProductName().equalsIgnoreCase(product.getName()) && quantity >= ri.getQuantity()) {
                    newReceipt.getReceiptItems().remove(ri);
                    break;
                } else if (ri.getProductName().equalsIgnoreCase(product.getName()) && quantity < ri.getQuantity()) {
                    ri.setQuantity(ri.getQuantity() - quantity);
                    break;
                }

            }
        }
    }

    public void viewCurrentSell() {
        if (ok == true) {
            System.out.println("Here are your receipt items, sir. . . ");
            System.out.println("-------------------------");
            for (ReceiptItem ri : newReceipt.getReceiptItems()) {
                System.out.println(ri.getProductName() + "      " + ri.getPricePerUnit() + "X" + ri.getQuantity() + " BUC     " + newReceipt.getTotalForProduct(ri) + " RON");
            }
            System.out.println("-------------------------");
        } else
            System.out.println("You didn't buy anything!");
    }
}