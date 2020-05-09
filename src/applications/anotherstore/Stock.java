package applications.anotherstore;

import java.math.BigDecimal;
import java.util.*;

public class Stock {
    private List<StockItem> stockItemList = new ArrayList<>();

    public void add(StockItem stockItem) {
        boolean ok = false;
        for (StockItem si : stockItemList) {
            if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName())) {
                ok = true;
                si.setQuantity(si.getQuantity() + stockItem.getQuantity());
                break;
            }
        }
        if (!ok) {
            stockItemList.add(stockItem);
        }
    }

    public void updateProductQuantity(StockItem stockItem, int newQuantity) {
        for (StockItem si : this.getStockItems()) {
            if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName())) {
                si.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void remove(StockItem stockItem) {
        for (StockItem si : this.getStockItems()) {
            if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName()) && si.getQuantity() > stockItem.getQuantity()) {
                updateProductQuantity(si, si.getQuantity() - stockItem.getQuantity());
                break;
            } else if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName()) && si.getQuantity() == stockItem.getQuantity()) {
                this.getStockItems().remove(si);
                break;
            } else if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName()) && si.getQuantity() < stockItem.getQuantity()) {
                break;
            }
        }
    }

    public void updateProductPrice(StockItem stockItem, double price) {
        for (StockItem si : this.getStockItems()) {
            if (si.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName())) {
                si.getProduct().setPrice(price);
                break;
            }
        }
    }

    public List<StockItem> getStockItems() {
        return stockItemList;
    }
}