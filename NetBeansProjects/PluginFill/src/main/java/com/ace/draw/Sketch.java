
package com.ace.draw;

import com.ace.pluginfill.interfaces.IShape;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sketch {
    static Scanner input = new Scanner(System.in);
    private IShape shape;
    private ArrayList<IShape> components = new ArrayList<>();

    public List<IShape> getShapeList() {
        return components;
    }
    
    public void add(){
            shape.read();
            components.add(shape);
            shape.print();
    }
    
    public void setShape(IShape shape){
        this.shape = shape;
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
        if(components.get(position)!=null){
            components.get(position).read();
        }   
    }
    
}

