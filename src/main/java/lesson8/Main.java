package lesson8;

public class Main {
    public static void main(String[] args) {
        System.out.println("==LinearProbingHashTable==");
        LinearProbingHashTable<Integer, Integer> hashTable = new LinearProbingHashTable<>();
        System.out.println("Capacity before filling: " + hashTable.capacity());
        for (int i = 0; i < 7; i++) {
            hashTable.put(i, i);
        }
        for (int i = 0; i < 7; i++) {
            hashTable.put(i, 2*i);
        }
        System.out.println("Capacity after filling: " + hashTable.capacity());
        for (int i = 0; i < 7; i++) {
            System.out.println("For key " + i + ": " + hashTable.get(i));
        }
        System.out.println("==ChainingHashTable==");
        ChainingHashTable<Integer, Integer> chainingHashTable = new ChainingHashTable<>();
        System.out.println("Capacity before filling: " + chainingHashTable.capacity());
        for (int i = 0; i < 7; i++) {
            chainingHashTable.put(i, i);
        }
        System.out.println("Capacity while filling: " + chainingHashTable.capacity());
        for (int i = 11; i < 15; i++) {
            chainingHashTable.put(i, 2*i);
        }
        System.out.println("Capacity after filling: " + chainingHashTable.capacity());
        System.out.println(chainingHashTable.get(1));
    }
}
