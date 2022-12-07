package agh.ics.oop;


import java.util.LinkedList;


public class SimulationEngine implements IEngine, Runnable {


    public MoveDirection[] directions;
    public AbstractWorldMap map;
    public Vector2d[] positions;
    boolean go =false;
    private final LinkedList<Animal> animals = new LinkedList<>();


    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap mapa, Vector2d[] pos) {
        map = mapa;
        this.positions = pos;
        int numOfAnimals = positions.length;
        map.addGrass(map.bound(0));

        for (int i = 0; i < numOfAnimals; i++) {
            Animal man = new Animal(map, positions[i]);
            animals.add(man);
            map.place(man);
            man.positionChanged(man.getPosition(),man.getPosition());
            map.positionChanged(man.getPosition(),man.getPosition());
        }
    }

    public IWorldMap getMap() {
        return this.map;
    }


    public void run() {

        int j = 0;
        if(go){

            for (MoveDirection o : directions) {
            if (j == positions.length) {
                j = 0;
            }
                Animal man = animals.get(j);
                Vector2d old = man.getPosition();
                map.moveAnimal(man,o);
                man.positionChanged(old, man.getPosition());
                map.positionChanged(old, man.getPosition());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
//                System.out.println(map.toString());
                j++;
            }

        }
    }
    public LinkedList<Animal> getAnimals(){
        return animals;
    }
    public Vector2d[] getE(){
        return map.checkEdges();
    }
    public Grass[] getGrass(){
        return map.getGrass();
    }
    public void applyMoves(MoveDirection[] dir){
        directions = dir;
        changeStatus();
    }
    public void changeStatus(){
        go=true;
    }

}