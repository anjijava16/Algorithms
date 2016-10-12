import edu.princeton.cs.algs4.*;


/**
 * Created by sunilpatil on 10/8/16.
 */
public class PointSET {
    private SET<Point2D> pointSet;

    public PointSET() {
        pointSet = new SET<>();
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 50);
        StdDraw.setYscale(0, 50);

        PointSET pointSET = new PointSET();

        Point2D firstPoint = null;
        for (int i = 0; i < 20; i++) {
            double x = StdRandom.uniform(50);
            double y = StdRandom.uniform(50);
            if (firstPoint == null) {
                firstPoint = new Point2D(x, y);
            }
            pointSET.insert(new Point2D(x, y));
        }
        Point2D nearestPoint = pointSET.nearest(firstPoint);
        System.out.println("First Point " + firstPoint
                + " Nearest Point " + nearestPoint);
        nearestPoint.drawTo(firstPoint);
        RectHV rectHV = new RectHV(10, 10, 30, 30);
        rectHV.draw();
        Iterable<Point2D> pointsInRect = pointSET.range(rectHV);
        for (Point2D rectPoint : pointsInRect)
            System.out.println(rectPoint);

        pointSET.draw();
        StdDraw.show();
    }

    public boolean isEmpty() {
        return pointSet.isEmpty();
    }

    public int size() {
        return pointSet.size();
    }

    public void insert(Point2D p) {
        if (p == null)
            throw new NullPointerException();
        pointSet.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null)
            throw new NullPointerException();
        return pointSet.contains(p);
    }

    public void draw() {
        for (Point2D p : pointSet) {
            p.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new NullPointerException();
        Stack<Point2D> point2DStack = new Stack<>();
        for (Point2D point2D : pointSet) {
            if (rect.contains(point2D)) {
                point2DStack.push(point2D);
            }
        }
        return point2DStack;
    }

    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new NullPointerException();

        double distance = Double.MAX_VALUE;
        Point2D nearestPoint = null;
        for (Point2D thatPoint : pointSet) {
            double currentDistance = thatPoint.distanceSquaredTo(p);
            if (currentDistance < distance) {
                distance = currentDistance;
                nearestPoint = thatPoint;
            }
        }
        return nearestPoint;
    }
}
