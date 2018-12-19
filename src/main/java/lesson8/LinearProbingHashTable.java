package lesson8;

public class LinearProbingHashTable<Key, Value> {
    private int M = 7;
    private int size = 0;
    private float loadFactor = 0.8f;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    public int size() {return size;}

    public int capacity() {return M;}

    public boolean isEmpty() {return size == 0;}

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void setLoadFactor (float loadFactor) {
        if (loadFactor > 0.2f & loadFactor < 1.0f) {
            this.loadFactor = loadFactor;
        } else {
            throw new IllegalArgumentException("Недопустимый диапазон для loadFactor");
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("ключ не может равняться null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("ключ не может равняться null");
        }
        if (size >= loadFactor * M) {
            resize();
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if ((keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    private void resize() {
        int tempM = M;
        M = nextPrimeNumber(2 * M + 1);
        Object[] tempKeys = this.keys;
        Object[] tempValues = this.values;
        keys = new Object[M];
        values = new Object[M];
        size = 0;
        for (int i = 0; i < tempM; i++) {
            if (tempKeys[i] != null) {
                put((Key) tempKeys[i], (Value) tempValues[i]);
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
