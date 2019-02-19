//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.awt.*;
//import java.util.Arrays;
//
////
////public class LocatorParameterizedTest {
////}
//@RunWith(Parameterized.class)
//public class TestClass{
//
//    @Parameterized.Parameters(name = "{index}: Test with X={0}, Y={1}, result: {2}")
//    public static Iterable<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//                {-1, -1, new Point(1, 1)},
//                {-1, 0, new Point(1, 0)},
//                {-1, 1, new Point(1, 1)},
//        });
//    }
//
//    @Test
//    public void testLocateLocalResult() {
//        assertTrue(arePointsEqual(expected, locatorUnderTest.locate(x, y)));
//    }
//
//    private boolean arePointsEqual(Point p1, Point p2) {
//        return p1.getX() == p2.getX()
//                && p1.getY() == p2.getY();
//    }
//}
//
