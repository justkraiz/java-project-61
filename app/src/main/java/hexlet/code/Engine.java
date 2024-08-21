package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    static int countWins = 0;
    static String userName = "";

    public static void start(String gameRules) {
        welcome();
        printRules(gameRules);
    }

    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void printRules(String gameRules) {
        System.out.println(gameRules);
    }

    public static String getUserAnswer() {
        System.out.print("Your answer: ");
        return new Scanner(System.in).nextLine();
    }

    public static boolean isLose(String userAnswer, String rightAnswer) {
        if (userAnswer.equalsIgnoreCase(rightAnswer)) {
            System.out.println("Correct!");
            countWins++;
            if (countWins == 3) {
                printCongratulations();
                System.exit(0);
            }
            return false;
        } else {
            printIncorrectAnswerMessage(userAnswer, rightAnswer);
            return true;
        }
    }

    public static int generateNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1; //generate 1-20 random number;
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + userName + "!");
    }
    public static void printIncorrectAnswerMessage(String userAnswer, String rightAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
                userAnswer, rightAnswer, userName);
    }

}
