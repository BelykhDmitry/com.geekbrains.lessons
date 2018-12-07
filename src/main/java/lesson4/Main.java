package lesson4;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        //
        queueDemo();

        stackDemo();

        dequeueDemo();

    }

    private static void queueDemo() {
        System.out.println("====LinkedQueue Demo====");
        MyQueue<Integer> queue = new MyLinkedQueue<>();
        for (int i = 0; i < 11; i+=2) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        while (queue.size() != 0)
            System.out.print(queue.dequeue() + " : ");
        System.out.println();
        System.out.println("Queue: " + queue);
    }

    private static void stackDemo() {
        System.out.println("====LinkedStackDemo====");
        MyStack<Integer> stack = new MyLinkedStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println(stack.pop() + ": " + stack);
            }
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    private static void dequeueDemo() {
        System.out.println("====LinkedDequeueDemo====");
        MyDequeue<Integer> dequeue = new MyLinkedDequeue<>();
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

}
