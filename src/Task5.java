import java.util.Scanner;

public class Task5 {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println(n + " is less than zero");
            return;
        }

        int result = fibonacci(n);
        System.out.printf("Fibonacci's %d number: %d", n, result);
    }

    public static void main(String[] args) {
        task5();
    }
}
