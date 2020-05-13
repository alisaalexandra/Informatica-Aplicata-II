package com.firstsampleproject;

import com.firstsampleproject.plugins.circle.Circle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sketch {
    static Scanner input = new Scanner(System.in);
    private Strategy strategy;
    private Shape shape;
    private List<Shape> components = new ArrayList<>();

    public List<Shape> getShapeList() {
        return components;
    }

    public void print() {
        for (int i = 0; i < components.size(); i++) {
            System.out.print((i + 1) + ". ");
            components.get(i).getDetails();
        }
    }

    public void delete(int position) {
        position = position - 1;
        for (int i = 0; i < components.size(); i++) {
            if (position == i) {
                components.remove(i);
            }
        }
    }

    public void modifyShape(int position) {
        position = position - 1;
        for (int i = 0; i < components.size(); i++) {
            if (position == i) {
                if (components.get(i).shapeName().equalsIgnoreCase("Square")) {
                    components.remove(i);
                    System.out.println("Enter new P1, P2 coordinates.");
                    Point p1 = new Point(input.nextInt(), input.nextInt());
                    Point p2 = new Point(input.nextInt(), input.nextInt());
                    Shape square = new Square(p1, p2);
                    components.add(i, square);
                    break;
                } else if (components.get(i).shapeName().equalsIgnoreCase("Circle")) {
                    components.remove(i);
                    System.out.println("Enter new point coordinates and radius");
                    Point p1 = new Point(input.nextInt(), input.nextInt());
                    int radius = input.nextInt();
                    Shape circle = new Circle(p1, radius);
                    components.add(i, circle);
                    break;
                }
            }
        }
    }

    public void printGeometricShape() {
        strategy.print();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void addShape(){
        components.add(shape);
        //setStrategy(new Square(p1, p2));
        this.printGeometricShape();
    }
}

