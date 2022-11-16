package agh.ics.oop;
public class Grass extends AbstractMapElement {
    private Vector2d position;

    public Grass(Vector2d vector) {
        this.position=vector;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String getType() {
        return "G";
    }

    @Override
    public String toString(){
        return "*";
    }
}
