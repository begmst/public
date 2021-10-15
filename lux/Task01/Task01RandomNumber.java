import java.util.Random;
import java.util.Scanner;

public class Task01RandomNumber {

    public static void main(String[] args) {
        System.out.println("Random number:");
        randomNumber();
    }

    public static void randomNumber(int N) {
        Scanner s = new Scanner(System.in);
        Random rnd = new Random();
        int answer = rnd.nextInt(N + 1);
        System.out.println(answer);
        boolean nextStep = true;
        int number;
        System.out.println(String.format("I have a number between 0 and %d. What is it?", N));
        while (nextStep) {
            System.out.print(String.format("Enter a number between 0 and %d: ", N));
            number = s.nextInt();
            if (number > answer) {
                System.out.println("Your number is greater than mine.");
            } else if (number < answer) {
                System.out.println("Your number is less than mine.");
            } else {
                System.out.println(String.format("You won! It's %d", answer));
                nextStep = false;
            }
        }
    }

    public static void randomNumber() {
        randomNumber(100);
    }
}
