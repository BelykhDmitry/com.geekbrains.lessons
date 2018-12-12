package lesson6;

public class Proram {
    public static void main(String[] args) {
        BST<Character, Integer> assArr = new BST<>();
        assArr.put('S', 123);
        System.out.println(assArr.isBalanced());
        assArr.put('E', 345);
        System.out.println(assArr.isBalanced());
        assArr.put('A', 123);
        System.out.println(assArr.isBalanced());
        assArr.put('C', 987);
        System.out.println(assArr.isBalanced());
        assArr.put('R', 911);
        System.out.println(assArr.isBalanced());
        assArr.put('H', 112);
        System.out.println(assArr.isBalanced());
        assArr.put('M', 012);
        System.out.println(assArr.isBalanced());
        assArr.put('X', 003);
        System.out.println(assArr.isBalanced());
        assArr.delete('H');
        System.out.println(assArr.isBalanced());
        System.out.println();
    }
}
