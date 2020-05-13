package applications.anotherstore;

public interface Menu<Store,Administrator,Seller,CashRegister,Stock> {
    void menu(Store store,Administrator administrator,Seller seller,CashRegister cashRegister,Stock stock);
}
