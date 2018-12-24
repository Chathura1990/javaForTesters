package by.itsm.task2and3;

public class Point {

    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Point(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance(Point p1, Point p2) {
       double distOfPoint = Math.sqrt(Math.pow(p1.x2 - p2.x1, 2.0) + Math.pow(p1.y2 - p2.y1, 2.0));
       return distOfPoint;
    }
}
