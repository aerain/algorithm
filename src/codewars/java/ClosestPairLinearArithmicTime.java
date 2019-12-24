package codewars.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClosestPairLinearArithmicTime {

    public static List<Point> closestPair(List<Point> points) {
        points.sort(Comparator.comparingDouble(o -> o.x));
        double d = Double.MAX_VALUE;
        Point p1 = null;
        Point p2 = null;


        return Arrays.asList(p1, p2);
    }

    static class Point {
        public double x, y;

        public Point() {
            x = y = 0.0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%f, %f)", x, y);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(x) ^ Double.hashCode(y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof codewars.java.Point) {
                codewars.java.Point other = (codewars.java.Point) obj;
                return x == other.x && y == other.y;
            } else {
                return false;
            }
        }
    }
}


