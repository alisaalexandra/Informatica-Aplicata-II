package applications.anotherstore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Store store = new Store("NK","open 24/7",stock);
        EmployeeInfo employeeInfoAdmin = new EmployeeInfo("Paul","08754631","Str. A");
        EmployeeInfo employeeInfoSeller1 = new EmployeeInfo("Mike","08754631","Str. A");
        EmployeeInfo employeeInfoSeller2 = new EmployeeInfo("Chloe","08754631","Str. A");



        Product smoothie = new Product("Smoothie","A delicious smoothie",7.20);
        Product milk = new Product("Milk","oat milk", 10);
        Product cupcakes = new Product("Cupcakes","homemade cupcakes",15.10);
        Product coffee = new Product("Coffee", "coffee with milk",9.35);

        Administrator admin = new Administrator(employeeInfoAdmin);
        store.setStock(stock);
        admin.addProductsToStock(smoothie,10,stock);
        admin.addProductsToStock(milk,25,stock);
        admin.addProductsToStock(cupcakes,20,stock);
        admin.addProductsToStock(coffee,13,stock);

        Seller seller1 = new Seller(employeeInfoSeller1);
        Seller seller2 = new Seller(employeeInfoSeller2);
        CashRegister cashRegister = new CashRegister();
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(admin);
        List<Seller> sellers = new ArrayList<>();
        seller1.setStock(stock);
        seller2.setStock(stock);
        sellers.add(seller1);
        sellers.add(seller2);
        List<CashRegister> cashRegisters = new ArrayList<>();
        cashRegisters.add(cashRegister);
        store.setAdmins(administrators);
        store.setSellers(sellers);
        store.setCashRegisters(cashRegisters);

        try{
            System.out.println("Welcome to NK!");
            store.menu(store,admin,seller1,cashRegister,stock);
        }catch(Exception e){
            System.out.println("Due to COVID-19, the store has been closed.");
            }
    }
}
