package lesson2;

public class Link<Item> {

    Item value;
    Link next;
    Link previous;

    public Link(Item value) {
        this.value = value;
    }

    public Link(Item value, Link next) {
        this.value = value;
        this.next = next;
    }

    public Item getValue() {
        return value;
    }

    public void setValue(Item value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }

}
