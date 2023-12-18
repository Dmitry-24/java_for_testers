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

}
