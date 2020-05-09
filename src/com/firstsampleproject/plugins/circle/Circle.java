package com.firstsampleproject.plugins.circle;

import com.firstsampleproject.Shape;
import com.firstsampleproject.Strategy;

import java.awt.*;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Circle implements com.firstsampleproject.Shape, Strategy {
    private Scanner input = new Scanner(System.in);
    private int radius;
    private Point point;
    private String name;

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
                        "\nArea: " + (int)round(area,2) +
                "\nPerimeter: " +(int) round(2 * 3.14 * radius,2));
        System.out.println();

    }

    @Override
    public void readShape() {
        System.out.println("Enter point coordinates.");
        Point p = new Point(input.nextInt(), input.nextInt());
        System.out.println("Enter radius.");
        int radius = input.nextInt();
        Shape circle = new Circle(p, radius);
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
