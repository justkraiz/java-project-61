package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public final class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int NUM_GENERATING_RANGE = 20;

    public static void play() {
        Engine.start(RULES, generateQuestionsAndAnswers());
    }

    public static Map<String, String> generateQuestionsAndAnswers() {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < Engine.MAX_WINS) {
            int number = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = String.valueOf(number);
            String answer = isPrime(number) ? "yes" : "no";
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
