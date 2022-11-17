package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal extends AbstractMapElement {
    public Vector2d vector = new Vector2d(2, 2);
    private final List<IPositionChangeObserver> observers = new LinkedList<>();
    private AbstractWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;

    public Animal(AbstractWorldMap map) {
        this.map = map;

        map.place(this);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        if (map.canMoveTo(initialPosition)) {
            this.vector = initialPosition;
            this.map = map;
            map.place(this);
        }

    }

    public Vector2d getPosition() {
        return vector;
    }

    @Override
    public String getType() {
        return "A";
    }

    public String toStringWhole() {
        String wordX = Integer.toString(vector.x);
        String wordY = Integer.toString(vector.y);
        return "(" + wordX + "," + wordY + "," + orientation.name() + ")";
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }


    public boolean isAt(Vector2d position) {
        return position.x == this.vector.x && position.y == this.vector.y;
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        } else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        } else if (direction == MoveDirection.FORWARD) {
            Vector2d obj = this.orientation.toUnitVector();
            if (obj != null) {
                int objx = obj.x;
                int objy = obj.y;
                Vector2d goTo = new Vector2d(this.vector.x + objx, this.vector.y + objy);
                if (map.canMoveTo(goTo)) {
                    this.vector = goTo;
                }
            }
        } else if (direction == MoveDirection.BACKWARD) {
            Vector2d obj = this.orientation.toUnitVector();
            if (obj != null) {
                int objx = obj.x;
                int objy = obj.y;
                Vector2d goTo = new Vector2d(this.vector.x - objx, this.vector.y - objy);
                if (map.canMoveTo(goTo)) {
                    positionChanged(this.vector, goTo);
                    this.vector = goTo;
                }
            }
        }

    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newpos) {
        {
            for (var observer : observers) {
                observer.positionChanged(oldPosition, newpos);
            }
        }
    }
}
