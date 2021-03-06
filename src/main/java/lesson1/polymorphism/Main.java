package lesson1.polymorphism;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figure> list = new ArrayList<Figure>();
        list.add(new Circle(5));
        list.add(new Rectangle(5, 6));
        list.add(new Circle(2));
        list.add(new Triangle(1, 2, 3));
        list.add(new Rectangle(2, 3));
        for (Figure f : list
        ) {
            f.print();
        }

    }
}
