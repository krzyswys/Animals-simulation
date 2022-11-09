package agh.ics.oop;


public class World {

    public static void main(String[] array) {


        MoveDirection[] directions =  OptionsParser.parse(array);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1), new Vector2d(4, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }
}