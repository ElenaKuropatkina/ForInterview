package lesson2;

public class MyLinkedList<Item> {

    private Link first;
    private Link last;
    private int size = 0;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Link getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }


    public Link getLast() {
        if (isEmpty()) {
            return null;
        }
        return last;
    }

    public void insertFirst(Item item) {
        Link newLink = new Link(item);
        newLink.setNext(first);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.setPrevious(newLink);
        }
        first = newLink;
        size++;
    }

    public void insertLast(Item item) {
        Link newNode = new Link(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public Link removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Link oldFisrt = first;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        return oldFisrt;
    }

    public Link removeLast() {
        if (isEmpty()) {
            return null;
        }
        Link oldLast = last;
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
        } else {
            first = null;
        }
        size--;
        last = last.getPrevious();
        return oldLast;
    }

    @Override
    public String toString() {
        Link current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + " ");
            current = current.next;
        }
        return sb.toString();
    }

    public int indexOf(Item item) {
        Link current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void insert(Item item, int index) {
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index > size) {
            index = size;
        }
        Link current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Link newLink = new Link(item);
        newLink.setNext(current.next);
        newLink.setPrevious(current);
        current.setNext(newLink);
        newLink.getNext().setPrevious(newLink);
        size++;
    }

    public boolean remove(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }
        Link current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.getNext().setPrevious(current.previous);
        current.getPrevious().setNext(current.next);
        size--;
        return true;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

}
