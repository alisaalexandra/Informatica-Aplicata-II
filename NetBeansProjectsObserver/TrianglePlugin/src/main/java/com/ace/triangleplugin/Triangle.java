
package com.ace.triangleplugin;

import com.ace.draw.Sketch;
import com.ace.pluginfill.interfaces.IShape;
import com.ace.pluginfill.interfaces.ISubject;
import java.awt.Point;
import java.util.Scanner;

public class Triangle implements IShape{
    private Scanner input = new Scanner(System.in);
    private Point A;
    private Point B;
    private Point C;
    private String name;

    public Triangle(){}
    
    public Triangle(Point p1, Point p2,Point p3) {
        this.A = new Point(p1.x, p1.y);
        this.B = new Point(p2.x, p2.y);
        this.C = new Point(p3.x, p3.y);
        this.name = "Triangle";
    }

    @Override
    public void getCoordinates() {
        System.out.print("Coordinates: P1(" + (int)this.A.getX() + " , " + (int)this.A.getY() + "), "
                + "P2(" + (int)this.B.getX() + " , " + (int)this.B.getY() + ")" + 
        "P3(" + (int)this.C.getX() + " , " + (int)this.C.getY() + ")");
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
        int l = (int)(A.getY()-A.getY());
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        //System.out.println("\nArea: " + 3*l  );
        System.out.println();
    }

    @Override
    public void read() {
        this.name="Triangle";
        System.out.println("Enter A, B, C coordinates.");
        this.A = new Point(input.nextInt(), input.nextInt());
        this.B = new Point(input.nextInt(), input.nextInt());
        this.C = new Point(input.nextInt(), input.nextInt());
    }

    @Override
    public Point highestPoint() {
        return new Point(A.x,C.y);
    }    

}