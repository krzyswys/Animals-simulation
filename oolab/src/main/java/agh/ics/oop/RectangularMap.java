package agh.ics.oop;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d rightEgde;
    private Vector2d leftEdge;

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            rightEgde = new Vector2d(width, height);
            leftEdge = new Vector2d(0, 0);
        } else if (width < 0 || height < 0) {
            rightEgde = new Vector2d(abs(width), abs(height));
            leftEdge = new Vector2d(0, 0);
        }
    }
    @Override
    public Vector2d getRightEgde() {
        return rightEgde;
    }

    @Override
    public Vector2d getLeftEdge() {
        return leftEdge;
    }

    @Override
    public boolean moveAnimal(Animal animal, MoveDirection o) {
        animal.move(o);
        if(o.equals(MoveDirection.BACKWARD) || o.equals(MoveDirection.FORWARD)){
            return true;
        }return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) {
            return false;
        } else return position.follows(leftEdge) && position.precedes(rightEgde);
    }

    @Override
    public Vector2d[] edges() {
        return new Vector2d[0];
    }


}
