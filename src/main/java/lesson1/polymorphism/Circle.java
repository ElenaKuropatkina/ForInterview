package lesson1.polymorphism;

import static java.lang.Math.PI;

public class Circle extends Figure {
    int d;
    double length = 0;

    public Circle(int d) {
        this.d = d;
    }

    public double length() {
        length = d * PI;
        return length;
    }

    public void print() {
        System.out.println("Circle length = " + length());
    }
}
