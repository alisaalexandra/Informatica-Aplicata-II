
package com.ace.draw;

import com.ace.exceptions.PositionNotFoundException;
import com.ace.pluginfill.interfaces.IObserver;
import com.ace.pluginfill.interfaces.IShape;
import java.awt.Canvas;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sketch implements IObserver{
    private IShape shape;
    private Point highestPoint = new Point(10,10);
    private ArrayList<IShape> components = new ArrayList<>();

    public List<IShape> getShapeList() {
        return components;
    }
    
    public void add(){
            shape.read();
            components.add(shape);
            update();
            shape.print();
    }
    
    public void setShape(IShape shape){
        this.shape = shape;
    }
    
    public void print() {
        System.out.println("Canvas dimension: "
                + "\nlowest point (0,0)"
                + "\nhighest point (" + highestPoint.x + "," + highestPoint.y + ")");
        for (int i = 0; i < components.size(); i++) {
            System.out.print((i + 1) + ". ");
            components.get(i).getDetails();
        }
    }

    public void delete(int position) throws PositionNotFoundException {
       if(validatePosition(position)){
           for (int i = 0; i < components.size(); i++) {
            if (position == i) {
                components.remove(i);
            }
        }
        }else
            throw new PositionNotFoundException();
    }
        

    public void modifyShape(int position) throws PositionNotFoundException {
        if(validatePosition(position)){
            components.get(position).read();
        }else
            throw new PositionNotFoundException();
    }
    
    public boolean validatePosition(int position){
        position = position - 1;
        if(position > 0  &&  position <= components.size()){
            return true;
        }
        else
            return false;
    }
    
    public Point getPoint(){
        return highestPoint;
    }
    
    public void setPoint(Point point){
        this.highestPoint = point;
    }
    public void setSize(List<IShape> shapes){
        for ( int i=0; i< shapes.size() ; i++){
            if((shapes.get(i).highestPoint().x > this.highestPoint.x ) || (shapes.get(i).highestPoint().y > this.highestPoint.y ) ){
               this.highestPoint.x=shapes.get(i).highestPoint().x;
               this.highestPoint.y=shapes.get(i).highestPoint().y;

            }
        }
    }
    
    @Override
    public void update() {
        setSize(components);
    }
}

