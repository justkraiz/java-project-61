package hexlet.code;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    private static String userName;
    public static final int MAX_WINS = 3;

    public static void start(String rules, Map<String, String> questionsAndAnswers) {
        welcome();
        playGame(questionsAndAnswers, rules);
    }

    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void playGame(Map<String, String> questionsAndAnswers, String rules) {
        int currentWins = 0;
        Iterator<String> keyIterator = questionsAndAnswers.keySet().iterator();

        System.out.println(rules);
        while (currentWins < MAX_WINS) {
            var question = keyIterator.next();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var userAnswer = new Scanner(System.in).nextLine();
            var rightAnswer = questionsAndAnswers.get(question);

            if (userAnswer.trim().equalsIgnoreCase(rightAnswer)) {
                System.out.println("Correct!");
                currentWins++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
                        userAnswer, rightAnswer, userName);
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        System.exit(0);
    }

}
