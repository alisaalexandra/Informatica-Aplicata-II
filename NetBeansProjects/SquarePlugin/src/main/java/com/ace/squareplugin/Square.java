/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.squareplugin;

import com.ace.pluginfill.interfaces.IShape;
import com.ace.pluginfill.interfaces.IStrategy;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Square implements IShape, IStrategy{
    private Scanner input = new Scanner(System.in);
    private Point upperLeft;
    private Point lowerRight;
    private String name;

    public Square(){}
    
    public Square(Point p1, Point p2) {
        this.upperLeft = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
        this.lowerRight = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
        this.name = "Square";
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
        System.out.println("Square added.");
    }

    @Override
    public void getDetails() {
        int l = (int)(upperLeft.getY()-lowerRight.getY());
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        System.out.println("\nArea: " + (int)2*l + "\nPerimeter: " + (int)4*l );
        System.out.println();
    }

    @Override
    public void read() {
        this.name="Square";
        System.out.println("Enter P1, P2 coordinates.");
        this.upperLeft = new Point(input.nextInt(), input.nextInt());
        this.lowerRight= new Point(input.nextInt(), input.nextInt());
    }   
}
