package lesson8;

public class ChainingHashTable<Key, Value> {
    private int M = 5;
    private int size = 0;
    private float loadFactor = 0.8f;
    private Object[] st = new Object[M];
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        private Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {return size;}

    public int capacity() {return M;}

    public boolean isEmpty() {return size == 0;}

    public void setLoadFactor (float loadFactor) {
        if (loadFactor > 0.2f & loadFactor < 1.0f) {
            this.loadFactor = loadFactor;
        } else {
            throw new IllegalArgumentException("Недопустимый диапазон для loadFactor");
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться Null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться Null");
        }
        if (size >= loadFactor * M) {
            resize();
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
    }

    private void resize() {
        int tempM = M;
        M = nextPrimeNumber(2 * M + 1);
        Object[] temp = this.st;
        st = new Object[M];
        size = 0;
        for (int i = 0; i < tempM; i++) {
            if (temp[i] != null) {
                Node node = (Node) temp[i];
                put(node.key, node.value);
                while (node.next != null) {
                    put(node.next.key, node.next.value);
                    node = node.next;
                }
            }
        }
    }

    private int nextPrimeNumber(int number) {
        while (!isPrime(number)) {
            number++;
        }
        return number;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
