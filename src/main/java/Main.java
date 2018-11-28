public class Main {
    private final static int arraySize = 100000;
    public static void main(String[] args) {
        // Одинаковые экземпляры массивов для чистоты эксперимента
        final MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        final MyArrayList<Integer> arrayList2 = new MyArrayList<>();
        final MyArrayList<Integer> arrayList3 = new MyArrayList<>();
        int randomNumber;
        for (int i = 0; i < arraySize; i++) {
            randomNumber = (int)(Math.random() * arraySize);
            arrayList1.add(randomNumber);
            arrayList2.add(randomNumber);
            arrayList3.add(randomNumber);
        }
        System.out.println("Start sorting..");
        // Несколько потоков, т.к. очень большое время выполнения
        Thread insertionSort = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            arrayList1.insertionSort();
            long workTime = System.currentTimeMillis() - startTime;
            System.out.println("Insertion sort: " + workTime + " [ms]");
        });
        Thread selectionSort = new Thread(()->{
            long startTime = System.currentTimeMillis();
            arrayList2.selectionSort();
            long workTime = System.currentTimeMillis() - startTime;
            System.out.println("Selection sort: " + workTime + " [ms]");
        });
        Thread bubbleSort = new Thread(()->{
            long startTime = System.currentTimeMillis();
            arrayList3.selectionSort();
            long workTime = System.currentTimeMillis() - startTime;
            System.out.println("Bubble sort: " + workTime + " [ms]");
        });

        insertionSort.start();
        selectionSort.start();
        bubbleSort.start();
        try {
            insertionSort.join();
            selectionSort.join();
            bubbleSort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
