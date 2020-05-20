package com.ace.pluginfill.interfaces;

import java.awt.Point;

public interface IShape{
   void getCoordinates();
   String shapeName();
   void getDetails();
   void read();
   void print();
   Point highestPoint();
}
