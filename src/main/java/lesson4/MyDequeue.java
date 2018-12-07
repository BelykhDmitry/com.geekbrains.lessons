package lesson4;

import java.util.NoSuchElementException;

public interface MyDequeue<Item> {
    public int size();

    public boolean isEmpty();

    public void insertLeft(Item item);

    public void insertRight(Item item);

    public Item removeLeft();

    public Item removeRight();

    public Item peekLeft();

    public Item peekRight();
}

