package telran.point.tests;

import org.junit.jupiter.api.Test;
import telran.point.dao.PointsSpace;
import telran.point.model.Point;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PointsSpaceTest {
    Point p0 = new Point(0, 0);
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(3, 3);
    Point p4 = new Point(4, 4);
    Point p5 = new Point(5, 5);
    Point p6 = new Point(6, 6);
    Point p_2 = new Point(-2, -2);
    Point[] expectedTemp = {p_2, p1, p2, p3, p4};
    Point[] original = {p3, p2, p0, p4};
    Point[] expected0 = {p0, p2, p3, p4};
    Point[] expected4 = {p4, p3, p2, p0};
    Point[] expected01 = {p0, p1, p2, p3, p4};
    Point[] expected05 = {p0, p2, p3, p4, p5};
    Point[] expected01_02 = {p0, p1, p_2, p2, p3, p4};


    @Test
    void testConstructor() {
        PointsSpace ps = new PointsSpace(p0, original);
        ps.printArray();
        assertArrayEquals(expected0, ps.getPoints());
        ps = new PointsSpace(p4, original);
        ps.printArray();
        assertArrayEquals(expected4, ps.getPoints());
    }

    @Test
    void testAddPoint() {
        PointsSpace ps = new PointsSpace(p0, original);
        ps.addPoint(p1);
        assertArrayEquals(expected01, ps.getPoints());
        ps.addPoint(p_2);
        assertArrayEquals(expected01_02, ps.getPoints());
    }

    @Test
    void temp() {


        Point relPoint = p4;
        Comparator<Point> comp = (p1, p2) -> {

            double distanceXP1 = ((p1.getX() - relPoint.getX()));
            double distanceYP1 = ((p1.getY() - relPoint.getY()));
            double distanceP1 = Math.sqrt(distanceXP1 * distanceXP1) + (distanceYP1 * distanceYP1);

            double distanceXP2 = ((p2.getX() - relPoint.getX()));
            double distanceYP2 = ((p2.getY()) - relPoint.getY());
            double distanceP2 = Math.sqrt(distanceXP2 * distanceXP2) + (distanceYP2 * distanceYP2);

            return Double.compare(distanceP1, distanceP2);
        };


        Point[] original = {p3, p2, p0, p4};
        printArray(original, "Original");
        Point[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy, comp);
        printArray(copy, "copy");
    }


    @Test
    void testAddPoint1() {
        PointsSpace ps = new PointsSpace(p0, original);
        ps.addPoint(p5);
        assertArrayEquals(expected05, ps.getPoints());
//        ps.addPoint(p_2);
//        assertArrayEquals(expected01_02, ps.getPoints());
    }

    private void printArray(Point[] arr, String title) {
        System.out.println(title);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }

}