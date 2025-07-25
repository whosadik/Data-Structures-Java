import java.util.Scanner;

public class Task1 {

    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        // O(1)
        int n = scanner.nextInt();

        // O(n)
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // O(n)
        int minNum = Integer.MAX_VALUE;
        for (int num : arr) {
            minNum = Math.min(minNum, num);
        }

        System.out.print(minNum);
    }

    public static void main(String[] args) {
        try {
            task1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
