package lesson1.polymorphism;

public class Rectangle extends Figure {

    int a, b;
    double length = 0;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double length() {
        length = 2 * (a + b);
        return length;
    }

    public void print() {
        System.out.println("Rectangle length = " + length());
    }
}
