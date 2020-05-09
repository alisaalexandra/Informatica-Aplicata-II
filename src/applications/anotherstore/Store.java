package applications.anotherstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store implements Menu<Store,Administrator,Seller,CashRegister,Stock> {
    private String description;
    private String name;
    private Stock stock;
    private List<CashRegister> cashRegisters = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();
    private List<Administrator> admins = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public Store( String name,String description,Stock stock) {
        this.description = description;
        this.name = name;
        this.stock=stock;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public void setAdmins(List<Administrator> admins) {
        this.admins = admins;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void addNewCashRegister() {
        CashRegister newCashRegister = new CashRegister();
            cashRegisters.add(newCashRegister);
    }
    public void addNewSeller() {
        Seller newSeller = new Seller();
        sellers.add(newSeller);
    }

    public void addNewAdministrator( ){
        Administrator newAdministrator = new Administrator();
        admins.add(newAdministrator);
    }

    @Override
    public void menu(Store store,Administrator administrator,Seller seller,CashRegister cashRegister,Stock stock) {
        System.out.println("0.Exit.");
        System.out.println("1.Use as Administrator.");
        System.out.println("2.Use as Seller.");
        System.out.println("-------------------------");
        int choice = input.nextInt();
        if(choice==1){
            //try{
            administrator.menu(store,administrator,seller,cashRegister,stock);
            //}catch (Exception e){
                System.out.println("There's no admin available.");
            //}
        }
        else if(choice==2) {
            //try {
                seller.menu(store,administrator,seller,cashRegister,stock);
           // } catch (Exception e) {
                System.out.println("There's no seller available.");
            //}
        }
        else if(choice==0){
            System.exit(0);
        }
    }

    public List<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(List<CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }
}

