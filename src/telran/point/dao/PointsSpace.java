package telran.point.dao;

import telran.point.model.Point;

import java.util.Arrays;
import java.util.Comparator;

public class PointsSpace {
    Point relPoint;
    Point[] points;
    Comparator<Point> comp = (p2, p1) -> {

        double distanceXP1 = ((p1.getX()- relPoint.getX()));
        double distanceYP1 = ((p1.getY()- relPoint.getY()));
        double distanceP1 = Math.sqrt(distanceXP1*distanceXP1)+(distanceYP1*distanceYP1);
        System.out.println("xxxx1  " + p1.getX());
        System.out.println("xxxx2  " + p2.getX());

        System.out.println("distanceP1  " + distanceP1);

        double distanceXP2 = ((p2.getX()- relPoint.getX()));
        double distanceYP2 = ((p2.getY())-relPoint.getY());
        double distanceP2 = Math.sqrt(distanceXP2*distanceXP2)+(distanceYP2*distanceYP2);
        System.out.println("distanceP2  " + distanceP2);
//        double relativeDistance = Double.compare(distanceP1, distanceP2);


        return Double.compare(distanceP2, distanceP1);
    };



    public PointsSpace(Point relPoint, Point[] points) {
        this.relPoint = relPoint;
        Point[] copyPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(points, comp);
        this.points = points;

        //FIXME Fix problem
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


    public void printArray(){
        System.out.println("========================");
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
        }
    }
}
