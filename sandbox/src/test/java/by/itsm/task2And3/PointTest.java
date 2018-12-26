package by.itsm.task2And3;

import by.itsm.task2and3.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void distanceOfPoint(){
        Point p1 = new Point(2,6);
        Point p2 = new Point(4.0,7.0);
        System.out.println("Distance Between two points: x:"+p1.x+", y:"+p1.y+ ", x:"+p2.x+", y:"+p2.y+" = " + p1.distance(p2));
        Assert.assertEquals(p1.distance(p2),2.23606797749979);
    }
}
