package lesson1.polymorphism;

public class Triangle extends Figure {
    int a, b, c;
    double length = 0;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double length() {
        length = a + b + c;
        return length;
    }

    public void print() {
        System.out.println("Triangle length = " + length());
    }
}
