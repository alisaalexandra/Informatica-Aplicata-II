package com.firstsampleproject;

import java.util.ArrayList;
import java.util.Scanner;

public class MyFirstApp {
    private static Scanner input = new Scanner(System.in);
    private static Sketch sketch = new Sketch();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Menu mainMenu = initializeMainMenu();
        mainMenu.execute();

    }

    private static Menu initializeMainMenu() {
        ArrayList<IMenuItem> mainMenuItems = new ArrayList();
        ArrayList<IMenuItem> addShapeItems = new ArrayList();

        addShapeItems.add(new MenuItem("Circle",
                1,
                (parameters) -> {
                    sketch.addCircle();
                }));

        addShapeItems.add(new MenuItem("Square",
                2,
                (parameters) -> {
                    sketch.addSquare();
                }));

        mainMenuItems.add(new Menu("Add shape", 1, addShapeItems));

        mainMenuItems.add(new MenuItem("Delete shape",
                2,
                (parameters) -> {
                    if (sketch.getShapeList().size() > 0) {
                        sketch.print();
                        System.out.println("Input a number.");
                        sketch.delete(input.nextInt());
                    } else
                        System.out.println("You must add shapes to the sketch in order to delete one...");
                }));
        mainMenuItems.add(new MenuItem("Modify shape",
                3,
                (parameters) -> {
                    if (sketch.getShapeList().size() > 0) {
                        sketch.print();
                        System.out.println("Input a number.");
                        sketch.modifyShape(input.nextInt());
                    } else
                        System.out.println("You must add shapes to the sketch in order to modify one...");
                }));
        mainMenuItems.add(new MenuItem("Print sketch",
                4,
                (parameters) -> {
                    sketch.print();
                }));

        return new Menu("Main Menu", 0, mainMenuItems);
    }

}