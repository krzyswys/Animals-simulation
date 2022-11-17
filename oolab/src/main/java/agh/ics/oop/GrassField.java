package agh.ics.oop;


import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap {
    public List<Grass> grasses;
    public IWorldMap map;
    public int bound;
    public GrassField(int noFields) {
        bound = bound(noFields);
        addGrass(noFields);
        this.grasses = new LinkedList<>();
    }
    @Override
    public Vector2d[] edges() {
        return checkEdges();
    }

    @Override
    public Vector2d getRightEgde() {
        return checkEdges()[0];
    }

    @Override
    public Vector2d getLeftEdge() {
        return checkEdges()[1];
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

        if (this.isOccupied(position) ) {
            if ((objectAt(position)).getType().equals("A")) {
                return false;
            } else {
                    grasses.remove(objectAt(position));
                    removeobjectAt(position);
                    return true;
                }

            }
        return true;

    }

}
