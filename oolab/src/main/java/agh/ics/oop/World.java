package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] array) {
        System.out.println("system has started\n");

        Application.launch(App.class, array);

        System.out.println("\nsystem has stopped");

//        MoveDirection[] directions = OptionsParser.parse(array);
////       IWorldMap map = new RectangularMap(12, 16);
//        AbstractWorldMap map = new GrassField(10);
//        Vector2d[] positions = {new Vector2d(2, 2),new Vector2d(3, 4)};
////        IEngine engine = new SimulationEngine(directions, map, positions);
//        IEngine engine = new SimulationEngineFrame(directions, map, positions);
////            Application.launch(App.class, array);
//        engine.run();

        //zamiast sorted set to treeset?
        //new treeSet<>(Comparator.comparing(Vector2d)::getX())
        //treesety maja przechowuwac wektory 2D i maj abyc posrotwoane jeden wzłuż osi Xi  drugi w osi Ymin->max
        //map boundaies zwraca gorne granice i dolne granice
        //ostani element treeseta i ostatni element i x, tak samo z y
        //getter i setter do wektorów 2d dal x-ow

        //zwierzakiem bedize label
        //stworzyc custom label ktora dzidiczy po label ktora nadpisuje jakies rzeczy
        //gridPane
        //komponent timeline dla javyFX, event handler
    }
}