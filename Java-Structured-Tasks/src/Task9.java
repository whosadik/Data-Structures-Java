import java.util.Scanner;

public class Task9 {

    public static int mathBinomialCoefficient(int k, int n) {
        if (k == 0 || k == n) {
            return 1;
        }
        int fPart = mathBinomialCoefficient(k - 1, n - 1);
        int sPart = mathBinomialCoefficient(k, n - 1);
        return fPart + sPart;
    }

    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n < 0 || k < 0) {
            System.out.printf("Both n and k must be more than 0. Got n = %d, k = %d", n, k);
            return;
        }
        System.out.printf("C (k = %d, n = %d) = %d", k, n, mathBinomialCoefficient(k, n));
    }

    public static void main(String[] args) {
        task9();
    }
}
