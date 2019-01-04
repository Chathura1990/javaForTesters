package by.itsm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void test0(){
        Equation e = new Equation(1,1,1);
        System.out.println(e.rootNumber());
        Assert.assertEquals(e.rootNumber(), 0.0);
    }

    @Test
    public void test1(){
        Equation e = new Equation(1,2,1);
        System.out.println(e.rootNumber());
        Assert.assertEquals(e.rootNumber(), 1.0);
    }

    @Test
    public void test2(){
        Equation e = new Equation(1,5,6);
        System.out.println(e.rootNumber());
        Assert.assertEquals(e.rootNumber(), 2.0);
    }
}
