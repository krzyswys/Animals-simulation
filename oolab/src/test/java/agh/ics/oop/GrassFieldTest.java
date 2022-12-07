//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GrassFieldTest {
//
//    @Test
//    void getRightEgde() {
//        AbstractWorldMap map = new GrassField(5);
//        String[] move = {};
//        MoveDirection[] dir = OptionsParser.parse(move);
//        Vector2d[] sPos = {};
//        IEngine engine = new SimulationEngine(dir, map, sPos);
//        engine.run();
//        assertEquals(map.getRightEgde().x, map.edges()[0].x);
//        assertEquals(map.getRightEgde().y, map.edges()[0].y);
//    }
//
//    @Test
//    void getLeftEdge() {
//        AbstractWorldMap map = new GrassField(5);
//        String[] move = {};
//        MoveDirection[] dir = OptionsParser.parse(move);
//        Vector2d[] sPos = {};
//        IEngine engine = new SimulationEngine(dir, map, sPos);
//        engine.run();
//        assertEquals(map.getLeftEdge().x, map.edges()[1].x);
//        assertEquals(map.getLeftEdge().y, map.edges()[1].y);
//    }
//
//    @Test
//    void getGrass(){
//        AbstractWorldMap map = new GrassField(5);
//        String[] move = {};
//        MoveDirection[] dir = OptionsParser.parse(move);
//        Vector2d[] sPos = {};
//        IEngine engine = new SimulationEngine(dir, map, sPos);
//        engine.run();
//        assertEquals(map.getGrass().size(), 5);
//    }
//}