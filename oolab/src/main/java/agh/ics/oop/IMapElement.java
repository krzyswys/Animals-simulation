package agh.ics.oop;


public interface IMapElement {
    String getImageUrl();
    public Vector2d getPosition();
    public String getType();

    boolean isAt(Vector2d position);
}