package agh.ics.oop;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class World {
   static JButton[] button = new JButton[50];

    public static void main(String[] array) {


        MoveDirection[] directions =  OptionsParser.parse(array);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }
}