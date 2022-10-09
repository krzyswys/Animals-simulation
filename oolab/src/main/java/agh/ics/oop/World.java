package agh.ics.oop;

public class World {
    public static void run(String[] args){
        System.out.println("Start");

        for (String argumenty : args) {
            switch (argumenty) {
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "r" -> System.out.println("Zwierzak skręca w prawo");
                case "l" -> System.out.println("Zwierzak skręca w lewo");
                case "b" -> System.out.println("Zwierzak idzie do tyłu");
            }
        }

        System.out.println("Stop");
    }

    public static void main(String[] array) {
        System.out.println("System wystartował");

        if (array.length>=2){
            run(array);
        }
        else {
            System.out.println("Zbyt mało argumentów aby się poruszać");
        }

        System.out.print("System zakończył działanie");

    }
}