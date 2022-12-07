package agh.ics.oop;

import java.util.*;


public class MapBoundary implements IPositionChangeObserver {
    private SortedSet<Vector2d> xAxis;
    private SortedSet<Vector2d> yAxis;
    public MapBoundary(){
        xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
        yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    }
    public void addElement(Vector2d vect){

        xAxis.add(vect);
        yAxis.add(vect);
    }
    public void removeElement(Vector2d vect){
        xAxis.remove(vect);
        yAxis.remove(vect);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
//        if ((oldPosition.x == getFirstXPosition() || oldPosition.x == getLastXPosition()) &&
//                oldPosition.x != newPosition.x) {
            removeElement(oldPosition);
            addElement(newPosition);
//        }

//        if ((oldPosition.y == getFirstYPosition() || oldPosition.y == getLastYPosition()) &&
//                oldPosition.y != newPosition.y) {
//            sortByY();
//        }
    }
    public int getFirstXPosition(){
        return xAxis.first().x;
    }
    public int getLastXPosition(){
        return xAxis.last().x;
    }
    public int getFirstYPosition(){
        return yAxis.first().y;
    }
    public int getLastYPosition(){
        return yAxis.last().y;
    }
}