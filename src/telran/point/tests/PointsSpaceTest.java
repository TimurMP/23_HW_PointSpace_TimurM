package telran.point.tests;

import org.junit.jupiter.api.Test;
import telran.point.dao.PointsSpace;
import telran.point.model.Point;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PointsSpaceTest {
    Point p0 = new Point(0, 0);
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(3, 3);
    Point p4 = new Point(4, 4);
    Point p_2 = new Point(-2, -2);
    Point[] original = { p3, p2, p0, p4 };
    Point[] expected0 = { p0, p2, p3, p4 };
    Point[] expected4 = { p4, p3, p2, p0 };
    Point[] expected01 = { p0, p1, p2, p3, p4 };
    Point[] expected01_02 = { p0, p1, p_2, p2, p3, p4 };




    @Test
    void testConstructor() {
        PointsSpace ps = new PointsSpace(p0, original);
        ps.printArray();
        assertArrayEquals(expected0, ps.getPoints());
        new PointsSpace(p4, original);
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
    void xxx() {
        double x1 = 2;
        double y1 = 2;
        double x2 = 0;
        double y2 = 0;

        double distanceX = (x2 - x1);
        double distanceY = (y2 - y1);
        double distance = Math.sqrt(distanceX * distanceX) + (distanceY * distanceY);
        System.out.println(distance);

    }


}