import java.util.Scanner;

public class Task8 {

    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean isOk = true;
        for (char myChar : s.toCharArray()) {
            if (!(myChar >= '0' && myChar <= '9')) {
                isOk = false;
                break;
            }
        }
        if (isOk) {
            System.out.printf("%s contains only digits", s);
        } else {
            System.out.printf("%s does not contain only digits", s);
        }
    }

    public static void main(String[] args) {
        task8();
    }
}
