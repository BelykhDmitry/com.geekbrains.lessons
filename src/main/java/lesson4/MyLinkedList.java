package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {

    private class MyLinkedListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            return null;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size = 0;
    private Node first = null;
    private Node last = null;

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    public void insertFirst(Item item) {
        Node old = first;
        first = new Node(item, old, null);
        if (isEmpty()) {
            last = first;
        } else {
            old.previous = first;
        }
        size++;
    }

    public Item deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        first.previous = null;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Item getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public void insertLast(Item item) {
        Node newLast = new Node(item, null, last);
        if (isEmpty()) {
            first = newLast;
        } else {
            last.next = newLast;
        }
        last = newLast;
        size++;
    }

    public Item deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.previous;
        last.next = null;
        size--;
        if (isEmpty()) {
            first = null;
        }
        return item;
    }

    public Item getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex++ < index) {
            current = current.next;
        }
        return current.item;
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex++ < index) {
            current = current.next;
        }
        current.item = item;
    }

    public boolean find(Item item) {
        Node current = first;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        return current != null;
    }

    public Item delete(Item item) {
        Node current = first;

        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            return deleteFirst();
        }
        else if (current == last) {
            return deleteLast();
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        current.next = null;
        current.previous = null;
        return current.item;
    }

    public void insert(int index, Item item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        else if (index == size) {
            insertLast(item);
            return;
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(item, current, current.previous);
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
    }
}
