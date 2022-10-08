package agh.ics;


class World { //to musi być takie jak nazwa pliku
    public static void run(String[] args){
        System.out.println("Start");
        for(int i=0; i< args.length; i++){
            if(args[i].equals("f")){
                System.out.println("Zwierzak idzie do przodu");
            } else if (args[i].equals("r")) {
                System.out.println("Zwierzak skręca w prawo");
            }
            else if (args[i].equals("l")) {
                System.out.println("Zwierzak skręca w lewo");
            }
            else if (args[i].equals("b")) {
                System.out.println("Zwierzak idzie do tyłu");
            }
        }
        System.out.println("Stop");
    }

    public static void main(String[] array) { // to jest jak zwykła funkcja
        System.out.println("System wystartował");
//        String[] some_array = new String[2];
//        String[] array = new String[] {"f","r","l", "b","f","f"};
        if (array.length>=2){
            run(array);
        }
        else {
            System.out.println("Zbyt mało argumentów aby się poruszać");

        }
        System.out.print("System zakończył działanie");

    }
}