import java.util.Scanner;

public class Task2 {

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Can't find avg value of zero items");
            return;
        }

        // O(n)
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // O(n)
        int sumOfNums = 0;
        for (int num : arr) {
            sumOfNums += num;
        }

        double avgValue = (double) sumOfNums / n;
        System.out.print(avgValue);
    }

    public static void main(String[] args) {
        task2();
    }
}
