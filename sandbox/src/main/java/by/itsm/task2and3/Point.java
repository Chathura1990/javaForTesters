package by.itsm.task2and3;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double distance(Point p1) {
        return Math.sqrt(Math.pow(p1.x-x, 2.0) + Math.pow(p1.y-y, 2.0));
    }
}
