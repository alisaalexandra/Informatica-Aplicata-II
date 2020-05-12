package com.ace.circleplugin;

import com.ace.pluginfill.interfaces.IShape;
import com.ace.pluginfill.interfaces.IStrategy;

import java.awt.*;
import java.util.Scanner;


public class Circle implements IShape, IStrategy {
    private Scanner input = new Scanner(System.in);
    private int radius;
    private Point point;
    private String name;

    public Circle(){}
    public Circle(Point p, int radius) {
        this.point=p;
        this.radius=radius;
        this.name="Circle";
    }

    @Override
    public void getDetails() {
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        double area = Math.pow((3.14 * radius),2);
        System.out.println("\nRadius: " + this.getRadius() +
                        "\nArea: " + area +
                "\nPerimeter: " + (2 * 3.14 * radius));
        System.out.println();

    }

    @Override
    public void read() {
        this.name="Circle";
        System.out.println("Enter point coordinates.");
        this.point = new Point(input.nextInt(), input.nextInt());
        System.out.println("Enter radius.");
        this.radius = input.nextInt();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void getCoordinates() {
        System.out.print("Center point: " + "P( " + (int)this.point.getX() + " , " + (int)this.point.getX() + " )");
    }

    @Override
    public String shapeName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println("Circle added.");
    }
    
}
