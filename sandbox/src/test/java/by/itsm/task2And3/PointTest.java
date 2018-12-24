package by.itsm.task2And3;

import by.itsm.task2and3.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void distanceOfPoint(){
        Point p = new Point(2,2,7,7);
        System.out.println("Distance Between two points: x1:"+p.x1+", y1:"+p.y2+ ", x2:"+p.x2+", y2:"+p.y2+" = " + p.distance(p,p));
        Assert.assertEquals(p.distance(p,p),7.0710678118654755);
    }
}
