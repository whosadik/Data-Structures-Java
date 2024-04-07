import java.util.Scanner;

public class Task10 {

    public static int getGCD(int a, int b) {
        if (a * b == 0) {
            return a + b;
        }
        int maxNum = Math.max(a, b);
        int minNum = Math.min(a, b);
        return getGCD(maxNum % minNum, minNum);
    }

    public static void task10() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < 0 || b < 0) {
            System.out.printf("Both a and b must be more than 0. Got a = %d, b = %d", a, b);
            return;
        }
        System.out.printf("GCD of %d and %d: %d", a, b, getGCD(a, b));
    }

    public static void main(String[] args) {
        task10();
    }
}
