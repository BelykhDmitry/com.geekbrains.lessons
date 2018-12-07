package lesson4;

public class MyLinkedStack<Item> implements MyStack<Item> {
    MyLinkedList<Item> stack = new MyLinkedList<>();

    @Override
    public void push(Item item) {
        stack.insertFirst(item);
    }

    @Override
    public Item pop() {
        return stack.deleteFirst();
    }

    @Override
    public Item peek() {
        return stack.getFirst();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
