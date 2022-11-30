package agh.ics.oop;


import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String wordX = Integer.toString(x);
        String wordY = Integer.toString(y);
        return "(" + wordX + "," + wordY + ")";
    }


    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    Vector2d add(Vector2d other) {
        int valx = this.x + other.x;
        int valy = this.y + other.y;
        return new Vector2d(valx, valy);
    }

    Vector2d subtract(Vector2d other) {
        int valx = this.x - other.x;
        int valy = this.y - other.y;
        return new Vector2d(valx, valy);
    }

    Vector2d upperRight(Vector2d other) {
        int valx = Math.max(this.x, other.x);
        int valy = Math.max(this.y, other.y);
        return new Vector2d(valx, valy);
    }

    Vector2d lowerLeft(Vector2d other) {
        int valx = Math.min(this.x, other.x);
        int valy = Math.min(this.y, other.y);
        return new Vector2d(valx, valy);
    }

    Vector2d opposite() {
        int valx = (-1) * this.x;
        int valy = (-1) * this.y;
        return new Vector2d(valx, valy);
    }
    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
