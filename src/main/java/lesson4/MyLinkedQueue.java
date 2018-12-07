package lesson4;

public class MyLinkedQueue<Item> implements MyQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    @Override
    public void enqueue(Item item) {
        queue.insertLast(item);
    }

    @Override
    public Item dequeue() {
        return queue.deleteFirst();
    }

    @Override
    public Item peek() {
        return queue.getFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
