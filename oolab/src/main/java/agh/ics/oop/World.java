package agh.ics.oop;
public class World {
    public static void run(Direction[] args){
        System.out.println("Start");

        for (Direction direction : args) {
            switch (direction) {
                case F -> System.out.println("Zwierzak idzie do przodu");
                case R -> System.out.println("Zwierzak skręca w prawo");
                case L -> System.out.println("Zwierzak skręca w lewo");
                case B -> System.out.println("Zwierzak idzie do tyłu");
                default -> System.out.println("Brak takiego ruchu");
            }
        }

        System.out.println("Stop");
    }
    public static void main(String[] array) {
        System.out.println("System wystartował");

        if (array.length>=2){

            Direction[] d = new Direction[array.length];
            for(int i=0; i<array.length; i++){
                d[i] = Direction.valueOf(array[i]);
            }
            run(d);
        }
        else {
            System.out.println("Zbyt mało argumentów aby się poruszać");
            Vector2d position1 = new Vector2d(1, 2);
            System.out.println(position1);
            Vector2d position2 = new Vector2d(-2, 1);
            System.out.println(position2);
            System.out.println(position1.add(position2));

//        System.out.println(position1.equals(position1));
//        Vector2d position3 = new Vector2d(-1, 5);
//        System.out.println(position1.upperRight(position3));
//        Vector2d position4 = new Vector2d(3, 4);
//        System.out.println(position3.lowerLeft(position4));
//        System.out.println(position3.opposite());
//        System.out.println(position1.hashCode());
//        System.out.println(position2.hashCode());
//        System.out.println(position3.hashCode());
//        System.out.println(position4.hashCode());
//        System.out.println(MapDirection.EAST.next());
//        System.out.println(MapDirection.EAST.toString());
//        System.out.println(MapDirection.EAST.previous());
//        System.out.println(MapDirection.EAST.toUnitVector());
        }
        System.out.print("System zakończył działanie");
    }
}