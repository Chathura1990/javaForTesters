package by.itsm;

import by.itsm.task2and3.Point;

public class JavaForTesters {

    public static void main(String[] args) {
        //Home task1
        System.out.println("Hello world!");
        //Home task 2 and 3
        Point p = new Point(3,4,8,9);
        System.out.println("Distance Between two points: x1:"+p.x1+", y1:"+p.y2+ ", x2:"+p.x2+", y2:"+p.y2+" = " + p.distance(p,p));
    }
}