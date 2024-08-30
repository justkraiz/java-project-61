package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    private static String userName;
    private static final int MAX_WINS = 3;

    public static void start(String rules, String[] questions, String[] answers) {
        welcome();
        printRules(rules);
        playGame(questions, answers);

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

    public static void playGame(String[] questions, String[] answers) {
        int currentWins = 0;
        while (currentWins < MAX_WINS) {
            System.out.println("Question: " + questions[currentWins]);
            var userAnswer = getUserAnswer();
            var rightAnswer = answers[currentWins];

            if (isUserRight(userAnswer, rightAnswer)) {
                System.out.println("Correct!");
                currentWins++;
            } else {
                printIncorrectAnswerMessage(userAnswer, rightAnswer);
                closeApplication();
            }
        }
        printCongratulations();
        closeApplication();
    }

    public static boolean isUserRight(String userAnswer, String rightAnswer) {
        return userAnswer.equalsIgnoreCase(rightAnswer);
    }

    public static String getUserAnswer() {
        System.out.print("Your answer: ");
        return new Scanner(System.in).nextLine();
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void printIncorrectAnswerMessage(String userAnswer, String rightAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
                userAnswer, rightAnswer, userName);
    }

    public static void closeApplication() {
        System.exit(0);
    }

    //generate from 1 -> range
    public static int generateNumber(int range) {
        Random random = new Random();
        return random.nextInt(range) + 1;
    }

    //generate from min -> max values
    public static int generateNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1)  + min;
    }

    public static int getMaxWins() {
        return MAX_WINS;
    }
}
