package agh.ics.oop;

import java.util.*;
import java.util.stream.Collectors;


public class OptionsParser {
    public static MoveDirection[] parse(String[] array) {
        return Arrays.stream(array)
                .map(OptionsParser::toEnum)
                .filter(item -> item != MoveDirection.NULL)
                .collect(Collectors.toList()).toArray(new MoveDirection[0]);
    }

    public static MoveDirection toEnum(String value) {
        return switch (value) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> MoveDirection.NULL;
        };
    }
}

