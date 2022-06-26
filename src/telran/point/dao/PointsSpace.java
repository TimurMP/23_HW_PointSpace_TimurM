package telran.point.dao;

import telran.point.model.Point;

import java.util.Comparator;

public class PointsSpace {
    Point relPoint;
    Point[] points;
    Comparator<Point> comp;

    public PointsSpace(Point relPoint, Point[] points) {
        this.relPoint = relPoint;
        this.points = points; //FIXME Fix problem
        //TODO sorting this.point by proximity to relPoint
        //to apply method sort of class Arrays
    }

    public Point[] getPoints() {
        return points;
    }

    public  void  addPoint(Point point){
        //TODO
        //Maintain sorting state (Without re-sorting again). Apply binarySearch from Arrays.
        //to apply method arrayCopy from System.
        //method arrayCopy will be called twice.
    }
}
