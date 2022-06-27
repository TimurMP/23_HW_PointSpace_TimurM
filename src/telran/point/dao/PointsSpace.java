package telran.point.dao;

import telran.point.model.Point;

import java.util.Arrays;
import java.util.Comparator;

public class PointsSpace {
    Point relPoint;
    Point[] points;
    Comparator<Point> comp = (p1, p2) -> {
        Point compPoint = relPoint;
        double distanceXP1 = ((p1.getX()- compPoint.getX()));
        double distanceYP1 = ((p1.getY()- compPoint.getY()));
        double distanceP1 = Math.sqrt(distanceXP1*distanceXP1)+(distanceYP1*distanceYP1);

        double distanceXP2 = ((p2.getX()- compPoint.getX()));
        double distanceYP2 = ((p2.getY())-compPoint.getY());
        double distanceP2 = Math.sqrt(distanceXP2*distanceXP2)+(distanceYP2*distanceYP2);

        return Double.compare(distanceP1, distanceP2);
    };



    public PointsSpace(Point relPoint, Point[] points) {
        this.relPoint = relPoint;
        Arrays.sort(points, comp);
        Point[] copyPoints = Arrays.copyOf(points, points.length);
        this.points = copyPoints;


        //FIXME Fix problem
        //TODO sorting this.point by proximity to relPoint
        //to apply method sort of class Arrays
    }


    public Point[] getPoints() {
        return points;
    }

    public  void  addPoint(Point point){
        printArray();
        int index = Arrays.binarySearch(points, point, comp);
        System.out.println(index);
        Point[] pointCopy = new Point[points.length+1];
        if (index<0){
            System.arraycopy(points, -index-1, pointCopy, -index, points.length+index+1);
            System.arraycopy(points, index-index, pointCopy, index-index, 1);
            pointCopy[-index-1] = point;
        }
        if (index>0){
            System.arraycopy(points, index, pointCopy, index+1, points.length-index);
            System.arraycopy(points, index-index, pointCopy, index-index, index);
            pointCopy[index] = point;
        }
        points = pointCopy;

        for (int i = 0; i < pointCopy.length; i++) {
            System.out.println(pointCopy[i]);
        }





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
