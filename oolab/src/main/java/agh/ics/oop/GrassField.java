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
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position) ) {
            if ((objectAt(position)).getType().equals("A")) {
                return false;
            } else {
                    removeobjectAt(position);
                    System.out.println("REMOVED");
                    return true;
                }

            }
        return true;

    }

}
