package by.itsm;

import by.itsm.task2and3.Point;

public class JavaForTesters {

    public static void main(String[] args) {
        //Home task1
        System.out.println("Hello world!");
        //Home task 2 and 3
        Point p1 = new Point(3.0, 6.0);
        Point p2 = new Point(4.0, 5.0);
        System.out.println("Distance Between two points: point1.x: "+p1.x+", point1.y: "+p1.y +", point2.x: "+p2.x+", point2.y: "+p2.y +" = " + p1.distance(p2));
    }
}