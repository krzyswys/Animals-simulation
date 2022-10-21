package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseFull() {
        String[] array = new String[]{"right", "left", "backward", "forward"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertEquals(expected, OptionsParser.parse(array));
    }

    @Test
    void parseShort() {
        String[] array = new String[]{"r", "l", "b", "f"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertEquals(expected, OptionsParser.parse(array));
    }

    @Test
    void parseUpperFull() {
        String[] array = new String[]{"RIGHT", "LEFT", "BACKWARD", "FORWARD"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertNotEquals(expected, OptionsParser.parse(array));
    }

    @Test
    void parseUpperShort() {
        String[] array = new String[]{"R", "L", "B", "F"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD);
        assertNotEquals(expected, OptionsParser.parse(array));

    }

    @Test
    void parseMixed() {
        String[] array = new String[]{"right", "L", "backward", "string", "right", "f", "f", "asdasd", "null"};
        List<MoveDirection> expected = List.of(
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD);
        assertEquals(expected, OptionsParser.parse(array));

    }

    @Test
    void parseNoneMix() {
        String[] array = new String[]{"rigsht", "L", "backwaards", "string", "rigfht", "af", "fs", "asdasd", "null"};
        List<MoveDirection> expected = List.of();
        assertEquals(expected, OptionsParser.parse(array));

    }

    @Test
    void parseNone() {
        String[] array = new String[]{};
        List<MoveDirection> expected = List.of();
        assertEquals(expected, OptionsParser.parse(array));

    }
}