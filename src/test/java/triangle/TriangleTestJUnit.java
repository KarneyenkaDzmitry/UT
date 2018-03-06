package triangle;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TriangleTestJUnit {
    private String marker;
    private Triangle triangle;
    private double a;//The first side of triangle
    private double b;//The second side of triangle
    private double c;//The third side of triangle
    private double expectedOfDetection;//The expected result of the method detectTriangle()
    private double expectedSquare;//The expected result of getSquare() of the triangle. If triangle doesn't exist
    //the parameter equals zero

    @Parameterized.Parameters
    public static Collection<Object[]> set_of_parameters() {
        // Parameters for every case (all from open source - see the table of the file: Junit tests of triangle.docx ):
        //String marker. "Несуществующий" or different kinds of triangle if it exist.
        //ArrayList = {a, b, c, expectedOfDetection, expectedSquare}
        //Where a, b, с - sides of the triangle;
        //expectedOfDetection - expected result working of detectRectangle();
        //expectedSquare - expected resul of calling getSquare() method.
        return Arrays.asList(new Object[][]{
                {"Прямоугольный", new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 8.0, 6.0))},
                {"Прямоугольный", new ArrayList<Double>(Arrays.asList(65.00, 72.00, 97.00, 8.0, 2340.00))},
                {"Прямоугольный", new ArrayList<Double>(Arrays.asList(68.00, 285.00, 293.00, 8.0, 9690.00))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(3.00, 3.00, 3*1.4142135623730950488016887242097, 10.0, 4.50))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(3.00, 3.00, 5.00, 2.0, 4.14578098794425))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(10.00, 10.00, 15.00, 2.0, 49.607837082461074))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(97.00, 97.00, 123.00, 2.0, 4613.217444203124))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(3.00, 3.00, 2.00, 2.0, 2.8284271247461903))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(10.00, 10.00, 9.00, 2.0, 40.18628497385644))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(99.00, 99.00, 94.00, 2.0, 4095.2079312288893))},
                {"Равносторонний", new ArrayList<Double>(Arrays.asList(5.00, 5.00, 5.00, 3.0, 10.825317547305483))},
                {"Равносторонний", new ArrayList<Double>(Arrays.asList(17.00, 17.00, 17.00, 3.0, 125.14067084685138))},
                {"Равносторонний", new ArrayList<Double>(Arrays.asList(111.00, 111.00, 111.00, 3.0, 5335.149500014034))},
                {"Равносторонний", new ArrayList<Double>(Arrays.asList(1.00, 1.00, 1.00, 3.0, 0.4330127018922193))},
                {"Разносторонний", new ArrayList<Double>(Arrays.asList(10.00,	6.00,	5.00, 4.00, 11.399013115177997))},
                {"Разносторонний", new ArrayList<Double>(Arrays.asList(26.00, 31.00, 12.00, 4.00, 151.96525096218542))},
                {"Разносторонний", new ArrayList<Double>(Arrays.asList(113.00, 158.00, 256.00, 4.00, 5601.6429230628))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(10.00, 3.00, 2.00, 0.00, Double.NaN))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(5.00, 12.00, 4.00, 0.00, Double.NaN))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(20.00, 20.00, 51.00, 0.00, Double.NaN))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(1.00, 1.00, 0.00, 0.00, 0.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(1.00, 0.00, 1.00, 0.00, 0.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(0.00, 1.00, 1.00, 0.00, 0.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(-5.00, 4.00, 3.00, 0.00, 6.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(4.00, 3.00, -5.00, 0.00, 6.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(3.00, -5.00, 4.00, 0.00, 6.0))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(10.00, 3.00, 2.00, 0.00, Double.NaN))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(5.00, 5.00, 12.00, 0.00, Double.NaN))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, 1.00, 2.00, Double.POSITIVE_INFINITY))},
                {"Несуществующий", new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE, 500.00, 400.00, 0.00, Double.NaN))},
                {"Разносторонний", new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE - 1.00,Double.MAX_VALUE - 2.00, 4.00, Double.POSITIVE_INFINITY))},
                {"Равносторонний", new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 3.00, Double.POSITIVE_INFINITY))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(Double.NaN, 5.00, 5.00, 2.00, Double.NaN))},
                {"Равнобедренный", new ArrayList<Double>(Arrays.asList(Double.POSITIVE_INFINITY, 5.00, 5.00, 2.00, Double.NaN))},
        });
    }

    public TriangleTestJUnit(String marker, ArrayList<Double> list) {
        this.marker = marker;
        this.a = list.get(0);
        this.b = list.get(1);
        this.c = list.get(2);
        this.expectedOfDetection = list.get(3);
        this.expectedSquare = list.get(4);
    }
    /*@BeforeClass
    public static void tst_BeforeClassAnnotation() {
        System.out.println("Test of @BeforeClass annotation");
    }
    @AfterClass
    public static void tst_AfterClassAnnotation() {
        System.out.println("Test of @AfterClass annotation");
    }*/

    @Before
    public void setUp() throws Exception {
        triangle = new Triangle(a, b, c);
        //System.out.println("Test of @Before annotation");
    }

    @After
    public void tearDown() throws Exception {
        triangle = null;
        //System.out.println("Test of @After annotation");

    }


    @Test
    public void tst_getMessage() {
        if (triangle.checkTriangle()) {
            assertNotNull(triangle.getMessage());
            assertEquals("", triangle.getMessage());
        } else {
            if (a <= 0) {
                assertEquals("a<=0", triangle.getMessage());
            }
            if (b <= 0) {
                assertEquals("b<=0", triangle.getMessage());
            }
            if (c <= 0) {
                assertEquals("c<=0", triangle.getMessage());
            }
            if (a + b <= c) {
                assertEquals("a+b<=c", triangle.getMessage());
            }
            if (a + c <= b) {
                assertEquals("a+c<=b", triangle.getMessage());
            }
            if (b + c <= a) {
                assertEquals("b+c<=a", triangle.getMessage());
            }
        }
    }

    @Test
    public void tst_checkTriangle() {
        if (marker.equals("Несуществующий")) {
            assertFalse(triangle.checkTriangle());
        } else {
            assertTrue(triangle.checkTriangle());
        }
    }

    @Test
    public void tst_detectTriangle() {
        assertEquals(expectedOfDetection, (double) triangle.detectTriangle(), 0.1);
    }

    @Test
    public void tst_getSquare() {
        assertEquals(expectedSquare, triangle.getSquare(), 0.000001);
    }
}