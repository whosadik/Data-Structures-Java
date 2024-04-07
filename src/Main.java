import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter task number:");
        int task = sc.nextInt();
        if(task == 1)
            Task1.task1();
        if(task == 2)
            Task2.task2();
        if(task == 3)
            Task3.task3();
        if(task == 4)
            Task4.task4();
        if(task == 5)
            Task5.task5();
        if(task == 6)
            Task6.task6();
        if(task == 7)
            Task7.task7();
        if(task == 8)
            Task8.task8();
        if(task == 9)
            Task9.task9();
        if(task == 10)
            Task10.task10();
    }
}