package lesson1.example;

class LightWeightCar extends Car implements Moveable {
    @Override
//  void open() {
//  /* изменить модификатор доступа
    public void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    // как вариант добавить метод stop, но не обязательно, так как не понятна задумка создателей, может stop и не нужен здесь
    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}





