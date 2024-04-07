import java.util.Scanner;

public class Task6 {
    public static int binPow(int p, int st) {
        if (st == 0) {
            return 1;
        }
        if (st % 2 == 0) {
            int sqrtAns = binPow(p, st / 2);
            return sqrtAns * sqrtAns;
        }
        return binPow(p, st - 1) * p;
    }

    // Основной метод
    public static void task6() {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.printf("Power of %d must be >= than zero! Got %d", a, n);
            return;
        }

        System.out.printf("%d^%d: %d", a, n, binPow(a, n));
    }

    public static void main(String[] args) {
        task6();
    }
}
