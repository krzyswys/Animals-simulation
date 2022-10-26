package agh.ics.oop;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    @Order(1)
    void parseFull(){
        OptionsParserTest.sparseFull();
    }
     static void sparseFull() {
        String[] array = new String[]{"right", "left", "backward", "forward"};
        List<MoveDirection> dir = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertEquals(dir, OptionsParser.parse(array));
    }

    @Test
    @Order(2)
    void parseShort(){
        OptionsParserTest.sparseShort();
    }
    public static void sparseShort() {
        String[] array = new String[]{"r", "l", "b", "f"};
        List<MoveDirection> dir = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertEquals(dir, OptionsParser.parse(array));
    }

    @Test
    @Order(3)
    void parseUpperFull(){
        OptionsParserTest.sparseUpperFull();
    }
    static void sparseUpperFull() {
        String[] array = new String[]{"RIGHT", "LEFT", "BACKWARD", "FORWARD"};
        List<MoveDirection> dir = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertNotEquals(dir, OptionsParser.parse(array));
    }

    @Test
    @Order(4)
    void parseUpperShort(){
        OptionsParserTest.sparseUpperShort();
    }
    static void sparseUpperShort() {
        String[] array = new String[]{"R", "L", "B", "F"};
        List<MoveDirection> dir = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertNotEquals(dir, OptionsParser.parse(array));

    }

    @Test
    @Order(5)
    void parseMixed(){
        OptionsParserTest.sparseMixed();
    }
    static void sparseMixed() {
        String[] array = new String[]{"right", "L", "backward", "string", "right", "f", "f", "asdasd", "null"};
        List<MoveDirection> dir = List.of(
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD);
        assertEquals(dir, OptionsParser.parse(array));

    }

    @Test
    @Order(6)
    void parseNoneMix(){
        OptionsParserTest.sparseNoneMix();
    }
    static void sparseNoneMix() {
        String[] array = new String[]{"rigsht", "L", "backwaards", "string", "rigfht", "af", "fs", "asdasd", "null"};
        List<MoveDirection> dir = List.of();
        assertEquals(dir, OptionsParser.parse(array));

    }

    @Test
    @Order(7)
    void parseNone(){
        OptionsParserTest.sparseNone();
    }
    static void sparseNone() {
        String[] array = new String[]{};
        List<MoveDirection> dir = List.of();
        assertEquals(dir, OptionsParser.parse(array));

    }

}