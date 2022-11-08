package agh.ics.oop;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        MoveDirection[] dir =  new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        assertEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)) );
    }

    @Test
    @Order(2)
    void parseShort(){
        OptionsParserTest.sparseShort();
    }
    public static void sparseShort() {
        String[] array = new String[]{"r", "l", "b", "f"};
        MoveDirection[] dir = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        assertEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));
    }

    @Test
    @Order(3)
    void parseUpperFull(){
        OptionsParserTest.sparseUpperFull();
    }
    static void sparseUpperFull() {
        String[] array = new String[]{"RIGHT", "LEFT", "BACKWARD", "FORWARD"};
        MoveDirection[] dir = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        assertNotEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));
    }

    @Test
    @Order(4)
    void parseUpperShort(){
        OptionsParserTest.sparseUpperShort();
    }
    static void sparseUpperShort() {
        String[] array = new String[]{"R", "L", "B", "F"};
        MoveDirection[] dir = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        assertNotEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));

    }

    @Test
    @Order(5)
    void parseMixed(){
        OptionsParserTest.sparseMixed();
    }
    static void sparseMixed() {
        String[] array = new String[]{"right", "L", "backward", "string", "right", "f", "f", "asdasd", "null"};
        MoveDirection[] dir = new MoveDirection[]{
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD};
        assertEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));

    }

    @Test
    @Order(6)
    void parseNoneMix(){
        OptionsParserTest.sparseNoneMix();
    }
    static void sparseNoneMix() {
        String[] array = new String[]{"rigsht", "L", "backwaards", "string", "rigfht", "af", "fs", "asdasd", "null"};
        MoveDirection[] dir = new MoveDirection[]{};
        assertEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));

    }

    @Test
    @Order(7)
    void parseNone(){
        OptionsParserTest.sparseNone();
    }
    static void sparseNone() {
        String[] array = new String[]{};
        MoveDirection[] dir = new MoveDirection[]{};
        assertEquals(Arrays.toString(dir), Arrays.toString(OptionsParser.parse(array)));

    }

}