package lesson4;

public interface MyStack<Item> {
    public void push(Item item);

    public Item pop();

    public Item peek();

    public int size();

    public boolean isEmpty();
}
