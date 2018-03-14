package triangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TriangleTestJUnit {
    private String markerOfTest;//PositiveTest or NegativeTest
    private String message;//Message for failed tests
    private Triangle triangle;//Object of the testing class
    private double a;//The first side of triangle
    private double b;//The second side of triangle
    private double c;//The third side of triangle
    private double expectedOfDetection;//The expected result of the method detectTriangle()
    private double expectedSquare;//The expected result of getSquare() of the triangle. If triangle doesn't exist
    //the parameter equals zero
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private String setErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"This is ").append(markerOfTest).append(" with parameters: a=[").append(a).append("], b=[").append(b).append("], c=[");
        builder.append(c).append("], \n");
        if (expectedOfDetection == 0.0) {
            builder.append("expected of detectionTriangle()=[Exception], ");
        } else {
            int exp = (int) expectedOfDetection;
            builder.append("expected of detectionTriangle()=[").append(exp).append("], ");
        }
        if (expectedSquare == 0.0) {
            builder.append("expected of getSquare()=[Exception], ");
        } else {
            builder.append("expected of getSquare()=[").append(expectedSquare).append("].\"");
        }
        return builder.toString();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> set_of_parameters() {
        // Parameters for every case (all from open source - see the table of the file: Junit tests of triangle.docx ):
        //String marker. "Несуществующий" or different kinds of triangle if it exist.
        //ArrayList = {a, b, c, expectedOfDetection, expectedSquare}
        //Where a, b, с - sides of the triangle;
        //expectedOfDetection - expected result working of detectRectangle();
        //expectedSquare - expected resul of calling getSquare() method.
        return Arrays.asList(new Object[][]{
                {"Positive Test", new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0, 8.0, 6.0))},
                {"Positive Test", new ArrayList<>(Arrays.asList(5.0, 3.0, 4.0, 8.0, 6.0))},
                {"Positive Test", new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0, 8.0, 6.0))},
                {"Positive Test", new ArrayList<>(Arrays.asList(65.00, 72.00, 97.00, 8.0, 2340.00))},
                {"Positive Test", new ArrayList<>(Arrays.asList(68.00, 285.00, 293.00, 8.0, 9690.00))},
                {"Positive Test", new ArrayList<>(Arrays.asList(3.00, 3.00, Math.sqrt(3.0*3.0+3.0*3.0), 10.0, 4.50))},
                {"Positive Test", new ArrayList<>(Arrays.asList(3.00, 3.00, 5.00, 2.0, 4.14578098794425))},
                {"Positive Test", new ArrayList<>(Arrays.asList(10.00, 10.00, 15.00, 2.0, 49.607837082461074))},
                {"Positive Test", new ArrayList<>(Arrays.asList(97.00, 97.00, 123.00, 2.0, 4613.217444203124))},
                {"Positive Test", new ArrayList<>(Arrays.asList(3.00, 3.00, 2.00, 2.0, 2.8284271247461903))},
                {"Positive Test", new ArrayList<>(Arrays.asList(10.00, 10.00, 9.00, 2.0, 40.18628497385644))},
                {"Positive Test", new ArrayList<>(Arrays.asList(99.00, 99.00, 94.00, 2.0, 4095.2079312288893))},
                {"Positive Test", new ArrayList<>(Arrays.asList(5.00, 5.00, 5.00, 3.0, 10.825317547305483))},
                {"Positive Test", new ArrayList<>(Arrays.asList(17.00, 17.00, 17.00, 3.0, 125.14067084685138))},
                {"Positive Test", new ArrayList<>(Arrays.asList(111.00, 111.00, 111.00, 3.0, 5335.149500014034))},
                {"Positive Test", new ArrayList<>(Arrays.asList(1.00, 1.00, 1.00, 3.0, 0.4330127018922193))},
                {"Positive Test", new ArrayList<>(Arrays.asList(10.00, 6.00, 5.00, 4.00, 11.399013115177997))},
                {"Positive Test", new ArrayList<>(Arrays.asList(26.00, 31.00, 12.00, 4.00, 151.96525096218542))},
                {"Positive Test", new ArrayList<>(Arrays.asList(113.00, 158.00, 256.00, 4.00, 5601.6429230628))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(10.00, 3.00, 2.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(5.00, 12.00, 4.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(20.00, 20.00, 51.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(1.00, 1.00, 0.00, 0.00, 0.0))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(1.00, 0.00, 1.00, 0.00, 0.0))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(0.00, 1.00, 1.00, 0.00, 0.0))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(0.00, 0.00, 0.00, 0.00, 0.0))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(-5.00, 4.00, 3.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(4.00, 3.00, -5.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(3.00, -5.00, 4.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(10.00, 3.00, 2.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(5.00, 5.00, 12.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, 1.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.MAX_VALUE, 500.00, 400.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE - 1.00, Double.MAX_VALUE - 2.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.NaN, 5.00, 5.00, 0.00, 0.00))},
                {"NegativeTest", new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, 5.00, 5.00, 0.00, 0.0))},
        });
    }

    public TriangleTestJUnit(String markerOfTest, ArrayList<Double> list) {
        this.markerOfTest = markerOfTest;
        this.a = list.get(0);
        this.b = list.get(1);
        this.c = list.get(2);
        this.expectedOfDetection = list.get(3);
        this.expectedSquare = list.get(4);
        this.message = setErrorMessage();
    }

    @Before
    public void setUp() {
        triangle = new Triangle(a, b, c);
    }

    @After
    public void tearDown() {
        triangle = null;
    }

    @Test
    public void tst_getMessage() {
        triangle.checkTriangle();
        if (markerOfTest.equals("PositiveTest")) {
            assertNotNull(triangle.getMessage());
            assertEquals(message, "", triangle.getMessage());
        } else {
            boolean fail = false;
            if (a <= 0) {
                assertEquals(message, "a<=0", triangle.getMessage());
                fail = true;
            }
            if ((b <= 0) && (!fail)) {
                assertEquals(message, "b<=0", triangle.getMessage());
                fail = true;
            }
            if ((c <= 0) && (!fail)) {
                assertEquals(message, "c<=0", triangle.getMessage());
                fail = true;
            }
            if ((a + b <= c) && (!fail)) {
                assertEquals(message, "a+b<=c", triangle.getMessage());
                fail = true;
            }
            if ((a + c <= b) && (!fail)) {
                assertEquals(message, "a+c<=b", triangle.getMessage());
                fail = true;
            }
            if ((b + c <= a) && (!fail)) {
                assertEquals(message, "b+c<=a", triangle.getMessage());
                fail = true;
            }
            if (!fail) {
                assertNotNull(triangle.getMessage());
                assertEquals(message, "", triangle.getMessage());
            }
        }
    }

    @Test
    public void tst_checkTriangle() {
        if (markerOfTest.equals("NegativeTest")) {
            assertFalse(message, triangle.checkTriangle());
        } else {
            assertTrue(message, triangle.checkTriangle());
        }
    }

    @Test
    public void tst_detectTriangle() {
        if (markerOfTest.equals("NegativeTest")) {
            exception.expect(Exception.class);
            triangle.detectTriangle();
        } else {
            assertEquals(message, expectedOfDetection, (double) triangle.detectTriangle(), 0.1);
        }
    }

    @Test
    public void tst_getSquare() {
        if (markerOfTest.equals("NegativeTest")) {
            exception.expect(Exception.class);
            triangle.getSquare();
        } else {
            assertEquals(message, expectedSquare, triangle.getSquare(), 0.000000001);
        }
    }
}