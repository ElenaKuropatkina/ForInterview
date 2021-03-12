package lesson2;

public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] elementData;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    public MyArrayList(int userCapacity) {
        if (userCapacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
            elementData = new Object[capacity];
        } else {
            capacity = userCapacity;
            elementData = new Object[capacity];
        }
    }

    public boolean enoughCapacity(int newSize, int capacity) {
        if (newSize <= capacity) {
            System.out.println("Емкости достаточно");
            return true;
        }
        System.out.println("Емкости не достаточно");
        return false;
    }

    public Object[] increaseCapacity(int capacity, Object[] elementData) {
        this.capacity = (capacity * 3) / 2 + 1; // формула взята с просторов интернета
        Object[] oldElementData = elementData;
        elementData = new Object[this.capacity];
        System.arraycopy(oldElementData, 0, elementData, 0, oldElementData.length);
        System.out.println("Емкость увеличена до " + this.capacity);
        return elementData;
    }

    public void add(Object object) {

        if (enoughCapacity(size + 1, capacity)) {
            elementData[size++] = object;
            System.out.println("Элемент " + object + " добавлен");
        } else {
            elementData = increaseCapacity(capacity, elementData);
            elementData[size++] = object;
            System.out.println("Элемент " + object + " добавлен");
        }
    }

    public void add(int index, Object object) {

        if (index < 0 || index > size) {
            System.out.println("Индекса " + index + " не существует, элемент не добавлен");
        } else {
            if (enoughCapacity(size + 1, capacity)) {
                System.arraycopy(elementData, index, elementData, index + 1, size - index);
                elementData[index] = object;
                System.out.println("Элемент " + object + " добавлен по индексу " + index);
            } else {
                elementData = increaseCapacity(size, elementData);
                System.arraycopy(elementData, index, elementData, index + 1, size - index);
                elementData[index] = object;
                System.out.println("Элемент " + object + " добавлен по индексу " + index);
            }
        }
    }

    public Object get(int index) {

        if (index < 0 || index > size) {
            System.out.println("Индекса " + index + " не существует, элемент не найден");
            return null;
        } else {
            System.out.println("Элемент " + elementData[index]);
            return elementData[index];
        }
    }

    public int indexOf(Object object) {
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(object)) {
                return index;
            }
        }
        System.out.println("Такого элемента нет");
        return -1;
    }


    public void remove(Object object) {
         remove(indexOf(object));
    }

    public void remove(int index) {

        if (index < 0 || index > size) {
            System.out.println("Индекса " + index + " не существует, элемент не найден");
        } else {
            elementData[index] = null;
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
            elementData[size] = null;
        }
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Object o : elementData
        ) {
            if (o != null) {
                sb.append(o + " ");
            }
        }
        return sb.toString();
    }

}
