package lesson5;

public class Main {
    public static void main(String[] args) {
        // 1. Возведение в степень
        powerDemo();
    }

    private static void powerDemo() {
        int order = 10000;
        System.out.println("==Степени от 0 до " + order + "==");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < order; i++) {
            powerFast(2, i);
        }
        long delta1 = System.currentTimeMillis() - startTime;
        System.out.println("Fast Power time: " + delta1);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < order; i++) {
            power(2, i);
        }
        long delta2 = System.currentTimeMillis() - startTime;
        System.out.println("Power time: " + delta2);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < order; i++) {
            powerF(2, i);
        }
        delta2 = System.currentTimeMillis() - startTime;
        System.out.println("Fast Power 2 time: " + delta2);

        System.out.println("==Отрицательные степени:==");

        startTime = System.currentTimeMillis();
        for (int i = -order/2; i < order/2; i++) {
            power(2, i);
        }
        delta2 = System.currentTimeMillis() - startTime;
        System.out.println("Power time: " + delta2);
        startTime = System.currentTimeMillis();
        for (int i = -order/2; i < order/2; i++) {
            powerF(2, i);
        }
        delta2 = System.currentTimeMillis() - startTime;
        System.out.println("Fast Power 2 time: " + delta2);
    }

    // Быстрое возведение в степень для натуральных степеней
    private static double powerFast(double num, int order) {
        if (order == 0) {
            return 1;
        } else if (order == 1) {
            return num;
        } else {
            if (order % 2 != 0) {
                return num * powerFast(num, order - 1);
            } else {
                return powerFast(num * num, order / 2);
            }
        }
    }

    // Обычное возведение в степень. Подходит для отрицательных степеней
    private static double power(double num, int order) {
        // Базовый случай
        if (order == 0)
            return 1;
        if (order == 1) {
            return num;
        } else if (order == -1) {
            return 1 / num;
        }
        // Рекурсивный случай
        double result = power(num, order - sign(order));
        if (order > 1) {
            return result * num;
        } else {
            return result / num;
        }
    }

    // Попытка сделать быстрое возведение в степень с поддержкой отрицательных степеней
    private static double powerF(double num, int order) {
        // Базовый случай
        if (order == 0)
            return 1;
        if (order == 1) {
            return num;
        } else if (order == -1) {
            return 1 / num;
        }
        // Рекурсивный случай
        double result;
        if (order % 2 != 0) {
            result = powerF(num, order - sign(order));
        } else {
            return powerF(num * num, order / 2);
        }
        if (order > 1) {
            return result * num;
        } else {
            return result / num;
        }
    }

    private static int sign(long num) {
        return num >= 0 ? 1 : -1;
    }
}
