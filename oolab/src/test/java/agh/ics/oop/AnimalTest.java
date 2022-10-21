package agh.ics.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import agh.ics.oop.OptionsParserTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest { //test dependancies?
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
    @Order(2)
    void testToStringBasic() {
        assertEquals("(2,2,NORTH)", new Animal().toString());
        assertNotEquals("(2,1,NORTH)", new Animal().toString());
    }

    @Test
    @Order(2)
    void testToStringConstructor() {
        assertEquals("(2,1,SOUTH)", new Animal(new Vector2d(2, 1), MapDirection.SOUTH).toString());
        assertEquals("(2,2,NORTH)", new Animal(new Vector2d(-2, -1), MapDirection.SOUTH).toString());
        assertNotEquals("(-2,-1,SOUTH)", new Animal(new Vector2d(-2, -1), MapDirection.SOUTH).toString());
        assertNotEquals("(5,6,WEST)", new Animal(new Vector2d(5, 6), MapDirection.WEST).toString());
    }

    @Test
    @Order(3)
    void testMoveEgde() {
        Animal y = new Animal();
        for (int i = 0; i < 4 * 2; i++) {
            y.move(MoveDirection.FORWARD);
        }
        assertEquals("(2,4,NORTH)", y.toString());

        Animal x = new Animal();
        x.move(MoveDirection.LEFT);
        for (int i = 0; i < 4 * 2; i++) {
            x.move(MoveDirection.FORWARD);
        }
        assertEquals("(0,2,WEST)", x.toString());

        Animal z = new Animal();
        z.move(MoveDirection.RIGHT);
        for (int i = 0; i < 4 * 2; i++) {
            z.move(MoveDirection.FORWARD);
        }
        assertEquals("(4,2,EAST)", z.toString());

        Animal u = new Animal();
        for (int i = 0; i < 4 * 2; i++) {
            u.move(MoveDirection.BACKWARD);
        }
        assertEquals("(2,0,NORTH)", u.toString());

    }

    @Test
    @Order(4)
    void testMoveParser() {
        Animal y = new Animal();
        String[] yMove = {"f", "f", "f", "r", "r", "b"};
        List<MoveDirection> ymove = OptionsParser.parse(yMove);
        for (MoveDirection go : ymove) {
            y.move(go);
        }
//        y.move(MoveDirection.FORWARD);
//        y.move(MoveDirection.FORWARD);
//        y.move(MoveDirection.FORWARD);
//        y.move(MoveDirection.RIGHT);
//        y.move(MoveDirection.RIGHT);
//        y.move(MoveDirection.BACKWARD);
        assertEquals("(2,4,SOUTH)", y.toString());

        Animal x = new Animal();
        String[] xMove = {"b", "l", "l", "f", "l", "l"};
        List<MoveDirection> xmove = OptionsParser.parse(xMove);
        for (MoveDirection go : xmove) {
            x.move(go);
        }
//        x.move(MoveDirection.BACKWARD);
//        x.move(MoveDirection.LEFT);
//        x.move(MoveDirection.LEFT);
//        x.move(MoveDirection.FORWARD);
//        x.move(MoveDirection.LEFT);
//        x.move(MoveDirection.LEFT);
        assertEquals("(2,0,NORTH)", x.toString());

        Animal z = new Animal();
        String[] zMove = {"r", "f", "f", "b", "l", "l"};
        List<MoveDirection> zmove = OptionsParser.parse(zMove);
        for (MoveDirection go : zmove) {
            z.move(go);
        }
//        z.move(MoveDirection.RIGHT);
//        z.move(MoveDirection.FORWARD);
//        z.move(MoveDirection.FORWARD);
//        z.move(MoveDirection.BACKWARD);
//        z.move(MoveDirection.LEFT);
//        z.move(MoveDirection.LEFT);
        assertNotEquals("(2,1,WEST)", z.toString());

        Animal u = new Animal();
        String[] uMove = {"r", "l", "l", "f", "r", "b"};
        List<MoveDirection> umove = OptionsParser.parse(uMove);
        for (MoveDirection go : umove) {
            u.move(go);
        }
//        u.move(MoveDirection.RIGHT);
//        u.move(MoveDirection.LEFT);
//        u.move(MoveDirection.LEFT);
//        u.move(MoveDirection.FORWARD);
//        u.move(MoveDirection.RIGHT);
//        u.move(MoveDirection.BACKWARD);

        assertNotEquals("(5,1,EAST)", u.toString());
    }

    @Test
    @Order(5)
    void testIsAtBasic() {
        assertTrue(new Animal().isAt(new Vector2d(2, 2)));
        assertFalse(new Animal().isAt(new Vector2d(2, -2)));
    }

    @Test
    @Order(6)
    void testIsAtMove() {
        Animal y = new Animal();
        String[] yMove = {"b", "b", "b", "r", "r", "f"};
        List<MoveDirection> ymove = OptionsParser.parse(yMove);
        for (MoveDirection go : ymove) {
            y.move(go);
        }
//        y.move(MoveDirection.BACKWARD);
//        y.move(MoveDirection.BACKWARD);
//        y.move(MoveDirection.BACKWARD);
//        y.move(MoveDirection.RIGHT);
//        y.move(MoveDirection.RIGHT);
//        y.move(MoveDirection.FORWARD);
        assertTrue(y.isAt(new Vector2d(2, 0)));

        Animal x = new Animal();
        String[] xMove = {"f", "f", "r", "b", "r", "l"};
        List<MoveDirection> xmove = OptionsParser.parse(xMove);
        for (MoveDirection go : xmove) {
            x.move(go);
        }
//        x.move(MoveDirection.FORWARD);
//        x.move(MoveDirection.FORWARD);
//        x.move(MoveDirection.RIGHT);
//        x.move(MoveDirection.BACKWARD);
//        x.move(MoveDirection.RIGHT);
//        x.move(MoveDirection.LEFT);
        assertTrue(x.isAt(new Vector2d(1, 4)));

        Animal z = new Animal();
        String[] zMove = {"r", "f", "f", "b", "l", "l"};
        List<MoveDirection> zmove = OptionsParser.parse(zMove);
        for (MoveDirection go : zmove) {
            z.move(go);
        }
//        z.move(MoveDirection.RIGHT);
//        z.move(MoveDirection.FORWARD);
//        z.move(MoveDirection.FORWARD);
//        z.move(MoveDirection.BACKWARD);
//        z.move(MoveDirection.LEFT);
//        z.move(MoveDirection.LEFT);
        assertFalse(z.isAt(new Vector2d(1, 4)));

        Animal u = new Animal();
        String[] uMove = {"r", "r", "r", "l", "l", "l"};
        List<MoveDirection> umove = OptionsParser.parse(uMove);
        for (MoveDirection go : umove) {
            u.move(go);
        }
//        u.move(MoveDirection.RIGHT);
//        u.move(MoveDirection.RIGHT);
//        u.move(MoveDirection.RIGHT);
//        u.move(MoveDirection.LEFT);
//        u.move(MoveDirection.LEFT);
//        u.move(MoveDirection.LEFT);
        assertFalse(u.isAt(new Vector2d(-2, -2)));
    }


}