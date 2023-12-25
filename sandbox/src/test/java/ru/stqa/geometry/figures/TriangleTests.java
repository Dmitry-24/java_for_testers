package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(21, new Triangle(6.0, 7.0, 8.0).perimeter());
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(6, new Triangle(5.0, 3.0, 4.0).area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 2.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithFalseSide() {
        try {
            new Triangle(2.0, 7.0, 2.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(4.0,5.0, 3.0);
        var t2 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }
}




