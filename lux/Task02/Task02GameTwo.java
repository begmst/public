import java.util.Scanner;

public class Task02GameTwo {
    public static void main(String[] args) {
        int min = 1;
        int max = 4;
        int result = getUserNumber(min, max);
        System.out.println(String.format("Your number is %d.", result));
    }

    public static int getUserNumber(int min, int max) {
        if (min == max) {
            return min;
        }
        int x = (min + max) / 2;
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("[%d; %d] Is your number %d? [=<>]", min, max, x));
        char response = scanner.next().charAt(0);
        switch (response) {
            case '<':
                return getUserNumber(min, x);
            case '>':
                return getUserNumber(x + 1, max);
            case '=':
                return x;
            default:
                return getUserNumber(min, max);
        }
    }
}
