package agh.ics.oop;


public class World {

    public static void main(String[] array) {

//        b l f f b b f f r f f f f l f f f f r b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r

        MoveDirection[] directions = OptionsParser.parse(array);
//       IWorldMap map = new RectangularMap(12, 16);
        AbstractWorldMap map = new GrassField(20);

        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(9, 7),new Vector2d(7, 8),new Vector2d(1, 1),new Vector2d(6, 5),new Vector2d(6, 12),new Vector2d(10, 10)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
        IEngine engine = new SimulationEngineFrame(directions, map, positions);
        engine.run();

    }
}