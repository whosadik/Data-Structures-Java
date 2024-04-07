import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {

    public static List<String> comb(String s) {
        int n = s.length();
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add(s);
            return result;
        }
        List<String> nextCombs = comb(s.substring(1));
        List<String> ans = new ArrayList<>();
        for (String nextComb : nextCombs) {
            for (int indexToAdd = 0; indexToAdd <= n - 1; indexToAdd++) {
                String strToAdd = nextComb.substring(0, indexToAdd) + s.charAt(0) + nextComb.substring(indexToAdd);
                ans.add(strToAdd);
            }
        }
        return ans;
    }

    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> allPermutations = comb(s);
        System.out.println("All permutations of " + s + ":");
        for (String myPermutation : allPermutations) {
            System.out.println(myPermutation);
        }
    }

    public static void main(String[] args) {
        task7();
    }
}
