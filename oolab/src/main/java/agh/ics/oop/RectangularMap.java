package agh.ics.oop;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class RectangularMap implements IWorldMap {
    private Vector2d rightEgde;
    private Vector2d leftEdge;
    private MapVisualizer visualizer = new MapVisualizer(this);
    private LinkedList<Animal> animals = new LinkedList<>();

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            rightEgde = new Vector2d(width, height);
            leftEdge = new Vector2d(0, 0);
        } else if (width < 0 || height < 0) {
            rightEgde = new Vector2d(abs(width), abs(height));
            leftEdge = new Vector2d(0, 0);
        }

    }

    public Vector2d getRightEgde() {
        return rightEgde;
    }

    public Vector2d getLeftEdge() {
        return leftEdge;
    }

    public String toString() {
        return visualizer.draw(leftEdge, rightEgde);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.vector.equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) {
            return false;
        } else return position.follows(leftEdge) && position.precedes(rightEgde);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.isOccupied(animal.vector) || animal.vector.precedes(leftEdge) || animal.vector.follows(rightEgde)) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Animal animal : animals) {
            if (animal.vector.equals(position)) {
                return animal;
            }
        }
        return null;

    }

}
