package agh.ics.oop;


public class World {

    public static void main(String[] array) {


        MoveDirection[] directions = OptionsParser.parse(array);
//       IWorldMap map = new RectangularMap(12, 16);
        AbstractWorldMap map = new GrassField(20);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(9, 7),new Vector2d(7, 8),new Vector2d(1, 1),new Vector2d(6, 5),new Vector2d(6, 12),new Vector2d(10, 10)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
        IEngine engine = new SimulationEngineFrame(directions, map, positions);
        engine.run();

    }
}