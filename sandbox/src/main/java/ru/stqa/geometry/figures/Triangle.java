package ru.stqa.geometry.figures;

import java.util.Objects;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if ((a + b) < c || (a + c) < b || (b + c) < a) {
            throw new IllegalArgumentException("Sum of any two sides must be greater than the third side");
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.b, triangle.a) == 0 && Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0)
                || (Double.compare(this.c, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 && Double.compare(this.a, triangle.c) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public double area() {
        var p = perimeter() / 2;
        return sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

}
