package lesson4;

public interface MyQueue<Item> {
    public void enqueue(Item item);

    public Item dequeue();

    public Item peek();

    public int size();

    public boolean isEmpty();
}
