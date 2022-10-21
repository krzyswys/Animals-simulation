package agh.ics.oop;

import java.util.List;

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
            List<MoveDirection> dir = OptionsParser.parse(array);
//            for (MoveDirection o : dir) {
//                System.out.println(o);
//            }

            Animal xy = new Animal();
            System.out.println(xy);
            for (MoveDirection o : dir) {
                xy.move(o);
            }
            System.out.println(xy);
        }
        System.out.print("System zakończył działanie");
    }
}