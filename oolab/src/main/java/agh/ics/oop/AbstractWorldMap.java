package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    public IWorldMap map;
    public int noFiled;
    private MapVisualizer visualizer = new MapVisualizer(this);
    public Map<Vector2d, Animal> animals = new HashMap<>();
    public Map<Vector2d, Grass> removedGrass = new HashMap<>();
    public Map<Vector2d, Grass> grass = new HashMap<>();

    public abstract Vector2d getRightEgde();

    public abstract Vector2d getLeftEdge();

    public abstract boolean canMoveTo(Vector2d position);

    public int bound(int numOfFields) {
        if (numOfFields != 0) {
            noFiled = numOfFields;
        }
        return (int) Math.sqrt(10 * noFiled) + 1;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal man = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, man);

    }

    public void addGrass(int numberOfFields) {
        Random random = new Random();

        Vector2d position;

        for (int i = 0; i < numberOfFields; i++) {
            do {
                position = new Vector2d(random.nextInt(bound(0)), random.nextInt(bound(0)));
            } while (isOccupied(position));
            grass.put(position, new Grass(position));
        }
    }

    public void removeobjectAt(Vector2d position) {
        removedGrass.put(position, grass.get(position));
        grass.remove(position);
        addGrass(1);
    }

    public abstract Vector2d[] edges();

    public Vector2d[] checkEdges() {
        Vector2d gp = new Vector2d(bound(0), bound(0));
        Vector2d gpg = new Vector2d(0, 0);
        for (Vector2d position : animals.keySet()) {
            if (position.upperRight(gp).follows(position)) {
                gp = position.upperRight(gp);

            }
            if (position.lowerLeft(gpg).precedes((position))) {
                gpg = position.lowerLeft(gpg);
            }
        }
        return new Vector2d[]{gp, gpg};
    }


    @Override
    public String toString() {
        return visualizer.draw(getLeftEdge(), getRightEgde());
    }

    @Override
    public Map<Vector2d, Grass> getGrass() {
        return grass;
    }

    @Override
    public Map<Vector2d, Grass> getRemovedGrass() {
        return removedGrass;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (animals.containsKey(position) || grass.containsKey(position)) {
            return true;
        }
        return false;
    }


    @Override
    public boolean place(Animal animal) {

        if ((this.isOccupied(animal.vector))) {
            return false;
        }
        animal.addObserver(this);
        animals.put(animal.vector, animal);
        return true;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grass.containsKey(position)) {
            return grass.get(position);
        }
        return null;
    }


}