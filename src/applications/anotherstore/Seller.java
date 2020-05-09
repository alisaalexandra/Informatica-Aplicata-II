package applications.anotherstore;

import java.util.Scanner;

public class Seller implements Menu<Store, Administrator, Seller, CashRegister, Stock> {
    private EmployeeInfo employeeInfo;
    private CashRegister cashRegister = null;
    private Stock stock = null;
    private Store store = null;

    Scanner input = new Scanner(System.in);

    public Seller(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Seller() {
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public boolean checkProductStock(Product product) {
        for (StockItem si : stock.getStockItems()) {
            if (product.getName().equalsIgnoreCase(si.getProduct().getName())) {
                return true;
            }
        }
        return false;
    }

    public void returnProduct(Product product, int quantity) {
        if (checkProductStock(product)) {
            for (StockItem si : stock.getStockItems()) {
                if (si.getProduct().getName().equalsIgnoreCase(product.getName())) {
                    stock.updateProductQuantity(si, si.getQuantity() + quantity);
                    break;
                }
            }
        }
    }

    public void sell(Product product, int quantity) {
        for (StockItem si : stock.getStockItems()) {
            if (si.getProduct().getName().equalsIgnoreCase(product.getName()) && si.getQuantity() >= quantity) {
                StockItem newStockItem = new StockItem(si.getProduct(), quantity);
                stock.remove(newStockItem);
                cashRegister.registerNewProduct(si.getProduct(), quantity);
                break;
            }
        }
    }

    public void searchProduct(Product product) {
        if (checkProductStock(product)) {
            for (int i = 0; i < stock.getStockItems().size(); i++) {
                StockItem key = stock.getStockItems().get(i);
                if (key.getProduct().getName().equalsIgnoreCase(product.getName())) {
                    System.out.println(key.getProduct().getName() + " - quantity : " + key.getQuantity());
                    break;
                }
            }
        }
    }

    public void viewStock(Stock stock) {
        for (StockItem si : stock.getStockItems()) {
            System.out.println(si.getProduct().getName() + " - quantity: " + si.getQuantity());
        }
    }

    @Override
    public void menu(Store store, Administrator administrator, Seller seller, CashRegister cashRegister, Stock stock) {
        int option = 1;
        seller.setStore(store);
        cashRegister.setStocktItems(stock.getStockItems());
        while (option >= 0 && option <= 3) {
            sellerOptions();
            option = input.nextInt();
            if (option == 0) {
                store.menu(store, administrator, seller, cashRegister, stock);
            } else if (option == 1) {
                // Seller - Sell
                seller.setCashRegister(cashRegister);
                cashRegister.startNewSell();
                    while (option >= 0 && option <= 4) {
                        sellOptions();
                        option = input.nextInt();
                        if (option == 0) {
                            //Back to seller menu
                            seller.menu(store, administrator, seller, cashRegister, stock);
                        } else if (option == 1) {
                            //1.Add product to sell
                            System.out.println("----------STOCK----------");
                            seller.viewStock(stock);
                            input.nextLine();

                            System.out.println("What product would you like to buy?" +
                                    "\nPlease, enter product's name.");
                            Product product = new Product();
                            product.setName(input.nextLine());
                            System.out.println("What quantity would you like to remove from sell?" +
                                    "\nPlease, enter a number.");
                            int quantity = input.nextInt();
                            seller.sell(product, quantity);
                        } else if (option == 2) {
                            //2.Remove product
                            input.nextLine();
                            System.out.println("What product would you like to remove from sell?" +
                                    "Please, enter product's name.");
                            Product product = new Product();
                            product.setName(input.nextLine());
                            System.out.println("What quantity would you like to remove from sell?" +
                                    "\nPlease, enter a number.");
                            int quantity = input.nextInt();
                            seller.cashRegister.removeProductFromSell(product, quantity);
                            seller.returnProduct(product, quantity);
                        } else if (option == 3) {
                            //3.View current sell
                            seller.cashRegister.viewCurrentSell();
                        } else if (option == 4) {
                            //4.Finalize Sell
                            System.out.println("-----------------");
                            System.out.println("I will give you the receipt, please wait a second.");
                            System.out.println("-----------------");
                            System.out.println("Here's your receipt, sir!");
                            seller.cashRegister.finalizeSell();
                        }
                    }
                }
            else if (option == 2) {
                //2.Search product
                input.nextLine();
                System.out.println("Can I help you? \nEnter product's name,please. ");
                Product product = new Product();
                product.setName(input.nextLine());
                System.out.println("Here's what I've found. . . ");
                seller.searchProduct(product);
            } else if (option == 3) {
                //3.View stock
                System.out.println("----------STOCK----------");
                seller.viewStock(stock);
            }
        }
    }

    public void sellerOptions() {
        System.out.println("0.Back.");
        System.out.println("1.Start sell");
        System.out.println("2.Search product");
        System.out.println("3.View stock.");
        System.out.println("-------------------------");
    }

    public void sellOptions() {
        System.out.println("0.Back.");
        System.out.println("1.Add product to sell.");
        System.out.println("2.Remove product.");
        System.out.println("3.View current sell.");
        System.out.println("4.Finalize sell.");
        System.out.println("-------------------------");

    }

}
