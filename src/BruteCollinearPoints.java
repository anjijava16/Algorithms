import edu.princeton.cs.algs4.*;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by sunilpatil on 9/20/16.
 */
public class BruteCollinearPoints {
    private ResizingArrayBag<LineSegment> collinearPoints = new ResizingArrayBag<LineSegment>();


    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException();
        if (points.length < 4)
            return;

        //   hasDuplicatePoints(points);
        if (points[0] == null || points[1] == null
                || points[2] == null || points[3] == null)
            throw new NullPointerException();

        int numberOfPoints = points.length;
        for (int i = 0; i < numberOfPoints; i++) {
            Point p = points[i];
            for (int j = i + 1; j < numberOfPoints; j++) {
                Point q = points[j];
                double firstSlope = p.slopeTo(q);
                for (int k = j + 1; k < numberOfPoints; k++) {
                    Point r = points[k];
                    double secondSlope = p.slopeTo(r);
                    if (firstSlope == secondSlope) {
                        for (int l = k + 1; l < numberOfPoints; l++) {
                            Point s = points[l];

                            double thirdSlope = p.slopeTo(s);
                            if (firstSlope == thirdSlope) {
                                Point[] lineSegmentPoints = new Point[4];
                                lineSegmentPoints[0] = p;
                                lineSegmentPoints[1] = q;
                                lineSegmentPoints[2] = r;
                                lineSegmentPoints[3] = s;
                                Merge.sort(lineSegmentPoints);
                                collinearPoints.add(new LineSegment(lineSegmentPoints[0], lineSegmentPoints[3]));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void hasDuplicatePoints(Point[] points) {
        HashSet<Point> pointHashSet = new HashSet<>();
        for (int i = 0; i < points.length - 1; i++) {
            if (pointHashSet.contains(points[i]))
                throw new IllegalArgumentException();
            pointHashSet.add(points[i]);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return collinearPoints.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] lineSegments = new LineSegment[collinearPoints.size()];
        Iterator<LineSegment> it = collinearPoints.iterator();
        int i = 0;
        while (it.hasNext())
            lineSegments[i++] = it.next();
        return lineSegments;
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}