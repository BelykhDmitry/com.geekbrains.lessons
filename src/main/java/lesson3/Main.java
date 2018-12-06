package lesson3;

public class Main {
    public static void main(String[] args) {
        // Пункт 1. Демонстрация очереди. Стек не демонстрируется отдельно, т.к. используется в задании №2
        queueDemo();
        // Пункт 2. Переворот строки. Выполнен двумя способами.
        stringRevertDemo();
        // Пункт 3. Демонстрация дека
        dequeueDemo();

    }

    private static void stringRevertDemo() {
        System.out.println("====№2====");
        String str = "Hello, world!";
        System.out.println(revert(str));
        System.out.println(revertWithStack(str));
    }

    private static void queueDemo() {
        System.out.println("====№1====");
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 11; i+=2) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        while (queue.size() != 0)
            System.out.print(queue.dequeue() + " : ");
        System.out.println();
    }

    private static void dequeueDemo() {
        System.out.println("====№3====");
        ArrayDequeue<Integer> dequeue = new ArrayDequeue<>();
        for (int i = 0; i < 11; i+=2) {
            dequeue.insertRight(i);
        }
        dequeue.insertLeft(1);
        dequeue.insertLeft(3);
        System.out.println(dequeue);
        System.out.println(dequeue.removeRight() + " :: " + dequeue);
        System.out.println(dequeue.removeLeft() + " :: " + dequeue);
        System.out.println(dequeue.removeRight() + " :: " + dequeue);
        System.out.println(dequeue.removeLeft() + " :: " + dequeue);
        System.out.println(dequeue.removeRight() + " :: " + dequeue);
        System.out.println(dequeue.removeLeft() + " :: " + dequeue);
        System.out.println(dequeue.removeRight() + " :: " + dequeue);
        System.out.println("Peek left:" + dequeue.peekLeft());
        System.out.println("Peek right:" + dequeue.peekRight());
        System.out.println(dequeue.removeLeft() + " :: " + dequeue);
        try {
            System.out.println(dequeue.removeLeft() + " :: " + dequeue);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Обычный переворот строки
    private static String revert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > -1 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Переворот строки через стек
    private static String revertWithStack(String str) {
        char[] arr = str.toCharArray();
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0)
            sb.append(stack.pop());
        return sb.toString();
    }

}
