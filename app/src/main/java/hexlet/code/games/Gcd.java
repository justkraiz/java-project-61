package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public final class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int NUM_GENERATING_RANGE = 20;

    public static void play() {
        Engine.start(RULES, generateQuestionsAndAnswers());
    }

    public static Map<String, String> generateQuestionsAndAnswers() {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < Engine.MAX_WINS) {
            int firstNumber = Utils.generateNumber(NUM_GENERATING_RANGE);
            int secondNumber = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = firstNumber + " " + secondNumber;
            String answer = String.valueOf(gcd(firstNumber, secondNumber));
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static int gcd(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }
}
