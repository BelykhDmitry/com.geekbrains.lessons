package lesson5;

public class Hanoi {

    private static final int DISK_COUNT = 8;

    private static int counter = 0;

    private static Integer towers[] = {DISK_COUNT, 0, 0};

    private static void move(int from, int with, int to, int count) {
        if (count == 1) {
            towers[from]--;
            towers[to]++;
            System.out.println(from + " -> " + to);
            counter++;
        } else {
            // Перенос на вспомогательную башню
            move(from, to, with, count - 1);
            towers[from]--;
            towers[to]++;
            System.out.println(from + " -> " + to);
            counter++;
            // Перенос на целевую башню
            move(with, from, to, count - 1);
        }
    }

    public static void main(String[] args) {
        move(0, 1, 2, DISK_COUNT);
        System.out.println(towers[0] + " : " + towers[1] + " : " + towers[2]);
        System.out.println(counter + " steps");
    }
}
