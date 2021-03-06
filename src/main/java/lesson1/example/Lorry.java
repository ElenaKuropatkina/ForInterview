package lesson1.example;

//class Lorry extends Car,   /* implements */   Moveable, Stopable{
//
//    /* Добавить обязательный метод open */
//
//    /* @Override - не обязательно, но можно */
//    public void move(){
//        System.out.println("Car is moving");
//    }
//
//     /* @Override - не обязательно, но можно */
//    public void stop(){
//        System.out.println("Car is stop");
//    }
//}

class Lorry extends Car implements Moveable, Stopable {

    @Override
    public void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}



