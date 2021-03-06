package lesson1.example;

abstract class Car {

//    public Engine engine;
//    private String color;
//    private String name;
//    /* изменить модификаторы доступа */

    Engine engine;
    String color;
    String name;

//    protected void start() {
//      System.out.println("Car starting");
//    }
//    /* изменить модификатор доступа */

    public void start() {
        System.out.println("Car starting");
    }

    //    abstract void open();
//    /* изменить модификатор доступа  и добавить тело метода*/
    public void open() {
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

