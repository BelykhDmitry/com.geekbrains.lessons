package lesson6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BST<Integer, Integer>> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            BST<Integer, Integer> binaryTree = new BST<>();
            while (binaryTree.height() < 6) {
                int random = (int) (Math.random() * 200 - 100);
                binaryTree.put(random, random);
            }
            list.add(binaryTree);
        }
        for (BST<Integer, Integer> binaryTree:list) {
            System.out.println("h=" + binaryTree.height() + " size=" + binaryTree.size() +  " isBalanced:" + binaryTree.isBalanced());
        }
        boolean founded = false;
        int counter = 0;
        while (!founded) {
            BST<Integer, Integer> binaryTree = new BST<>();
            while (binaryTree.height() < 6) {
                int random = (int) (Math.random() * 200 - 100);
                binaryTree.put(random, random);
            }
            if (binaryTree.isBalanced())
                founded = true;
            counter++;
        }
        System.out.println("First balanced BST with H = 6 is " + counter);
    }
}
