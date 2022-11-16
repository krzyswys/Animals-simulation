package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class AbstractWorldMap implements IWorldMap {
    public IWorldMap map;
    public List<IMapElement> elements = new LinkedList<>();
    public List<IMapElement> removedGrass = new LinkedList<>();
    public int noFiled;
    private MapVisualizer visualizer = new MapVisualizer(this);


    public abstract Vector2d getRightEgde();

    public abstract Vector2d getLeftEdge();

    public abstract boolean canMoveTo(Vector2d position);

    public int bound(int numOfFields) {
        if (numOfFields != 0) {
            noFiled = numOfFields;

        }
        return (int) Math.sqrt(10 * noFiled) + 1;
    }

    public void addGrass(int numberOfFields) {
        Random random = new Random();

        Vector2d position;

        for (int i = 0; i < numberOfFields; i++) {
            do {
                position = new Vector2d(random.nextInt(bound(0)), random.nextInt(bound(0)));
            } while (isOccupied(position));
            elements.add(new Grass(position));
        }
    }
    public void removeobjectAt(Vector2d position) {
        for (IMapElement grass : elements) {
            if (grass.getPosition().equals(position)) {
                removedGrass.add(grass);
                elements.remove(grass);
                addGrass(1);
                break;
            }
        }
    }
    public abstract Vector2d[] edges();
    public Vector2d[] checkEdges() {
        Vector2d h = RightcheckEdges();
        Vector2d hh = LeftcheckEdges();
        return new Vector2d[]{h,hh};
    }
    public Vector2d RightcheckEdges() {
        Vector2d gp = new Vector2d(0, 0);
        for (IMapElement g : elements) {
            Vector2d position = g.getPosition();
            if (position.upperRight(gp).follows(position)) {
                gp = position.upperRight(gp);
            }
        }return gp;

    }
    public Vector2d LeftcheckEdges() {
        Vector2d gp = new Vector2d(0, 0);
        for (IMapElement g : elements) {
            Vector2d position = g.getPosition();
            if (position.lowerLeft(gp).precedes((position))) {
                gp = position.lowerLeft(gp);
            }
        }return gp;
    }

    @Override
    public String toString() {
        return visualizer.draw(getLeftEdge(), getRightEgde());
    }

    @Override
    public IMapElement[] getGrass() {
        List<IMapElement> grass= new LinkedList<>();
        for (IMapElement g: elements) {
            if (g.getType().equals("G")) {
                grass.add(g);
            }
        }
        return grass.toArray(new IMapElement[0]);
    }
    @Override
    public Grass[] getRemovedGrass() {
        return removedGrass.toArray(new Grass[0]);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (IMapElement g: elements) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean place(Animal animal) {

        if ((this.isOccupied(animal.vector) && (objectAt(animal.vector) instanceof Animal)) || animal.vector.precedes(getLeftEdge()) || animal.vector.follows(getRightEgde())) {
            return false;
        }
        elements.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement animal : elements) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }



}