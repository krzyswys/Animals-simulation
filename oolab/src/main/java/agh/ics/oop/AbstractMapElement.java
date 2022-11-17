package agh.ics.oop;

public abstract class AbstractMapElement implements IMapElement{

    protected Vector2d position;
    @Override
    public Vector2d getPosition() {
        return position;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
    }

    @Override
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
}