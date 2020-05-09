package applications.anotherstore;

import java.util.List;
import java.util.Scanner;

public class Administrator implements Menu<Store, Administrator, Seller, CashRegister, Stock> {
    private EmployeeInfo employeeInfo;
    Scanner input = new Scanner(System.in);

    public Administrator(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Administrator() {
    }

    public void addProductsToStock(Product product, int quantity, Stock stock) {
        boolean ok= false;
        for (StockItem si : stock.getStockItems()) {
            if (si.getProduct().getName().equalsIgnoreCase(product.getName())) {
                si.setQuantity(si.getQuantity() + quantity);
                ok=true;
            }
            }
        if(!ok){
            StockItem newStockItem = new StockItem(product, quantity);
            stock.add(newStockItem);
        }
    }

    public boolean checkProductStock(Product product, Stock stock) {
        for (int i = 0; i < stock.getStockItems().size(); i++) {
            StockItem key = stock.getStockItems().get(i);
            if (product.getName().equalsIgnoreCase(key.getProduct().getName())) {
                System.out.println(key.getProduct().getName() + " -> " + key.getQuantity());
                return true;
            }
        }
        return false;
    }

    public void removeProductsFromStock(List<Product> products, Stock stock) {
        for (Product p : products) {
            for (int i = 0; i < stock.getStockItems().size(); i++) {
                StockItem key = stock.getStockItems().get(i);
                if (key.getProduct().getName().equals(p.getName())) {
                    stock.remove(key);
                }
            }
        }
    }

    public void removeProductFromStock(Product product, int quantity, Stock stock) {
        StockItem newStockItem = new StockItem(product, quantity);
        stock.remove(newStockItem);
    }

    public void viewStock(Stock stock) {
        for (StockItem si: stock.getStockItems()) {
            System.out.println("Product: " + si.getProduct().getName() +
                    "      quantity: " + si.getQuantity());
        }
    }

    @Override
    public void menu(Store store, Administrator administrator, Seller seller, CashRegister cashRegister, Stock stock) {
        int choice = 1;
        while (choice >= 0 && choice <= 3) {
            adminOptions();
            choice = input.nextInt();
            if (choice == 1) {
                while (choice >= 0 && choice <= 3) {
                    //1.Stock
                    adminStockOptions();
                    choice = input.nextInt();
                    if (choice == 0) {
                        //0.Back to administrator menu
                        administrator.menu(store, administrator, seller, cashRegister, stock);
                    } else if (choice == 1) {
                        //1.Add product
                        input.nextLine();
                        Product newProduct = new Product();
                        System.out.println("Enter product's name . . .");
                        newProduct.setName(input.nextLine());
                        System.out.println("Description?");
                        newProduct.setDescription(input.nextLine());
                        System.out.println("Price?");
                        newProduct.setPrice(input.nextDouble());
                        System.out.println("Quantity? ");
                        administrator.addProductsToStock(newProduct, input.nextInt(), stock);
                    } else if (choice == 2) {
                        //2.Remove product
                        input.nextLine();
                        Product newProduct = new Product();
                        System.out.println("Enter product's name . . .");
                        newProduct.setName(input.nextLine());
                        System.out.println("Quantity?");
                        administrator.removeProductFromStock(newProduct, input.nextInt(), stock);
                    } else if (choice == 3) {
                        //3.View stock
                        viewStock(stock);
                    }
                }
            } else if (choice == 2) {
                while (choice >= 0 && choice <= 3) {
                    administrator.adminCashRegisterOptions();
                    choice = input.nextInt();
                    if (choice == 0) {
                        //0.Back to administrator menu
                        administrator.menu(store, administrator, seller, cashRegister, stock);
                    } else if (choice == 1) {
                        //1.Add cash register
                        System.out.println("Adding new cash register...");
                        store.addNewCashRegister();
                    } else if (choice == 2) {
                        //2.Remove cash register
                        System.out.println("Removing cash register...");
                        store.getCashRegisters().remove(cashRegister);
                    } else if (choice == 3) {
                        //3.View cash registers
                        for (int i = 0; i < store.getCashRegisters().size(); i++) {
                            System.out.println("Cash register no." + (i + 1) + " : current receipt number :" + store.getCashRegisters().get(i).getCurrentReceiptNumber());
                        }
                    }
                }
            } else if (choice == 0) {
                store.menu(store, administrator, seller, cashRegister, stock);
            }
        }
    }

    public void adminOptions() {
        System.out.println("0.Back.");
        System.out.println("1.Stock.");
        System.out.println("2.Cash Registers.");
        System.out.println("-------------------------");
    }

    public void adminStockOptions() {
        System.out.println("0.Back.");
        System.out.println("1.Add product.");
        System.out.println("2.Remove product.");
        System.out.println("3.View stock.");
        System.out.println("-------------------------");

    }

    public void adminCashRegisterOptions() {
        System.out.println("0.Back.");
        System.out.println("1.Add cash register.");
        System.out.println("2.Remove cash register.");
        System.out.println("3.View cash registers.");
        System.out.println("-------------------------");
    }
}


