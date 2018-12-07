package lesson4;

public class MyLinkedDequeue<Item> implements MyDequeue<Item> {
    MyLinkedList<Item> dequeue = new MyLinkedList<>();
    @Override
    public int size() {
        return dequeue.size();
    }

    @Override
    public boolean isEmpty() {
        return dequeue.isEmpty();
    }

    @Override
    public void insertLeft(Item item) {
        dequeue.insertFirst(item);
    }

    @Override
    public void insertRight(Item item) {
        dequeue.insertLast(item);
    }

    @Override
    public Item removeLeft() {
        return dequeue.deleteFirst();
    }

    @Override
    public Item removeRight() {
        return dequeue.deleteLast();
    }

    @Override
    public Item peekLeft() {
        return dequeue.getFirst();
    }

    @Override
    public Item peekRight() {
        return dequeue.getLast();
    }

    @Override
    public String toString() {
        return dequeue.toString();
    }
}
