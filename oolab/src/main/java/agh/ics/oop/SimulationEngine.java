package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine {

    public MoveDirection[] directions;
    public IWorldMap map;
    public Vector2d[] positions;
    private LinkedList<Animal> animals = new LinkedList<>();


    public SimulationEngine(MoveDirection[] directions, IWorldMap mapa, Vector2d[] pos) {
        this.directions = directions;
        this.map = mapa;
        this.positions = pos;

    }
    public IWorldMap getMap(){
        return this.map;
    }

    @Override
    public void run() {
        int numOfAnimals = positions.length;
        for (int i = 0; i < numOfAnimals; i++) {
            Animal man = new Animal(map, positions[i]);
//            map.place(man);
            System.out.println(positions[i].toString());
            animals.add(man);

        }
        System.out.println(map.toString());

        int j = 0;
        for (MoveDirection o : directions) {
            if (j == numOfAnimals) {
                j = 0;
            }
            Animal man = animals.get(j);
            man.move(o);
            System.out.println(map.toString());
            j++;
        }
    }

}
