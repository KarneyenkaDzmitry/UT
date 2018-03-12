package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTestNG {

    @DataProvider(name = "negativeTests")
    public Object[][] createNegativeData() {
        return new Object[][]{
                {0.0, 0.0, 0.0},
                {10.0, 3.0, 2.0},
                {5.0, 12.0, 4.0},
                {20.0, 20.0, 51.0},
                {1.0, 1.0, 0.0},
                {1.0, 0.0, 1.0},
                {0.0, 1.0, 1.0},
                {-5.0, 4.0, 3.0},
                {4.0, 3.0, -5.0},
                {3.0, -5.0, 4.0},
                {5.0, 5.0, 12.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                //{Double.MAX_VALUE, 500, 400},
                //{400.0, Double.MAX_VALUE, 500},
                //{Double.NaN, 500, 500},
                //{Double.POSITIVE_INFINITY, 500, 500},
        };
    }

    @Test(dataProvider = "negativeTests", groups = "negative")
    public void testGetMessageNegative(Double a, Double b, Double c) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.checkTriangle();
        boolean fail = false;
        if (a <= 0) {
            assertEquals(triangle.getMessage(), "a<=0");
            fail = true;
        }
        if ((b <= 0) && (!fail)) {
            assertEquals(triangle.getMessage(), "b<=0");
            fail = true;
        }
        if ((c <= 0) && (!fail)) {
            assertEquals(triangle.getMessage(), "c<=0");
            fail = true;
        }
        if ((a + b <= c) && (!fail)) {
            assertEquals(triangle.getMessage(), "a+b<=c");
            fail = true;
        }
        if ((a + c <= b) && (!fail)) {
            assertEquals(triangle.getMessage(), "a+c<=b");
            fail = true;
        }
        if ((b + c <= a) && (!fail)) {
            assertEquals(triangle.getMessage(), "b+c<=a");
            fail = true;
        }
        if (!fail) {
            assertNotNull(triangle.getMessage());
            assertEquals(triangle.getMessage(), "");
        }
    }

    @Test(dataProvider = "negativeTests", groups = "negative")
    public void testCheckTriangleNegative(Double a, Double b, Double c) {
        Triangle triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle());
    }

    @Test(dataProvider = "negativeTests", expectedExceptions = Exception.class, groups = "negative")
    public void testDetectTriangleNegative(Double a, Double b, Double c) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.detectTriangle();
    }

    @Test(dataProvider = "negativeTests", expectedExceptions = Exception.class, groups = "negative")
    public void testGetSquareNegative(Double a, Double b, Double c) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.getSquare();
    }

    @DataProvider(name = "positiveTests")
    public Object[][] createPositiveData() {
        return new Object[][]{
                {3.0, 4.0, 5.0, 8.0, 6.0},
                {5.0, 3.0, 4.0, 8.0, 6.0},
                {4.0, 5.0, 3.0, 8.0, 6.0},
                {65.0, 72.0, 97.0, 8.0, 2340.00},
                {68.0, 285.0, 293.0, 8.0, 9690.00},
                {293.0, 68.0, 285.0, 8.0, 9690.00},
                {285.0, 293.0, 68.0, 8.0, 9690.00},
                {3.0, 3.0, 4.242640687, 10.0, 4.5},
                {3.0, 3.0, 5.0, 2.0, 4.14578098794425},
                {10.0, 10.0, 15.00, 2.0, 49.607837082461074},
                {97.0, 97.0, 123.00, 2.0, 4613.217444203124},
                {3.0, 3.0, 2.00, 2.0, 2.8284271247461903},
                {10.0, 10.0, 9.00, 2.0, 40.18628497385644},
                {99.0, 99.0, 94.00, 2.0, 4095.2079312288893},
                {5.0, 5.0, 5.00, 3.0, 10.825317547305483},
                {17.0, 17.0, 17.00, 3.0, 125.14067084685138},
                {111.0, 111.0, 111.00, 3.0, 5335.149500014034},
                {1.0, 1.0, 1.00, 3.0, 0.4330127018922193},
                {10.0, 6.0, 5.00, 4.0, 11.399013115177997},
                {26.0, 31.0, 12.00, 4.0, 151.96525096218542},
                {113.0, 158.0, 256.00, 4.0, 5601.64292306284},
                {753.12345678, 987.65432198, 456.78945612, 4.0, 164611.65116652913},
        };
    }

    @Test(dataProvider = "positiveTests", groups = "positive")
    public void testGetMessagePositive(Double a, Double b, Double c, Double expectedDetection, Double ExpectedSquare) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.checkTriangle();
        assertNotNull(triangle.getMessage());
        assertEquals(triangle.getMessage(), "");
    }

    @Test(dataProvider = "positiveTests", groups = "positive")
    public void testCheckTrianglePositive(Double a, Double b, Double c, Double expectedDetection, Double ExpectedSquare) {
        Triangle triangle = new Triangle(a, b, c);
        assertTrue(triangle.checkTriangle());
    }

    @Test(dataProvider = "positiveTests", groups = "positive")
    public void testDetectTrianglePositive(Double a, Double b, Double c, Double expectedDetection, Double ExpectedSquare) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals((double) triangle.detectTriangle(), expectedDetection);
    }

    @Test(dataProvider = "positiveTests", groups = "positive")
    public void testGetSquarePositive(Double a, Double b, Double c, Double expectedDetection, Double ExpectedSquare) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(triangle.getSquare(), ExpectedSquare);
    }
}