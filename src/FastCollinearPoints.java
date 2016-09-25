
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sunilpatil on 9/20/16.
 */
public class FastCollinearPoints {
    //  private Point[] aux;
    private ArrayList<LineSegment> collinearPoints =
            new ArrayList<>();
    private HashSet<String> lineSegments = new HashSet<>();
    private Point p;


    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException();
        //   hasDuplicatePoints(points);


        int numberOfPoints = points.length;


        Point[] points1 = points.clone();
        Arrays.sort(points1);

        for (int i = 0; i < numberOfPoints; i++) {
            p = points1[i];
            //  Arrays.sort(points, p.slopeOrder());
            sort(points);

            double currentSlope = Double.MIN_VALUE;
            ArrayList<Point> lineSegmentPoint = new ArrayList<Point>();
            for (int j = 0; j < numberOfPoints; j++) {
                if (p == points[j]) {
                    if (j == numberOfPoints - 1) {
                        if (lineSegmentPoint.size() >= 3) {
                            lineSegmentPoint.add(p);
                            Point[] pointsOnSameLine = getPointsArray(lineSegmentPoint);
                            Merge.sort(pointsOnSameLine);
                            LineSegment lineSegment = new LineSegment(pointsOnSameLine[0],
                                    pointsOnSameLine[pointsOnSameLine.length - 1]);

                            if (!lineSegments.contains(lineSegment.toString())) {
                                lineSegments.add(lineSegment.toString());
                                collinearPoints.add(lineSegment);
                            }
                        }
                    }
                    continue;
                }


                if (currentSlope == Double.MIN_VALUE) {
                    currentSlope = p.slopeTo(points[j]);
                    lineSegmentPoint.add(points[j]);
                    continue;
                }

                double thisSlope = p.slopeTo(points[j]);
                if (thisSlope == currentSlope && j != numberOfPoints - 1) {
                    lineSegmentPoint.add(points[j]);
                } else {
                    if (lineSegmentPoint.size() >= 3) {
                        lineSegmentPoint.add(p);
                        Point[] pointsOnSameLine = getPointsArray(lineSegmentPoint);
                        Merge.sort(pointsOnSameLine);

                        LineSegment lineSegment = new LineSegment(pointsOnSameLine[0],
                                pointsOnSameLine[pointsOnSameLine.length - 1]);

                        if (!lineSegments.contains(lineSegment.toString())) {
                            lineSegments.add(lineSegment.toString());
                            collinearPoints.add(lineSegment);
                        }
                    }
                    lineSegmentPoint.clear();
                    lineSegmentPoint.add(points[j]);
                    currentSlope = thisSlope;
                }

            }
        }
    }


    private Point[] getPointsArray(ArrayList<Point> pointsList) {
        Point[] points = new Point[pointsList.size()];
        int i = 0;
        for (Point currentPoint : pointsList)
            points[i++] = currentPoint;
        return points;
    }

    private LineSegment[] getLineSegmentsArray(ArrayList<LineSegment> lineSegmentArrayList) {
        LineSegment[] returnLineSegment = new LineSegment[lineSegmentArrayList.size()];
        int i = 0;
        for (LineSegment currentLineSegment : lineSegmentArrayList)
            returnLineSegment[i++] = currentLineSegment;
        return returnLineSegment;
    }

    // the number of line segments
    public int numberOfSegments() {
        return collinearPoints.size();
    }

    // the line segments
    public LineSegment[] segments() {

        return getLineSegmentsArray(collinearPoints);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();


        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println(collinear.segments().length);
        StdDraw.show();
    }

    private void merge(Point[] a, Point[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private void sort(Point[] a, Point[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private void sort(Point[] a) {
        Point[] aux = new Point[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private boolean less(Point v, Point w) {
        return p.slopeTo(v) > p.slopeTo(w);
    }

    private class LSPoints {
        private Point p1;
        private Point p2;

        LSPoints(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LSPoints lsPoints = (LSPoints) o;

            if (p1 != null ? !p1.equals(lsPoints.p1) :
                    lsPoints.p1 != null)
                return false;
            return p2 != null ? p2.equals(lsPoints.p2) :
                    lsPoints.p2 == null;
        }

        @Override
        public String toString() {
            return "LSPoints{" +
                    "p1=" + p1 +
                    ", p2=" + p2 +
                    '}';
        }
    }

}