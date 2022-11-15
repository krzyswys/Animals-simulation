package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public abstract class AbstractWorldMap implements IWorldMap {
    public IWorldMap map;
    private LinkedList<Animal> animals = new LinkedList<>();
    public List<Grass> grasses = new LinkedList<>();
    public List<Grass> removedGrass = new LinkedList<>();
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
            grasses.add(new Grass(position));
        }
    }
    public void removeobjectAt(Vector2d position) {

        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                removedGrass.add(grass);
                grasses.remove(grass);
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
        for (Grass g : grasses) {
            Vector2d position = g.getPosition();
            if (position.upperRight(gp).follows(position)) {
                gp = position.upperRight(gp);
            }
        }
        Vector2d an = new Vector2d(0, 0);
        for (Animal animal : animals) {

            Vector2d position = animal.getPosition();
            if (position.upperRight(an).follows(position)) {
                an = position.upperRight(an);
            }
        }


        return an.upperRight(gp);
    }
    public Vector2d LeftcheckEdges() {
        Vector2d gp = new Vector2d(0, 0);
        for (Grass g : grasses) {
            Vector2d position = g.getPosition();
            if (position.lowerLeft(gp).precedes((position))) {
                gp = position.lowerLeft(gp);
            }
        }
        Vector2d an = new Vector2d(0, 0);
        for (Animal animal : animals) {

            Vector2d position = animal.getPosition();
            if (position.lowerLeft(an).precedes(position)) {
                an = position.lowerLeft(an);
            }
        }
        return an.lowerLeft(gp);
    }

    @Override
    public String toString() {
        return visualizer.draw(getLeftEdge(), getRightEgde());
    }

    @Override
    public Grass[] getGrass() {
        return grasses.toArray(new Grass[0]);
    }
    @Override
    public Grass[] getRemovedGrass() {
        return removedGrass.toArray(new Grass[0]);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass g : grasses) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }

        for (Animal animal : animals) {
            if (animal.vector.equals(position)) {
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
        animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position))
                return grass;
        }
        for (Animal animal : animals) {
            if (animal.vector.equals(position)) {
                return animal;
            }
        }
        return null;
    }



}
