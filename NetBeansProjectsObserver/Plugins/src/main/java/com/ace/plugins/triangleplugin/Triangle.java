package com.ace.plugins.triangleplugin;

import com.ace.pluginfill.interfaces.IShape;
import java.awt.Point;
import java.util.Scanner;

public class Triangle implements IShape{
    private Scanner input = new Scanner(System.in);
    private Point upperLeft;
    private Point lowerRight;
    private String name;

    public Triangle(){}
    
    public Triangle(Point p1, Point p2) {
        this.upperLeft = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
        this.lowerRight = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
        this.name = "Triangle";
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public Point getLowerRight() {
        return lowerRight;
    }

    @Override
    public void getCoordinates() {
        System.out.print("Coordinates: P1(" + (int)this.upperLeft.getX() + " , " + (int)this.upperLeft.getY() + "), P2(" + (int)this.lowerRight.getX() + " , " + (int)this.lowerRight.getY() + ")");
    }

    @Override
    public String shapeName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println("Triangle added.");
    }

    @Override
    public void getDetails() {
        int l = (int)(upperLeft.getY()-lowerRight.getY());
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        System.out.println("\nArea: " + 3*l  );
        System.out.println();
    }

    @Override
    public void read() {
        this.name="Triangle";
        System.out.println("Enter P1, P2 coordinates.");
        this.upperLeft = new Point(input.nextInt(), input.nextInt());
        this.lowerRight = new Point(input.nextInt(), input.nextInt());
    }
    
}
    
