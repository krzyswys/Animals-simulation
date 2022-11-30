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
        MoveDirection move = null;
             return switch (value) {
            case "f", "forward" -> move = MoveDirection.FORWARD;
            case "b", "backward" -> move = MoveDirection.BACKWARD;
            case "r", "right" -> move = MoveDirection.RIGHT;
            case "l", "left" -> move = MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(value + " is not legal move specification");
        };

    }
}

