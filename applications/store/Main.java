package applications.store;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 1;
        Data expirationDate = new Data(2020, 13, 9);
        Data productionDate = new Data(2020, 27, 1);

        Employee employee = new Employee("A", 1);

        Product milk = new Product("Milk", 7.3, "oat milk", productionDate, expirationDate);
        Product cupcakes = new Product("Cupcakes", 10, "homemade cupcakes", productionDate, expirationDate);
        Product smoothie = new Product("Smoothie", 9, "healty smoothie", productionDate, expirationDate);
        Product coffee = new Product("Coffee", 4, "coffee with milk", productionDate, expirationDate);

        employee.addProductInStore(milk, 25);
        employee.addProductInStore(cupcakes, 10);
        employee.addProductInStore(smoothie, 7);

        System.out.println("           Welcome to our store!\n");
        while (option != 0) {
            System.out.println("What are you looking for?\n");
            System.out.println("1.Something to eat or drink. . . \n2.Find a certain product. . .\n3.Get receipt. . .");
            option = input.nextInt();
            if (option == 1) {
                System.out.println("All we have is: ");
                System.out.println("  -   1. Milk (" + milk.getDescription() + ") price : " + milk.getPrice() +
                        "\n  -   2. Cupcakes (" + cupcakes.getDescription() + ") price : " + cupcakes.getPrice() +
                        "\n  -   3. Smoothie (" + smoothie.getDescription() + ") price : " + smoothie.getPrice() +
                        "\n  -   4. Coffee (" + coffee.getDescription() + ") price : " + coffee.getPrice());
                System.out.println("In order to buy something, you have to enter a number from 1 - 4,\n" +
                        " otherwise nothing will happen.");
                option = input.nextInt();
                if (option == 1) {
                    System.out.println("How many would you like to buy?");
                    employee.buyProduct("milk", input.nextInt());
                } else if (option == 2) {
                    System.out.println("How many would you like to buy?");
                    employee.buyProduct("cupcakes", input.nextInt());
                } else if (option == 3) {
                    System.out.println("How many would you like to buy?");
                    employee.buyProduct("smoothie", input.nextInt());
                } else if (option == 4) {
                    System.out.println("How many would you like to buy?");
                    employee.buyProduct("coffee", input.nextInt());
                }
            } else if (option == 2) {
                String product = input.nextLine();
                employee.findProduct(product);
            } else if (option == 3) {
                System.out.println("  -  Here's your receipt!");
                employee.getReceipt();
                System.exit(0);
            }
        }
    }
}
