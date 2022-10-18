package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(1,2)", new Vector2d(1, 2).toString());
        assertEquals("(60,-1)", new Vector2d(60, -1).toString());
        assertNotEquals("(-1,2)", new Vector2d(1, 2).toString());
        assertNotEquals("2,1", new Vector2d(2, 1).toString());
    }

    @Test
    void precedes_test() {
        assertTrue(new Vector2d(1, 2).precedes(new Vector2d(11, 2)));
        assertTrue(new Vector2d(60, -1).precedes(new Vector2d(60, 0)));
        assertFalse(new Vector2d(4, 20).precedes(new Vector2d(4, 19)));
        assertFalse(new Vector2d(2, 50).precedes(new Vector2d(1, 1)));

    }

    @Test
    void follows_test() {
        assertTrue(new Vector2d(1, 22).follows(new Vector2d(1, 2)));
        assertTrue(new Vector2d(60, 70).follows(new Vector2d(5, -2)));
        assertFalse(new Vector2d(2, 1).follows(new Vector2d(3, 7)));
        assertFalse(new Vector2d(-6, -6).follows(new Vector2d(-6, -5)));

    }

    @Test
    void add_test() {
        assertEquals(new Vector2d(2,24),new Vector2d(1, 22).add(new Vector2d(1, 2)));
        assertEquals(new Vector2d(21,-37),new Vector2d(15, -6).add(new Vector2d(6, -31)));
        assertNotEquals(new Vector2d(234,123),new Vector2d(172, 2452).add(new Vector2d(17, -24)));
        assertNotEquals(new Vector2d(72,2234),new Vector2d(1234, -2622).add(new Vector2d(11, 32)));

    }

    @Test
    void subtract_test() {
        assertEquals(new Vector2d(0,20),new Vector2d(1, 22).subtract(new Vector2d(1, 2)));
        assertEquals(new Vector2d(-8,0),new Vector2d(-25, 22).subtract(new Vector2d(-17, 22)));
        assertNotEquals(new Vector2d(165,210),new Vector2d(1341, 2722).subtract(new Vector2d(34, 25)));
        assertNotEquals(new Vector2d(2845,173),new Vector2d(825, 714).subtract(new Vector2d(914, 914)));

    }

    @Test
    void upperRight_test() {
        assertEquals(new Vector2d(1,20),new Vector2d(-3, 20).upperRight(new Vector2d(1, 20)));
        assertEquals(new Vector2d(1,70),new Vector2d(-3, 14).upperRight(new Vector2d(1, 70)));
        assertNotEquals(new Vector2d(141,70),new Vector2d(-3, 14).upperRight(new Vector2d(1, 70)));
        assertNotEquals(new Vector2d(-141,46),new Vector2d(6, 10).upperRight(new Vector2d(5, 7)));

    }

    @Test
    void lowerLeft_test() {
        assertEquals(new Vector2d(-1,2),new Vector2d(-1, 20).lowerLeft(new Vector2d(10, 2)));
        assertEquals(new Vector2d(5,6),new Vector2d(5, 60).lowerLeft(new Vector2d(5, 6)));
        assertNotEquals(new Vector2d(2364,1),new Vector2d(86, 93).lowerLeft(new Vector2d(67, 23)));
        assertNotEquals(new Vector2d(71,39),new Vector2d(298, 935).lowerLeft(new Vector2d(123, 93)));

    }

    @Test
    void opposite_test() {
        assertEquals(new Vector2d(-1, -2), new Vector2d(1, 2).opposite());
        assertEquals(new Vector2d(-60, 1), new Vector2d(60, -1).opposite());
        assertNotEquals(new Vector2d(5, 2), new Vector2d(1, 2).opposite());
        assertNotEquals(new Vector2d(3, 7), new Vector2d(2, 1).opposite());

    }

    @Test
    void testEquals_test() {
        assertTrue(new Vector2d(1, 2).equals(new Vector2d(1, 2)));
        assertTrue(new Vector2d(60, -1).equals(new Vector2d(60, -1)));
        assertFalse(new Vector2d(1, 2).equals(new Vector2d(5, 2)));
        assertFalse(new Vector2d(2, 1).equals(new Vector2d(3, 7)));

    }
}