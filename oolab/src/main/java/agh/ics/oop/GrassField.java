package agh.ics.oop;


public class GrassField extends AbstractWorldMap {
    public IWorldMap map;
    public int bound;
    public GrassField(int noFields) {
        bound = bound(noFields);
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
                    removeobjectAt(position);
                    return true;
                }

            }
        return true;

    }

}
