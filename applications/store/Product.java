package applications.store;

public class Product {
    private String name;
    private double price;
    private Stock stock;
    private String description;
    private Data expirationDate;
    private Data productionDate;

    public Product(String name, double price, String description, Data expirationDate, Data productionDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
