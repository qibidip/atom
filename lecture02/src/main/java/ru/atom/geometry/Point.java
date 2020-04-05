package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider /* super class and interfaces here if necessary */ {
    // fields
    // and methods
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        return this.x == point.x && this.y == point.y;

    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other)) return true;
        if (getClass() != other.getClass()) {
            Bar bar = (Bar) other;
            return bar.getFirstPoint().getX() <= this.getX()
                    && bar.getSecondPoint().getX() >= this.getX()
                    && bar.getFirstPoint().getY() <= this.getY()
                    && bar.getSecondPoint().getY() >= this.getY();
        }
        return false;
    }
}
