package ru.atom.geometry;

public class Bar implements Collider {
    private Point firstPoint;
    private Point secondPoint;

    public Bar(Point p1, Point p2) {
        int xcoordMin = Math.min(p1.getX(), p2.getX());
        int xcoordMax = Math.max(p1.getX(), p2.getX());
        int ycoordMin = Math.min(p1.getY(), p2.getY());
        int ycoordMax = Math.max(p1.getY(), p2.getY());
        this.firstPoint = new Point(xcoordMin, ycoordMin);
        this.secondPoint = new Point(xcoordMax, ycoordMax);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Bar
        Bar bar = (Bar) o;

        return this.getFirstPoint().equals(bar.getFirstPoint())
                && this.getSecondPoint().equals(bar.getSecondPoint());
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other)) return true;

        if (getClass() != other.getClass()) {
            Point point = (Point) other;
            return firstPoint.getX() <= point.getX()
                   && secondPoint.getX() >= point.getX()
                   && firstPoint.getY() <= point.getY()
                   && secondPoint.getY() >= point.getY();
        }
        return false;
    }
}
