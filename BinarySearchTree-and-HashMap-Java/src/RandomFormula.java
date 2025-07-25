import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFormula {

    public static int randomFormula(int x) {
        int sqrtX = (int) Math.sqrt(x);
        int a = x * (x + 5);
        int b = sqrtX - 3 * x;

        int c = Math.abs(a - b) - b / 2;
        int d = sqrtX * (sqrtX - 3);
        int e = c * (sqrtX - 3) - d;

        int randomSqrt = (int) Math.sqrt(sqrtX + 10);
        int f = e - x * b - c * randomSqrt;

        return f;
    }

    public static class TestStruct {
        String name;
        int age;
        boolean isStudent;

        public TestStruct(String name, int age, boolean isStudent) {
            this.name = name;
            this.age = age;
            this.isStudent = isStudent;
        }
    }

    public static TestStruct getStruct(int i) {
        return new TestStruct(String.valueOf((char) i), randomFormula(i), (i + randomFormula(i)) % 2 == 0);
    }

    public static int[] shuffleMp(Map<Integer, Integer> mp) {
        int n = mp.size();
        int[] arr = new int[n];
        int index = 0;
        for (int key : mp.keySet()) {
            arr[index++] = key;
        }
        shuffleArray(arr);
        return arr;
    }

    private static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        // Пример использования
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 10);
        mp.put(2, 20);
        mp.put(3, 30);

        int[] shuffledKeys = shuffleMp(mp);
        for (int key : shuffledKeys) {
            System.out.println(key);
        }
    }
}
