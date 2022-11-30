package agh.ics.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import agh.ics.oop.OptionsParserTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @BeforeAll
    static void parserTest() {
        OptionsParserTest.sparseFull();
        OptionsParserTest.sparseShort();
        OptionsParserTest.sparseUpperFull();
        OptionsParserTest.sparseUpperShort();
        OptionsParserTest.sparseMixed();
        OptionsParserTest.sparseNoneMix();
        OptionsParserTest.sparseNone();
    }
    @Test
    @Order(1)
    void testToStringBasic() {
        assertEquals("(2,2,NORTH)", new Animal(new RectangularMap(4, 4)).toStringWhole());
        assertNotEquals("(2,1,NORTH)",new Animal(new RectangularMap(4, 4)).toStringWhole());
    }

    @Test
    @Order(3)
    void testMoveEgde() {
        Animal y = new Animal(new RectangularMap(4, 4));
        for (int i = 0; i < 4 * 2; i++) {
            y.move(MoveDirection.FORWARD);
        }
        assertEquals("(2,4,NORTH)", y.toStringWhole());

        Animal x = new Animal(new RectangularMap(4, 4));
        x.move(MoveDirection.LEFT);
        for (int i = 0; i < 4 * 2; i++) {
            x.move(MoveDirection.FORWARD);
        }
        assertEquals("(0,2,WEST)", x.toStringWhole());

        Animal z = new Animal(new RectangularMap(4, 4));
        z.move(MoveDirection.RIGHT);
        for (int i = 0; i < 4 * 2; i++) {
            z.move(MoveDirection.FORWARD);
        }
        assertEquals("(4,2,EAST)", z.toStringWhole());

        Animal u = new Animal(new RectangularMap(4, 4));
        for (int i = 0; i < 4 * 2; i++) {
            u.move(MoveDirection.BACKWARD);
        }
        assertEquals("(2,0,NORTH)", u.toStringWhole());

    }

    @Test
    @Order(4)
    void testMoveParser() {
        Animal y = new Animal(new RectangularMap(8, 4));
        String[] yMove = {"f", "f", "f", "r", "r", "b"};
        MoveDirection[] ymove = OptionsParser.parse(yMove);
        for (MoveDirection go : ymove) {
            y.move(go);
        }

        assertEquals("(2,4,SOUTH)", y.toStringWhole());

        Animal x = new Animal(new RectangularMap(4, 3));
        String[] xMove = {"b", "l", "l", "f", "l", "l"};
        MoveDirection[] xmove = OptionsParser.parse(xMove);
        for (MoveDirection go : xmove) {
            x.move(go);
        }

        assertEquals("(2,0,NORTH)", x.toStringWhole());

        Animal z = new Animal(new RectangularMap(5, 4));
        String[] zMove = {"r", "f", "f", "b", "l", "l"};
        MoveDirection[] zmove = OptionsParser.parse(zMove);
        for (MoveDirection go : zmove) {
            z.move(go);
        }

        assertNotEquals("(2,1,WEST)", z.toStringWhole());

        Animal u = new Animal(new RectangularMap(4, 9));
        String[] uMove = {"r", "l", "l", "f", "r", "b"};
        MoveDirection[] umove = OptionsParser.parse(uMove);
        for (MoveDirection go : umove) {
            u.move(go);
        }


        assertNotEquals("(5,1,EAST)", u.toStringWhole());
    }

    @Test
    @Order(5)
    void testIsAtBasic() {
        assertTrue(new Animal(new RectangularMap(4, 4)).isAt(new Vector2d(2, 2)));
        assertFalse(new Animal(new RectangularMap(4, 4)).isAt(new Vector2d(2, -2)));
    }

    @Test
    @Order(6)
    void testIsAtMove() {
        Animal y = new Animal(new RectangularMap(3, 4));
        String[] yMove = {"b", "b", "b", "r", "r", "f"};
        MoveDirection[] ymove = OptionsParser.parse(yMove);
        for (MoveDirection go : ymove) {
            y.move(go);
        }

        assertTrue(y.isAt(new Vector2d(2, 0)));

        Animal x = new Animal(new RectangularMap(4, 4));
        String[] xMove = {"f", "f", "r", "b", "r", "l"};
        MoveDirection[] xmove = OptionsParser.parse(xMove);
        for (MoveDirection go : xmove) {
            x.move(go);
        }

        assertTrue(x.isAt(new Vector2d(1, 4)));

        Animal z = new Animal(new RectangularMap(5, 5));
        String[] zMove = {"r", "f", "f", "b", "l", "l"};
        MoveDirection[] zmove = OptionsParser.parse(zMove);
        for (MoveDirection go : zmove) {
            z.move(go);
        }
        assertFalse(z.isAt(new Vector2d(1, 4)));

        Animal u = new Animal(new RectangularMap(6, 4));
        String[] uMove = {"r", "r", "r", "l", "l", "l"};
        MoveDirection[] umove = OptionsParser.parse(uMove);
        for (MoveDirection go : umove) {
            u.move(go);
        }
        assertFalse(u.isAt(new Vector2d(-2, -2)));
    }


}