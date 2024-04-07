import java.util.Scanner;

public class Task3 {

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        // O(1)
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.printf("%d is not a natural number", n);
            return;
        }
        if (n == 1) {
            System.out.printf("%d can't be determined as it is prime or not", n);
            return;
        }
        int sqrtN = (int) Math.sqrt(n);
        // O(sqrt(n))
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                System.out.printf("%d is Composite", n);
                return;
            }
        }
        System.out.printf("%d is Prime", n);
    }

    public static void main(String[] args) {
        task3();
    }
}
