package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a > 0 || b > 0 || c > 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a + b > c || a + c > b || b + c > a) {
            throw new IllegalArgumentException("Sum of any two sides must be greater than the third side");
        }

    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area() {
        var p = perimeter() / 2;
        return sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

}
