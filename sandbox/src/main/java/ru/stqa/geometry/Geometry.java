package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        var squares = Stream.of(new Square( 7.0), new Square( 5.0), new Square( 3.0));
        squares.forEach(Square::printSquareArea);
    }

}
