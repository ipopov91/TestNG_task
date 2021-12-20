import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import static org.testng.Assert.*;

public class TestTriangle {

    @DataProvider
    public static Object[][] validationData() {
        return new Object[][] {
                {1.0, 2.0, 3.0},
                {6.0, 5.0, 4.0},
                {1.0, 1.0, 2.5},
                {1.0, 1.0, 1.0},
                {1.0, 2.0, 1.0},
                {0, 0, 0},
                {-1.0, 2.0, -5.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
        };
    }
    // Check sides more then zero
    @Test(dataProvider = "validationData")
    public void checkSideMoreZero(double a, double b, double c) {
        assertEquals(new Triangle(a, b, c).checkTriangle(),a > 0);
        assertEquals(new Triangle(a, b, c).checkTriangle(),b > 0);
        assertEquals(new Triangle(a, b, c).checkTriangle(),c > 0);
    }
    // Check if the triangle type is equilateral
    @Test(dataProvider = "validationData")
    public void checkEquilateralTriangle(double a, double b, double c) {
        assertEquals(new Triangle(a, b, c).detectTriangle(), 1);
    }
    // Check if the triangle type is isosceles
    @Test(dataProvider = "validationData")
    public void checkIsoscelesTriangle(double a, double b, double c) {
        assertEquals(new Triangle(a, b, c).detectTriangle(), 2);
    }
    // Check if the triangle type is ordinary
    @Test(dataProvider = "validationData")
    public void checkOrdinaryTriangle(double a, double b, double c) {
        assertEquals(new Triangle(a, b, c).detectTriangle(), 4);
    }
    // Check if the triangle type is rectangular
    @Test(dataProvider = "validationData")
    public void checkRectangularTriangle(double a, double b, double c) {
        assertEquals(new Triangle(a, b, c).detectTriangle(), 8);
    }
    // Check two sides are larger than the third
    @Test(dataProvider = "validationData")
    public void testSum(double a, double b, double c) {
        assertEquals(new Triangle(a,b,c).checkTriangle(), a + b > c);
        assertEquals(new Triangle(a,b,c).checkTriangle(), c + b > a);
        assertEquals(new Triangle(a,b,c).checkTriangle(), a + c > b);
    }
    // Check type of input parameters
    @Test(dataProvider = "validationData")
    public void testCorrectInputType(double a, double b, double c) {
        double compare = a;
        assertSame(a, compare);
    }
    // Check triangle square for int values
    @Test
    public void checkSquareIntValue() {
        Triangle triangle1 = new Triangle(5, 5, 6);
        assertEquals(triangle1.getSquare(), 12);
    }
    // Check triangle square for double values
    @Test
    public void checkSquareDoubleValue() {
        Triangle triangle2 = new Triangle(5.5, 6.5, 7.5);
        assertEquals(triangle2.getSquare(), 17.407231794573196);
    }
}
