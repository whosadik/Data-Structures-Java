import java.util.Scanner;

public class Task4 {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
    public static void task4() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println(n + " is less than zero");
            return;
        }

        int result = factorial(n);
        System.out.printf("Factorial of %d: %d", n, result);
    }

    public static void main(String[] args) {
        task4();
    }
}
