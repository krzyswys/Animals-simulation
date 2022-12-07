package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    public IWorldMap map;
    public int noFiled;
    public MapBoundary mapRam = new MapBoundary();
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
    public boolean moveAnimal(Animal animal, MoveDirection o) {
        Vector2d old = animal.getPosition();
        animal.move(o);
        positionChanged(old, animal.getPosition());
        if(o.equals(MoveDirection.BACKWARD) || o.equals(MoveDirection.FORWARD)){
            return true;
        }return false;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        Animal man = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, man);
        mapRam.positionChanged(oldPosition, newPosition);
    }

    public void addGrass(int numberOfFields) {
        Random random = new Random();

        Vector2d position;

        for (int i = 0; i < numberOfFields; i++) {
            do {
                position = new Vector2d(random.nextInt(bound(0)), random.nextInt(bound(0)));
            } while (isOccupied(position));
            grass.put(position, new Grass(position));

            mapRam.addElement(position);
        }
    }

    public void removeobjectAt(Vector2d position) {
        removedGrass.put(position, grass.get(position));
        grass.remove(position);
        mapRam.removeElement(position);
        addGrass(1);
    }

    public abstract Vector2d[] edges();

    public Vector2d[] checkEdges() {
        Vector2d gp = new Vector2d(mapRam.getLastXPosition(), mapRam.getLastYPosition());
        Vector2d gpg = new Vector2d(mapRam.getFirstXPosition(), mapRam.getFirstYPosition());
        return new Vector2d[]{gp, gpg};
    }


    @Override
    public String toString() {
        return visualizer.draw(getLeftEdge(), getRightEgde());
    }

    @Override
    public Grass[] getGrass() {
        return grass.values().toArray(new Grass[0]);
    }
    @Override
    public Animal[] getAnimals() {
        System.out.println(animals.size());
        return animals.values().toArray(new Animal[0]);
    }

    @Override
    public Grass[] getRemovedGrass() {
        return removedGrass.values().toArray(new Grass[0]);
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
//            return false;
            throw new IllegalArgumentException("Błędne pole przy stawianiu animala: "+animal.vector.toString());
        }
            animal.addObserver(this);
            animals.put(animal.vector, animal);
            mapRam.addElement(animal.vector);
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